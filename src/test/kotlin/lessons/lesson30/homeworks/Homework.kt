package lessons.lesson30.homeworks

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

public class Tests() {
    private val inventoryManager = InventoryManager(10)

    @BeforeEach
    fun setUp() {
        inventoryManager.items = mutableMapOf<String, Int>()
    }

    @Test
    fun testItemCountReturnsZeroIfElementDoesNotExist() {
        assertEquals(0, inventoryManager.getItemCount("Smth"))
    }

    @Test
    fun testItemCountReturnsNumberIfElementExists() {
        inventoryManager.addItem("Smth", 1)
        assertEquals(1, inventoryManager.getItemCount("Smth"))
    }

    @Test
    fun testAddItemShouldAddGivenQuantityToNewItem() {
        inventoryManager.addItem("apple", 1)
        assertEquals(1, inventoryManager.getItemCount("apple"))
    }

    @Test
    fun testAddItemShouldAddGivenQuantityToExistingItem() {
        inventoryManager.addItem("apple", 1)
        inventoryManager.addItem("apple", 3)
        assertEquals(4, inventoryManager.getItemCount("apple"))
    }

    @Test
    fun testAddItemThrowsException() {
        assertThrows<IllegalStateException> {
            inventoryManager.addItem("apple", 11)
        }
    }

    @Test
    fun testRemoveItemShouldRemoveExisting() {
        inventoryManager.addItem("apple", 1)
        assertEquals(true, inventoryManager.removeItem("apple", 1))
        assertEquals(0, inventoryManager.getItemCount("apple"))
    }

    @Test
    fun testRemoveItemShouldNotRemoveMoreThanExists() {
        inventoryManager.addItem("apple", 1)
        assertEquals(false, inventoryManager.removeItem("apple", 2))
        assertEquals(1, inventoryManager.getItemCount("apple"))
    }

    @Test
    fun testRemoveItemShouldNotRemoveNonExisting() {
        assertEquals(false, inventoryManager.removeItem("apple", 2))
    }

    @Test
    fun testCheckCapacityShouldNotThrow() {
        assertDoesNotThrow { inventoryManager.checkCapacity(10) }
    }

    @Test
    fun testCheckCapacityShouldThrow() {
        assertDoesNotThrow { inventoryManager.checkCapacity(11) }
    }
}