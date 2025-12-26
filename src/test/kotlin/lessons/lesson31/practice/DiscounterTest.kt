package lessons.lesson31.practice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DiscounterTest {
    @ParameterizedTest
    @MethodSource("provideDiscountData")
    fun `should calculate discounted price correctly`(
        dateOfBirth: String,
        price: Double,
        discount: Double
    ) {
        val profile = ClientProfile(birthday = dateOfBirth)
        val discounter = Discounter()
        val actualDiscount = discounter.calculateSingleDiscount(profile, price, 1)
        assertEquals(discount, actualDiscount, 0.01)
    }

    @ParameterizedTest
    @MethodSource("provideDiscountDataWithSmth")
    fun `should calculate discounted price correctly with smth`(
        purchaseCount: Int,
        price: Double,
        discount: Double
    ) {
        val profile = ClientProfile(birthday = "1983.12.01")
        val discounter = Discounter()
        for (i in 1..purchaseCount) {
            profile.addPurchase(LocalDate.of(1977, 12, 1))
        }
        val actualDiscount = discounter.calculateSingleDiscount(profile, price, 1)
        assertEquals(discount, actualDiscount,0.01)
    }


    companion object {
        @JvmStatic
        fun provideDiscountData(): List<Array<Any?>> {
            val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
            val sixtyYearsBirthday = LocalDate.now().minusYears(60).format(dateTimeFormatter)
            val lessThanSixtyYearsBirthday = LocalDate.now().minusYears(60).plusDays(1).format(dateTimeFormatter)
            val moreThanSixtyYearsBirthday = LocalDate.now().minusYears(60).minusDays(1).format(dateTimeFormatter)
            return listOf(
                arrayOf(sixtyYearsBirthday, 100.0, 11.0),
                arrayOf(lessThanSixtyYearsBirthday, 100.0, 0.0),
                arrayOf(moreThanSixtyYearsBirthday, 100.0, 10.0),
            )
        }

        @JvmStatic
        fun provideDiscountDataWithSmth(): List<Array<Any?>> {
            return listOf(
                arrayOf(4, 100.0, 1.0),
                arrayOf(11, 100.0, 4.0),
                arrayOf(51, 100.0, 8.0),
                arrayOf(101, 100.0, 10.0),
            )
        }
    }
}

