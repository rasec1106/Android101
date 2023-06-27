package pe.edu.cibertec.restaurantcompose.ui.login

import android.util.Log
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.edu.cibertec.restaurantcompose.data.model.Restaurant
import pe.edu.cibertec.restaurantcompose.data.model.User
import pe.edu.cibertec.restaurantcompose.data.remote.ApiClient
import pe.edu.cibertec.restaurantcompose.ui.theme.RestaurantComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Login(navController: NavController){
    // Column is a composable item that help us to set the elements
    Column(
        modifier = Modifier.fillMaxSize(),     // we can add modifiers to change the behaviour
        verticalArrangement = Arrangement.Center, // Arrangement for vertical
        horizontalAlignment = Alignment.CenterHorizontally // Alignment for horizontal
    ) {
        Text(text = "Login")
        // onValueChange needs a function, so we can pass a {} at a first moment
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Username") },
            value = "",
            onValueChange = {},
            // leadingIcon puts an icon at the beginning, trailingIcon at the end
            leadingIcon = { Icon(Icons.Default.Person, null) }
        )
        // We can use another composable to add space
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Password") },
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Lock, null) }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp, 8.dp, 0.dp),
            onClick = {
                val userInterface = ApiClient.getUserInterface()
                val deleteUser = userInterface.deleteUser(13)
                deleteUser.enqueue(object: Callback<User> {
                    override fun onResponse(
                        call: Call<User>,
                        response: Response<User>
                    ){
                        if (response.isSuccessful){
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable){
                        TODO("Not yet implemented")
                    }
                })
            }
        ) {
            Text(text = "Sign in")
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            onClick = {
                val userInterface = ApiClient.getUserInterface()
                val createUser = userInterface.createUser(User("pruebaCesar", "passwordCesar"))
                createUser.enqueue(object: Callback<User> {
                    override fun onResponse(
                        call: Call<User>,
                        response: Response<User>
                    ){
                        if (response.isSuccessful){
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable){
                        t.message?.let { Log.d("RestaurantList", it) }
                    }
                })
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