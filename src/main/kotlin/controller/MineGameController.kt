package controller

import domain.MineMap
import view.InputView
import view.OutputView

class MineGameController {
    private lateinit var mineMap: MineMap

    fun run() {
        val mineMapRequestDto = InputView.getInitialInput()
        mineMap = MineMap(mineMapRequestDto)
        OutputView.printMineMap(mineMap)
    }
}