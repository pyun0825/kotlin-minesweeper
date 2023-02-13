package view

import domain.MineMap

object OutputView {
    private const val MINE_MAP_MESSAGE = "==========현재 지뢰밭 상태=========="

    fun printMineMap(mineMap: MineMap) {
        println(MINE_MAP_MESSAGE)
        for (x in 0 until mineMap.height) {
            printMineMapRow(mineMap, x)
            println()
        }
    }

    private fun printMineMapRow(mineMap: MineMap, rowNum: Int) {
        for (y in 0 until mineMap.width) {
            if (mineMap.isMine(rowNum, y)) print("x ") else print(". ")
        }
    }
}