package pe.edu.cibertec.musicapp.data.remote.service

import pe.edu.cibertec.musicapp.data.model.CustomResponse
import retrofit2.Call
import retrofit2.http.GET

interface AlbumService {
    @GET("mostloved.php?format=album")
    fun getAlbums(): Call<CustomResponse>
}