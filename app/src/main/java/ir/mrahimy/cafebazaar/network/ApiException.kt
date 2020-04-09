package ir.mrahimy.cafebazaar.network

import java.io.IOException

/**
 * will be used to throw exceptions in interceptors
 */
class ApiException(val statusCode: Int, e: Throwable? = null) : IOException(e)