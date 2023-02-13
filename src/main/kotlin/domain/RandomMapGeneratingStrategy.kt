package domain

import kotlin.random.Random

class RandomMapGeneratingStrategy : MapGeneratingStrategy {
    override fun generateMap(width: Width, height: Height, mineCount: MineCount): ArrayList<List<Tile>> {
        val mineMap = ArrayList<List<Tile>>()
        (0 until height.height).map {
            mineMap.add(List(width.width) { Tile(TileStatus.NORMAL) })
        }
        generateMine(width, height, mineCount).forEach {
            mineMap[it.row][it.col].changeStatus(TileStatus.MINE)
        }
        return mineMap
    }

    private fun generateMine(width: Width, height: Height, mineCount: MineCount): Set<Coordinate> {
        val coords = mutableSetOf<Coordinate>()
        while (mineCount.isBiggerThan(coords.size)) {
            val row = Random.nextInt(height.height)
            val col = Random.nextInt(width.width)
            coords.add(Coordinate(row, col))
        }
        return coords
    }
}