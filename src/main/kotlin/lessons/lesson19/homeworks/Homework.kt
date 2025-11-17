package lessons.lesson19.homeworks

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 == 0) {
        return null
    }
    return list[list.size / 2]
}

class ListHolder<T> {
    private val list = mutableListOf<T>()

    fun addElement(element: T) {
        list.add(element)
    }

    fun getList(): List<T> {
        return list.toList()
    }
}

interface Mapper<T, S> {
    fun map(element: T): S
    fun map(list: List<T>): List<S>
}

class PhrasesToListOfStrings: Mapper<String, List<String>> {
    override fun map(element: String): List<String> {
        return element.split(" ")
    }

    override fun map(list: List<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        for (element in list) {
            result.add(listOf(element))
        }
        return result
    }
}

fun <T, S> transposition(dict: Map<T, S>): Map<S, T> {
    return dict.map { it }.associate { it.value to it.key }
}

interface Validator<T> {
    fun validate(element: T): Boolean
}

class StringValidator: Validator<String?> {
    override fun validate(element: String?): Boolean {
        return element?.isNotBlank() ?: false
    }
}

class OddValidator: Validator<Int> {
    override fun validate(element: Int): Boolean {
        return element % 2 == 0 ?: false
    }
}

class ListValidator<T: Number>: Validator<List<T?>> {
    override fun validate(element: List<T?>): Boolean {
        for (el in element) {
            if (el == null || el.toDouble() == 0.0) {
                return false
            }
        }
        return true
    }

}