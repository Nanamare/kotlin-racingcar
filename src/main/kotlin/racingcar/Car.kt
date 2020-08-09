package racingcar

import racingcar.strategy.Strategy

class Car(position: List<Int>, private val strategy: Strategy) {

    val position
        get() = _position
    private val _position = position.toMutableList()

    fun forward() = _position.add(_position.last() + 1)
    fun wait() = _position.add(_position.last())

    fun run() {
        when (strategy.move(strategy.generateNumber())) {
            true -> forward()
            false -> wait()
        }
    }
}
