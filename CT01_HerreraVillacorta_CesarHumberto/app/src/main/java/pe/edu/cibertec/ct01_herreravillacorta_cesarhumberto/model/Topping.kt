package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class Topping (
    val _name: String,
    val _price: Int,
    val _isSelected: Boolean
        ){
    val name: String
    val price: Int
    val isSelected: MutableState<Boolean>
    init {
        name = _name
        price = _price
        isSelected = mutableStateOf(_isSelected)
    }
}