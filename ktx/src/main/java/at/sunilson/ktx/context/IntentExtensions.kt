package at.sunilson.ktx.context

import android.content.Context
import android.content.Intent

fun Context.checkIntentCanBeHandled(intent: Intent) =
    intent.resolveActivity(this.packageManager) != null

fun Context.startIntentOrElse(intent: Intent, elseBlock: () -> Unit) {
    if (checkIntentCanBeHandled(intent)) {
        startActivity(intent)
    } else {
        elseBlock()
    }
}