package pe.edu.cibertec.agendacompose_lab02.data.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "firstname")
    var name: String,
    @ColumnInfo(name = "isfavorite")
    var isFavorite: Int
)