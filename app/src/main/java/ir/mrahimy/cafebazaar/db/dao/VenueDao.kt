package ir.mrahimy.cafebazaar.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ir.mrahimy.cafebazaar.base.BaseDao
import ir.mrahimy.cafebazaar.data.dataclass.Venue

@Dao
interface VenueDao : BaseDao<Venue> {

    @Query("SELECT * FROM venue ORDER BY fetched_order")
    fun getAll(): LiveData<List<Venue>>

    @Query("SELECT * FROM venue WHERE id in (:ids) ORDER BY fetched_order")
    fun get(vararg ids: String): LiveData<List<Venue>>

    @Query("SELECT * FROM venue WHERE id =:id LIMIT 1")
    suspend fun getSuspend(id: String): Venue

    /**
     * counting them to add the order index
     */
    @Query("SELECT COUNT(id) FROM venue")
    suspend fun count(): Int

    @Query("DELETE FROM venue WHERE 1")
    suspend fun clearAll(): Int

}