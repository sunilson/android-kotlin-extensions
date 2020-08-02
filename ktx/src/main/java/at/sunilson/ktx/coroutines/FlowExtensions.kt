package at.sunilson.ktx.coroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Emits results of multiple flow in the order they arrive. Doesn't wait for all flows to emit something
 * before it starts emitting.
 *
 * For 4 flows (A, B, C, D), emissions could look like this:
 *
 * []
 * [A, C]
 * [A, C, D]
 * [A, B, C, D]
 */
@ExperimentalCoroutinesApi
inline fun <reified T : Any> List<Flow<T>>.combineAsync() = channelFlow {
    val results = Array<T?>(size) { null }
    send(results.filterNotNull())
    forEachIndexed { index, flow ->
        launch {
            flow.collect {
                results[index] = it
                send(results.filterNotNull())
            }
        }
    }
}
