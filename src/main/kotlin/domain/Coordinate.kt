package domain

data class Coordinate(val row: Int, val col: Int) {
    constructor(rowColString: String) : this(
        rowColString.split(",")[0].trim().toInt(),
        rowColString.split(",")[1].trim().toInt()
    )
}
