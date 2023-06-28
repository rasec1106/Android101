package pe.edu.cibertec.musicapp.data.model

import com.google.gson.annotations.SerializedName

data class CustomResponse (
    @SerializedName("loved")
    val albums: List<Album>
)