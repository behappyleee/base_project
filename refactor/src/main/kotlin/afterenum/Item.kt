package afterenum

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    fun getItemTypeByName(name: String): ItemType =
        when(name) {
            "+5 Dexterity Vest" -> ItemType.VEST
            "Aged Brie" ->ItemType.AGED_BRIE
            "Elixir" -> ItemType.ELIXIR
            "Sulfuras" -> ItemType.SULFURAS
            "Backstage passes to a TAFKAL80ETC concert" -> ItemType.BACKSTAGE_PASSES
            "Conjured Mana Cake" -> ItemType.CONJURED
            else -> throw RuntimeException("Unknown ItemType: $name")
        }
}

//VEST(
//itemName = "+5 Dexterity Vest",
//controlQuality = {
//
//},
//),
//AGED_BRIE(
//itemName = "Aged Brie",
//controlQuality = {
//
//},
//),
//ELIXIR(
//itemName = "Elixir",
//controlQuality = {
//
//},
//),
//SULFURAS(
//itemName = "Sulfuras",
//controlQuality = {
//
//},
//),
//BACKSTAGE_PASSES(
//itemName = "Backstage passes to a TAFKAL80ETC concert",
//controlQuality = {
//
//},
//),
//CONJURED(
//itemName = "Conjured Mana Cake",
//controlQuality =  {
//
//},
//),