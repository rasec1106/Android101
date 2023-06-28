package pe.edu.cibertec.musicapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.cibertec.musicapp.ui.albums.AlbumList

@Composable
fun Home(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.AlbumList.route ){
        composable(Route.AlbumList.route){
            AlbumList(navController)
        }
    }
}

sealed class Route(val route: String){
    object AlbumList: Route("albumlist")
}