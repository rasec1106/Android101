package pe.edu.cibertec.agendacompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.cibertec.agendacompose.data.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO
}