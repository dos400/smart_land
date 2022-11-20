package uz.hamroev.smartland.db.daromad

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "daromad")
class DaromadEntity {


    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var ekin_nomi: String = ""
    var xarajat: Int = 0
    var daromad: Int = 0
    var sof_foyda: Int = 0
    var maydoni: Int = 0
    var fasl: String = ""

    constructor()

    @Ignore
    constructor(
        ekin_nomi: String,
        xarajat: Int,
        daromad: Int,
        sof_foyda: Int,
        maydoni: Int,
        fasl: String
    ) {
        this.ekin_nomi = ekin_nomi
        this.xarajat = xarajat
        this.daromad = daromad
        this.sof_foyda = sof_foyda
        this.maydoni = maydoni
        this.fasl = fasl
    }
}