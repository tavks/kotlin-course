package lessons.lesson31.practice

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class ClientProfile(birthday: String = "1986.05.23") {

    private var lastActivity = LocalDate.of(2000, 1, 1)
    private var purchaseNumber = 0
    private val dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    private val birthday: LocalDate = LocalDate.parse(birthday, dateFormat)

    init {
        require(this.birthday.isBefore(LocalDate.now()))
    }

    fun addPurchase(date: LocalDate = LocalDate.now()) {
        lastActivity = date
        purchaseNumber++
    }

    fun getLastActivity(): LocalDate {
        return LocalDate.from(lastActivity)
    }

    /**
     * Возвращает true если на профиле покупок больше, чем переданное число
     */
    fun moreThanPurchases(numberForCompare: Int): Boolean {
        return purchaseNumber > numberForCompare
    }

    fun getAge(): Int {
        return Period.between(birthday, LocalDate.now()).years
    }
}

class Discounter {

    fun calculateSingleDiscount(profile: ClientProfile, price: Double, count: Int): Double {
        var coefficient = 1.0
        if (profile.getAge() >= 60) {
            coefficient -= 0.1
        }
        if (profile.getAge() in 18..20) {
            coefficient -= 0.05
        }

        when {
            profile.moreThanPurchases(100) -> coefficient -= 0.1
            profile.moreThanPurchases(50) -> coefficient -= 0.08
            profile.moreThanPurchases(10) -> coefficient -= 0.04
        }
        when {
            count > 100 -> coefficient -= 0.1
            count > 50 -> coefficient -= 0.08
            count > 10 -> coefficient -= 0.04
        }
        val lastActivity = profile.getLastActivity()
        val lastWeek = LocalDate.now().minusDays(7)
        val lastMonth = LocalDate.now().minusMonths(1)
        if (lastActivity.isAfter(lastWeek)) {
            coefficient -= 0.03
        }
        if (lastActivity.isAfter(lastMonth)) {
            coefficient -= 0.02
        }
        return price * (1.0 - coefficient)
    }
}