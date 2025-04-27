package after

class GlidedRose(
    private val flowers: List<Item>,
) {
    fun updateQuality() {
        flowers.forEach {
            it.controlQuality()
        }
    }
}
