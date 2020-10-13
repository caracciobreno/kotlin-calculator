package service.calculator

import java.util.*
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun `calculator executes the instructions properly`() {

        val initialValue = Random.nextDouble()
        val calculator = Calculator(initialValue)

        assertEquals(
            initialValue,
            calculator.executeInstructions(LinkedList(emptyList())),
            "when the instructions are empty the value should be kept"
        )

        val addValue = Random.nextDouble()
        val subtractValue = Random.nextDouble()
        val multiplyValue = Random.nextDouble()
        val divideValue = Random.nextDouble(0.1, Double.MAX_VALUE)

        val instructions = listOf(
            ArithmeticInstruction.Add(addValue),
            ArithmeticInstruction.Subtract(subtractValue),
            ArithmeticInstruction.Multiply(multiplyValue),
            ArithmeticInstruction.Divide(divideValue),
        )

        val expectedResult = calculator.currentValue
            .let { it + addValue }
            .let { it - subtractValue }
            .let { it * multiplyValue }
            .let { it / divideValue }

        assertEquals(
            expectedResult,
            calculator.executeInstructions(LinkedList(instructions)),
            "invalid state of the calculator"
        )
    }
}