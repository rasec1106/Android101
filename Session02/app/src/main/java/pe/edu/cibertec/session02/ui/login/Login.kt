package pe.edu.cibertec.session02.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.cibertec.session02.ui.theme.Session02Theme

@Composable
fun Login(){
    // Column is a composable item that help us to set the elements
    Column(
        modifier = Modifier.fillMaxSize(),     // we can add modifiers to change the behaviour
        verticalArrangement = Arrangement.Center, // Arrangement for vertical
        horizontalAlignment = Alignment.CenterHorizontally // Alignment for horizontal
    ) {
        Text(text = "Login")
        // onValueChange needs a function, so we can pass a {} at a first moment
        TextField(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            label = { Text(text = "Username")},
            value = "",
            onValueChange = {},
            // leadingIcon puts an icon at the beginning, trailingIcon at the end
            leadingIcon = {Icon(Icons.Default.Person, null)}
        )
        TextField(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            label = { Text(text = "Password")},
            value = "",
            onValueChange = {},
            leadingIcon = {Icon(Icons.Default.Lock, null)}
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign in")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign up")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Forgot password")
        }
    }
}

// Creating the preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Session02Theme {
        Login()
    }
}