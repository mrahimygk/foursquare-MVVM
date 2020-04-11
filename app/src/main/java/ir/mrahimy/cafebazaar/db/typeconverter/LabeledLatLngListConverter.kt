package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import ir.mrahimy.cafebazaar.data.dataclass.LabeledLatLng

class LabeledLatLngListConverter : Serializer() {

    private val type by lazy {
        object : TypeToken<List<LabeledLatLng>?>() {}.type
    }

    @TypeConverter
    fun fromList(list: List<LabeledLatLng>?): String = gson.toJson(list, type)

    @TypeConverter
    fun fromDb(json: String?): List<LabeledLatLng> = gson.fromJson(json, type)

}