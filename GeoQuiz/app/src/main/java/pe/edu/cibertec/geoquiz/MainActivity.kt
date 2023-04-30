package pe.edu.cibertec.geoquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.geoquiz.ui.theme.GeoQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GeoQuiz()
                }
            }
        }
    }
}

@Composable
fun GeoQuiz(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // if we want to change the default position we can use offset
//            .offset(20.dp, 80.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Canberra is the capital of Australia")
        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "True")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "False")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeoQuizTheme {
        GeoQuiz()
    }
}