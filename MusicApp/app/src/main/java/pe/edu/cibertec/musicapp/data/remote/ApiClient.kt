package pe.edu.cibertec.musicapp.data.remote

import pe.edu.cibertec.musicapp.data.remote.service.AlbumService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val API_BASE_URL = "https://theaudiodb.com/api/v1/json/523532/"

    private var retrofit: Retrofit? = null
    private var albumService: AlbumService? = null

    private fun getRetrofit(): Retrofit {
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit as Retrofit
    }
    fun getAlbumService(): AlbumService {
        if(albumService == null){
            albumService = getRetrofit().create(AlbumService:: class.java)
        }
        return albumService as AlbumService
    }
}