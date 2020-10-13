package service.calculator

// Instruction defines an Instruction accepted by the program, could be an Arithmetic Instruction or an Apply
// instruction. All instructions must come with a number.
sealed class Instruction(val value: Double)

// Instruction used to start the calculator with a given number
class ApplyInstruction(value: Double) : Instruction(value) {

    // Applies the instruction, creating a calculator with the value provided
    internal fun apply(): Calculator {
        return Calculator(value)
    }
}

// Arithmetic instructions, such as Add, Subtract etc.
sealed class ArithmeticInstruction(value: Double) : Instruction(value) {

    class Add(value: Double) : ArithmeticInstruction(value) {
        override fun execute(target: Double): Double {
            return target + value
        }
    }

    class Subtract(value: Double) : ArithmeticInstruction(value) {
        override fun execute(target: Double): Double {
            return target - value
        }
    }

    class Multiply(value: Double) : ArithmeticInstruction(value) {
        override fun execute(target: Double): Double {
            return target * value
        }
    }

    class Divide(value: Double) : ArithmeticInstruction(value) {
        init {
            require(value != 0.0) {
                "value can't be zero on division"
            }
        }

        override fun execute(target: Double): Double {
            return target / value
        }
    }

    // Executes the instruction on target using the given value, returning the result of the operation
    abstract fun execute(target: Double): Double
}
