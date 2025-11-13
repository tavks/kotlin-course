package lessons.lesson18.homeworks

abstract class PowerableEquipment(): Powerable {
    override fun powerOn() {
        println("turn on")
    }

    override fun powerOff() {
        println("turn off")
    }
}