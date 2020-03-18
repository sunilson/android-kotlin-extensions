package at.sunilson.ktx.core

import android.content.Context
import android.content.Intent

fun Intent.canBeHandled(context: Context) = this.resolveActivity(context.packageManager) != null
