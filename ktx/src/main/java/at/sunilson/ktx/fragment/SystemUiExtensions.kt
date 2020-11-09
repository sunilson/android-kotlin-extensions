@file:Suppress("DEPRECATION")

package at.sunilson.ktx.fragment

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment

fun Fragment.setStatusBarColor(@ColorRes color: Int, receiver: Window? = activity?.window) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(requireContext(), color)
    }
}

fun Fragment.setNavigationBarColor(@ColorRes color: Int, receiver: Window? = activity?.window) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        navigationBarColor = ContextCompat.getColor(requireContext(), color)
    }
}

/**
 * Draw below status and navigation bar
 */
fun Fragment.edgeToEdge(enabled: Boolean = true, receiver: Window? = requireActivity().window) {
    WindowCompat.setDecorFitsSystemWindows(receiver ?: return, !enabled)
}

fun Fragment.drawBelowStatusBar(
    enabled: Boolean = true,
    receiver: Window? = requireActivity().window
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        receiver?.setDecorFitsSystemWindows(true)
    }

    receiver?.decorView?.run {
        systemUiVisibility = if (enabled) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        } else {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv()
        }
    }
}

fun Fragment.drawBelowNavigationBar(
    enabled: Boolean = true,
    receiver: Window? = requireActivity().window
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        receiver?.setDecorFitsSystemWindows(true)
    }

    receiver?.decorView?.run {
        systemUiVisibility = if (enabled) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        } else {
            systemUiVisibility and View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION.inv()
        }
    }
}

fun Fragment.drawFullscreen(
    enabled: Boolean = true,
    receiver: Window? = requireActivity().window
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        receiver?.setDecorFitsSystemWindows(!enabled)
    } else {
        drawBelowNavigationBar(enabled, receiver)
        drawBelowStatusBar(enabled, receiver)
    }
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.useLightStatusBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.decorView?.run {
        systemUiVisibility = if (!light) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun Fragment.useLightNavigationBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.decorView?.run {
        systemUiVisibility = if (!light) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
        }
    }
}
