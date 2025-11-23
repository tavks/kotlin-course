package lessons.lesson22.homewroks

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст.
// Выброси это исключение в main
class MyException(message: String) : AssertionError(message)

//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
// IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
// перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
class AnotherMyException(arg: IndexOutOfBoundsException, message: String) : RuntimeException(message)