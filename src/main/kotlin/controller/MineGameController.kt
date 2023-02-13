package controller

import domain.MineMap
import domain.RandomMapGeneratingStrategy
import view.InputView
import view.OutputView

class MineGameController {
    private lateinit var mineMap: MineMap

    fun run() {
        val mineMapRequestDto = InputView.getInitialInput()
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        mineMap = MineMap(mineMapRequestDto, randomMapGeneratingStrategy)
        OutputView.printMineMap(mineMap)
    }
}