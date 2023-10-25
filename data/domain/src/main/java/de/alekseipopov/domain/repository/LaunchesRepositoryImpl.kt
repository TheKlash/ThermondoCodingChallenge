package de.alekseipopov.domain.repository

import androidx.paging.PagingData
import androidx.paging.map
import de.alekseipopov.domain.enteties.LaunchDto
import de.alekseipopov.domain.pagination.LaunchPagerAdapter
import de.alekseipopov.domain.util.toLaunchDto
import de.alekseipopov.network.api.LaunchesApi
import de.alekseipopov.storage.dao.BookmarkDao
import de.alekseipopov.storage.enteties.BookmarkEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.toList

class LaunchesRepositoryImpl(
    val launchPagerAdapter: LaunchPagerAdapter,
    val bookmarkDao: BookmarkDao
): LaunchesRepository {

    private lateinit var launchPagingDataFlow: Flow<PagingData<LaunchDto>>
    init {
        restartFlow()
    }

    override suspend fun getLaunches(): Flow<PagingData<LaunchDto>> = launchPagingDataFlow

    override suspend fun setBookmark(uuid: String) {
        bookmarkDao.addBookmark(
            BookmarkEntity(
                launch = uuid
            )
        )
        restartFlow()
    }

    override suspend fun removeBookmark(uuid: String) {
        bookmarkDao.deleteBookmark(uuid)
    }

    private fun restartFlow() {
        launchPagingDataFlow = launchPagerAdapter.pager.flow.map { pagingData ->
            pagingData.map { it.toLaunchDto() }
        }

    }
}