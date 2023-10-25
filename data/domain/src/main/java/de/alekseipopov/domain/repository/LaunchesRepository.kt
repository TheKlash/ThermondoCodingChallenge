package de.alekseipopov.domain.repository

import de.alekseipopov.domain.enteties.LaunchDto
import kotlinx.coroutines.flow.Flow

interface LaunchesRepository {

    suspend fun getLaunches(): Flow<List<LaunchDto>>

    suspend fun setBookmark(uuid: String?, bookmark: Boolean = true)

}