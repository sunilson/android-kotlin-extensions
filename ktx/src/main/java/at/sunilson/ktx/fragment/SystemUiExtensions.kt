@file:Suppress("DEPRECATION")

package at.sunilson.ktx.fragment

import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import at.sunilson.ktx.context.getThemeColor
import at.sunilson.ktx.window.*

fun Fragment.setStatusBarColor(@ColorRes color: Int, receiver: Window? = activity?.window) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(requireContext(), color)
    }
}

fun Fragment.setStatusBarThemeColor(@AttrRes color: Int, receiver: Window? = activity?.window) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = requireContext().getThemeColor(color)
    }
}

fun Fragment.setNavigationBarColor(@ColorRes color: Int, receiver: Window? = activity?.window) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        navigationBarColor = ContextCompat.getColor(requireContext(), color)
    }
}

fun Fragment.setNavigationBarThemeColor(@AttrRes color: Int, receiver: Window? = activity?.window) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        navigationBarColor = requireContext().getThemeColor(color)
    }
}

fun Fragment.edgeToEdge(enabled: Boolean = true, receiver: Window? = requireActivity().window) {
    receiver?.edgeToEdge(enabled)
}

fun Fragment.drawBelowStatusBar(
    enabled: Boolean = true,
    receiver: Window? = requireActivity().window
) {
    receiver?.drawBelowStatusBar(enabled)
}

fun Fragment.drawBelowNavigationBar(
    enabled: Boolean = true,
    receiver: Window? = requireActivity().window
) {
    receiver?.drawBelowNavigationBar(enabled)
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.useLightStatusBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.useLightStatusBarIcons(light)
}

@RequiresApi(Build.VERSION_CODES.O)
fun Fragment.useLightNavigationBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.useLightNavigationBarIcons(light)
}
