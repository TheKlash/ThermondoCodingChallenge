package de.alekseipopov.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.alekseipopov.storage.dao.BookmarkDao
import de.alekseipopov.storage.dao.LaunchDao
import de.alekseipopov.storage.enteties.BookmarkEntity
import de.alekseipopov.storage.enteties.LaunchEntity

const val DB_NAME = "thermondo-challenge-db"
@Database(entities = [LaunchEntity::class, BookmarkEntity::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun launchDao(): LaunchDao
    abstract fun bookmarkDao(): BookmarkDao
}