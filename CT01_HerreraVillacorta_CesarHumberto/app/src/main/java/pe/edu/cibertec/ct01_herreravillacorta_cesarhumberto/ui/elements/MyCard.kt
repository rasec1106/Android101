package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * This composable is a card with
 * - a title
 * - a content passed as a parameter --> needs to be another Composable
 * We are using this element to avoid styling it everytime
 */
@Composable
fun MyCard(
    title: String,
    content: @Composable () -> Unit
) {
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
            Column {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = title)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    content()
                }
            }
        }
    }
}
