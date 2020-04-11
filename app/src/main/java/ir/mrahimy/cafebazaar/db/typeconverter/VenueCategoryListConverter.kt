package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import ir.mrahimy.cafebazaar.data.dataclass.VenueCategory

class VenueCategoryListConverter : Serializer() {

    private val type by lazy {
        object : TypeToken<List<VenueCategory>?>() {}.type
    }

    @TypeConverter
    fun fromList(list: List<VenueCategory>?): String = gson.toJson(list, type)

    @TypeConverter
    fun fromDb(json: String?): List<VenueCategory>? = gson.fromJson(json, type)

}