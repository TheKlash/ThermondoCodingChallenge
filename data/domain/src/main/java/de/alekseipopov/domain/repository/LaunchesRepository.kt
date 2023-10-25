package de.alekseipopov.domain.repository

import androidx.paging.PagingData
import de.alekseipopov.domain.enteties.LaunchDto
import kotlinx.coroutines.flow.Flow

interface LaunchesRepository {

    suspend fun getLaunches(): Flow<PagingData<LaunchDto>>

    suspend fun setBookmark(uuid: String)

    suspend fun removeBookmark(uuid: String)

}