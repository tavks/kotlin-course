package lessons.lesson23.homeworks

import lessons.lesson12.homeworks.num

//1. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных
// чисел этого списка. С помощью require проверь, что список не пустой.
fun getEvenAvg(list: List<Int>): Double {
    require(list.isNotEmpty())
    return list.filter { it % 2 == 0 }.average()
}

//2. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа.
// Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать
// функцию digitToInt()
fun getSum(number: Long): Int {
    require(number > 0) { "Number is not positive" }
    var sum = 0
    val numberAsString = number.toString()
    for (char in numberAsString) {
        sum += char.digitToInt()
    }
    return sum
}

//3. Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел
// (встречающихся в списке более одного раза)
fun List<Number>.getDuplicates(): Set<Number> {
    val uniqueNumbers = mutableSetOf<Number>()
    val nonUniqueNumbers = mutableSetOf<Number>()
    for (number in this) {
        if (uniqueNumbers.contains(number)) {
            nonUniqueNumbers.add(number)
        } else {
            uniqueNumbers.add(number)
        }
    }
    return nonUniqueNumbers
}

fun main() {
    //1_1. Создай аналогичную анонимную функцию.
    val task1_1 = fun (list: List<Int>): Double {
        require(list.isNotEmpty()) { "List is empty" }
        return list.filter { it % 2 == 0 }.average()
    }

    //1_2. Создай аналогичное лямбда выражение с указанием типа.
    val task1_2: (List<Int>) -> Double = { list ->
        require(list.isNotEmpty()) { "List is empty" }
        list.filter { it % 2 == 0 }.average()
    }

    //1_3. Создай лямбда выражение без указания типа.
    val task1_3 = { list: List<Int> ->
        require(list.isNotEmpty()) { "List is empty" }
        list.filter { it % 2 == 0 }.average()
    }

    //1_4. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
    println(task1_1(listOf(1, 2, 4)))
    println(task1_2(listOf()))
    println(task1_3(listOf(1, 3, 5, 7)))

    //2_1. Создай аналогичную анонимную функцию.
    val task2_1 = fun (number: Long): Int {
        require(number > 0) { "Number is not positive" }
        var sum = 0
        val numberAsString = number.toString()
        for (char in numberAsString) {
            sum += char.digitToInt()
        }
        return sum
    }

    //2_2. Создай аналогичное лямбда выражение с указанием типа.
    val task_2_2: (Long) -> Int = { number ->
        require(number > 0) { "Number is not positive" }
        var sum = 0
        val numberAsString = number.toString()
        for (char in numberAsString) {
            sum += char.digitToInt()
        }
        sum
    }

    //2_3. Создай лямбда выражение без указания типа.
    val task2_3 = { number: Long ->
        require(number > 0) { "Number is not positive" }
        var sum = 0
        val numberAsString = number.toString()
        for (char in numberAsString) {
            sum += char.digitToInt()
        }
        sum
    }

    //2_4. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
    println(task2_1(23))
    println(task_2_2(0))
    println(task2_3(12345678))

    //3_1. Создай аналогичную анонимную функцию.
    val task3_1 = fun List<Number>.(): Set<Number> {
        val uniqueNumbers = mutableSetOf<Number>()
        val nonUniqueNumbers = mutableSetOf<Number>()
        for (number in this) {
            if (uniqueNumbers.contains(number)) {
                nonUniqueNumbers.add(number)
            } else {
                uniqueNumbers.add(number)
            }
        }
        return nonUniqueNumbers
    }

    //3_2. Создай аналогичное лямбда выражение с указанием типа.
    val task3_2: List<Number>.() -> Set<Number> = {
        val uniqueNumbers = mutableSetOf<Number>()
        val nonUniqueNumbers = mutableSetOf<Number>()
        for (number in this) {
            if (uniqueNumbers.contains(number)) {
                nonUniqueNumbers.add(number)
            } else {
                uniqueNumbers.add(number)
            }
        }
        nonUniqueNumbers
    }

    //3_3. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
    val test1 = listOf(1, 3.14, 5, 3.14, 5)
    val test2 = listOf(5, 6, 1349, 45, 484, 1349, 3.1415)
    println(test1.task3_1())
    println(test2.task3_2())
}
