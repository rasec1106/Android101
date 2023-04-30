package pe.edu.cibertec.pizzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.pizzaapp.ui.theme.PizzaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier ) {

    val isCheckedPizzaAmericana = remember {
        mutableStateOf(false)
    }
    val isCheckedPizzaHawaiana = remember {
        mutableStateOf(true)
    }
    val isCheckedPizzaVegetariana = remember {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        TextField(value = "Name", onValueChange = {})
        TextField(value = "Quantity", onValueChange = {})
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCheckedPizzaAmericana.value, onCheckedChange = {})
            Text(text = "Pizza americana")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isCheckedPizzaHawaiana.value, onCheckedChange = {})
            Text(text = "Pizza hawaiana")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isCheckedPizzaVegetariana.value, onCheckedChange = {})
            Text(text = "Pizza vegetariana")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PizzaAppTheme {
        Home()
    }
}