package lessons.lesson28.homeworks

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal


fun main() {
    //1. Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
    val currentTime = Instant.now()
    println(currentTime)
    //2. Создай дату своего дня рождения.
    val birthDate = LocalDate.of(1999, 11, 3)
    //3. Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val period = Period.between(birthDate, LocalDate.now())
    println(period.years)
    //5. Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше.
    // Не используй в них метод now()
    val date = LocalDate.of(2025, 12, 22)
    val time = LocalTime.of(22, 16, 0)
    printFormatted(date)
    printFormatted(time)
    printFormatted(LocalDateTime.of(date, time))
    printFormatted(ZonedDateTime.of(date, time, ZoneId.of("Asia/Bangkok")))

    //7. Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года.
    // Создай форматтер, который форматирует дату в месяц и день.
    val v71 = LocalDate.of(2023, 2, 25)
    val v72 = LocalDate.of(2024, 2, 25)
    val formatter = DateTimeFormatter.ofPattern("MM-dd")
    //8. Выведи первую отформатированную дату, прибавив к ней 10 дней.
    println(v71.plusDays(10).format(formatter))
    //9. Выведи вторую отформатированную дату, прибавив к ней 10 дней. Найди отличия)))
    println(v72.plusDays(10).format(formatter))


}

//4. Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того,
// содержит ли аргумент время и часовой пояс. Temporal - это общий тип для разных классов даты-времени.
// В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте.
// Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный форматированием и
// с форматами из ISO коллекции.

fun printFormatted(arg: Temporal) {
    when (arg) {
        is LocalDate -> "dd-MM-YYYY"
        is LocalTime -> "HH:mm:ss"
        is LocalDateTime -> "dd-MM-YYYY HH:mm:ss"
        is ZonedDateTime -> "dd-MM-YYYY HH:mm:ss z"
        is OffsetDateTime -> "dd-MM-YYYY HH:mm:ss ZZZ"
        else -> throw IllegalArgumentException("Неизвестный тип данных")
    }.let {
        DateTimeFormatter.ofPattern(it).format(arg)
    }.also { println(it) }
}

//6. Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую,
// к какому поколению принадлежит человек родившийся в эту дату: "Бумер" для тех, кто родился с 1946 по 1964 год
// включительно, и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни в один
// из этих диапазонов, функция должна печатать "Не определено". Для сравнения дат используй методы isAfter(otherDate) и
// isBefore(otherDate) или проверку вхождения в диапазон. Объекты с эталонными датами вынеси в приватные поля файла с
// методом identifyGeneration.

fun LocalDate.identifyGeneration() {
    when (this) {
        in boomerFrom..boomerTo -> println("Это бумер!")
        in zoomerFrom..zoomerTo -> println("Это зумер!")
        else -> println("Не определено")
    }
}

private val boomerFrom = LocalDate.of(1946, 1, 1)
private val boomerTo = LocalDate.of(1964, 1, 1)
private val zoomerFrom = LocalDate.of(1997, 1, 1)
private val zoomerTo = LocalDate.of(2012, 1, 1)
