package ir.mrahimy.cafebazaar.data.dataclass


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class DeliveryProvider(
    @Embedded(prefix = "icon")
    @SerializedName("icon")
    val icon: NamedIconAddress,
    @SerializedName("name")
    val name: String
)