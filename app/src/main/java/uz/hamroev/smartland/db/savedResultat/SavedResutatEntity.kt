package uz.hamroev.smartland.db.savedResultat

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import uz.hamroev.smartland.model.Selected

@Entity(tableName = "savedresutat")
class SavedResutatEntity {

    @PrimaryKey
    var id: Int = 0
    var area: String = ""
    var allProductAbout: String = ""
    var seasons: String = ""
    var time: String = ""


    constructor()

    @Ignore
    constructor(area: String, allProductAbout: String, seasons: String, time: String) {
        this.area = area
        this.allProductAbout = allProductAbout
        this.seasons = seasons
        this.time = time
    }


}