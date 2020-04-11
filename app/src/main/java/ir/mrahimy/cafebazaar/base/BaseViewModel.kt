package ir.mrahimy.cafebazaar.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.mrahimy.cafebazaar.helper.Event

abstract class BaseViewModel(private val model: BaseModel) : ViewModel() {

    /**
     * classes extending [BaseViewModel] can use _snackMessage to post string resources
     * Views should observe on the public value [snackMessage]
     */
    protected val _snackMessage = MutableLiveData<Event<Int>>()
    val snackMessage: LiveData<Event<Int>>
        get() = _snackMessage
}