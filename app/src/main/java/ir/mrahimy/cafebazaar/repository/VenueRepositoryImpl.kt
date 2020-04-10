package ir.mrahimy.cafebazaar.repository

import androidx.lifecycle.LiveData
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.db.dao.VenueDao
import ir.mrahimy.cafebazaar.network.ApiResult
import ir.mrahimy.cafebazaar.network.api.VenuesApi
import ir.mrahimy.cafebazaar.network.safeApiCall

class VenueRepositoryImpl(
    private val api: VenuesApi,
    private val dao: VenueDao
) : VenueRepository {
    override suspend fun get(): List<Venue> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOffline(): LiveData<List<Venue>> = dao.get()

    override suspend fun sync(queryMap: Map<String, String>) =
        safeApiCall {
            val result = api.query(queryMap)
            val venueList = result.groups.flatMap { group ->
                group.items.map { item ->
                    item.venue
                }
            }
            venueList.forEach { venue -> dao.insert(venue) }
            return@safeApiCall ApiResult.Success(Any())
        }
}