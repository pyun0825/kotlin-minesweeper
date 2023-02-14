package domain

import dto.MineMapRequestDto

class MineMap (private val width: Width,
               private val height: Height,
               private val mineCount: MineCount,
               private val mapGeneratingStrategy: MapGeneratingStrategy
) {
    private val mineMap: List<List<Tile>>
    private val area: Int
        get() = width.width * height.height

    init {
        require(mineCount.isLessThan(area + 1)) { "Mine Count should be less than area!" }
        mineMap = mapGeneratingStrategy.generateMap(width, height, mineCount)
    }

    constructor(mineMapRequestDto: MineMapRequestDto, mapGeneratingStrategy: MapGeneratingStrategy) : this(
        mineMapRequestDto.width,
        mineMapRequestDto.height,
        mineMapRequestDto.mineCount,
        mapGeneratingStrategy
    )

    private fun validateThatCoordinateIsInsideMap(coordinate: Coordinate) {
        if (!height.isRowBetween(coordinate) || !width.isColBetween(coordinate)) {
            throw IllegalArgumentException("Coordinate is outside of map.")
        }
    }

    fun getTileStatusInCoordinate(coordinate: Coordinate): TileStatus {
        validateThatCoordinateIsInsideMap(coordinate)
        return mineMap[coordinate.row][coordinate.col].status
    }

    fun getNumberOfMinesAroundCoordinate(coordinate: Coordinate): Int {
        validateThatCoordinateIsInsideMap(coordinate)
        val startCoordinateOfSubMap = getStartCoordinateOfSubMap(coordinate)
        val endCoordinateOfSubMap = getEndCoordinateOfSubMap(coordinate)
        var count = 0

        for (row in startCoordinateOfSubMap.row..endCoordinateOfSubMap.row) {
            for (col in startCoordinateOfSubMap.col..endCoordinateOfSubMap.col) {
                if (mineMap[row][col].status == TileStatus.MINE) {
                    count++
                }
            }
        }
        return count
    }

    private fun getStartCoordinateOfSubMap(coordinate: Coordinate): Coordinate {
        val startRow = maxOf(0, coordinate.row - 1)
        val startCol = maxOf(0, coordinate.col - 1)
        return Coordinate(startRow, startCol)
    }

    private fun getEndCoordinateOfSubMap(coordinate: Coordinate): Coordinate {
        val endRow = minOf(height.height - 1, coordinate.row + 1)
        val endCol = minOf(width.width - 1, coordinate.col + 1)
        return Coordinate(endRow, endCol)
    }

    fun getMaxRowNum(): Int {
        return height.height - 1
    }

    fun getMaxColNum(): Int {
        return width.width - 1
    }
}