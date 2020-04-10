package ir.mrahimy.cafebazaar.network

import ir.mrahimy.cafebazaar.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun <T : Any> safeApiCall(
    call: suspend () -> ApiResult<T>
): ApiResult<T> {
    return withContext(Dispatchers.Main) {
        try {
            withContext(Dispatchers.IO) {
                call()
            }
        } catch (e: Exception) {
            val errorCode = if (e is ApiException) e.statusCode else -1
            ApiResult.Error(R.string.error, errorCode)
        }
    }
}
