package lessons.lesson18.homeworks

abstract class ProgrammableEquipment: PowerableEquipment(), Programmable {
    override fun programAction(action: String) {
        println("programming action")
    }
    override fun execute() {
        println("executing")
    }
}