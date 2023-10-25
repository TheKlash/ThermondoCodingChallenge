package de.alekseipopov.storage.dao

import androidx.paging.Pager
import androidx.paging.PagingSource
import androidx.room.*
import de.alekseipopov.storage.enteties.LaunchEntity
import de.alekseipopov.storage.enteties.LaunchWithBookmark
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {
    @Transaction
    @Query("SELECT * FROM launch ORDER BY id")
    fun getLaunches(): PagingSource<Int, LaunchWithBookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(items: List<LaunchEntity>)
    @Query("DELETE FROM launch WHERE id NOT IN (SELECT * FROM bookmark)")
    suspend fun removeAllExceptBookmarks()

}