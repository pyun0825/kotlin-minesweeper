package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MineCountTest {
    @DisplayName("MineCount 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun heightTest_success(mineCount: Int) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { MineCount(mineCount) }
    }

    @DisplayName("MineCount 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [-10, -5, -3, -1, 0])
    fun heightTest_fail(mineCount: Int) {
        //given
        //when
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { MineCount(mineCount) }
    }

    @DisplayName("isLessThan 결과 True")
    @ParameterizedTest
    @ValueSource(ints = [10, 11, 7, 9])
    fun isLessThan_True(num: Int) {
        //given
        val mineCount = MineCount(6)
        //when
        //then
        Assertions.assertThat(mineCount.isLessThan(num)).isTrue
    }

    @DisplayName("isLessThan 결과 False")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 4, 5, 6])
    fun isLessThan_False(num: Int) {
        //given
        val mineCount = MineCount(6)
        //when
        //then
        Assertions.assertThat(mineCount.isLessThan(num)).isFalse
    }

    @DisplayName("isBiggerThan 결과 True")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun isBiggerThan_True(num: Int) {
        //given
        val mineCount = MineCount(6)
        //when
        //then
        Assertions.assertThat(mineCount.isBiggerThan(num)).isTrue
    }

    @DisplayName("isBiggerThan 결과 False")
    @ParameterizedTest
    @ValueSource(ints = [6, 7, 8, 9])
    fun isBiggerThan_False(num: Int) {
        //given
        val mineCount = MineCount(6)
        //when
        //then
        Assertions.assertThat(mineCount.isBiggerThan(num)).isFalse
    }
}