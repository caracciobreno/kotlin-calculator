import libs.file.FileUtils
import service.calculator.CalculatorService
import service.calculator.parseInstructions

fun main(args: Array<String>) {

    val fileName = args.getOrNull(0)
        ?: throw IllegalArgumentException("please provide the full file path")

    val stringInstructions = FileUtils.readFileAsLinesOrNull(fileName)
        ?: throw IllegalArgumentException("failed to read file '$fileName'")

    val calculatorService = CalculatorService()
    println(calculatorService.calculate(stringInstructions.parseInstructions()))
}