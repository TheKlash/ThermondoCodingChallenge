package de.alekseipopov.storage.di

import androidx.room.Room
import de.alekseipopov.storage.dao.BookmarkDao
import de.alekseipopov.storage.dao.LaunchDao
import de.alekseipopov.storage.dao.RemoteKeyDao
import de.alekseipopov.storage.database.DB_NAME
import de.alekseipopov.storage.database.Database
import org.koin.dsl.module

val storageModule = module {
    single<Database> {
        Room.databaseBuilder(
            get(),
            Database::class.java,
            DB_NAME
        ).build()
    }

    single<LaunchDao> {
        get<Database>().launchDao()
    }

    single<BookmarkDao> {
        get<Database>().bookmarkDao()
    }

    single<RemoteKeyDao> {
        get<Database>().remoteKeyDao()
    }
}