package pe.edu.cibertec.agendacompose.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.cibertec.agendacompose.data.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO

    // Creation of the database instance singleton
    companion object{
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    name = "agenda.db"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE as AppDatabase
        }
    }
}