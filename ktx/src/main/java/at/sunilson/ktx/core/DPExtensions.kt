package at.sunilson.ktx.core

import android.content.Context
import android.util.DisplayMetrics

fun Int.convertToPx(context: Context) =
    (this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()

fun Int.convertToDp(contefxt: Context) =
    (this / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()

fun Float.convertToPx(context: Context) =
    (this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))

fun Float.convertToDp(context: Context) =
    (this / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
