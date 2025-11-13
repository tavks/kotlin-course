package lessons.lesson17.homework
fun main() {
    val children = ChildrenClass("privateVal", "protectedVal", "publicVal")
    children.publicField = "Антонио Бандерас"
    println(children.getAll())
    children.updateProtectedField("new value")
}

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    // Оно, в действительности, недоступно, т.к. оно private
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    // Поле protected – доступно только внутри класса и производных классов
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    // Невозможно изменить это поле, т.к. оно прайват
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной
    // Она возвращает протектед класс, доступ к которому есть только внутри класса или производных класса
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // Т.к. метод переопределен в наследнике
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    // Т.к. возвращает private класс, доступ к которому только внутри класса
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // Доступно другое поле с тем же названием, не этот аргумент
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // Т.к. она есть в родительском классе и публичная
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // Т.к. метод приватный, он не переопределяется, это новый метод с тем же названием
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    fun updateProtectedField(value: String) {
        protectedField = value
    }
}