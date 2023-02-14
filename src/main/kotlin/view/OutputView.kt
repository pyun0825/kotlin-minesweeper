package view

import domain.Coordinate
import domain.MineMap
import domain.TileStatus

object OutputView {
    private const val MINE_MAP_MESSAGE = "==========현재 지뢰밭 상태=========="

    fun printMineMap(mineMap: MineMap) {
        println(MINE_MAP_MESSAGE)
        for (rowNum in 0 .. mineMap.getMaxRowNum()) {
            printMineMapRow(mineMap, rowNum)
            println()
        }
    }

    private fun printMineMapRow(mineMap: MineMap, rowNum: Int) {
        for (colNum in 0 .. mineMap.getMaxColNum()) {
            printMineMapTile(mineMap, Coordinate(rowNum, colNum))
        }
    }

    private fun printMineMapTile(mineMap: MineMap, coordinate: Coordinate) {
        if (mineMap.getTileStatusInCoordinate(coordinate) == TileStatus.NORMAL) {
            print(mineMap.getNumberOfMinesAroundCoordinate(coordinate).toString() + " ")
            return
        }
        print(mineMap.getTileStatusInCoordinate(coordinate).displayChar + " ")
    }
}