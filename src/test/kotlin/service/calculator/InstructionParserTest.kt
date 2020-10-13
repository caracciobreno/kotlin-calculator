package service.calculator

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class InstructionParserTest {

    @Test
    fun `parseInstruction fails when the format is not 'instruction number'`() {

        assertFailsWith(IllegalArgumentException::class) {
            "".parseInstruction()
        }

        assertFailsWith(IllegalArgumentException::class) {
            applyInstruction.parseInstruction()
        }

        assertFailsWith(IllegalArgumentException::class) {
            "$addInstruction ".parseInstruction()
        }
    }

    @Test
    fun `parseInstruction fails when the second argument is not a number`() {

        assertFailsWith(IllegalArgumentException::class) {
            "$addInstruction abcd".parseInstruction()
        }

        assertFailsWith(IllegalArgumentException::class) {
            "$subtractInstruction $$$".parseInstruction()
        }

        assertFailsWith(IllegalArgumentException::class) {
            "$applyInstruction _".parseInstruction()
        }
    }

    @Test
    fun `parseInstruction fails when an invalid instruction is provided`() {

        assertFailsWith(IllegalArgumentException::class) {
            "sqrt 10".parseInstruction()
        }

        assertFailsWith(IllegalArgumentException::class) {
            "pow 2".parseInstruction()
        }

        assertFailsWith(IllegalArgumentException::class) {
            "reset 5".parseInstruction()
        }
    }

    @Test
    fun `parseInstruction parses the proper given instruction`() {
        assertTrue {
            val value = Random.nextDouble()
            val instruction = "$addInstruction $value".parseInstruction()
            instruction is ArithmeticInstruction.Add && instruction.value == value
        }

        assertTrue("subtract instruction wasn't subtract") {
            val value = Random.nextDouble()
            val instruction = "$subtractInstruction $value".parseInstruction()
            instruction is ArithmeticInstruction.Subtract && instruction.value == value
        }

        assertTrue {
            val value = Random.nextDouble()
            val instruction = "$multiplyInstruction $value".parseInstruction()
            instruction is ArithmeticInstruction.Multiply && instruction.value == value
        }

        assertTrue {
            val value = Random.nextDouble()
            val instruction = "$divideInstruction $value".parseInstruction()
            instruction is ArithmeticInstruction.Divide && instruction.value == value
        }

        assertTrue {
            val value = Random.nextDouble()
            val instruction = "$applyInstruction $value".parseInstruction()
            instruction is ApplyInstruction && instruction.value == value
        }
    }

    @Test
    fun `parseInstructions returns an empty list if the current list is empty`() {

        assertTrue {
            emptyList<String>().parseInstructions().isEmpty()
        }
    }

    @Test
    fun `parseInstructions works`() {
        val value = Random.nextDouble()

        assertTrue {
            val instructions = listOf("$subtractInstruction $value").parseInstructions()
            instructions.size == 1 && instructions.first().value == value
        }
    }
}