package at.sunilson.ktx.view

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewTreeObserver
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

@RequiresApi(Build.VERSION_CODES.R)
fun View.showKeyboard() {
    windowInsetsController?.show(WindowInsetsCompat.Type.ime())
}

fun View.showKeyboard(window: Window) {
    WindowInsetsControllerCompat(window, this).show(WindowInsetsCompat.Type.ime())
}

@RequiresApi(Build.VERSION_CODES.R)
fun View.hideKeyboard() {
    windowInsetsController?.hide(WindowInsetsCompat.Type.ime())
}

fun View.hideKeyboard(window: Window) {
    WindowInsetsControllerCompat(window, this).hide(WindowInsetsCompat.Type.ime())
}

val View.keyboardIsVisible: Boolean
    get() = WindowInsetsCompat
        .toWindowInsetsCompat(rootWindowInsets)
        .isVisible(WindowInsetsCompat.Type.ime())
