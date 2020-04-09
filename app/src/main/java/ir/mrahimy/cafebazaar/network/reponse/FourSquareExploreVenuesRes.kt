package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName

/**
 * This data class holds other responses.
 * e.g. [PlacesApi][ir.mrahimy.cafebazaar.network.api.PlacesApi] returns
 * [VenueQueryResponse] and not this class.
 */
data class FourSquareExploreVenuesRes(
    @SerializedName("meta")
    val meta: FourSquareResponseMetaData,
    @SerializedName("response")
    val response: Any?
)