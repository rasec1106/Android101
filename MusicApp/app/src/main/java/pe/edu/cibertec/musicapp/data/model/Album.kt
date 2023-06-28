package pe.edu.cibertec.musicapp.data.model
import com.google.gson.annotations.SerializedName
data class Album (
    @SerializedName("idAlbum")
    val id: String,
    @SerializedName("strAlbum")
    val title: String,
    @SerializedName("strAlbumThumb")
    val imageUrl: String
)