package at.sunilson.ktx.core

import android.content.Context

fun Int.px(context: Context) = (this * context.resources.displayMetrics.density).toInt()
fun Int.dp(context: Context) = (this / context.resources.displayMetrics.density).toInt()
fun Float.px(context: Context) = (this * context.resources.displayMetrics.density)
fun Float.dp(context: Context) = (this / context.resources.displayMetrics.density)
