val exampleOne = mapOf(
    "1abc2" to 12,
    "pqr3stu8vwx" to 38,
    "a1b2c3d4e5f" to 15,
    "treb7uchet" to 77
)

fun firstLastDigit(line: String): Int {
    val digits = line.filter { it.isDigit() }
    val combination = "${digits.first()}${digits.last()}"
    return combination.toInt()
}

// ====================================================================

val exampleTwo = mapOf(
    "two1nine" to 29,
    "eightwothree" to 83,
    "abcone2threexyz" to 13,
    "xtwone3four" to 24,
    "4nineeightseven2" to 42,
    "zoneight234" to 14,
    "7pqrstsixteen" to 76,
    "3one8ncctmbsixeighttwonegb" to 31 // the "one" at the end is not matched with regex
)

val numbersMap = mapOf(
    "one" to 1, "two" to 2, "three" to 3,
    "four" to 4, "five" to 5, "six" to 6,
    "seven" to 7, "eight" to 8, "nine" to 9
)

fun String.toDigit() = this.toIntOrNull() ?: numbersMap.getValue(this)

fun firstLastDigitWithText(line: String): Int {
    val spelledOutAndDigits = numbersMap.keys + numbersMap.values.map { it.toString() }

    fun findAnyWith(find: (CharSequence, Collection<String>) -> Pair<Int, String>?) =
        find(line, spelledOutAndDigits)?.second ?: ""

    val firstText = findAnyWith(CharSequence::findAnyOf)
    val lastText = findAnyWith(CharSequence::findLastAnyOf)

    val combination = "${firstText.toDigit()}${lastText.toDigit()}"
    return combination.toInt()
}

fun main() {
    fun partOne(lines: List<String>) = lines.sumOf { firstLastDigit(it) }
    fun partTwo(lines: List<String>) = lines.sumOf { firstLastDigitWithText(it) }

    val input = readInput("Day01")
    partOne(input).println()
    partTwo(input).println()
    //firstLastDigitWithText("3one8ncctmbsixeighttwonegb").println()
}
