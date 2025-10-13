package lessons.lesson10.homework

fun main() {
    val a1 = mapOf<Int, Int>()
    val a2 = mapOf<Float, Double>(1.52F to 1.67, 7.86F to 14.8)
    val a3 = mutableMapOf<Int, String>(1 to "One", 2 to "Two")
    a3[3] = "Three"
    a3[4] = "Four"

    val a5 = a3[1]
    val a6 = a3[7]

    a3.remove(1)

    val a7 = mapOf<Double, Int>(3.14 to 1, 6.28 to 2)
    for (key in a7.keys) {
        val value: Int = a7[key]!!
        if (value != 0) {
            println(key / value)
        } else {
            println("Бесконечность")
        }
    }

    a3[2] = "New value"

    val a8 = mapOf<Int, String>(6 to "Six")
    val a9 = mapOf<Int, String>(7 to "Seven")
    val a10 = mutableMapOf<Int, String>()

    for (key in a8.keys) {
        a10[key] = a8[key]!!
    }
    for (key in a9.keys) {
        a10[key] = a9[key]!!
    }

    val a11 = mutableMapOf<String, Array<Int>>()
    a11["Балаково"] = arrayOf(613980, 613981, 613800)
    a11["Белгад>"] = arrayOf(11070, 11080, 11090)

    val a12 = mutableMapOf<Int, MutableSet<String>>()
    a12[1] = mutableSetOf("Один", "One")
    a12[1]!!.add("Jedan")
    println(a12[1])

    val a13 = mapOf<Pair<Int, Int>, String>(Pair(5, 5) to "Five", Pair(1, 2) to "Not a five")
    for (key in a13.keys) {
        if ((key.first == 5) || (key.second == 5)) {
            println(a13[key])
        }
    }

}