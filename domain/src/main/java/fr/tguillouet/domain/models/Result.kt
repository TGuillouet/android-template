package fr.tguillouet.domain.models

sealed class Result<out T: Any>
data class Success<out T : Any>(val data: T) : Result<T>()
data class Failure(val error: Error) : Result<Nothing>()

open class Error(val throwable: Throwable)
class HttpError(throwable: Throwable, val errorCode: Int = 0): Error(throwable)

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data)
    return this
}

inline fun <T : Any> Result<T>.onFailure(action: (Error) -> Unit) {
    if (this is Failure) action(error)
}