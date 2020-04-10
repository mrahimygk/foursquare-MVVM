package ir.mrahimy.cafebazaar.ui.main

import ir.mrahimy.cafebazaar.base.BaseModel
import ir.mrahimy.cafebazaar.data.dataclass.*
import ir.mrahimy.cafebazaar.network.reponse.Photos
import ir.mrahimy.cafebazaar.network.reponse.VenuePage
import ir.mrahimy.cafebazaar.repository.VenueRepository
import kotlin.random.Random

class MainModel(
    private val venueRepository: VenueRepository
) : BaseModel() {
    suspend fun get() = venueRepository.get()
    val offlineVenueList = venueRepository.getOffline()
    private fun makeMockVenue(i: Int): Venue =
        Venue(
            listOf(),
            Delivery(
                i.toString(),
                DeliveryProvider(NamedIconAddress("a", "b", listOf()), "name"),
                "http"
            ),
            "id$i", Location(
                "add",
                "ct$i",
                "city$i",
                "iran",
                "onja",
                100,
                listOf("aaa$i", "bbb$i"),
                listOf(
                    LabeledLatLng("inja", 100.0, 200.0)
                ),
                200.0,
                150.0,
                "9874$i",
                "CA"
            ), "CAffeLate", Photos(1, listOf()),
            VenuePage("2$i")
        )

    suspend fun addMockVenue() {
        venueRepository.insert(makeMockVenue(Random.nextInt(10000)))
    }

    suspend fun sync() = venueRepository.sync()

}