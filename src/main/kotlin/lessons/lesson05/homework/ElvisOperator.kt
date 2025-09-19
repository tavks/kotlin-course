package org.example.lessons.lesson05.homework

fun main() {
    // example 1
    val initialSoundIntensity = 5.0
    var attenuationCoeff: Double? = 0.69
    val baseCoeff = 0.5
    val result1 = initialSoundIntensity * (attenuationCoeff ?: baseCoeff)

    // example 2
    val deliveryFee: Double = 70.0
    var packagePrice: Double? = 100.0
    val insurancePrice = (packagePrice ?: 10000 * 0.005)
    val result2 = deliveryFee + insurancePrice

    // example 3
    var currentPressure: String? = "713"
    val alarmMessage: String = "No pressure data"
    val result3 = currentPressure ?: alarmMessage
}