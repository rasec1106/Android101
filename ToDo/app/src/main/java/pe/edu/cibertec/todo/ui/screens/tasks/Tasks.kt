package pe.edu.cibertec.todo.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.todo.ui.theme.ToDoTheme

@Composable
fun Tasks(){
    /**
     * Instead of using a normal Column, we use a LazyColumn
     * It can be scrollable and has a flexible height
     */

    val names = listOf("Lili","Diego","Jorge")

    // Create a state
    var newName = remember {
        mutableStateOf(TextFieldValue())
    }
    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "New name")},
            value = newName.value,
            onValueChange = {
                newName.value = it
            }
        )
        Button(onClick = {
            newName.value = TextFieldValue("Prueba")
        }) {
            Text(text = "Submit")
        }
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(names){
                Text(text = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TasksPreview(){
    ToDoTheme {
        Tasks()
    }
}