package step2

fun main() {
    StringCalculator.parsing(
        stringExpression = readLine(),
        result = { expressionPair ->
            println(StringCalculator.evaluate(expressionPair.first, expressionPair.second))
        }
    )
}
