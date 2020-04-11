package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import java.io.Serializable

/**
 * Integers are converted to json as doubles?
 * So I could not use ktx from [Serializable]
 */
class IntListConverter : Serializer() {

    private val type by lazy {
        object : TypeToken<List<Int>?>() {}.type
    }

    @TypeConverter
    fun fromList(list: List<Int>?): String = gson.toJson(list, type)

    @TypeConverter
    fun fromDb(json: String?): List<Int>? = gson.fromJson(json, type)

}