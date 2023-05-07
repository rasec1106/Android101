package pe.edu.cibertec.agendacompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.cibertec.agendacompose.data.model.Contact

@Dao
interface ContactDAO {
    @Insert
    fun insert(contact: Contact)
    @Delete
    fun delete(contact: Contact)
    @Query("select * from contacts")
    fun fetchAll(): List<Contact>
}