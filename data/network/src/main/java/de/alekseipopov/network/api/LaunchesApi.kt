package de.alekseipopov.network.api

import de.alekseipopov.network.enteties.LaunchesRequest
import de.alekseipopov.network.enteties.LaunchesResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LaunchesApi {
    @POST("/launches/query")
    fun getLaunches(@Body request: LaunchesRequest): LaunchesResponse

}