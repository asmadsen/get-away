package no.asmadsen.getaway.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

fun Float.toDP(context: Context) : Float {
    val factor : Float = (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT).toFloat()
    return this / factor
}

fun Float.toPixels(context: Context) : Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this ,context.resources.displayMetrics)
}