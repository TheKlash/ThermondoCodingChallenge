package de.alekseipopov.storage.dao

import androidx.room.*
import de.alekseipopov.storage.enteties.BookmarkEntity

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmark WHERE launch = :uuid")
    suspend fun deleteBookmark(uuid: String)
}