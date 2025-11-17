package lessons.lesson20.homeworks

import kotlin.math.absoluteValue

fun Array<Int>.returnFirstAndLast(): Pair<Int?, Int?> {
    if (this.isEmpty()) {
        return Pair(null, null)
    } else {
        return Pair(this.first(), this.last())
    }
}

fun <T : Comparable<T>> MutableList<T>.returnSorted(acsending: Boolean): List<T> {
    val self = toList()
    if (acsending) {
        sort()
    } else {
        sortDescending()
    }
    return self
}

fun <T> Map<T, List<T>>?.returnMapToString(num: Int): Map<String, T?>? {
    return this?.mapKeys { it.key.toString() }
        ?.mapValues { it.value.getOrNull(num) }
}

fun Number.within(other: Number, deviation: Number): Boolean {
    return (this.toDouble().absoluteValue - other.toDouble().absoluteValue) <= deviation.toDouble().absoluteValue
}

fun String.encrypt(shift: Int): String {
    return this.map { ch -> (ch.code + shift).toChar() }
        .joinToString("")
}

fun String.decrypt(shift: Int): String {
    return this.map { ch -> (ch.code - shift).toChar() }
        .joinToString("")
}

fun String.makeTwitterStyle(users: List<String>) {
    var counter = 0
    for (ch in this) {
        if (counter >= users.size) {
            counter == 0
        }
        println(users[counter])
        println(ch.uppercaseChar())
    }
}