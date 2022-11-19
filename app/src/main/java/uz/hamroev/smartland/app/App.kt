package uz.hamroev.smartland.app

import android.app.Application
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.db.ProductDatabase
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbDatabase
import uz.hamroev.smartland.db.savedResultat.SavedResutatDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Cache.init(this)
        ProductDatabase.getInstance(this)
        ProductUzbDatabase.init(this)
        SavedResutatDatabase.getInstance(this)
    }
}