package lessons.lesson18.homeworks

abstract class OpenableAndTemperatureRegulatableEquipment: ProgrammableEquipment(), Openable, TemperatureRegulatable {
    override fun open() {
        println("open")
    }

    override fun close() {
        println("close")
    }

    override fun setTemperature(temp: Int) {
        println("setting temperature")
    }

}