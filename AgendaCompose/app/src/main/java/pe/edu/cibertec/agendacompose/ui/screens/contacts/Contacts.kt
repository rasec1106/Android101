package pe.edu.cibertec.agendacompose.ui.screens.contacts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.agendacompose.data.local.AppDatabase
import pe.edu.cibertec.agendacompose.data.model.Contact
import pe.edu.cibertec.agendacompose.ui.theme.AgendaComposeTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Contacts(){
    val contacts = remember {
        mutableStateOf(listOf<Contact>())
    }
    val name = remember {
        mutableStateOf("")
    }
    val isEditing = remember {
        mutableStateOf(false)
    }
    val editContact = remember {
        mutableStateOf(Contact(0,""))
    }
    val context = LocalContext.current
    val contactDao = AppDatabase.getInstance(context).contactDao()
    contacts.value = contactDao.fetchAll()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agenda") },
                actions = {
                    IconButton(onClick = {
                        if(isEditing.value){
                            editContact.value.name = name.value
                            contactDao.update(editContact.value)
                        } else{
                            val contact = Contact(0,name.value)
                            contactDao.insert(contact)
                        }
                        contacts.value = contactDao.fetchAll()
                        name.value = ""
                        isEditing.value = false
                    }) {
                        Icon(
                            if(isEditing.value) Icons.Filled.Edit
                            else Icons.Filled.Add,
                            null)
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
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        onClick = {
                            name.value = contact.name
                            isEditing.value = true
                            editContact.value = contact
                    }) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                                ){
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    AgendaComposeTheme {
        Contacts()
    }
}