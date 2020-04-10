package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import ir.mrahimy.cafebazaar.data.dataclass.VenueCategory
import ir.mrahimy.cafebazaar.ktx.serialization.fromJson
import ir.mrahimy.cafebazaar.ktx.serialization.toJson
import java.io.Serializable

class VenueCategoryListConverter : Serializable {

    @TypeConverter
    fun fromList(list: List<VenueCategory>?) = toJson(list)

    @TypeConverter
    fun fromDb(json: String?): List<VenueCategory> = fromJson(json)
}