package dto

import domain.Height
import domain.MineCount
import domain.Width

data class MineMapRequestDto(
    val width: Width,
    val height: Height,
    val mineCount: MineCount
) {
    constructor (width: Int, height: Int, mineCount: Int) : this(
        Width(width), Height(height), MineCount(mineCount)
    )
}
