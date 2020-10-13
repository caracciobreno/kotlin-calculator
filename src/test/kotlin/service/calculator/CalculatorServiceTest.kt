package service.calculator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CalculatorServiceTest {

    @Test
    fun `calculate fails when there are no instructions`() {
        assertFailsWith(IllegalArgumentException::class) {
            CalculatorService().calculate(emptyList())
        }
    }

    @Test
    fun `calculate fails when the last instruction is not an apply`() {
        assertFailsWith(IllegalArgumentException::class) {
            CalculatorService().calculate(
                listOf(ArithmeticInstruction.Divide(10.0))
            )
        }
    }


    @Test
    fun `calculate fails when there are more than one apply instructions`() {
        assertFailsWith(IllegalArgumentException::class) {
            CalculatorService().calculate(
                listOf(
                    ArithmeticInstruction.Divide(10.0),
                    ApplyInstruction(10.0),
                    ArithmeticInstruction.Add(10.0),
                    ApplyInstruction(6.0),
                )
            )
        }
    }


    @Test
    fun `calculate succeeds given a list of instructions`() {
        assertEquals(
            30.0,
            CalculatorService().calculate(
                listOf(
                    ArithmeticInstruction.Add(10.0),
                    ArithmeticInstruction.Add(20.0),
                    ArithmeticInstruction.Subtract(5.0),
                    ApplyInstruction(5.0),
                )
            )
        )
    }
}