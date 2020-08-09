package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomStrategy

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [1000, 113, 989, 119, 0])
    fun `Car forward test`(repetition: Int) {
        val car = Car(mutableListOf(0), RandomStrategy())
        repeat(repetition) {
            car.forward()
        }
        assertThat(0..repetition).allSatisfy {
            assertThat(car.position[it]).isEqualTo(it)
            assertThat(car.position.size).isEqualTo(repetition + 1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 999, 10, 2020, 0])
    fun `Car wait test`(repetition: Int) {
        val car = Car(mutableListOf(0), RandomStrategy())
        repeat(repetition) {
            car.wait()
        }
        repeat(repetition) {
            assertThat(car.position[it]).isEqualTo(0)
        }
        assertThat(car.position.size).isEqualTo(repetition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 999, 10, 2020, 1919, 99999])
    fun `Car run test`(repetition: Int) {
        val car = Car(mutableListOf(0), MovingStrategy())
        repeat(repetition) {
            car.run()
        }
        repeat(repetition) {
            assertThat(car.position[it]).isEqualTo(it)
        }
        assertThat(car.position.size).isEqualTo(repetition + 1)
    }
}
