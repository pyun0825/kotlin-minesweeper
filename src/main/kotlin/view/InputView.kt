package view

import domain.Coordinate
import dto.MineMapRequestDto

object InputView {
    private const val GET_HEIGHT_MESSAGE = "높이를 입력하세요."
    private const val GET_WIDTH_MESSAGE = "너비를 입력하세요."
    private const val GET_MINE_COUNT = "지뢰는 몇 개인가요?"
    private const val GET_TARGET_COORD = "오픈할 좌표를 입력해 주세요 row, col ex) 5, 4"

    fun getInitialInput(): MineMapRequestDto {
        println(GET_WIDTH_MESSAGE)
        val width = readln().toInt()
        println(GET_HEIGHT_MESSAGE)
        val height = readln().toInt()
        println(GET_MINE_COUNT)
        val mineCount = readln().toInt()
        return MineMapRequestDto(width, height, mineCount)
    }

    fun getTargetCoordinate(): Coordinate {
        println(GET_TARGET_COORD)
        val rowColString = readln()
        return Coordinate(rowColString)
    }
}