package lessons.lesson21.homeworks

import kotlin.math.pow

fun main() {

}

fun analyzeDataType(obj: Any) {
    when (obj) {
        is String -> println("Это строка: $obj")
        is Number -> println("Это число: $obj")
        is List<*> -> println("Это список, количество элементов: ${obj.size}")
        is Map<*, *> -> println("Это список, количество пар: ${obj.size}")
        else -> println("Неизвестный тип данных")
    }
}

fun safeCastToList(obj: Any): Int {
    val result = obj as? List<*>
    if (result != null) {
        return result.size
    } else {
        return -1
    }
}

fun getStringLengthOrZero(obj: Any?): Int {
    return (obj as? String)?.length?.toInt()?: 0
}

fun Any.toSquare(): Double {
    if (this is String) {
        return (this.toDouble().pow(2))
    } else {
        return (this as Double).pow(2)
    }
}

fun sumIntOrDoubleValues(list: List<Any>): Double {
    var sum = 0.0
    for (element in list) {
        if (element is Double) {
            sum += element
        } else if (element is Int) {
            sum += element.toDouble()
        }
    }
    return sum
}

fun tryCastToListAndPrint(obj: Any) {
    val result = obj as? List<*>
    if (result != null) {
        for (element in result) {
            if (element is String) {
                println(element)
            } else {
                println("Элемент не является строкой")
            }
        }
    } else {
        println("Приведение произошло неудачно")
    }
}
