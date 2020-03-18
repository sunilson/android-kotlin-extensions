package at.sunilson.ktx.databinding

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter

@BindingAdapter("app:hideIf")
fun View.hide(value: Boolean?) {
    visibility = if (value == true) {
        GONE
    } else {
        VISIBLE
    }
}

@BindingAdapter("app:showIf")
fun View.show(value: Boolean?) {
    visibility = if (value == true) {
        VISIBLE
    } else {
        GONE
    }
}
