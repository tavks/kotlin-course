package lessons.lesson08.homework

fun main() {

}

fun getIronicString(str: String) {
    var result = str
    result.replace(oldValue = "невозможно", newValue = "совершенно точно возможно, просто требует времени")
    if (result.startsWith("Я не уверен")) {
        result += ", но моя интуиция говорит об обратном"
    }
    result.replace(oldValue = "катастрофа", newValue = "интересное событие")
    if (result.endsWith("без проблем")) {
        result.replace(oldValue = "без проблем", newValue = "с парой интересных вызовов на пути")
    }
    if (result.split("").count() == 1) {
        val oldValue = result
        result = "Иногда," + oldValue + ", но не всегда"
    }
}

fun getDateFromLog(str: String) {
    val dateAndTime = str.split(" -> ")[1]
    val arrayDateAndTime = dateAndTime.split(" ")
    println(arrayDateAndTime[0])
    println(arrayDateAndTime[1])
}

fun cardMask(str: String) {
    val cardArray = str.split(" ").toMutableList()
    for (i in 0..cardArray.count() - 2) {
        cardArray[i] = "****"
    }

    var result = ""
    for (element in cardArray) {
        result += element
        result += " "
    }
}

fun emailFormat(str: String) {
    var result = str.replace("@", " [at] ")
    result = str.replace(".", " [dot] ")
}

fun filenameExtractor(str: String) {
    val path = str.split("/")
    val result = path[path.count() - 1]
}

fun getAbbr(str: String) {
    val strArray = str.split(" ")
    var result = ""
    for (element in  strArray) {
        result += element.first()
    }
}

