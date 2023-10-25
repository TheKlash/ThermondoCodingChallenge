package de.alekseipopov.domain.di

import de.alekseipopov.domain.pagination.LaunchPagingSource
import de.alekseipopov.domain.repository.LaunchesRepository
import de.alekseipopov.domain.repository.LaunchesRepositoryImpl
import org.koin.dsl.module

val domainModule = module {
    single<LaunchPagingSource> { LaunchPagingSource(get()) }
    factory<LaunchesRepository> { LaunchesRepositoryImpl(get(), get()) }
}