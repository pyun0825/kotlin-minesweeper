package domain

import dto.MineMapRequestDto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MineMapTest {
    @DisplayName("MineMap 생성 성공")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    @ParameterizedTest()
    fun generateMineMap_Success(mineCount: Int) {
        //given
        val mineMapRequestDto = MineMapRequestDto(3, 3, mineCount)
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { MineMap(mineMapRequestDto, randomMapGeneratingStrategy) }
    }

    @DisplayName("MineMap 생성 실패")
    @ValueSource(ints = [10, 11, 12, 13, 14])
    @ParameterizedTest()
    fun generateMineMap_Fail(mineCount: Int) {
        //given
        val mineMapRequestDto = MineMapRequestDto(3, 3, mineCount)
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        //when
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { MineMap(mineMapRequestDto, randomMapGeneratingStrategy) }
    }

    @DisplayName("getMaxRowNum이 입력한 Height - 1 와 동일한 수 반환")
    @Test
    fun getMaxRowNum() {
        //given
        val height = 3
        val mineMapRequestDto = MineMapRequestDto(3, height, 1)
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        //when
        val mineMap = MineMap(mineMapRequestDto, randomMapGeneratingStrategy)
        //then
        Assertions.assertThat(mineMap.getMaxRowNum()).isEqualTo(height-1)
    }

    @DisplayName("getMaxColNum이 입력한 Width - 1 와 동일한 수 반환")
    @Test
    fun getMaxColNum() {
        //given
        val width = 3
        val mineMapRequestDto = MineMapRequestDto(width, 3, 1)
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        //when
        val mineMap = MineMap(mineMapRequestDto, randomMapGeneratingStrategy)
        //then
        Assertions.assertThat(mineMap.getMaxColNum()).isEqualTo(width - 1)
    }

    @DisplayName("무조건 Mine인 칸에서 status MINE으로 검출")
    @Test
    fun getTileStatusInCoordinate() {
        //given
        val mineMapRequestDto = MineMapRequestDto(1, 1, 1)
        val randomMapGeneratingStrategy = RandomMapGeneratingStrategy()
        //when
        val mineMap = MineMap(mineMapRequestDto, randomMapGeneratingStrategy)
        //then
        Assertions.assertThat(mineMap.getTileStatusInCoordinate(Coordinate(0, 0))).isEqualTo(TileStatus.MINE)
    }
}