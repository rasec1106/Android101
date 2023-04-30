package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.Order
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.PizzaSize
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.Topping
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.theme.CT01_HerreraVillacorta_CesarHumbertoTheme

@Composable
fun OrderPizza() {

    val toppingsList = mutableListOf<Topping>(
        Topping("Onions",1, false),
        Topping("Olives",2, false),
        Topping("Tomatoes",3, false)
    )
    val pizzaSizeList = mutableListOf<PizzaSize>(
        PizzaSize("Small",5),
        PizzaSize("Medium",7),
        PizzaSize("Large",9)
    )
    val selectedPizzaSize = remember {
        mutableStateOf(pizzaSizeList.first())
    }
    val context = LocalContext.current

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
                            MyRadioButtonGroup(
                                pizzaSizeList = pizzaSizeList,
                                selectedPizzaSizeState = selectedPizzaSize
                            )
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
                                    MyCheckbox(topping)
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
                Button(onClick = {
                    val myOrder = Order(selectedPizzaSize.value,mutableListOf())
                    toppingsList.forEach{topping ->  
                        if (topping.isSelected.value)
                            myOrder.addTopping(topping)
                    }
                    Toast.makeText(
                        context,
                        "Correct ${myOrder.calculateTotal()}",
                        Toast.LENGTH_SHORT)
                        .show()
                }) {
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
fun MyCheckbox(topping: Topping){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = topping.isSelected.value, onCheckedChange = {
            topping.isSelected.value = it
        })
        Text(text = "${topping.name} ($${topping.price})")
    }
}
@Composable
fun MyRadioButtonGroup(
    pizzaSizeList: MutableList<PizzaSize>,
    selectedPizzaSizeState: MutableState<PizzaSize>
){
    val selectedSize = remember {
        mutableStateOf(pizzaSizeList.first())
    }
    val selectedIndex = remember {
        mutableStateOf(0)
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyColumn{
            pizzaSizeList.forEachIndexed { index, pizzaSize ->
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (index == selectedIndex.value),
                            onClick = {
                                selectedSize.value = pizzaSize
                                selectedIndex.value = index
                                selectedPizzaSizeState.value = pizzaSize
                            }
                        )
                        Text(text = "${pizzaSize.size} ($${pizzaSize.price})")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    CT01_HerreraVillacorta_CesarHumbertoTheme {
        OrderPizza()        
    }
}