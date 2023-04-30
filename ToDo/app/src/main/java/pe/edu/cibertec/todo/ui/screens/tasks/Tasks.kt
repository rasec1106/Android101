package pe.edu.cibertec.todo.ui.screens.tasks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
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
    LazyColumn(modifier = Modifier.fillMaxSize()){
        item {
            Text(text = "Prueba")
        }
        items(5) {
            Text(text = "$it item")
        }
        item {
            Text(text = "Cesar")
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