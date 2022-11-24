package uz.hamroev.smartland.db.agrotexnikaUZB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
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

    constructor()

    @Ignore
    constructor(
        product_name: String,
        ekilishi: String,
        parvarishi: String,
        harorat: String,
        ogitlash: String,
        sugorish: String,
        qarshi_kurash: String,
        davri: String,
        season: String
    ) {
        this.product_name = product_name
        this.ekilishi = ekilishi
        this.parvarishi = parvarishi
        this.harorat = harorat
        this.ogitlash = ogitlash
        this.sugorish = sugorish
        this.qarshi_kurash = qarshi_kurash
        this.davri = davri
        this.season = season
    }
}