package at.sunilson.ktx.window

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import at.sunilson.ktx.view.showKeyboard

fun Window.edgeToEdge(enabled: Boolean = true) {
    WindowCompat.setDecorFitsSystemWindows(this, !enabled)
}

@Deprecated("Use WindowCompat.setDecorFitsSystemWindows(window, false) instead and handle top and bottom insets")
fun Window.drawBelowStatusBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        setDecorFitsSystemWindows(true)
    }

    decorView.run {
        systemUiVisibility = if (enabled) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        } else {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv()
        }
    }
}

@Deprecated("Use WindowCompat.setDecorFitsSystemWindows(window, false) instead and handle top and bottom insets")
fun Window.drawBelowNavigationBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        setDecorFitsSystemWindows(true)
    }

    decorView.run {
        systemUiVisibility = if (enabled) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        } else {
            systemUiVisibility and View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION.inv()
        }
    }
}

fun Window.useLightStatusBarIcons(light: Boolean) {
    WindowInsetsControllerCompat(this, decorView).isAppearanceLightStatusBars = light
}

fun Window.useLightNavigationBarIcons(light: Boolean) {
    WindowInsetsControllerCompat(this, decorView).isAppearanceLightNavigationBars = light
}
