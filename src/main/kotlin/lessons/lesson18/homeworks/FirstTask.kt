package lessons.lesson18.homeworks

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

abstract class Fridge(): Powerable, Openable, Movable, LightEmitting, TemperatureRegulatable {
}

abstract class WashingMachine(): Powerable, Openable, Movable, SoundEmitting, TemperatureRegulatable, WaterContainer, WaterConnection, Drainable {
}

abstract class SmartLamp(): Powerable, LightEmitting, Programmable, Cleanable {
}

abstract class RobotCleaner(): Powerable, Movable, SoundEmitting, Rechargeable, Cleanable {
}

abstract class MechanicalWatch(): Movable, Mechanical {
}

abstract class Spotlight(): Movable, BatteryOperated, LightEmitting {
}

abstract class CoffeeMaker(): Movable, Powerable, WaterContainer, Cleanable, TemperatureRegulatable {
}

abstract class SmartSpeaker(): Powerable, Movable, Cleanable, SoundEmitting, Timable {
}