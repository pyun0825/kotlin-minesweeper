package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class HeightTest {
    @DisplayName("Height 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun heightTest_success(height: Int) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { Height(height) }
    }

    @DisplayName("Height 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [-10, -5, -3, -1, 0])
    fun heightTest_fail(height: Int) {
        //given
        //when
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { Height(height) }
    }

    @DisplayName("isRowBetween 결과가 True")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5])
    fun isRowBetween_success(row: Int) {
        //given
        val coordinate = Coordinate(row, 1)
        val height = Height(6)
        //when
        //then
        Assertions.assertThat(height.isRowBetween(coordinate)).isTrue
    }

    @DisplayName("isRowBetween 결과가 False")
    @ParameterizedTest
    @ValueSource(ints = [6, 7, 8, 9, 10])
    fun isRowBetween_fail(row: Int) {
        //given
        val coordinate = Coordinate(row, 1)
        val height = Height(6)
        //when
        //then
        Assertions.assertThat(height.isRowBetween(coordinate)).isFalse
    }
}