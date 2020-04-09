package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName

data class Delivery(
    @SerializedName("id")
    val id: String,
    @SerializedName("provider")
    val provider: DeliveryProvider,
    @SerializedName("url")
    val url: String
)