package ir.mrahimy.cafebazaar.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.db.dao.VenueDao
import ir.mrahimy.cafebazaar.db.typeconverter.*

@Database(
    entities = [
        Venue::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    VenueCategoryListConverter::class,
    LabeledLatLngListConverter::class,
    NothingListConverter::class,
    IntListConverter::class,
    StringListConverter::class
)
abstract class FourSquareDb : RoomDatabase() {
    abstract fun venueDao(): VenueDao
}