package at.sunilson.ktx.fragment

import android.graphics.Bitmap
import android.graphics.Rect
import android.os.Build
import android.os.Handler
import android.view.PixelCopy
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

@RequiresApi(Build.VERSION_CODES.O)
private suspend fun Fragment.takeScreenshot() = suspendCancellableCoroutine<Bitmap?> {
    val view = requireView()
    val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
    val locationOfViewInWindow = IntArray(2)
    view.getLocationInWindow(locationOfViewInWindow)
    PixelCopy.request(
        requireActivity().window,
        Rect(
            locationOfViewInWindow[0],
            locationOfViewInWindow[1],
            locationOfViewInWindow[0] + view.width,
            locationOfViewInWindow[1] + view.height
        ),
        bitmap,
        { copyResult ->
            if (copyResult == PixelCopy.SUCCESS) {
                it.resume(bitmap)
            } else {
                it.resume(null)
            }
        },
        Handler()
    )
}