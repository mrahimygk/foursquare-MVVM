package ir.mrahimy.cafebazaar.data.dataclass


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.network.reponse.Photos
import ir.mrahimy.cafebazaar.network.reponse.VenuePage
import java.lang.StringBuilder

@Entity
data class Venue(
    @SerializedName("categories")
    val categories: List<VenueCategory>?,
    @Embedded(prefix = "delivery_")
    @SerializedName("delivery")
    val delivery: Delivery?,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @Embedded(prefix = "location_")
    @SerializedName("location")
    val location: Location?,
    @SerializedName("name")
    val name: String?,
    @Embedded(prefix = "photo_")
    @SerializedName("photos")
    val photos: Photos?,
    @Embedded(prefix = "page_")
    @SerializedName("venuePage")
    val venuePage: VenuePage?,
    /**
     * the most basic way of syncing local order with server when no data has been specified
     * maybe 4sq api orders them by distance ( sqrt(power(lat,2) + power(lon,2) )
     */
    @ColumnInfo(name = "fetched_order")
    val fetchedOrder: Int
) {
    var image: String? = ""
}

fun Venue.fill(): Venue {
    delivery?.provider?.icon?.let { address ->
        image = StringBuilder()
            .append(address.prefix)
            .append(address.sizes?.max())
            .append(address.name).toString()
    }
    return this
}