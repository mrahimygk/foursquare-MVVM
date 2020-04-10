package ir.mrahimy.cafebazaar.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.mrahimy.cafebazaar.base.BaseViewModel
import ir.mrahimy.cafebazaar.data.dataclass.Venue
import ir.mrahimy.cafebazaar.helper.StatelessEvent
import ir.mrahimy.cafebazaar.network.ApiResult
import ir.mrahimy.cafebazaar.ui.main.MainModel
import kotlinx.coroutines.launch

class DetailsViewModel(private val model: MainModel) : BaseViewModel(model) {

    private val _selectedVenue = MutableLiveData<Venue>()
    val selectedVenue: LiveData<Venue>
        get() = _selectedVenue

    fun selectVenue(venueId: String) {
        viewModelScope.launch {
            _selectedVenue.postValue(model.get(venueId))
        }
    }
}
