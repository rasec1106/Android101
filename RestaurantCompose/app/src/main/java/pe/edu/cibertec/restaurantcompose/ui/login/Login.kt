package pe.edu.cibertec.restaurantcompose.ui.login


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.edu.cibertec.restaurantcompose.data.repository.UserRepository

import pe.edu.cibertec.restaurantcompose.ui.Route
import pe.edu.cibertec.restaurantcompose.ui.theme.RestaurantComposeTheme


@Composable
fun Login(navController: NavController){

    val username = remember{
        mutableStateOf(TextFieldValue())
    }
    val password = remember{
        mutableStateOf(TextFieldValue())
    }
    val showPassword = remember{
        mutableStateOf(false)
    }

    val userRepository = UserRepository()

    // Column is a composable item that help us to set the elements
    Column(
        modifier = Modifier.fillMaxSize(),     // we can add modifiers to change the behaviour
        verticalArrangement = Arrangement.Center, // Arrangement for vertical
        horizontalAlignment = Alignment.CenterHorizontally // Alignment for horizontal
    ) {
        Text(text = "Login")
        // onValueChange needs a function, so we can pass a {} at a first moment
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it },
            // leadingIcon puts an icon at the beginning, trailingIcon at the end
            leadingIcon = { Icon(Icons.Default.Person, null) },
            shape = RoundedCornerShape(8.dp)
        )
        // We can use another composable to add space
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = if(showPassword.value){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            },
            onValueChange = { password.value = it },
            leadingIcon = { Icon(Icons.Default.Lock, null) },
            /**
             * To use Visibility icon, add this dependency
             * implementation 'androidx.compose.material:material-icons-extended:1.4.3'
             */
            trailingIcon = {
                IconButton(onClick = {
                    showPassword.value = !showPassword.value
                }) {
                    if(showPassword.value){
                        Icon(Icons.Filled.VisibilityOff, null)
                    }else{
                        Icon(Icons.Filled.Visibility, null)
                    }
                }
            },
            shape = RoundedCornerShape(8.dp)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp, 8.dp, 0.dp),
            onClick = {
                userRepository.login(username.value.text, password.value.text){ result ->
                    if(result){
                        navController.navigate(Route.Restaurants.route)
                    }
                }
            }
        ) {
            Text(text = "Sign in")
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            onClick = {
                navController.navigate(Route.SignUp.route)
            }) {
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
    RestaurantComposeTheme() {
        Login(navController = rememberNavController())
    }
}