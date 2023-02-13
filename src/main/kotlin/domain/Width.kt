package domain

class Width(val width: Int) {
    init {
        require(width > THRESHOLD) { "Width should be larger than $THRESHOLD!" }
    }

    fun isColBetween(coordinate: Coordinate): Boolean {
        return coordinate.col >= THRESHOLD && coordinate.col < this.width
    }

    companion object {
        // 너비의 최소니 0보단 1..?
        const val THRESHOLD = 0
    }
}