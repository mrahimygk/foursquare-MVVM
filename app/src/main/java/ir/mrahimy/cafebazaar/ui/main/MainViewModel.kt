package ir.mrahimy.cafebazaar.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.mrahimy.cafebazaar.base.BaseViewModel
import ir.mrahimy.cafebazaar.network.ApiResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val model: MainModel) : BaseViewModel(model) {

    val venueList = model.offlineVenueList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun sync(offset:Int) = viewModelScope.launch {
        _isLoading.postValue(true)
        delay(100)
        when (val result = model.syncVenueList(offset)) {
            is ApiResult.Success -> {
                val data = result.data
            }
            is ApiResult.Error -> {
                val error = result.errorCode
            }
        }
        _isLoading.postValue(false)
    }

}
