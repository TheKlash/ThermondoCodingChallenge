package de.alekseipopov.domain.pagination

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import de.alekseipopov.domain.enteties.LaunchDto
import de.alekseipopov.domain.remoteMediator.LaunchRemoteMediator
import de.alekseipopov.storage.database.Database
import de.alekseipopov.storage.enteties.LaunchWithBookmark

@OptIn(ExperimentalPagingApi::class)
class LaunchPagerAdapter(
    val database: Database,
    val mediator: LaunchRemoteMediator,
)  {
    val pager = Pager (
        config = PagingConfig(pageSize = 10),
        remoteMediator = mediator,
        pagingSourceFactory = {
            database.launchDao().getLaunches()
        },
    )
}