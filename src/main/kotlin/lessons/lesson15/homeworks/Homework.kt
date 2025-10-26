package lessons.lesson15.homeworks

import kotlin.math.max

fun main() {
}

abstract class GeometricFigure {
    fun getArea() {
        println("The ares is ...")
    }
}

open class Polygon(val numOfAngles: Int): GeometricFigure() {
}

class Circle(val radius: Int): GeometricFigure() {
}

class Triangle(val largestAngle: Int): Polygon(numOfAngles = 3) {
}

class Square(val sideLength: Int): Polygon(numOfAngles = 4) {
}

abstract class EducationalInstitution() {
    fun getDiploma() {
        println("Lol")
    }
}

open class School(val numOfYears: Int) {
}

class MiddleSchool(): School(numOfYears = 5) {
}

abstract class Furniture(val color: String) {
}

open class Chairs(seatMaterial: String): Furniture(color = "brown") {
}

class WorkingChairs(val brandName: String): Chairs(seatMaterial = "textile") {
}



abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class InsertMaterial: Materials() {
    fun insertMaterial(material: String) {
        val extracted = extractMaterials()
        addMaterial(material)
        for (element in extracted) {
            addMaterial(element)
        }
    }
}

class InsertOneByOneMaterials : Materials() {
    fun insert(items: List<String>) {
        val materials = extractMaterials()
        val maxIndex = max(items.lastIndex, materials.lastIndex)
        for (i in 0..maxIndex) {
            if (i < items.size) {
                addMaterial(items[i])
            }
            if (i < materials.size) {
                addMaterial(materials[i])
            }
        }
    }
}

class InsertSortedMaterials : Materials() {
    fun insert(item: String) {
        val materials = (extractMaterials() + item).sorted()
        materials.forEach {
            addMaterial(it)
        }
    }
}

class InsertMapMaterials : Materials() {
    fun insert(items: Map<String, String>) {
        val materials = items.keys.reversed() + extractMaterials() + items.values
        materials.forEach {
            addMaterial(it)
        }
    }
}