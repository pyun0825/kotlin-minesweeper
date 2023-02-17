package view

import domain.Coordinate
import domain.MineMap
import domain.TileStatus

object OutputView {
    private const val MINE_MAP_MESSAGE = "==========현재 지뢰밭 상태=========="
    private const val GAME_OVER_MESSAGE = "지뢰를 터트리셨습니다!! Game Over..."
    private const val GAME_WIN_MESSAGE = "모든 타일을 다 여셨습니다!! Congratulations"

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
        if (mineMap.getTileStatusInCoordinate(coordinate) == TileStatus.OPEN) {
            print(mineMap.getNumberOfMinesAroundCoordinate(coordinate).toString() + " ")
            return
        }
        print(". ")
    }

    fun printGameOver() {
        println(GAME_OVER_MESSAGE)
    }

    fun printGameWin() {
        println(GAME_WIN_MESSAGE)
    }
}