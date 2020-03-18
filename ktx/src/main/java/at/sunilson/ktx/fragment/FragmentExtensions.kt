package at.sunilson.ktx.fragment

import android.content.Intent
import androidx.fragment.app.Fragment
import at.sunilson.ktx.core.canBeHandled

/**
 * Start intent if it can be handled by any app
 *
 * @return True if intent could be handled
 */
fun Fragment.safeStartActivity(intent: Intent) = if (intent.canBeHandled(requireActivity())) {
    startActivity(intent)
    true
} else {
    false
}
