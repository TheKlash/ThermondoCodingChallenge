package de.alekseipopov.storage.dao

import androidx.room.*
import de.alekseipopov.storage.enteties.LaunchEntity
import de.alekseipopov.storage.enteties.LaunchWithBookmark
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {
    @Transaction
    @Query("SELECT * FROM launchentity ORDER BY launchId ASC LIMIT :limit OFFSET :offset")
    suspend fun getLaunches(limit: Int, offset: Int): List<LaunchWithBookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(vararg launchEntity: LaunchEntity)
}