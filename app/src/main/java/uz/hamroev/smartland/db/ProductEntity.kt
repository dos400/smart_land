package uz.hamroev.smartland.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class ProductEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var product_name: String? = null
    var product_percentage: Int? = null
    var seasons: String? = null

}