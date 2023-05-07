package pe.edu.cibertec.agendacompose.ui.screens.contacts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.agendacompose.data.model.Contact
import pe.edu.cibertec.agendacompose.ui.theme.AgendaComposeTheme

@Composable
fun Contacts(){
    val contacts = mutableListOf<Contact>(
        Contact(1,"Jorge"),
        Contact(2,"Francisco")
    )
    val name = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agenda") },
                actions = {
                    IconButton(onClick = {
                        val contact = Contact(3,name.value)
                        contacts.add(contact)
                        name.value = ""
                    }) {
                        Icon(Icons.Filled.Add, null)
                    }
                }
            )
        }
    ) {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nombre") },
                value = name.value,
                onValueChange = {
                    name.value = it
                })
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(contacts) { contact ->
                    Text(text = contact.name)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    AgendaComposeTheme {
        Contacts()
    }
}