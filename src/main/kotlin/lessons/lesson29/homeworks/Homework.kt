package lessons.lesson29.homeworks

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

data class Employee(
    val name: String,
    val isEmployed: Boolean,
    val birthDate: String,
    val position: CharacterTypes,
    val subordinates: List<Employee> = emptyList()
)

enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM,
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

val crm = Employee(name = "Alex", isEmployed = true, birthDate = "11.11.1990", position = CharacterTypes.CRM, subordinates = listOf())
val backendTL = Employee(name = "Egor", isEmployed = true, birthDate = "11.11.1989", position = CharacterTypes.TEAM_LEAD, subordinates = listOf())
val frontendTL = Employee(name = "Igor", isEmployed = true, birthDate = "11.11.1989", position = CharacterTypes.TEAM_LEAD, subordinates = listOf())
val backendDev = Employee(name = "Elena", isEmployed = true, birthDate = "11.12.1989", position = CharacterTypes.BACKEND_DEV)
val frontendDev = Employee(name = "Andrey", isEmployed = true, birthDate = "11.09.1999", position = CharacterTypes.FRONTEND_DEV)
val pm = Employee(name = "Olga", isEmployed = true, birthDate = "11.11.2000", position = CharacterTypes.PM, subordinates = listOf(backendTL, frontendTL))
val cto = Employee(name = "Ivan", isEmployed = true, birthDate = "11.11.1911", position = CharacterTypes.CTO, subordinates = listOf(pm, crm))

fun ex3() {
    val gson = GsonBuilder().setPrettyPrinting().create()
    gson.toJson(cto).also {
        File("cto.json").writeText(it)
    }
}

fun ex4() {
    val gson = Gson()
    val json = File("cto.json").readText()
    val cto = gson.fromJson(json, Employee::class.java)
    println(cto)
}

fun main() {
    ex3()
    ex4()
}