package pe.edu.cibertec.restaurantcompose.ui.signup

import android.util.Log
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
import pe.edu.cibertec.restaurantcompose.data.model.Restaurant
import pe.edu.cibertec.restaurantcompose.data.model.User
import pe.edu.cibertec.restaurantcompose.data.remote.ApiClient
import pe.edu.cibertec.restaurantcompose.ui.theme.RestaurantComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignUp(){

    val username = remember{
        mutableStateOf(TextFieldValue())
    }
    val password = remember{
        mutableStateOf(TextFieldValue())
    }
    val confirmPassword = remember{
        mutableStateOf(TextFieldValue())
    }
    val showPassword = remember{
        mutableStateOf(false)
    }
    val showConfirmPassword = remember{
        mutableStateOf(false)
    }

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
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = "Confirm Password") },
            value = confirmPassword.value,
            visualTransformation = if(showConfirmPassword.value){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
                 },
            onValueChange = { confirmPassword.value = it },
            leadingIcon = { Icon(Icons.Default.Lock, null) },
            trailingIcon = {
                IconButton(onClick = {
                    showConfirmPassword.value = !showConfirmPassword.value
                }) {
                    if(showConfirmPassword.value){
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
                val userInterface = ApiClient.getUserInterface()
                val createUser = userInterface.createUser(User(username.value.text, password.value.text))
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
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            onClick = {
            }
        ) {
            Text(text = "Sign in")
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
        SignUp()
    }
}