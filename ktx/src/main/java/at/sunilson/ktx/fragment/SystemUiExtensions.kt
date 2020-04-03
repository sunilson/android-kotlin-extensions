package at.sunilson.ktx.fragment

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

/**
 * This method changes the color of the top notification bar
 *
 *  @param color The color of the status bar
 *  @param dark If true, the status bar should have a dark background and has light icons
 */
fun Fragment.setStatusBarColor(
    @ColorInt color: Int,
    fullscreen: Boolean = false,
    receiver: Window? = activity?.window
) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        if (!fullscreen) {
            receiver.decorView.run { systemUiVisibility = 0 }
        } else {
            extendLayoutToFullscreen(this)
        }

        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = color
    }
}

/**
 * Sets the color of the system navigation bar and the icon color depending on the [dark] parameter
 */
@RequiresApi(Build.VERSION_CODES.O)
fun Fragment.setNavBarColor(
    @ColorInt color: Int,
    dark: Boolean,
    receiver: Window? = activity?.window
) {
    receiver?.run {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        navigationBarColor = color

        if (!dark) {
            decorView.systemUiVisibility =
                decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            decorView.systemUiVisibility =
                decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
        }
    }
}

/**
 * If [light] is true, system bar icons will be drawn white, otherwise dark
 *
 * @param receiver The window that these settings should be applied to. Use dialog.window for dialogs
 */
@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.useLightStatusBarIcons(light: Boolean, receiver: Window? = activity?.window) {
    receiver?.run {
        if (!light) {
            decorView.systemUiVisibility =
                decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            decorView.systemUiVisibility =
                decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }
}

fun Fragment.extendLayoutToFullscreen(receiver: Window? = requireActivity().window) {
    receiver?.decorView?.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}