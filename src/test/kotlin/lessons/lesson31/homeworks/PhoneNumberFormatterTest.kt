package lessons.lesson31.homeworks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PhoneNumberFormatterTest {
    @ParameterizedTest
    @MethodSource("provideDiscountValidData")
    fun `should format telephone number correctly`(inputNumber: String, formattedCorrectlyNumber: String) {
        val formatter = PhoneNumberFormatter()
        assertEquals(formattedCorrectlyNumber, formatter.formatPhoneNumber(inputNumber))
    }

    @ParameterizedTest
    @MethodSource("provideDiscountInvalidData")
    fun `should throw exception on invalid number`(inputNumber: String, exception: Exception) {
        val formatter = PhoneNumberFormatter()
        assertThrows<IllegalArgumentException> {
            formatter.formatPhoneNumber(inputNumber)
        }
    }

    companion object {
        @JvmStatic
        fun provideDiscountValidData(): List<Array<String>> {
            return listOf(
                arrayOf("8 (922) 941-11-11", "+7 (922) 941-11-11"),
                arrayOf("79229411111", "+7 (922) 941-11-11"),
                arrayOf("+7 922 941 11 11", "+7 (922) 941-11-11"),
                arrayOf("9229411111", "+7 (922) 941-11-11"),
                arrayOf("abc +7 922 941 11 11", "+7 (922) 941-11-11")
            )
        }

        @JvmStatic
        fun provideDiscountInvalidData(): List<Array<Any>> {
            return listOf(
                arrayOf("12345", IllegalArgumentException()),
                arrayOf("+1 (922) 941-11-11", IllegalArgumentException())
            )
        }
    }
}