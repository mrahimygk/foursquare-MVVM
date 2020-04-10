package ir.mrahimy.cafebazaar.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.mrahimy.cafebazaar.base.BaseViewModel
import ir.mrahimy.cafebazaar.data.dataclass.*
import ir.mrahimy.cafebazaar.network.reponse.Photos
import ir.mrahimy.cafebazaar.network.reponse.VenuePage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val model: MainModel) : BaseViewModel(model) {

    private val _venueList = MutableLiveData<List<Venue>>()
    val venueList: LiveData<List<Venue>>
        get() = _venueList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        viewModelScope.launch {
            initList()
        }
    }

    suspend fun initList() {
        _isLoading.postValue(true)
        var i = 0
        repeat(15) {
            delay(100)
            _venueList.postValue(mutableListOf<Venue>().apply {
                addAll(venueList.value ?: listOf())
                add(model.makeMockVenue(i++))
            })
        }
        _isLoading.postValue(false)
    }
}
