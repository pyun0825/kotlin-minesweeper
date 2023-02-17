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
        while (true) {
            OutputView.printMineMap(mineMap)
            if (mineMap.isNormalAllOpened()) {
                OutputView.printGameWin()
                return
            }
            val targetCoordinate = InputView.getTargetCoordinate()
            if (mineMap.isMine(targetCoordinate)) {
                OutputView.printGameOver()
                return
            }
            mineMap.openCoordinate(targetCoordinate)
            if (mineMap.getNumberOfMinesAroundCoordinate(targetCoordinate) == 0) {
                mineMap.openAroundCoordinate(targetCoordinate)
            }
        }
    }
}