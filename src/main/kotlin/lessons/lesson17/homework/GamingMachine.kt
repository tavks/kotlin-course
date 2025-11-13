package lessons.lesson17.homework

class GamingMachine(val color: String, val model: String, ) {
    private var isOn = true
    private var osBooted = true
    val gamesAvailable = listOf<String>()
    var isGamepadAvailable = true
    private var moneyEarned = 100
    private var owner = "Smbd"
    var supportContact = "8 800 555 35 35"
    var isSessionPaid = true
    var sessionPrice = 100
    private var pin = "1111"

    fun turnOn() {
    }

    fun turnOff() {
    }

    private fun bootOS() {
    }

    private fun terminateOS() {
    }

    fun showGamesAvailable() {
    }

    fun loadGame() {
    }

    fun payForSession() {
    }

    private fun getCash(pin: String) {
    }

    private fun openSafe() {
    }
}