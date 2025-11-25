package lessons.lesson22.homewroks

import java.lang.NumberFormatException
import kotlin.random.Random

fun main() {
    //1. NullPointerException
    try {
        val a1: Int? = null
        val a2 = a1 as Int
    } catch (e: NullPointerException) {
        println("Can not cast null to Int")
    }

    //2. IndexOutOfBoundsException
    try {
        val a3 = listOf<Int>(1, 2, 3)
        val a4 = a3[3]
    } catch (e: IndexOutOfBoundsException) {
        println("There is no object at given index")
    }

    //3. ClassCastException
    try {
        val a5 = 1
        val a6 = a5 as String
    } catch (e: ClassCastException) {
        println("Can not cast Number to String")
    }


    //4. IllegalArgumentException
    fun makePayment(amount: Int) {
        require(amount > 0) { "The amount should be positive" }
    }
    try {
        makePayment(amount = -1)
    } catch (e: IllegalArgumentException) {
        println("An error occurred")
    }


    //5. NumberFormatException
    val a7 = "smth"
    try {
        val a8 = a7.toInt()
    } catch (e: NumberFormatException) {
        println("Can not convert to Number")
    }


    //6. IllegalStateException
    fun checkState(state: Boolean) {
        check(state) { "The current state is not suitable" }
    }
    try {
        checkState(false)
    } catch (e: IllegalStateException) {
        println("The state is false")
    }

    //7. OutOfMemoryError
    val list = mutableListOf<Int>()
    fun generateRandomNumbers() {
        list.add(Random.nextInt())
    }
    try {
        while (true) {
            generateRandomNumbers()
        }
    } catch (e: OutOfMemoryError) {
        println("The JVM ran out of memory")
    }


    //8. StackOverflowError
    fun doSmth() {
        doSmth()
    }
    try {
        doSmth()
    } catch (e: StackOverflowError) {
        println("Too many function calls")
    }

    //Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий
    // с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
    //    NullPointerException
    //    IndexOutOfBoundsException
    //    ClassCastException
    //    IllegalArgumentException
    //    NumberFormatException
    //    IllegalStateException

    fun testExample(arg: Any?) {
        try {
            //NullPointerException
            val a1 = arg as List<*>
            //IndexOutOfBoundsException
            val a2 = arg[4]
            //ClassCastException
            val a3 = arg as Int
            //IllegalArgumentException
            require(arg == "smth") { "The argument is incorrect" }
            //NumberFormatException
            val a4 = arg.toDouble()
            //IllegalStateException
            check(true) { "The state is incorrect" }
        } catch (e: Throwable) {
            when (e) {
                is NullPointerException -> println("Object is null")
                is IndexOutOfBoundsException -> println("No such index")
                is ClassCastException -> println("Can not cast like this")
                is IllegalArgumentException -> println("The argument provided is not gonna take us far")
                is NumberFormatException -> println("Not a number, lol")
                is IllegalStateException -> println("You can't park there mate")
            }
            throw e
        }
        println("The argument provided is fantastically awesome")
    }

    //Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст.
    // Выброси это исключение в main
    //throw MyException(message = "Smth gone wrong, do smth 'bout it")

    //Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
    // IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
    // перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
    val a8 = listOf<Int>(1, 4, 82)
    try {
        println(a8[484598945])
    } catch (e: IndexOutOfBoundsException) {
        println("Exceptional situation to be in")
        throw AnotherMyException(arg = IndexOutOfBoundsException(), message = "Lol, smth exceptional happened")
    }
}