package pe.edu.cibertec.agendacompose.ui.screens.contacts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.agendacompose.data.local.AppDatabase
import pe.edu.cibertec.agendacompose.data.model.Contact
import pe.edu.cibertec.agendacompose.ui.theme.AgendaComposeTheme

@Composable
fun Contacts(){
    val contacts = remember {
        mutableStateOf(listOf<Contact>())
    }
    val context = LocalContext.current
    val name = remember {
        mutableStateOf("")
    }
    val contactDao = AppDatabase.getInstance(context).contactDao()
    contacts.value = contactDao.fetchAll()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agenda") },
                actions = {
                    IconButton(onClick = {
                        val contact = Contact(0,name.value)
                        contactDao.insert(contact)
                        contacts.value = contactDao.fetchAll()
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
                label = { Text(text = "Name") },
                value = name.value,
                onValueChange = {
                    name.value = it
                })
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(contacts.value) { contact ->
                    Row {
                        Text(text = contact.name)
                        IconButton(onClick = {
                            contactDao.delete(contact)
                            contacts.value = contactDao.fetchAll()
                        }) {
                            Icon(Icons.Filled.Delete, null)
                        }
                    }

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