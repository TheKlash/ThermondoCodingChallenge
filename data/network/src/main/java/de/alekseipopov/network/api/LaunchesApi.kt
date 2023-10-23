package de.alekseipopov.network.api

import de.alekseipopov.network.enteties.Launch
import de.alekseipopov.network.enteties.LaunchesRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LaunchesApi {
    @POST("/launches/query")
    fun getLaunches(@Body request: LaunchesRequest): List<Launch>

}