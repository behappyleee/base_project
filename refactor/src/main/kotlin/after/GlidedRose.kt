package after

class GlidedRose(
    private val flowers: List<FlowerItem>,
) {
    fun updateQuality() {
        flowers.forEach {
            it.controlQuality()
        }
    }
}
