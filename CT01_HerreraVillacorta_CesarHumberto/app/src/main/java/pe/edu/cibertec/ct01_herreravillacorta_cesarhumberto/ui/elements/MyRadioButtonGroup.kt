package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.PizzaSize

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
