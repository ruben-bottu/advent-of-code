data class Cube(val amount: Int, val color: String)

val colorMax = mapOf(
    "red" to 12,
    "green" to 13,
    "blue" to 14
)

fun toCubes(line: String) =
    line.split(":", ";")
        .drop(1)
        .map {
            it.split(",")
                .map { draw -> draw.trimStart() }
                .map { draw -> draw.split(" ") }
                .map { (amount, color) -> Cube(amount.toInt(), color) }
        }

fun isPossible(line: String) =
    toCubes(line).all {
            it.all { (amount, color) -> amount <= colorMax.getValue(color) }
        }

fun main() {
    fun partOne(input: List<String>) =
        input.foldIndexed(0) { index, acc, current ->
            if (isPossible(current)) acc + (index + 1) else acc
        }

    fun partTwo(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day02")
    //isPossible(input[0])
    partOne(input).println()
    //partTwo(input).println()
}