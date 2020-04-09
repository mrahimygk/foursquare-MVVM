package ir.mrahimy.cafebazaar.data.dataclass


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.network.reponse.Photos
import ir.mrahimy.cafebazaar.network.reponse.VenuePage

@Entity
data class Venue(
    @SerializedName("categories")
    val categories: List<VenueCategory>,
    @Embedded(prefix = "delivery_")
    @SerializedName("delivery")
    val delivery: Delivery,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @Embedded(prefix = "location_")
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @Embedded(prefix = "photo_")
    @SerializedName("photos")
    val photos: Photos,
    @Embedded(prefix = "page_")
    @SerializedName("venuePage")
    val venuePage: VenuePage
)