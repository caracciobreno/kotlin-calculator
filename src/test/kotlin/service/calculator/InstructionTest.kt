package service.calculator

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ApplyInstructionTest {

    @Test
    fun `apply instruction creates a valid calculator after being applied`() {

        val initialValue = Random.nextDouble()

        val calculator = ApplyInstruction(initialValue).apply()
        assertEquals(
            initialValue,
            calculator.currentValue,
            "the current value of the calculator should be the one provided on the apply instruction"
        )
    }
}

class ArithmeticInstructionTest {

    @Test
    fun `add instruction executes a mathematical add operation`() {
        val targetValue = Random.nextDouble()
        val instructionValue = Random.nextDouble()

        val expectedValue = targetValue + instructionValue

        assertEquals(
            expectedValue,
            ArithmeticInstruction.Add(instructionValue).execute(targetValue),
            "expected the operation of $targetValue + $instructionValue = $expectedValue"
        )
    }

    @Test
    fun `subtract instruction executes a mathematical subtract operation`() {
        val targetValue = Random.nextDouble()
        val instructionValue = Random.nextDouble()

        val expectedValue = targetValue - instructionValue

        assertEquals(
            expectedValue,
            ArithmeticInstruction.Subtract(instructionValue).execute(targetValue),
            "expected the operation of $targetValue - $instructionValue = $expectedValue"
        )

        assertEquals(
            -10.0,
            ArithmeticInstruction.Subtract(10.0).execute(0.0),
            "expected the subtract operation of 0 - 10 = -10"
        )
    }

    @Test
    fun `multiply instruction executes a mathematical multiply operation`() {
        val targetValue = Random.nextDouble()
        val instructionValue = Random.nextDouble()

        val expectedValue = targetValue * instructionValue

        assertEquals(
            expectedValue,
            ArithmeticInstruction.Multiply(instructionValue).execute(targetValue),
            "expected the operation of $targetValue * $instructionValue = $expectedValue"
        )
    }

    @Test
    fun `divide instruction executes a mathematical divide operation`() {
        val targetValue = Random.nextDouble()
        val instructionValue = Random.nextDouble(0.1, Double.MAX_VALUE)

        val expectedValue = targetValue / instructionValue

        assertEquals(
            expectedValue,
            ArithmeticInstruction.Divide(instructionValue).execute(targetValue),
            "expected the operation of $targetValue / $instructionValue = $expectedValue"
        )
    }

    @Test
    fun `divide fails when the value provided is 0`() {
        assertFailsWith(IllegalArgumentException::class) {
            ArithmeticInstruction.Divide(0.0).execute(10.0)
        }
    }
}