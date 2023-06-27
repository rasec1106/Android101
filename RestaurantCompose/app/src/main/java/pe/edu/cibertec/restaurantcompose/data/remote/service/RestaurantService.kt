package pe.edu.cibertec.restaurantcompose.data.remote.service

import pe.edu.cibertec.restaurantcompose.data.model.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {
    @GET("restaurants")
    fun getRestaurants(): Call<List<Restaurant>>
}