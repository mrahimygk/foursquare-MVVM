package ir.mrahimy.cafebazaar.ui.main

import android.location.Location
import com.google.android.gms.location.LocationRequest
import ir.mrahimy.cafebazaar.base.BaseModel
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.repository.VenueRepository

class MainModel(
    private val venueRepository: VenueRepository
) : BaseModel() {

    suspend fun getAll() = venueRepository.getAll()

    suspend fun get(venueId: String): Venue {
        return venueRepository.get(venueId)
    }

    val offlineVenueList = venueRepository.getOffline()

    suspend fun syncVenueList(
        limit: Int,
        offset: Int/*TODO: GET raw LOCATION DATA FROM vm <-- activity*/
    ) = venueRepository.sync(
        mapOf(
            "ll" to "40.7243,-74.0018",
            "limit" to limit.toString(),
            "offset" to offset.toString()
        )
    )

    private val locationRequest: LocationRequest? by lazy {
        LocationRequest.create()?.apply {
            fastestInterval = 2000L
            interval = 1000L
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    fun makeLocationRequest(): LocationRequest? = locationRequest

}