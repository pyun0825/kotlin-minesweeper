package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomMapGeneratingStrategyTest {

    @Test
    fun generateMap() {
        //given
        val width = Width(3)
        val height = Height(3)
        val mineCount = MineCount(2)
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        //when
        val generatedMap = randomMapGeneratingStrategy.generateMap(width, height, mineCount)
        //then
        Assertions.assertThat(generatedMap.flatten().count { it.status == TileStatus.MINE }).isEqualTo(2)
    }
}