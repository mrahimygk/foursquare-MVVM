package ir.mrahimy.cafebazaar.db.dao

import androidx.room.Dao
import androidx.room.Query
import ir.mrahimy.cafebazaar.base.BaseDao
import ir.mrahimy.cafebazaar.data.dataclass.Venue

@Dao
interface VenueDao : BaseDao<Venue> {

    @Query("SELECT * FROM venue")
    suspend fun get(): List<Venue>

    @Query("SELECT * FROM venue WHERE id in (:ids)")
    suspend fun get(vararg ids: String): List<Venue>

}