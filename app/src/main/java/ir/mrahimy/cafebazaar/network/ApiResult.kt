package ir.mrahimy.cafebazaar.network

import androidx.annotation.StringRes

sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(@StringRes val errorStringResourceId: Int, val errorCode: Int): ApiResult<Nothing>()
}