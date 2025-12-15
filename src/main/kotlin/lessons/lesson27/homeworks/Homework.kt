package lessons.lesson27.homeworks

//1. Создай Enum со статусами прохождения теста (passed, broken, failed).
//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
enum class TestStatus {
    Passed,
    Broken,
    Failed,
    Skipped
}

enum class RealEstateType(Desc: String) {
    House("House"),
    Apartment("Apartment"),
    Commercial("Commercial"),
    Land("Land")
}

enum class SunSystemPlanets(distToSun: Int, weight: Int) {
    Mercury(1, 100),
    Venus(2, 200),
    Earth(3, 300),
    Mars(4, 250),
    Jupiter(5, 600),
    Saturn(6, 400),
    Neptune(7, 333),
    Pluto(100000, 1)
}

//2. Создай функцию, которая выводит на печать человекочитаемые названия
// типов недвижимости в порядке возрастания длины названия enum.
fun ex2(type: RealEstateType) {
    println(RealEstateType.entries.sortedBy { it.name.length })
}

//3. Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum
// со статусом прохождения теста в зависимости от того как выполнится принятая лямбда:
//если без исключений - PASSED
//если будет AssertionError - FAILED
//прочие исключения  - BROKEN

fun ex3(lmbd: () -> Unit): TestStatus {
    return try {
        lmbd()
        TestStatus.Passed
    }
    catch (e: AssertionError) {
        TestStatus.Failed
    }
    catch (e: Throwable) {
        TestStatus.Broken
    }
}

//4. Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать
// булево значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по
// какому-либо признаку (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка
// или выкинуть исключение если список пустой.

fun ex4(lmbd: (SunSystemPlanets) -> Boolean): SunSystemPlanets {
    val list = SunSystemPlanets.entries.filter { lmbd(it) }
    if (list.isNullOrEmpty()) {
        throw IllegalStateException()
    } else {
        return list.first()
    }
}