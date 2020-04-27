package at.sunilson.ktx.fragment

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
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

fun Fragment.drawBelowStatusBar(receiver: Window? = requireActivity().window) {
    receiver?.decorView?.run {
        systemUiVisibility =
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}

fun Fragment.drawBelowNavigationBar(receiver: Window? = requireActivity().window) {
    receiver?.decorView?.run {
        systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.useLightStatusBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.decorView?.run {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            systemUiVisibility = if (!light) {
                systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun Fragment.useLightNavigationBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.decorView?.run {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            systemUiVisibility = if (!light) {
                systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
            }
        }
    }
}