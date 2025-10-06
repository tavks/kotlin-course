package lessons.lesson09.homework

fun main() {
    val a1 = arrayOf(1, 2, 3, 4, 5)
    val a2 = Array(10) { "" }
    val a3 = Array<Double>(5) { 0.0 }
    for (i in 0..<a3.count()) {
        a3[i] = i * 2.0
    }

    val a4 = Array<Int>(5) { 0 }
    for (i in 0..<a4.count()) {
        a4[i] = i * 3
    }

    val a5: Array<String?> = arrayOf("smth", null, "djj")
    val a6 = arrayOf(1, 2, 3, 4, 5)
    val a7 = Array<Int>(size = 5) { 0 }
    for (i in 0..<a6.count()) {
        a7[i] = a6[i]
    }

    val a8 = arrayOf(1, 2, 3, 4, 5)
    val a9 = arrayOf(6, 7, 8, 9, 10)
    val a10 = Array<Int>(5) { 0 }
    for (i in 0..<a8.count()) {
        a10[i] = a8[i] - a9[i]
        println(a10[i])
    }

    val a11 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var cnt = 0
    var isFivePresent = false
    while (cnt < a11.count()) {
        if (a11[cnt] == 5) {
            println(cnt)
            isFivePresent = true
            break
        }
    }
    if (!isFivePresent) {
        println(-1)
    }

    for (element in a11) {
        if (element % 2 == 0) {
            println("$element четное")
        } else {
            println("$element нечетное")
        }

    }


    fun searchSubstring(strings: Array<String>, searchString: String) {
        for (element in strings) {
            if (element.contains(searchString)) {
                println(element)
            }
        }
    }


    val a12 = listOf<Int>(1, 2, 3)
    val a13 = listOf<String>("Hello", "World", "Kotlin")
    val a14 = mutableListOf<Int>(1, 2, 3, 4, 5)
    a14.add(6)
    a14.add(7)
    a14.add(8)

    val a15 = mutableListOf<String>("Hello", "World", "Kotlin")
    a15.remove("World")

    for (element in a12) {
        println(element)
    }

    val a16 = a13[1]
    a14[2] = 12

    val a17 = mutableListOf<String>()
    for (element in a13) {
        a17.add(element)
    }
    for (element in a15) {
        a17.add(element)
    }

    var min = 2_147_483_647
    var max = -2_147_483_648
    for (element in a14) {
        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
    }

    val a18 = mutableListOf<Int>()
    for (element in a14) {
        if (element % 2 == 0) {
            a18.add(element)
        }
    }

    val a19 = setOf<Int>()
    val a20 = setOf<Int>(1, 2, 3)
    val a21 = mutableSetOf<String>("Kotlin", "Java", "Scala")
    a21.add("Swift")
    a21.add("Go")
    val a22 = mutableSetOf<Int>(1, 2, 3, 4, 5)
    a22.remove(2)

    for (element in a20) {
        println(element)
    }

    fun isStringPresent(set: Set<String>, str: String): Boolean {
        for (element in set) {
            if (element == str) {
                return true
            }
        }
        return false
    }

    val a23 = mutableListOf<String>()
    for (element in a21) {
        a23.add(element)
    }
}

