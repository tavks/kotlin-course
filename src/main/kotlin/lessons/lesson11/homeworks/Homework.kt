package lessons.lesson11.homeworks

fun main() {

}

fun a1() {
}

fun a2(f: Int, s: Int): Int {
    return f + s
}

fun a3(s: String) {
}

fun a4(list: List<Int>): Double {
    var counter: Int = 0
    var sum: Int = 0
    for (element in list) {
        counter += 1
        sum += element
    }
    return ((sum / counter).toDouble())
}

private fun a5(str: String?): Int? {
    if (str != null) {
        return str.count()
    } else {
        return null
    }
}

fun a6(): Double? {
    return 3.14
}

private fun a7(list: List<Int>?) {
}

fun  a8(num: Int): String? {
    return null
}

fun a9(): List<String?> {
    return listOf("smth", null)
}

fun a10(str: String?, num: Int?): Boolean? {
    return  true
}

fun multiplyByTwo(num: Int): Int {
    return num * 2
}

fun isEven(num: Int): Boolean {
    return num % 2 == 0
}

fun printNumbersUntil(num: Int) {
    if (num < 1) {
        return
    }
    for (i in 1..num) {
        println(i)
    }
}

fun findFirstNegative(list: List<Int>): Int? {
    for (element in list) {
        if (element < 0) {
            return element
        }
    }
    return null
}

fun processList(list: List<String?>) {
    for (element in list) {
        if (element == null) {
            return
        }
        println(element)
    }
}