package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.Order
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.PizzaSize
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.Topping
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.theme.CT01_HerreraVillacorta_CesarHumbertoTheme

@Composable
fun OrderPizza() {

    val toppingsList = mutableListOf<Topping>(
        Topping("Onions",1),
        Topping("Olives",2),
        Topping("Tomatoes",3)
    )
    val pizzaSizeList = mutableListOf<PizzaSize>(
        PizzaSize("Small",5),
        PizzaSize("Medium",7),
        PizzaSize("Large",9)
    )

    Scaffold(topBar = { MyTopBar() }) {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(8.dp)) {
            Card(
                elevation = 2.dp,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Choose your pizza size:")
                        }
                        Row(modifier = Modifier.fillMaxWidth()) {
                            LazyColumn{
                                items(pizzaSizeList){size ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(selected = false, onClick = { /*TODO*/ })
                                        Text(text = size.size)
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Card(
                elevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Add your toppings:")
                        }
                        Row(modifier = Modifier.fillMaxWidth()) {
                            LazyColumn{
                                items(toppingsList){topping ->
                                    MyCheckbox(isChecked = false, description = topping.name )
                                }
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Confirm")
                }
            }
        }
    }
}

@Composable
fun MyTopBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Pizza Shop")
            }
        }
    )
}
@Composable
fun MyCheckbox(isChecked: Boolean, description: String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = false, onCheckedChange = {

        })
        Text(text = description)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    CT01_HerreraVillacorta_CesarHumbertoTheme {
        OrderPizza()        
    }
}