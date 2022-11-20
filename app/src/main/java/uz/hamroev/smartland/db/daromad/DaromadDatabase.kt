package uz.hamroev.smartland.db.daromad

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.hamroev.smartland.db.ProductDao
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbDatabase

@Database(entities = [DaromadEntity::class], version = 1)
abstract class DaromadDatabase: RoomDatabase() {

    abstract fun daromadDao(): DaromadDao

    companion object {
        @Volatile
        private var database: DaromadDatabase? = null

        fun init(context: Context) {
            synchronized(this) {
                if (database == null) {
                    database = Room.databaseBuilder(
                        context.applicationContext,
                        DaromadDatabase::class.java,
                        "daromad.db"
                    )
                        .createFromAsset("daromad.db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
        }
    }

    object GET {
        fun getDaromadDatabase(): DaromadDatabase = database!!
    }
}