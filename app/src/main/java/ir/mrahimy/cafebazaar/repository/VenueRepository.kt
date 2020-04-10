package ir.mrahimy.cafebazaar.repository

import ir.mrahimy.cafebazaar.data.dataclass.Venue

interface VenueRepository {
    suspend fun get(): List<Venue>
    suspend fun getOffline(): List<Venue>
    suspend fun sync()
}