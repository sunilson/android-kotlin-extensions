package at.sunilson.ktx.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, crossinline block: (T) -> Unit) =
    Observer<T> { block(it) }.also { observe(lifecycleOwner, it) }