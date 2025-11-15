package after

import before.GildedRose
import before.Item
import com.sun.org.slf4j.internal.LoggerFactory
import kotlin.time.Duration

sealed class FlowerItem(
    protected open val name: String,
    protected open var sellIn: Int,
    protected open var quality: Int,
    protected open val controlFn: (Int) -> Int = {
        when {
            quality <= 0 -> quality
            sellIn > 0 -> quality - DEFAULT_DISCOUNT_QUALITY
            sellIn <= 0 -> quality - (DEFAULT_DISCOUNT_QUALITY * 2)
            else ->  quality - DEFAULT_DISCOUNT_QUALITY
        }
    },
): after.Item {

    data class NormalFlower(
        override val name: String = "Normal Flower",
        override var sellIn: Int = 50,
        override var quality: Int = 30,
    ): FlowerItem(
        name = name,
        sellIn = sellIn,
        quality = quality
    ) {
        override fun controlQuality() {
            controlCustomQuality(
                controlQuality = DEFAULT_DISCOUNT_QUALITY,
                controlFn = this.controlFn,
            )
        }
    }

    data class Sulfuras(
        override val name: String = "Sulfuras",
        override var sellIn: Int = 50,
    ): FlowerItem(
        name = name,
        sellIn = sellIn,
        quality = SULFURAS_QUALITY
    ) {
        override fun controlQuality() {
            logger.warn("Sulfuras Flower Quality can't control !")
        }

        companion object {
            private const val SULFURAS_QUALITY: Int = 80
        }
    }

    data class AgedBrie(
        override val name: String = "Aged Brie",
        override var sellIn: Int = 50,
        override var quality: Int = 30,
    ): FlowerItem(
        name = name,
        sellIn = sellIn,
        quality = quality
    ) {
        override fun controlQuality() {
            controlCustomQuality(
                controlQuality = DEFAULT_DISCOUNT_QUALITY,
            ) {
                quality + it
            }
        }
    }

    data class Conjured(
        override val name: String = "Conjured",
        override var sellIn: Int = 50,
        override var quality: Int = 20,
    ): FlowerItem(
        name = name,
        sellIn = sellIn,
        quality = quality
    ) {
        override fun controlQuality() {
            controlCustomQuality(
                controlQuality = if (quality >= DEFAULT_DISCOUNT_QUALITY * 2) {
                    DEFAULT_DISCOUNT_QUALITY * 2
                } else {
                    DEFAULT_DISCOUNT_QUALITY
                },
            ) {
                quality - it
            }
        }
    }

    data class BackStage(
        override val name: String,
        override var sellIn: Int,
        override var quality: Int,
    ): FlowerItem(
        name = name,
        sellIn = sellIn,
        quality = quality,
    ) {
        override fun controlQuality() {
            controlCustomQuality(
                controlQuality = when {
                    sellIn  in 1.. 5 -> DEFAULT_DISCOUNT_QUALITY * 3
                    sellIn in 6..10 -> DEFAULT_DISCOUNT_QUALITY * 2
                    sellIn > 10 -> DEFAULT_DISCOUNT_QUALITY
                    else -> quality
                }
            ) {
                if (sellIn > 0) {
                    quality + it
                } else {
                    quality - it
                }
            }
        }
    }

    fun controlCustomQuality(
        controlQuality: Int,
        controlFn: (Int) -> Int,
    ): Int {
        require(
            quality <= MAX_QUALITY || quality >= MINIMUM_QUALITY
        ) {
            logger.error("Quality Should Not Over 50 or Negative")
            return quality
        }
        return controlFn(controlQuality)
    }

    companion object {
        private const val MAX_QUALITY = 50
        private const val MINIMUM_QUALITY = 0
        private const val DEFAULT_DISCOUNT_QUALITY = 1
        private val logger = LoggerFactory.getLogger(FlowerItem::class.java)
    }
}



fun main(args: Array<String>) {
    Duration

    val items = listOf(
       FlowerItem.AgedBrie(name = "Aged Brie", sellIn = 50),
    )

//    println("OMGHAI!")
//
//    val items = listOf(
//        Flo("+5 Dexterity Vest", 10, 20), //
//        Item("Aged Brie", 2, 0), //
//        Item("Elixir of the Mongoose", 5, 7), //
//        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
//        Item("Sulfuras, Hand of Ragnaros", -1, 80),
//        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
//        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
//        // this conjured item does not work properly yet
//        Item("Conjured Mana Cake", 3, 6)
//    )
//
//    val app = GildedRose(items)
//
//    var days = 2
//    if (args.size > 0) {
//        days = Integer.parseInt(args[0]) + 1
//    }
//
//    for (i in 0..days - 1) {
//        println("-------- day $i --------")
//        println("name, sellIn, quality")
//        for (item in items) {
//            println(item)
//        }
//        println()
//        app.updateQuality()
//    }
}