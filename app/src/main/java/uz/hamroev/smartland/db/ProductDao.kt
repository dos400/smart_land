package uz.hamroev.smartland.db

import androidx.room.*
import uz.hamroev.smartland.firebase.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<ProductEntity>

//    @Query("SELECT * FROM product WHERE seasons='spring'")
//    fun getSpringProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(productEntity: ProductEntity)

    @Update
    fun updateProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product WHERE seasons=:seasonName")
    fun getSeasonsProduct(seasonName: String): List<ProductEntity>




}