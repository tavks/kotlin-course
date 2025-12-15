package lessons.lesson26.homeworks

import java.io.File

fun main() {
    //1. Создайте текстовый файл workspace/task1/example.txt. Запишите в него строку "Hello, Kotlin!",
    // а затем проверьте, существует ли файл. Реши задачу с использованием scope функции без создания переменной.
    File("workspace/task1/example.txt").apply {
        parentFile?.mkdirs()
        createNewFile()
        writeText("Hello, Kotlin!")
    }

    //2. Создайте директорию workspace/task2/testDir. Проверьте, является ли она директорией, и выведите её абсолютный путь
    File("workspace/task2/testDir").apply {
        parentFile?.mkdirs()
        mkdir()
        isDirectory
        println(absoluteFile)
    }

    //3. Создайте директорию workspace/task3/structure. Внутри директории structure создайте папку myDir с двумя вложенными
    // поддиректориями subDir1 и subDir2. Проверьте, что myDir действительно содержит эти поддиректории.
    // Используй scope функции для минимизации создания переменных а так же метод file.resolve("myDir") для создания
    // нового объекта File путём добавления к существующему пути ещё одной секции. И так же для других директорий.
    File("workspace/task3/structure/myDir").apply {
        parentFile?.mkdirs()
        mkdir()
        val s1 = File("subDir1").mkdir()
        val s2 = File("subDir2").mkdir()
        val filesInMyDir = list()
        if (filesInMyDir?.all { it.contains("subDir1") || it.contains("subDir2") } ?: false) {
            println("All good")
        } else {
            println("Smth gone wrong")
        }
    }

    //4. Создайте директорию workspace/task4/temp. Внутри директории temp создайте несколько вложенных файлов и директорий.
    // Удалите директорию workspace/task4 со всем содержимым
    File("workspace/task4/temp").apply {
        File("subDir1").mkdir()
        File("subDir2").mkdir()
        File("smth1.txt").createNewFile()
        File("smth2.txt").createNewFile()
    }
    File("workspace/task4").deleteRecursively()

    //5. Создайте файл workspace/task5/config/config.txt. запишите в него список параметров (в формате ключ=значение),
    // а затем прочитайте файл и выведите только значения.
    with(File("workspace/task5/config/config.txt")) {
        parentFile.mkdirs()
        createNewFile()
        listOf("param 1 = true", "param 2 = false").also {
            writeText(it.joinToString("\n"))
        }
        readLines().map {
            it.split("=")
                .getOrNull(1)
                ?.trim() ?: ""
        }.also {
            println(it.joinToString())
        }
    }

    //6. Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов
    File("workspace").apply {
        walk().groupBy { if (it.isDirectory) "dir" else "file" }
            .also {
                println("Directories")
                println(it["dir"]?.joinToString("\n"))
                println("Files")
                println(it["file"]?.joinToString("\n"))
            }
    }

    //7. Создайте директорию workspace/task7/docs. Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его
    // и запишите текст "This is a README file.". Проверьте текст в файле.
    val dir = File("workspace/task7/docs")
    val readme = dir.resolve(File("readme.md"))
    if (!readme.isFile) {
        readme.createNewFile()
        readme.writeText("\"This is a README file.\"")
    }

    //8
    File("workspace/task8").deleteRecursively()
    listOf(
        "workspace/task8/data/1/4/prod/data14.mysql",
        "workspace/task8/data/2/3/prod/data23.mysql",
        "workspace/task8/data/5/2/prod/data52.mysql",
    ).forEach {
        File(it).apply {
            parentFile?.mkdirs()
        }.createNewFile()
    }
    val backup = File("workspace/task8/backup").also { it.mkdirs() }
    File("workspace/task8/data").apply {
        walk().filter { it.isFile }
            .forEach {
                val relative = it.relativeTo(this)
                it.copyTo(backup.resolve(relative))
            }
    }
}