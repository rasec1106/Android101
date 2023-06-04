package pe.edu.cibertec.restaurantcompose.data.model

data class Restaurant(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val latitude: Double,
    val longitude: Double
)