package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName

data class DeliveryProvider(
    @SerializedName("icon")
    val icon: NamedIconAddress,
    @SerializedName("name")
    val name: String
)