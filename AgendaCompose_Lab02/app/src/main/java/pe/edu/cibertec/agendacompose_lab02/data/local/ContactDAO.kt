package pe.edu.cibertec.agendacompose_lab02.data.local

import androidx.room.*
import pe.edu.cibertec.agendacompose_lab02.data.model.Contact

@Dao
interface ContactDAO {
    @Insert
    fun insert(contact : Contact)
    @Update
    fun update(contact: Contact)
    @Delete
    fun delete(contact: Contact)
    @Query("select * from contacts")
    fun getAll(): List<Contact>
    //@Update
    //fun saveFavorite(contact: Contact)
}