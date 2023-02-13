package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WidthTest {
    @DisplayName("Width 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun widthTest_success(width: Int) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { Width(width) }
    }

    @DisplayName("Width 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [-10, -5, -3, -1, 0])
    fun widthTest_fail(width: Int) {
        //given
        //when
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { Width(width) }
    }

    @DisplayName("isColBetween 결과가 True")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5])
    fun isColBetween_success(col: Int) {
        //given
        val coordinate = Coordinate(1, col)
        val width = Width(6)
        //when
        //then
        Assertions.assertThat(width.isColBetween(coordinate)).isTrue
    }

    @DisplayName("isColBetween 결과가 False")
    @ParameterizedTest
    @ValueSource(ints = [6, 7, 8, 9, 10])
    fun isColBetween_fail(col: Int) {
        //given
        val coordinate = Coordinate(1, col)
        val width = Width(6)
        //when
        //then
        Assertions.assertThat(width.isColBetween(coordinate)).isFalse
    }
}