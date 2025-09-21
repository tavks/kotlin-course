package lessons.lesson06.homework

fun getSeason(monthNumber: Int) {
    if ((monthNumber in 1..2) || monthNumber == 12) {
        print("Winter")
    } else if (monthNumber in 3..5) {
        print("Spring")
    } else if (monthNumber in 6..8) {
        print("Summer")
    } else if (monthNumber in 9..11) {
        print("Fall")
    } else {
       print("Unexpected month number entered")
    }
}

fun getDogAge(age: Double) {
    var humanAge: Double = 0.0
    if (age <= 2) {
        humanAge = age * 10.5
    } else {
        humanAge = ((age - 2) * 4) + 21
    }
    print(humanAge)
}

fun getTheBestTransportationMethod(distance: Double) {
    if (distance <= 1) {
        print("On foot")
    } else if (distance <= 5) {
        print("Bicycle")
    } else {
        print("Auto")
    }
}

fun getBonusPoints(checkAmount: Int) {
    var bonusPoints: Int = 0
    if (checkAmount <= 1000) {
        bonusPoints = (checkAmount / 100) * 2
    } else {
        bonusPoints = ((checkAmount - 1000) / 100) * 3 - 10
    }
    print(bonusPoints)
}

fun getDocumentType(extension: String) {
    if (extension == ".txt") {
        print("Text file")
    } else if (extension == ".jpg") {
        print("Image")
    } else if (extension == ".xls") {
        print("Table")
    } else {
        print("Unknown")
    }
}

fun temperatureConverter(temp: Double, currentSystem: String) {
    var resultTemperature: Double = 0.0
    lateinit var resultSystem: String
    if (currentSystem == "C") {
        resultTemperature = (temp * 9/5) + 32
        resultSystem = "F"
    } else if (currentSystem == "F") {
        resultTemperature = (temp - 32) * 5/9
        resultSystem = "C"
    } else {
        print("Unknown system")
    }
    print(resultTemperature)
    print(resultSystem)
}

fun getConvenientClothes(temperature: Int) {
    if ((temperature <= -30) || (temperature >= 35)) {
        print("Do not leave the house")
    } else if (temperature < 10) {
        print("Jacket and hat")
    } else if (temperature in 10..18) {
        print("Light jacket")
    } else if (temperature > 18) {
        print("T-short and shorts")
    }
}

fun getMovieCategory(age: Int) {
    if (age <= 9) {
        print("For kids")
    } else if (age in 10..17) {
        print("For teenagers")
    } else {
        print("For adults")
    }
}