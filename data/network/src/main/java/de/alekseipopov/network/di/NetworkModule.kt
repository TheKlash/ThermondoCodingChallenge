package de.alekseipopov.network.di

import de.alekseipopov.network.api.LaunchesApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<LaunchesApi> { providePhotoApi(get<Retrofit>()) }
}
private fun providePhotoApi(retrofit: Retrofit) = retrofit.create(LaunchesApi::class.java)
