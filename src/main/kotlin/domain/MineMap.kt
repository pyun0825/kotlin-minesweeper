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
        require(mineCount.isLessThan(area)) { "Mine Count should be less than area!" }
        mineMap = mapGeneratingStrategy.generateMap(width, height, mineCount)
    }

    constructor(mineMapRequestDto: MineMapRequestDto, mapGeneratingStrategy: MapGeneratingStrategy) : this(
        mineMapRequestDto.width,
        mineMapRequestDto.height,
        mineMapRequestDto.mineCount,
        mapGeneratingStrategy
    )

    fun isCoordinateInsideMap(coordinate: Coordinate): Boolean {
        return height.isRowBetween(coordinate) && width.isColBetween(coordinate)
    }

    fun getTileStatusInCoordinate(coordinate: Coordinate): TileStatus {
        return mineMap[coordinate.row][coordinate.col].status
    }

    fun getMaxRowNum(): Int {
        return height.height - 1
    }

    fun getMaxColNum(): Int {
        return width.width - 1
    }
}