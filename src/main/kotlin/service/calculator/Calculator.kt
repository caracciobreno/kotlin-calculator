package service.calculator

import java.util.*

// Calculator represents the state of a number that will mutate according to arithmetic instructions
internal data class Calculator(val currentValue: Double) {

    // Executes the given instructions on the current value of this calculator returning the result of the operations
    fun executeInstructions(instructions: Queue<ArithmeticInstruction>): Double {

        val instruction = instructions.poll() ?: return currentValue

        // recursively calls the execute instructions with a new calculator until there are no more instructions
        return this.copy(currentValue = instruction.execute(currentValue)).executeInstructions(instructions)
    }
}
