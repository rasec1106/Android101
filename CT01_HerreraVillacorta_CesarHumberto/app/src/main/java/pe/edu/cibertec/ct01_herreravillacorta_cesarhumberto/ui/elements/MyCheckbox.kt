package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model.Topping

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