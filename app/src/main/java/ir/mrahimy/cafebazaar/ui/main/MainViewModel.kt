package ir.mrahimy.cafebazaar.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.mrahimy.cafebazaar.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val model: MainModel) : BaseViewModel(model) {

    private val _test = MutableLiveData<String>("")
    val test: LiveData<String>
        get() = _test

    init {
        viewModelScope.launch {
            var i = 0
            while (true) {
                delay(100)
                _test.postValue(i.toString())
                i++
            }

        }
    }
}
