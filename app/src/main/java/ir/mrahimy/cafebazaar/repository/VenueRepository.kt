package ir.mrahimy.cafebazaar.repository

import androidx.lifecycle.LiveData
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.network.ApiResult

interface VenueRepository {
    suspend fun getAll(): List<Venue>
    fun getOffline(): LiveData<List<Venue>>
    suspend fun sync(queryMap: Map<String, String>, shouldClearDb: Boolean): ApiResult<Any>
    suspend fun get(venueId: String): Venue
}