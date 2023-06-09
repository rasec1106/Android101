package pe.edu.cibertec.agendacompose_lab02.ui.screen.contacts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.agendacompose_lab02.data.local.AppDatabase
import pe.edu.cibertec.agendacompose_lab02.data.model.Contact
import pe.edu.cibertec.agendacompose_lab02.ui.theme.AgendaCompose_Lab02Theme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Contacts(){
    val contacts = remember {
        mutableStateOf(listOf<Contact>())
    }
    val favoritesArray= remember {
        mutableStateOf(listOf<Int>())
    }
    val name = remember {
        mutableStateOf("")
    }
    val isEditing = remember {
        mutableStateOf(false)
    }
    val editContact = remember {
        mutableStateOf(Contact(0,"",0))
    }
    val context = LocalContext.current
    val contactDao = AppDatabase.getInstance(context).contactDao()
    contacts.value = contactDao.getAll()
    favoritesArray.value = contacts.value.map { contact: Contact -> contact.isFavorite }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agenda Compose") },
                actions = {
                    IconButton(onClick = {
                        if(isEditing.value){
                            editContact.value.name = name.value
                            contactDao.update(editContact.value)
                        } else{
                            val contact = Contact(0,name.value,0)
                            contactDao.insert(contact)
                        }
                        contacts.value = contactDao.getAll()
                        favoritesArray.value = contacts.value.map { contact: Contact -> contact.isFavorite }
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
                            .padding(4.dp),
                        backgroundColor = Color.hsl(207F, 0.22F, 0.88F,1F),
                        onClick = {
                            name.value = contact.name
                            isEditing.value = true
                            editContact.value = contact
                        }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp, 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(modifier = Modifier.weight(6f), text = contact.name)
                            IconButton(modifier = Modifier.weight(1f), onClick = {
                                contact.isFavorite = (contact.isFavorite + 1) % 2
                                contactDao.update(contact)
                                contacts.value = contactDao.getAll()
                                favoritesArray.value = contacts.value.map { contact: Contact -> contact.isFavorite }
                            }) {
                                if(favoritesArray.value[contacts.value.indexOf(contact)] == 1) Icon(Icons.Filled.Favorite, null, tint = Color.Blue)
                                else Icon(Icons.Filled.Favorite,null)
                            }
                            IconButton(modifier = Modifier.weight(1f), onClick = {
                                contactDao.delete(contact)
                                contacts.value = contactDao.getAll()
                                favoritesArray.value = contacts.value.map { contact: Contact -> contact.isFavorite }
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
    AgendaCompose_Lab02Theme {
        Contacts()
    }
}