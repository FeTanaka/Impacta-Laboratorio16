package br.com.impacta.laboratrio16.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.impacta.laboratrio16.data.local.dao.ContatoDao
import br.com.impacta.laboratrio16.data.models.Contato

@Database(entities = [Contato::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}