package ir.mrahimy.cafebazaar.repository

import androidx.lifecycle.LiveData
import ir.mrahimy.cafebazaar.data.dataclass.Venue

interface VenueRepository {
    suspend fun get(): List<Venue>
    fun getOffline(): LiveData<List<Venue>>
    suspend fun sync()
    suspend fun insert(venue: Venue)
}