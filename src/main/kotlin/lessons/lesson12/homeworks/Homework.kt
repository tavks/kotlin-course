package lessons.lesson12.homeworks

import kotlin.collections.filter

fun main() {

}

val num = listOf(-1, 2, -3, 4, -5, 8, 264)
val str = listOf("Smth", "Smth2")

val a1 = num.size > 5
val a2 = num.isEmpty()
val a3 = num.isNotEmpty()
val a4 = num.getOrElse(1) { 5 }
val a5 = num.joinToString( ", ")
val a6 = num.sum()
val a7 = num.average()
val a8 = num.max()
val a9 = num.min()
val a10 = num.firstOrNull()
val a11 = num.contains(2)
val a12 = num.filter { 18 <= it <= 30 }
val a13 = num.filterNot { ((it % 2 == 0) && (it % 3 == 0)) }
val a14 = num.filterNotNull()
val a15 = str.map { it.count() }
val a16 = str.associate { it.reversed() to it.count() }
val a17 = str.sorted()