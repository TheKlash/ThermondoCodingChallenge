package de.alekseipopov.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import de.alekseipopov.storage.dao.LaunchDao
import de.alekseipopov.storage.enteties.LaunchWithBookmark

class LaunchPagingSource(
    private val launchDao: LaunchDao
) : PagingSource<Int, LaunchWithBookmark>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LaunchWithBookmark> {

        return try {
            val currentPage = params.key ?: 1
            val launches = launchDao.getLaunches(params.key ?: 0, params.loadSize)
            LoadResult.Page(
                data = launches,
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (launches.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LaunchWithBookmark>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }

}