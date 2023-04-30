package pe.edu.cibertec.todo.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.todo.ui.theme.ToDoTheme

@Composable
fun Tasks(){
    /**
     * Instead of using a normal Column, we use a LazyColumn
     * It can be scrollable and has a flexible height
     */

    val names = listOf("Lili","Diego","Jorge")

    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "New name")},
            value = "",
            onValueChange = {}
        )
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