package ir.mrahimy.cafebazaar.ui.main

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

}