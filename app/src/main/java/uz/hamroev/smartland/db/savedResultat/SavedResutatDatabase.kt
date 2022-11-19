package uz.hamroev.smartland.db.savedResultat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.hamroev.smartland.db.ProductDao
import uz.hamroev.smartland.db.ProductDatabase
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbDatabase


@Database(entities = [SavedResutatEntity::class], version = 1)
abstract class SavedResutatDatabase : RoomDatabase() {

    abstract fun savedResutatDao(): SavedResutatDao

    companion object {
        private var instance: SavedResutatDatabase? = null

        @Synchronized
        fun getInstance(context: Context): SavedResutatDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    SavedResutatDatabase::class.java,
                    "savedresutat.db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

}