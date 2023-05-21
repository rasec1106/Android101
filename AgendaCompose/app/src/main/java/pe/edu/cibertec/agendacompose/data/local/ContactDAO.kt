package pe.edu.cibertec.agendacompose.data.local

import androidx.room.*
import pe.edu.cibertec.agendacompose.data.model.Contact

@Dao
interface ContactDAO {
    @Insert
    fun insert(contact: Contact)
    @Update
    fun update(contact: Contact)
    @Delete
    fun delete(contact: Contact)
    @Query("select * from contacts")
    fun fetchAll(): List<Contact>
}