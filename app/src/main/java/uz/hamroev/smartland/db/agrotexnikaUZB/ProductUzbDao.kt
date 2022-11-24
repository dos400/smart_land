package uz.hamroev.smartland.db.agrotexnikaUZB

import androidx.room.Dao
import androidx.room.Query
import uz.hamroev.smartland.db.ProductEntity

@Dao
interface ProductUzbDao {

    @Query("SELECT * FROM product")
    fun getAllProducts(): List<ProductUzbEntity>

    @Query("SELECT * FROM product WHERE season=:seasonName")
    fun getSeasonsProduct(seasonName: String): List<ProductUzbEntity>

    @Query("SELECT * FROM product WHERE product_name=:product_name")
    fun getByProductName(product_name: String): List<ProductUzbEntity>

    @Query("SELECT * FROM product WHERE season=:seasonName AND id=:id2")
    fun getByProductSeasonsAndPosition(seasonName: String, id2: Int ): List<ProductUzbEntity>

}