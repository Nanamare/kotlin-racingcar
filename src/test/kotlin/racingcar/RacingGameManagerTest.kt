package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.strategy.RandomStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView
import java.util.function.Consumer
import java.util.function.Supplier

class RacingGameManagerTest {

    private val inputView = InputView.Builder()
        .player(Consumer(::println), Supplier { "3" })
        .repetition(Consumer(::println), Supplier { "5" })
        .build()

    private val resultView = ResultView()

    @Test
    fun `RacingGameManager test`() {

        val racingGameManager = RacingGameManager.builder(inputView, resultView)
            .strategy(RandomStrategy())
            .build()

        assertThat(racingGameManager).isNotNull

        racingGameManager.racing(Consumer { racingGameManager.showRacingResult() })
    }
}
