package domain

data class MineCount(private val count: Int) {
    init {
        require(count >= MIN_COUNT) { "Mine Count should be equal or larger than $MIN_COUNT" }
    }

    fun isBiggerThan(num: Int): Boolean {
        return this.count > num
    }

    fun isLessThan(num: Int): Boolean {
        return this.count < num
    }

    companion object {
        const val MIN_COUNT = 1
    }
}