package view

import domain.Coordinate
import domain.MineMap

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
            print(mineMap.getTileStatusInCoordinate(Coordinate(rowNum, colNum)).displayChar + " ")
        }
    }
}