package de.alekseipopov.domain.repository

import de.alekseipopov.domain.enteties.LaunchDto
import de.alekseipopov.domain.pagination.LaunchPagingSource
import de.alekseipopov.network.api.LaunchesApi
import kotlinx.coroutines.flow.Flow

class LaunchesRepositoryImpl(
    pagingSource: LaunchPagingSource,
    launchesApi: LaunchesApi
): LaunchesRepository {
    override suspend fun getLaunches(): Flow<List<LaunchDto>> {
        TODO("Not yet implemented")
    }

    override suspend fun setBookmark(uuid: String?, bookmark: Boolean) {
        TODO("Not yet implemented")
    }
}