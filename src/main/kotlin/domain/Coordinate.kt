package domain

data class Coordinate(val row: Int, val col: Int) {
    constructor(rowColString: String) : this(
        rowColString.split(",")[0].toInt(),
        rowColString.split(",")[1].toInt()
    )
}
