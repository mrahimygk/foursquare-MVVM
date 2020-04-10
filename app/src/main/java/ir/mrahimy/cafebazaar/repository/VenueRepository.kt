package ir.mrahimy.cafebazaar.repository

import androidx.lifecycle.LiveData
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.network.ApiResult

interface VenueRepository {
    suspend fun get(): List<Venue>
    fun getOffline(): LiveData<List<Venue>>
    suspend fun sync(): ApiResult<Any>
    suspend fun insert(venue: Venue)
}