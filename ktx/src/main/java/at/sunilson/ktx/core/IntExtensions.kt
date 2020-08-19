package at.sunilson.ktx.core

/**
 * Adds a zero in front of this and returns as [String]
 */
fun Int.padZero() = String.format("%02d", this)
