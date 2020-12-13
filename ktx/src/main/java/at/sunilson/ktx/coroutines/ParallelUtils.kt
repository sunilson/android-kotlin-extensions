package at.sunilson.ktx.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun <T> Iterable<T>.forEachParallel(block: suspend (T) -> Unit) = coroutineScope {
    map { async { block(it) } }.forEach { it.await() }
}

suspend fun <T, R> Iterable<T>.mapParallel(block: suspend (T) -> R): Iterable<R> = coroutineScope {
    map { async { block(it) } }.map { it.await() }
}

suspend fun doParallel(vararg blocks: suspend () -> Unit) = coroutineScope {
    blocks
        .map { async { it() } }
        .forEach { it.await() }
}

suspend fun <T> doParallelWithResult(vararg blocks: suspend () -> T) = coroutineScope {
    val result = mutableListOf<T>()
    blocks
        .map { async { it() } }
        .forEach { result.add(it.await()) }

    return@coroutineScope result
}
