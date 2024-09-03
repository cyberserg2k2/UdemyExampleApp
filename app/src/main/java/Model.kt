class Model {
    val items: HashMap<String, Int> = hashMapOf(
        "bag" to 0,
        "ring" to 0
    )

    fun addItem(itemName: String) {
        items[itemName] = items[itemName]!! + 1
    }

    fun clearItems() {
        items["bag"] = 0
        items["ring"] = 0
    }

    fun getCountOfItem(itemName: String) : Int? {
        return items[itemName]
    }

    fun getTotalItemCount(): Int {
        val countOfBags = items["bag"]
        val countOfRings = items["ring"]
        return countOfBags!! + countOfRings!!
    }
}