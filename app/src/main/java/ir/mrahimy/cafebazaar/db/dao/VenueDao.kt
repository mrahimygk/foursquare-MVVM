package ir.mrahimy.cafebazaar.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ir.mrahimy.cafebazaar.base.BaseDao
import ir.mrahimy.cafebazaar.data.dataclass.Venue

@Dao
interface VenueDao : BaseDao<Venue> {

    @Query("SELECT * FROM venue")
    fun get(): LiveData<List<Venue>>

    @Query("SELECT * FROM venue WHERE id in (:ids)")
    fun get(vararg ids: String): LiveData<List<Venue>>

    @Query("SELECT * FROM venue WHERE id =:id LIMIT 1")
    suspend fun getSuspend(id: String): Venue

}