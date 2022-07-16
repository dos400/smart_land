package uz.hamroev.smartland.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.hamroev.smartland.firebase.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<ProductEntity>

//    @Query("SELECT * FROM product WHERE seasons='spring'")
//    fun getSpringProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(product: Product)


}