package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName

data class FourSquareExploreVenuesRes(
    @SerializedName("meta")
    val meta: FourSquareResponseMetaData,
    @SerializedName("response")
    val response: VenueQueryResponse
)