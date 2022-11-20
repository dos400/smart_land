package uz.hamroev.smartland.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun EditText.text(): String = this.text.toString().trim()

fun Context.showToast(message: String?) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


fun String.formatPrice(): String {
    val amount: Int = this.toInt()
    val formatter = DecimalFormat("###,###")
    return formatter.format(amount).replace(",", " ")
}


fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}

fun Fragment.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    requireContext().toast(msg, length)
}


fun Context.drawable(@DrawableRes resId: Int) =
    ResourcesCompat.getDrawable(resources, resId, null)

fun Context.font(@FontRes resId: Int) =
    ResourcesCompat.getFont(this, resId)

fun Context.dimen(@DimenRes resId: Int) =
    resources.getDimension(resId)

fun Context.anim(@AnimRes resId: Int) =
    AnimationUtils.loadAnimation(this, resId)


//TODO("dp and sp     -----    ")
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Float.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp get() = toFloat().dp
val Int.sp get() = toFloat().sp

//TODO("dp and sp how to use    -----    ")
/*
 * use as 18.dp
 * or 22.5f.sp
 */


operator fun String.times(n: Int): String {
    val sb = StringBuilder()
    repeat(n) {
        sb.append(this)
    }
    return sb.toString()
}

/*

CREATE TABLE "daromad" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"mahsulot_nomi"	TEXT NOT NULL,
	"maydoni"	INTEGER NOT NULL,
	"foyda"	INTEGER NOT NULL,
	"bozor_narx"	INTEGER NOT NULL,
	"daromadi"	INTEGER NOT NULL,
	"hosil_davomiyligi"	INTEGER NOT NULL,
	"izoh_uz"	TEXT NOT NULL,
	"izoh_ru"	TEXT,
	"izoh_en"	TEXT
);


CREATE TABLE "daromad" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"ekin_nomi"	TEXT NOT NULL,
	"xarajat"	INTEGER NOT NULL,
	"daromad"	INTEGER NOT NULL,
	"sof_foyda"	INTEGER NOT NULL,
	"maydoni"	INTEGER NOT NULL
);

* */

fun Float.roundTo(n: Int): Float {
    return "%.${n}f".format(this).toFloat()
}

fun Double.roundTo(n: Int): Double {
    return "%.${n}f".format(this).toDouble()
}

fun getCurrentDateAndTime(): String {
    val dateAndTime: Date = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val date = dateFormat.format(dateAndTime)
    val time = timeFormat.format(dateAndTime)
    val vaqt: String = "$date - $time"
    return vaqt

}




