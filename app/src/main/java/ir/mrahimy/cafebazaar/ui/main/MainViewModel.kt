package ir.mrahimy.cafebazaar.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.mrahimy.cafebazaar.base.BaseViewModel
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.helper.Event
import ir.mrahimy.cafebazaar.network.ApiResult
import kotlinx.coroutines.launch

class MainViewModel(private val model: MainModel) : BaseViewModel(model) {

    val venueList = model.offlineVenueList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun syncVenueList(limit: Int, offset: Int) = viewModelScope.launch {
        _isLoading.postValue(true)
        when (val result = model.syncVenueList(limit, offset)) {
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
}
