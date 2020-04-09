package ir.mrahimy.cafebazaar.data.dataclass


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Delivery(
    @SerializedName("id")
    val id: String,
    @Embedded(prefix = "provider")
    @SerializedName("provider")
    val provider: DeliveryProvider,
    @SerializedName("url")
    val url: String
)