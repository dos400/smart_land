package uz.hamroev.smartland.db

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class ProductEntity {

    @PrimaryKey
    var product_name: String = ""

    var product_percentage: Int? = null
    var seasons: String? = null


    constructor()

    @Ignore
    constructor(product_name: String, product_percentage: Int?, seasons: String?) {
        this.product_name = product_name
        this.product_percentage = product_percentage
        this.seasons = seasons
    }


}