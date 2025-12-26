package lessons.lesson31.homeworks

class PhoneNumberFormatter {
    fun formatPhoneNumber(input: String): String {
        var formattedInput = input.replace("\\D".toRegex(), "")
        val inputLength = formattedInput.length
        check(inputLength == 10 || inputLength == 11) {
            throw IllegalArgumentException()//"The number must contain 10 or 11 symbols")
        }
        if (inputLength == 10) {
            formattedInput = "7" + formattedInput
        }
        if (formattedInput.startsWith("7")) {
            formattedInput = "+" + formattedInput
        } else if (formattedInput.startsWith("8")) {
            formattedInput = formattedInput.removePrefix("8")
            print("after")
            print(formattedInput)
            formattedInput = "+7" + formattedInput
        } else {
            throw IllegalArgumentException()//"The number must start with 7 or 8")
        }
        val output = formattedInput.substring(0,2) + " (" + formattedInput.substring(2,5) + ") " + formattedInput.substring(5, 8) + "-" + formattedInput.substring(8, 10) + "-" + formattedInput.substring(10, 12)
        return output
    }
}

fun main() {
    val sm = PhoneNumberFormatter()
    print(sm.formatPhoneNumber("8 (922) 941-11-11"))
}