package pe.edu.cibertec.session02.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
            label = { Text(text = "Username")},
            value = "",
            onValueChange = {} )
        TextField(
            label = { Text(text = "Password")},
            value = "",
            onValueChange = {} )
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