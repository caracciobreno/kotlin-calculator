package service.calculator

import java.util.*

// CalculatorService provides features to calculate results given instructions
class CalculatorService {

    // Calculates a number given the provided instructions. Instructions must contain
    fun calculate(instructions: List<Instruction>): Double {

        require(instructions.isNotEmpty()) {
            "no instructions provided"
        }

        val applyInstruction: ApplyInstruction = instructions.last() as? ApplyInstruction
            ?: throw IllegalArgumentException("the last Instruction should always be an '$applyInstruction}' instruction")

        val arithmeticInstructions = instructions.filterIsInstance<ArithmeticInstruction>()

        val applyInstructions = instructions.filterIsInstance<ApplyInstruction>()
        require(applyInstructions.size == 1) {
            "there should be only one '${service.calculator.applyInstruction}}' instruction"
        }

        // initiates the calculator applying the instruction
        val calculator = applyInstruction.apply()

        return calculator.executeInstructions(LinkedList(arithmeticInstructions))
    }
}