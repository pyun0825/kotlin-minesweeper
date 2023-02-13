package domain

import dto.MineMapRequestDto
import kotlin.random.Random

fun generateNDistinctCoordinates(n: Int, xMax: Int, yMax: Int): Set<Pair<Int, Int>> {
    val coords = mutableSetOf<Pair<Int, Int>>()
    while (coords.size < n) {
        val x = Random.nextInt(xMax)
        val y = Random.nextInt(yMax)
        coords.add(Pair(x, y))
    }
    return coords
}

class MineMap (val width: Int,
               val height: Int,
               val mineCount: Int
) {
    private val mineMap: MutableList<MutableList<Char>>
    private val mineCoordinates: Set<Pair<Int, Int>>

    constructor(mineMapRequestDto: MineMapRequestDto) : this(
        mineMapRequestDto.width,
        mineMapRequestDto.height,
        mineMapRequestDto.mineCount
    )

    init {
        mineMap = ArrayList()
        for (i in 1..height) {
            mineMap.add(MutableList(width) { '.' })
        }
        mineCoordinates = generateNDistinctCoordinates(mineCount, height, width)
        mineCoordinates.forEach { coord -> mineMap[coord.first][coord.second] = 'x' }
    }

    fun isMine(x: Int, y: Int): Boolean {
        validateCoordinate(x, y)
        return mineMap[x][y] == 'x'
    }

    private fun validateCoordinate(x: Int, y: Int) {
        if (x < 0 || x >= height || y < 0 || y >= width) {
            throw IllegalArgumentException("Coordinate out of bound!")
        }
    }
}