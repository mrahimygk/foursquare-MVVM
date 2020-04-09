package ir.mrahimy.cafebazaar.network.api

import ir.mrahimy.cafebazaar.network.reponse.VenueQueryResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PlacesApi {

    @GET("venues/explore/")
    suspend fun getPlaces(@QueryMap params: Map<String, String>): VenueQueryResponse
}