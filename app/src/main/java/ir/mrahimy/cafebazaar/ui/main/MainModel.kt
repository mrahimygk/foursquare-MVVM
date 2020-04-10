package ir.mrahimy.cafebazaar.ui.main

import ir.mrahimy.cafebazaar.base.BaseModel
import ir.mrahimy.cafebazaar.repository.VenueRepository

class MainModel(
    private val venueRepository: VenueRepository
) : BaseModel() {
    suspend fun get() = venueRepository.get()
}