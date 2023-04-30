package pe.edu.cibertec.todo.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.todo.ui.theme.ToDoTheme

@Composable
fun Tasks(){
    /**
     * Instead of using a normal Column, we use a LazyColumn
     * It can be scrollable and has a flexible height
     */
    LazyColumn{
        item {
            Text(text = "Prueba")
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