package uz.hamroev.smartland.db.agrotexnikaUZB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ProductUzbEntity::class], version = 2, exportSchema = false)
abstract class ProductUzbDatabase : RoomDatabase() {

    abstract fun getProductUzbDao(): ProductUzbDao

    companion object {
        @Volatile
        private var database: ProductUzbDatabase? = null

        fun init(context: Context) {
            synchronized(this) {
                if (database == null) {
                    database = Room.databaseBuilder(
                        context.applicationContext,
                        ProductUzbDatabase::class.java,
                        "product.db"
                    )
                        .createFromAsset("productlar.db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
        }
    }

    object GET {
        fun getProductUzbDatabase(): ProductUzbDatabase = database!!
    }

}