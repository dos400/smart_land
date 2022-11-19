package uz.hamroev.smartland.db.savedResultat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SavedResutatDao {

    @Query("SELECT * FROM savedresutat")
    fun getAllSavedResultat(): List<SavedResutatEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSavedProduct(savedResutatEntity: SavedResutatEntity)

}