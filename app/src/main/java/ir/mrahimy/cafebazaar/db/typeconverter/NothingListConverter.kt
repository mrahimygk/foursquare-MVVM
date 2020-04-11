package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter

class NothingListConverter : Serializer() {

    @TypeConverter
    fun fromList(list: List<Nothing>?): String {
        return ""
    }

    @TypeConverter
    fun fromDb(json: String?): List<Nothing> {
        return emptyList()
    }
}