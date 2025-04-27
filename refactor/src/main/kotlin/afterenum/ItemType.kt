package afterenum

enum class ItemType(
    private val itemName: String,
    val controlQuality: () -> Unit,
) {
    VEST(
        itemName = "+5 Dexterity Vest",
        controlQuality = {

        },
    ),
    AGED_BRIE(
        itemName = "Aged Brie",
        controlQuality = {

        },
    ),
    ELIXIR(
        itemName = "Elixir",
        controlQuality = {

        },
    ),
    SULFURAS(
        itemName = "Sulfuras",
        controlQuality = {

        },
    ),
    BACKSTAGE_PASSES(
        itemName = "Backstage passes to a TAFKAL80ETC concert",
        controlQuality = {

        },
    ),
    CONJURED(
        itemName = "Conjured Mana Cake",
        controlQuality =  {

        },
    ),
    ;
}

//Item("+5 Dexterity Vest", 10, 20), //
//Item("Aged Brie", 2, 0), //
//Item("Elixir of the Mongoose", 5, 7), //
//Item("Sulfuras, Hand of Ragnaros", 0, 80), //
//Item("Sulfuras, Hand of Ragnaros", -1, 80),
//Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
//Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
//// this conjured item does not work properly yet
//Item("Conjured Mana Cake", 3, 6)

