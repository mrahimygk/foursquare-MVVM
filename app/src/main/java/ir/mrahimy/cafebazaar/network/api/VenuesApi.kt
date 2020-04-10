package ir.mrahimy.cafebazaar.network.api

import ir.mrahimy.cafebazaar.network.reponse.VenueQueryResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * 4sq DOCS:
 * (ll and radius) or
 * (sw and ne) or
 * (near and radius) or
 * (nearVenueId and ll) or
 * (superVenueId) or
 * (polygon)"
 */
interface VenuesApi {

    @GET("venues/explore")
    suspend fun query(@QueryMap params: Map<String, String>): VenueQueryResponse
}