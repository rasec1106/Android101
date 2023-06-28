package pe.edu.cibertec.musicapp.util

sealed class Result<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T): Result<T>(data= data)
    class Error<T>(message: String, data: T? = null): Result<T>(data = data, message = message)
}
