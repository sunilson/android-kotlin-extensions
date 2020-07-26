package at.sunilson.ktx.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

/**
 * Navigates to given [res] and ignores navigation if the action can not be found,
 * so the app doesn't crash
 */
fun Fragment.navigateSafe(
    @IdRes res: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    findNavController().run {
        val action = getAction(res)
        if (action != null && currentDestination?.id != action.destinationId) {
            navigate(res, args, navOptions, navExtras)
        }
    }
}

/**
 * Navigates to given [directions] and ignores navigation if the action can not be found,
 * so the app doesn't crash
 */
fun Fragment.navigateSafe(directions: NavDirections) {
    findNavController().run {
        val action = getAction(directions.actionId)
        if (action != null && currentDestination?.id != action.destinationId) {
            navigate(directions)
        }
    }
}

fun NavController.getAction(@IdRes actionId: Int) =
    currentDestination?.getAction(actionId) ?: graph.getAction(actionId)
