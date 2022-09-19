package uz.hamroev.smartland.db.agrotexnikaUZB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class ProductUzbEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "product_name")
    var product_name: String = ""
    var ekilishi: String = ""
    var parvarishi: String = ""
    var harorat: String = ""
    var ogitlash: String = ""
    var sugorish: String = ""
    @ColumnInfo(name = "qarshi_kurash")
    var qarshi_kurash: String = ""
    var davri: String = ""
    var season: String = ""

}