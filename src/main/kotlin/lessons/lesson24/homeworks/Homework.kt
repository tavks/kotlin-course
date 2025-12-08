package lessons.lesson24.homeworks

import org.w3c.dom.css.Counter

//1. Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число

fun exmpl1(someBool: Boolean, func: (String) -> Unit): Int {
    return 1
}

//2. Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк

fun Int.returnStringsList(func: Int.(String) -> List<String>): List<String> {
    return func("smth")
}

//3. Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик

fun <T, F> T.exmpl3(func: T.() -> F): F {
    return func()
}

//4. Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку

fun exmpl4(str: String): () -> String {
    val func: () -> String = { "smth" }
    return func
}

//5. Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик

fun <T> T.exmpl5(): (String) -> T {
    val func: (String) -> T = { "smth" as? T as T }
    return func
}

//6. Скопируй набор кодов цвета и функцию окрашивания строки в переданный в неё цвет из набора.

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: (String) -> String): String {
    return "$color$this${Colors.RESET}"
}

fun String.colorizeWords(func: (String) -> String): String {
    return this
        .split(" ")
        .joinToString(" ") { word -> func(word) }
}

//1. цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//начинается с большой буквы
//длина меньше трёх символов
//длина больше 6 символов
//длина кратна двум
//для всех прочих отдельный цвет.
fun exmpl1(word: String): String {
    val color = when {
        word.first().isUpperCase() -> Colors.RED
        word.length < 3 -> Colors.GREEN
        word.length > 6 -> Colors.BLUE
        word.length % 2 == 0 -> Colors.CYAN
        else -> Colors.RESET
    }
    return word.colorize({ color })
}

//2. цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
// Когда счётчик доходит до края списка слов - он обнуляется и начинается заново.

fun exmpl2(word: String): String {
    var counter = 0
    if (counter > 7) {
        counter = 0
    }
    when (counter) {
        0 -> return Colors.RESET
        1 -> return Colors.RED
        2 -> return Colors.GREEN
        3 -> return Colors.YELLOW
        4 -> return Colors.BLUE
        5 -> return Colors.PURPLE
        6 -> return Colors.CYAN
        7 -> return Colors.WHITE
    }
    counter++
    return Colors.RESET
}

//3. цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
// Счётчиком управляет функция, находящаяся в изменяемой переменной. Сначала это функция с инкрементом счётчика.
// Когда счётчик доходит до края списка цветов, нужно заменить функцию счётчика на функцию с декрементом.
// Когда счётчик доходит до нуля - заменить функцию счётчика на функцию с инкрементом и так далее.
var counter = 0
var counterFunction = { counter++ }

var exmpl3: (String) -> String = fun(word: String): String {
    if (counter >= 7) {
        counterFunction = { counter-- }
    }
    if (counter <= 0) {
        counterFunction = { counter++ }
    }
    when (counter) {
        0 -> return Colors.RESET
        1 -> return Colors.RED
        2 -> return Colors.GREEN
        3 -> return Colors.YELLOW
        4 -> return Colors.BLUE
        5 -> return Colors.PURPLE
        6 -> return Colors.CYAN
        7 -> return Colors.WHITE
    }
    return Colors.RESET
}

fun main() {
    val text = "Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом. Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже в цвете через функцию colorize"
    println(text.colorizeWords({ exmpl1(text) }))
    println(text.colorizeWords({ exmpl2(text) }))
    println(text.colorizeWords({ exmpl3(text) }))
}