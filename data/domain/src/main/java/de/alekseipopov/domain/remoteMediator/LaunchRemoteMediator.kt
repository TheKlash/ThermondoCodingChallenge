package de.alekseipopov.domain.remoteMediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import de.alekseipopov.domain.util.toLaunchEntity
import de.alekseipopov.network.api.LaunchesApi
import de.alekseipopov.network.enteties.LaunchesRequest
import de.alekseipopov.network.enteties.Options
import de.alekseipopov.storage.database.Database
import de.alekseipopov.storage.enteties.LaunchWithBookmark
import de.alekseipopov.storage.enteties.RemoteKeyEntity

@OptIn(ExperimentalPagingApi::class)
class LaunchRemoteMediator(
    private val database: Database,
    private val launchesApi: LaunchesApi,
) : RemoteMediator<Int, LaunchWithBookmark>() {

    private val REMOTE_KEY_ID = "remote-key"

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, LaunchWithBookmark>,
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = database.remoteKeyDao().getById(REMOTE_KEY_ID)
                    if (remoteKey?.nextPage == null)
                        return MediatorResult.Success(endOfPaginationReached = true)
                    remoteKey.nextPage
                }
            }
            val apiResponse = launchesApi.getLaunches(
                request = LaunchesRequest(
                    options = Options(
                        page = page ?: 1
                    )
                )
            )
            val results = apiResponse.docsList
            val nextPage = apiResponse.nextPage ?: 0
            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.launchDao().removeAllExceptBookmarks()
                    database.remoteKeyDao().deleteById(REMOTE_KEY_ID)
                }
                database.launchDao().insertLaunches(
                    results.map { it.toLaunchEntity() }
                )
                database.remoteKeyDao().insert(
                    RemoteKeyEntity(
                        remoteKeyId = REMOTE_KEY_ID,
                        nextPage = nextPage,
                    )
                )
            }
            MediatorResult.Success(endOfPaginationReached = results.size < state.config.pageSize)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}
