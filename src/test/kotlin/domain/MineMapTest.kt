package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MineMapTest {
    @DisplayName("N개의 다른 좌표 생성 테스트")
    @Test
    fun generateNDistinctCoordinatesTest() {
        //given
        val n = 3
        val width = 5
        val height = 5
        //when
        val coordinates = generateNDistinctCoordinates(n, width, height)
        //then
        Assertions.assertThat(coordinates).hasSize(n)
    }

    @DisplayName("지뢰 있는 좌표에서 지뢰 검출")
    @Test
    fun isMineTrue() {
        //given
        val width = 1
        val height = 1
        val mineCount = 1
        //when
        val mineMap = MineMap(width, height, mineCount)
        //then
        Assertions.assertThat(mineMap.isMine(0, 0)).isTrue
    }

    @DisplayName("지뢰 없는 좌표에서 지뢰 검출 실패")
    @Test
    fun isMineFalse() {
        //given
        val width = 1
        val height = 1
        val mineCount = 0
        //when
        val mineMap = MineMap(width, height, mineCount)
        //then
        Assertions.assertThat(mineMap.isMine(0, 0)).isFalse
    }

    @DisplayName("좌표 범위 벗어난 곳에 지뢰 검출 시 예외 발생")
    @Test
    fun validateTest() {
        //given
        val width = 1
        val height = 1
        val mineCount = 0
        //when
        val mineMap = MineMap(width, height, mineCount)
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { mineMap.isMine(2, 2) }
    }
}