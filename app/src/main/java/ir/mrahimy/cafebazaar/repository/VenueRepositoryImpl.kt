package ir.mrahimy.cafebazaar.repository

import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.db.dao.VenueDao
import ir.mrahimy.cafebazaar.network.api.VenuesApi

class VenueRepositoryImpl(
    private val api: VenuesApi,
    private val dao: VenueDao
) : VenueRepository {
    override suspend fun get(): List<Venue> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getOffline(): List<Venue> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sync() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}