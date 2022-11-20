package uz.hamroev.smartland.db.daromad

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.hamroev.smartland.db.ProductEntity

@Dao
interface DaromadDao {

    @Query("SELECT * FROM daromad")
    fun getAllProduct(): List<DaromadEntity>


    @Query("SELECT * FROM daromad WHERE fasl=:seasonName")
    fun getSeasonsProduct(seasonName: String): List<DaromadEntity>


}