package lessons.lesson18.homeworks

class Fridge(override val maxTemperature: Int) : OpenableAndTemperatureRegulatableEquipment() {
    fun produceCold() {
        powerOn()
        println("producing cold")
    }
}

class WashingMachine(override val maxTemperature: Int): OpenableAndTemperatureRegulatableEquipment() {
    fun washClothes() {
        powerOn()
        println("washing")
    }
}

class Kettle(override val maxTemperature: Int) : OpenableAndTemperatureRegulatableEquipment() {
    fun boilWater() {
        powerOn()
        println("boiling")
    }
}

class Oven(override val maxTemperature: Int) : OpenableAndTemperatureRegulatableEquipment() {
    fun produceHeat() {
        powerOn()
        println("heating")
    }
}