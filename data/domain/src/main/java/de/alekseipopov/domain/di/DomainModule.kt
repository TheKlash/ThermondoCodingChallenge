package de.alekseipopov.domain.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import de.alekseipopov.domain.pagination.LaunchPagerAdapter
import de.alekseipopov.domain.remoteMediator.LaunchRemoteMediator
import de.alekseipopov.domain.repository.LaunchesRepository
import de.alekseipopov.domain.repository.LaunchesRepositoryImpl
import org.koin.dsl.module

val domainModule = module {
    single<LaunchRemoteMediator> {
        LaunchRemoteMediator(get(), get())
    }
    single<LaunchPagerAdapter> {
        LaunchPagerAdapter(get(), get())
    }
    factory<LaunchesRepository> {
        LaunchesRepositoryImpl(get(), get())
    }
}