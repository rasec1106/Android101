package pe.edu.cibertec.musicapp.data.repository

import android.util.Log
import pe.edu.cibertec.musicapp.data.model.Album
import pe.edu.cibertec.musicapp.data.model.CustomResponse
import pe.edu.cibertec.musicapp.data.remote.ApiClient
import pe.edu.cibertec.musicapp.data.remote.service.AlbumService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import pe.edu.cibertec.musicapp.util.Result

class AlbumRepository (
    private val albumService: AlbumService = ApiClient.getAlbumService()
){
    fun getAlbums(callback: (Result<List<Album>>) -> Unit){
        albumService.getAlbums().enqueue(object: Callback<CustomResponse> {
            override fun onResponse(call: Call<CustomResponse>, response: Response<CustomResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val customResponse: CustomResponse = response.body()!!
                    callback(Result.Success(customResponse.albums))
                }else{
                    callback(Result.Error("Data not found"))
                }
            }

            override fun onFailure(call: Call<CustomResponse>, t: Throwable) {
                callback(Result.Error("Albums not available"))
            }
        })
    }
}