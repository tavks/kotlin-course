package lessons.lesson30.homeworks

class InventoryManager(private val capacity: Int) {

    var items = mutableMapOf<String, Int>()

    /**
     * Метод возвращает количество инвентаря. Если наименования нет, возвращает 0
     */
    fun getItemCount(itemName: String): Int {
        if (items.keys.contains(itemName)) {
            return items.getValue(itemName)
        } else {
            return 0
        }
    }

    /**
     * Добавляет инвентарь в хранилище к существующему.
     * @param itemName название инвентаря
     * @param quantity количество инвентаря
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    fun addItem(itemName: String, quantity: Int) {
        checkCapacity(quantity)
        items[itemName] = (items[itemName] ?: 0) + quantity
    }

    /**
     * Удаляет инвентарь из хранилища
     * @param itemName название инвентаря
     * @param quantity количество инвентаря для удаления
     * @return true если удаление произошло и false если удаление невозможно, например нет наименования или нужного количества
     */
    fun removeItem(itemName: String, quantity: Int): Boolean {
        val currentQuantity = items[itemName]
        if (currentQuantity != null && quantity <= currentQuantity) {
            items[itemName] = currentQuantity - quantity
            return true
        }
        return false
    }

    /**
     * Проверяет, что количество объектов в инвентаре с учётом добавляющихся не превысит допустимого количества
     * @param itemsForAdding количество объектов для добавления
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    fun checkCapacity(itemsForAdding: Int) {
        check(capacity - items.values.sum() >= itemsForAdding) {
            "Количество инвентаря не должно превышать $capacity единиц"
        }
    }
}


