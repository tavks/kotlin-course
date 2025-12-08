package lessons.lesson25.homeworks

//1. Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время
// её выполнения. Функция timeTracker должна возвращать затраченное время в миллисекундах.
// Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.
fun timeTracker(function: () -> Any): Long {
    val start = System.currentTimeMillis()
    function()
    val stop = System.currentTimeMillis()
    return (stop - start)
}

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

//Задание 3: Использование also для логирования
fun logPerson(person: Person) {
    with(person) {
        println(name)
        println(age)
        println(email)
    }
}

//Задание 6: Использование let для безопасного преобразования Person в Employee
//Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
// В функции используйте функцию let для создания Employee, только если объект Person не null.
// В противном случае возвращается null
fun Person.toEmployee(): Employee? {
    this?.let {
        return Employee(this.name, this.age, "smth")
    }
    return null
}

fun main() {
    //1.
    val myFunction = {
        val list = List(10000000) { (0..10000).random() }
        list.sorted()
    }
    println(timeTracker(myFunction))

    //2. Задание 2: Использование apply для инициализации объекта Employee
    val employee = Employee("Smth", 25, "Engineer").apply {
        email = "smth@company.com"
        department = "Engineering"
    }

    //Задание 3: Использование also для логирования
    val person = Person("Ivan", age = 25).also {
        it.email = "ivan@company.com"
        println(logPerson(it))
    }

    //Задание 4: Использование with для преобразование Person в Employee
    //Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee,
    // указав дополнительно должность. Возвращаемым значением должен быть новый объект Employee.
    val somePerson = Person("Vova", 26)
    with(somePerson) {
        val someEmployee = Employee(name, age, position = "Something doer")
    }

    //Задание 5: Использование run для преобразования и инициализации Employee
    //Перепиши предыдущую задачу на использование run вместо with.
    val yetAnotherEmployee = somePerson.run {
        Employee(name, age, position = "Clucking the buttons")
    }



}
