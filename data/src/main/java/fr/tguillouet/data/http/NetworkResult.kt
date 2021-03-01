package fr.tguillouet.data.http

import fr.tguillouet.data.common.DomainMapper
import fr.tguillouet.domain.models.Failure
import fr.tguillouet.domain.models.HttpError
import fr.tguillouet.domain.models.Result
import fr.tguillouet.domain.models.Success
import retrofit2.Response
import java.io.IOException

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (HttpError) -> Unit) {
    if (!isSuccessful) errorBody()?.run { action(HttpError(Throwable(message()), code())) }
}

inline fun <T : DomainMapper<R>, R : Any> Response<T>.getData(
    cacheAction: (R) -> Unit,
    fetchFromCacheAction: () -> R): Result<R> {
    try {
        onSuccess {
            val convertedHttpResponse = it.mapToDomainModel()
            cacheAction(convertedHttpResponse)
            return Success(convertedHttpResponse)
        }
        onFailure {
            val cachedModel = fetchFromCacheAction()
            if (cachedModel != null) Success(cachedModel) else Failure(HttpError(Throwable("DB_ENTRY_ERROR")))
        }
        return Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
    } catch (e: IOException) {
        return Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
    }
}

/**
 * Use this when communicating only with the api service
 */
fun <T : DomainMapper<R>, R : Any> Response<T>.getData(): Result<R> {
    try {
        onSuccess { return Success(it.mapToDomainModel()) }
        onFailure { return Failure(it) }
        return Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
    } catch (e: IOException) {
        return Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
    }
}