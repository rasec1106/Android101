package pe.edu.cibertec.musicapp.ui.albums

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import pe.edu.cibertec.musicapp.data.model.Album
import pe.edu.cibertec.musicapp.data.repository.AlbumRepository
import pe.edu.cibertec.musicapp.ui.theme.MusicAppTheme
import pe.edu.cibertec.musicapp.util.Result

@Composable
fun AlbumList(navController: NavController){
    val albums = remember{
        mutableStateOf(listOf<Album>())
    }
    val context = LocalContext.current
    val albumRepository = AlbumRepository()

    albumRepository.getAlbums {result ->
        if(result is Result.Success){
            albums.value = result.data!!
        } else{
            albums.value = listOf(Album("00000",result.message.toString(),"" ))
            Toast.makeText(context, result.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Music App") }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            LazyColumn() {
                items(albums.value) { album ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        Card {
                            AsyncImage(
                                model = album.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(256.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Box(
                            modifier = Modifier.padding(8.dp).background(
                                color = MaterialTheme.colors.onPrimary,
                                shape = RoundedCornerShape(4.dp)
                            )
                        ) {
                            Text(text = album.title, modifier = Modifier.padding(8.dp))
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MusicAppTheme() {
        AlbumList(navController = rememberNavController())
    }
}