package domain

class Height(val height: Int) {
    init {
        require(height > THRESHOLD) { "Height should be larger than $THRESHOLD!" }
    }

    fun isRowBetween(coordinate: Coordinate): Boolean {
        return coordinate.row >= THRESHOLD && coordinate.row < this.height
    }

    companion object {
        // 높이의 최소니 0보단 1..?
        const val THRESHOLD = 0
    }
}
