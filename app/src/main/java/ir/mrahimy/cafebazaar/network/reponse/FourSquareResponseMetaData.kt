package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName

data class FourSquareResponseMetaData(
    @SerializedName("code")
    val code: Int,
    @SerializedName("requestId")
    val requestId: String
)