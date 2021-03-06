package service.calculator


const val addInstruction = "add"
const val subtractInstruction = "subtract"
const val multiplyInstruction = "multiply"
const val divideInstruction = "divide"
const val applyInstruction = "apply"

// Parses the current string in order to create an Instruction. Must be in the format "instruction <NUMBER>", e.g:
// "add 10".
fun String.parseInstruction(): Instruction {
    val splitLine = this.split(" ")

    require(splitLine.size == 2) {
        "invalid line '$this', should contain an instruction and a value, e.g.: 'add 10'"
    }

    val instruction = splitLine[0]
    val value = splitLine[1].toDoubleOrNull() ?: throw IllegalArgumentException("the value should be a number")

    return when (instruction) {
        addInstruction -> ArithmeticInstruction.Add(value)
        subtractInstruction -> ArithmeticInstruction.Subtract(value)
        multiplyInstruction -> ArithmeticInstruction.Multiply(value)
        divideInstruction -> ArithmeticInstruction.Divide(value)
        applyInstruction -> ApplyInstruction(value)
        else -> throw IllegalArgumentException("invalid instruction $instruction")
    }
}

// Maps the list to a list of Instructions
fun List<String>.parseInstructions(): List<Instruction> {
    return this.map(String::parseInstruction)
}