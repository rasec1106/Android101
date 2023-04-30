package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.ui.theme.CT01_HerreraVillacorta_CesarHumbertoTheme

@Composable
fun OrderPizza(){
    Text(text = "Hello World!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    CT01_HerreraVillacorta_CesarHumbertoTheme {
        OrderPizza()        
    }
}