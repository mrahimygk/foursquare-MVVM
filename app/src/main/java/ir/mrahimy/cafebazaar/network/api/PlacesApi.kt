package ir.mrahimy.cafebazaar.network.api

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PlacesApi {

    @GET("/explore")
    suspend fun getPlaces(@QueryMap params: Map<String, String>): Any
}