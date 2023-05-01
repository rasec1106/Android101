package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.screens

import android.content.Context
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
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements.MyCard
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements.MyCheckbox
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements.MyRadioButtonGroup
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements.MyTopBar
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.theme.CT01_HerreraVillacorta_CesarHumbertoTheme

@Composable
fun OrderPizza() {
    /**
     * We need some hardcoded elements, this could be improved by using a .json file
     * Is it possible in Kotlin???
     */
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

    /**
     * We need a state to remember which size has been selected
     * By default it'll be the first element in the list
     */
    val selectedPizzaSize = remember {
        mutableStateOf(pizzaSizeList.first())
    }
    val context = LocalContext.current

    Scaffold(topBar = { MyTopBar("Pizza Shop") }) {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(8.dp)
        ) {
            MyCard(
                title = "Choose your pizza size:",
                content = {
                    MyRadioButtonGroup(
                        pizzaSizeList = pizzaSizeList,
                        selectedPizzaSizeState = selectedPizzaSize
                    )
                }
            )
            MyCard(
                title = "Add your toppings:",
                content = {
                    LazyColumn{
                        items(toppingsList){topping ->
                            MyCheckbox(topping)
                        }
                    }
                }
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    /**
                     * Here we call all the logic to calculate the total amount
                     */
                    calculateTotalAmount(context, selectedPizzaSize, toppingsList)
                }) {
                    Text(text = "Confirm")
                }
            }
        }
    }
}
fun calculateTotalAmount(
    context: Context,
    selectedPizzaSize: MutableState<PizzaSize>,
    toppingsList: MutableList<Topping>
){
    // Create a new Order with the selectedPizzaSize and an empty list of toppings
    val myOrder = Order(selectedPizzaSize.value,mutableListOf())
    // Add the toppings to the order if they were selected by the user
    toppingsList.forEach{topping ->
        if (topping.isSelected.value)
            myOrder.addTopping(topping)
    }
    // Show the toast
    Toast.makeText(
        context,
        "The amount of your order is: $${myOrder.calculateTotal()}",
        Toast.LENGTH_SHORT)
        .show()
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    CT01_HerreraVillacorta_CesarHumbertoTheme {
        OrderPizza()        
    }
}