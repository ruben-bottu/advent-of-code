data class Cube(val amount: Int, val color: String)


fun parseLine(line: String): List<String> {
    val parts = line.split(":|;")
    return parts
}


fun main() {
    fun partOne(input: List<String>): Int {
        return 0
    }

    fun partTwo(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day02_test")
    parseLine(input[0]).println()
    //partOne(input).println()
    //partTwo(input).println()
}