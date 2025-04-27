package after

import com.sun.org.slf4j.internal.LoggerFactory

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
): Item {

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
