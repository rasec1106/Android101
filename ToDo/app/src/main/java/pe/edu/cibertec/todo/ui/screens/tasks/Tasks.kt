package pe.edu.cibertec.todo.ui.screens.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.todo.ui.theme.ToDoTheme

@Composable
fun Tasks(){
    /**
     * Instead of using a normal Column, we use a LazyColumn
     * It can be scrollable and has a flexible height
     */

//    val names = mutableListOf("Lili","Diego","Jorge")
    // We transform names into a state, so Kotlin can re-render when it changes
    val names = remember {
        mutableStateListOf<String>("Lili","Diego","Jorge")
    }
    // Create a state
    val newName = remember {
        mutableStateOf(TextFieldValue())
    }
    val isEnabled = remember {
        mutableStateOf(false)
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
            // The top bar can be declared also this way, but the second one has a different format because it has a title
//            TopAppBar {
//                Text(text = "To Do")
//            }
            TopAppBar(
                title = {Text(text = "To Do")},
                actions = {
                    IconButton(
                        onClick = {
                            names.add(newName.value.text)
                            newName.value = TextFieldValue()
                            isEnabled.value = false
                        },
                        enabled = isEnabled.value
                    ) {
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
                    isEnabled.value = newName.value.text.isNotEmpty()
                },
                // we could also add some Keyboard mapping
                // The objective is to add a new element when the user hits enter
                keyboardActions = KeyboardActions(
                    onDone = {
                        names.add(newName.value.text)
                        newName.value = TextFieldValue()
                        isEnabled.value = false
                    }
                )
            )
            // This button has been replaced by the floating button of the Scaffold
//            Button(onClick = {
//                newName.value = TextFieldValue("Test")
//            }) {
//                Text(text = "Submit")
//            }
            LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                items(names) {name->
                    Card(
                        elevation = 2.dp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = name,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            IconButton(onClick = {
                                names.remove(name)
                            }) {
                                Icon(Icons.Filled.Delete, null)
                            }
                        }
                    }
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