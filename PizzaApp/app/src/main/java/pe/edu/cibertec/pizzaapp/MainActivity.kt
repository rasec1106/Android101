package pe.edu.cibertec.pizzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val name = remember {
        mutableStateOf("")
    }
    val quantity = remember {
        mutableStateOf("")
    }

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        TextField(
            label = { Text(text = "Name")},
            modifier = Modifier.fillMaxWidth(),
            value = name.value,
            onValueChange = {
                name.value = it
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            // Select only numbers for the input
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Quantity")},
            modifier = Modifier.fillMaxWidth(),
            value = quantity.value,
            onValueChange = {
                quantity.value = it
            }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCheckedPizzaAmericana.value,
                onCheckedChange = {newValue ->
                    isCheckedPizzaAmericana.value = newValue
                })
            Text(text = "Pizza americana")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCheckedPizzaHawaiana.value,
                onCheckedChange = {newValue ->
                    isCheckedPizzaHawaiana.value = newValue
                })
            Text(text = "Pizza hawaiana")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCheckedPizzaVegetariana.value,
                onCheckedChange = {newValue ->
                    isCheckedPizzaVegetariana.value = newValue
                })
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