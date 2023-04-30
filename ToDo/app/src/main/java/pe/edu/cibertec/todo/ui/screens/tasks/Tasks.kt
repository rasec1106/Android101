package pe.edu.cibertec.todo.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
    // Wrapping all inside a new Composable called Scaffold
    Scaffold(
        /**
         * Scaffold has integrated components that can be useful
         * For example we can have a floating button
         */
//        floatingActionButton = {
//            FloatingActionButton(onClick = { /*TODO*/ }) {
//                Icon(Icons.Filled.Add, null)
//            }
//        },
        /**
         * And/Or we can add a top bar
         */
        topBar = {
            // The top bar can be declared also this way, but the second one has a different format because it's a title
//            TopAppBar {
//                Text(text = "To Do")
//            }
            TopAppBar(
                title = {Text(text = "To Do")},
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Add, null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "New name") },
                value = newName.value,
                onValueChange = {
                    newName.value = it
                }
            )
            // This button has been replaced by the floating button of the Scaffold
//            Button(onClick = {
//                newName.value = TextFieldValue("Prueba")
//            }) {
//                Text(text = "Submit")
//            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(names) {
                    Text(text = it)
                }
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