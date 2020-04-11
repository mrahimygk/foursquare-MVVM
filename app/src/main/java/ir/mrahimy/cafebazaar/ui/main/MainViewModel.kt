package ir.mrahimy.cafebazaar.ui.main

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseViewModel
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.data.dataclass.fill
import ir.mrahimy.cafebazaar.helper.Event
import ir.mrahimy.cafebazaar.network.ApiResult
import kotlinx.coroutines.launch

class MainViewModel(private val model: MainModel) : BaseViewModel(model) {

    val venueList = model.offlineVenueList.map {
        it.map { venue ->
            venue.fill()
        }
    }

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val perPageLimit = 10

    fun syncVenueList(page: Int, location: Location?, shouldClearDb: Boolean = false) =
        viewModelScope.launch {
            if (location == null) {
                _snackMessage.postValue(Event(R.string.no_last_location))
                return@launch
            }
            _isLoading.postValue(true)
            when (val result =
                model.syncVenueList(
                    perPageLimit,
                    page * perPageLimit,
                    location,
                    shouldClearDb
                )) {
                is ApiResult.Success -> {
                    val data = result.data
                }
                is ApiResult.Error -> {
                    val error = result.errorCode
                }
            }
            _isLoading.postValue(false)
        }

    private val _onStartDetailsActivity = MutableLiveData<Event<String>>()
    val onStartDetailsActivity: LiveData<Event<String>>
        get() = _onStartDetailsActivity

    fun selectVenue(item: Venue) {
        _onStartDetailsActivity.postValue(Event(item.id))
    }

    fun getLocationRequest() = model.makeLocationRequest()
}
