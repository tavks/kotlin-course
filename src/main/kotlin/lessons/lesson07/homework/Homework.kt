package lessons.lesson07.homework

fun main() {
    for (i in 1..5) {
        println(i)
    }

    for (i in 1..10) {
        if (i % 2 == 0) {
            println(i)
        }
    }

    for (i in 5 downTo 1) {
        println(i)
    }

    for (i in 10 downTo 1) {
        println(i - 2)
    }

    for (i in 1..9 step 2) {
        println(i)
    }

    for (i in 1..20 step 3) {
        println(i)
    }

    val size = 50
    for (i in 3 until size step 2) {
        println(i)
    }

    var i = 1
    while (i <= 5) {
        println(i * i)
        i += 1
    }

    var c = 10
    while (c != 5) {
        c--
    }
    println(c)

    var n = 5
    do {
        println(n)
        n--
    } while (n >= 1)

    var counter = 5
    do {
        counter++
    } while (counter < 10)

    for (i in 1..10) {
        if (i == 6) {
            break
        }
    }

    val x = 1
    while (x < 10) {
        println(x)
    }

    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        println(i)
    }

    for (i in 1..10) {
        if (i % 3 == 0) {
            continue
        }
        println(i)
    }
}

