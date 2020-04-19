package at.sunilson.ktx.collections

fun <T> listBuilder(builder: MutableList<T>.() -> Unit) = mutableListOf<T>().apply(builder).toList()
