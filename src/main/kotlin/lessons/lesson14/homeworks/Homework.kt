package lessons.lesson14.homeworks

import java.awt.MenuItem
import kotlin.concurrent.timer

fun main() {

}

class Party(val location: String, var attendees: Int) {
    private fun details() {
        println("The party will be at $location, $attendees will be here")
    }
}

class Emotion(val type: String, val intensity: Int) {
    private fun express() {
        println("Expressing $type with $intensity intensity")
    }
}

class Moon(var isVisible: Boolean, var phase: String) {
    private fun showPhase() {
        println("Current phase is $phase")
    }
}

data class Product(val name: String, var price: Float, var quantity: Int) {
}

class Concert(val band: String, val place: String, var price: String, val capacity: Int, private var ticketsSold: Int) {
    fun getInfo() {
        println("The band name is $band, it will be at $place, ticket price is $price, hall capacity is $capacity")
    }

    fun buyTicket() {
        ticketsSold++
    }
}

class Rack(val shelves: MutableList<Shelf>, val maxShelvesCount: Int) {
    fun addShelf(shelf: Shelf): Boolean {
        if (!shelves.contains(shelf) && shelves.count() < maxShelvesCount) {
            shelves.add(shelf)
            return true
        }
        return false
    }

    fun removeShelf(index: Int): List<String> {
        if ((shelves.count() - 1) <= index) {
            val shelf = shelves[index]
            val items = shelf.items
            shelves.removeAt(index)
            return items
        } else {
            return listOf()
        }
    }

    fun addItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.canAccommodate(item)) {
                shelf.addItem(item)
                return true
            }
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.containsItem(item)) {
                shelf.removeItem(item)
                return true
            }
        }
        return false
    }

    fun containsItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.containsItem(item)) {
                return true
            }
        }
        return false
    }

    fun viewShelves(): List<Shelf> {
        return shelves.toList()
    }

    fun printContents() {
        for (shelf in shelves) {
            println("Shelf ${shelves.indexOf(shelf)} has capacity of ${shelf.capacity}, has ${shelf.spaceLeft} of free space and contains that items: ${shelf.items}")
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index >= shelves.count()) {
            return listOf<String>()
        }
        val shelvesByCapacity = shelves.sortedByDescending { it.capacity }
        val itemsToAccomodate = shelves[index].items
        val itemsWithoutAccomodation = mutableListOf<String>()

        for (item in itemsToAccomodate) {
            for (shelve in shelves) {
                if (shelves.indexOf(shelve) == index) {
                    continue
                }
                if (shelve.canAccommodate(item)) {
                    shelve.addItem(item)
                    break
                }
                itemsWithoutAccomodation.add(item)
            }
        }
        return itemsWithoutAccomodation.toList()
    }
}

class Shelf(val capacity: Int, var items: MutableList<String>) {
    var currentOccupacy = 0
    var spaceLeft = capacity - currentOccupacy
    fun addItem(item: String): Boolean {
        if (canAccommodate(item)) {
            items.add(item)
            currentOccupacy += item.count()
            return true
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        if (containsItem(item)) {
            items.remove(item)
            return true
        }
        return false
    }

    fun canAccommodate(item: String): Boolean {
        if (item.count() <= (capacity - currentOccupacy)) {
            return true
        }
        return false
    }

    fun containsItem(item: String): Boolean {
        if (items.contains(item)) {
            return true
        }
        return false
    }

    fun viewItems(): List<String> {
        return items.toList()
    }
}


