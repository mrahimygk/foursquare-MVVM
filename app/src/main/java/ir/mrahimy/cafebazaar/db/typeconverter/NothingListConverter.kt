package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter

class NothingListConverter : Serializer() {

    @TypeConverter
    fun fromList(list: List<Nothing>?): String = ""


    @TypeConverter
    fun fromDb(json: String?): List<Nothing>? = emptyList()
}
