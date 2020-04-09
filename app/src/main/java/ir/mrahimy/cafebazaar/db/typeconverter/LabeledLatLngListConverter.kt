package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.mrahimy.cafebazaar.data.dataclass.LabeledLatLng
import ir.mrahimy.cafebazaar.data.dataclass.VenueCategory
import java.io.Serializable

class LabeledLatLngListConverter : Serializable {

    @TypeConverter
    fun fromList(list: List<LabeledLatLng>?): String {
        return toJson(list)
    }

    @TypeConverter
    fun fromDb(json: String?): List<LabeledLatLng> {
        return fromJson(json)
    }
}