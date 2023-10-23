package de.alekseipopov.storage.dao

import androidx.room.*
import de.alekseipopov.storage.enteties.LaunchEntity
import de.alekseipopov.storage.enteties.LaunchesWithBookmarks
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {
    @Transaction
    @Query("SELECT * FROM launchentity")
    suspend fun getAllLaunches(): Flow<LaunchesWithBookmarks>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(vararg launchEntity: LaunchEntity)
}