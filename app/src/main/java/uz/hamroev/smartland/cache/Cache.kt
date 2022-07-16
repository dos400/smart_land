package uz.hamroev.smartland.cache

import android.content.Context
import android.content.SharedPreferences

object Cache {

    private const val NAME = "smartland"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var language: String?
        get() = sharedPreferences.getString("language", "en")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("language", value)
            }
        }

    var isHaveUpdate: Boolean?
        get() = sharedPreferences.getBoolean("update", false)
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putBoolean("language", value)
            }
        }


}
