package fr.tguillouet.data.repository.base

import fr.tguillouet.data.common.DomainMapper
import fr.tguillouet.data.common.coroutine.CoroutineContextProvider
import fr.tguillouet.data.common.utils.Connectivity
import fr.tguillouet.data.http.GENERAL_NETWORK_ERROR
import fr.tguillouet.domain.models.Failure
import fr.tguillouet.domain.models.HttpError
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import fr.tguillouet.domain.models.Result
import fr.tguillouet.domain.models.Success

@KoinApiExtension
abstract class BaseRepository : KoinComponent {
    private val connectivity: Connectivity by inject()
    private val contextProvider: CoroutineContextProvider by inject()

    /**
     * Use this if you need to cache data after fetching it from the api, or retrieve something from cache
     */
    protected suspend fun <T : Any, R : DomainMapper<T>> fetchData(
        apiDataProvider: suspend () -> Result<T>,
        dbDataProvider: suspend () -> R
    ): Result<T> {
        return if (connectivity.hasNetworkAccess()) {
            withContext(contextProvider.io) {
                apiDataProvider()
            }
        } else {
            withContext(contextProvider.io) {
                val dbResult = dbDataProvider()
                if (dbResult != null) Success(dbResult.mapToDomainModel()) else Failure(HttpError(Throwable("Error")))
            }
        }
    }

    /**
     * Use this when communicating only with the api service
     */
    protected suspend fun <T: Any> fetchData(dataProvider: suspend () -> Result<T>): Result<T> {
        return if (connectivity.hasNetworkAccess()) {
            withContext(contextProvider.io) {
                dataProvider()
            }
        } else {
            Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
        }
    }
}