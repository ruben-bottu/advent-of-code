data class Cube(val amount: Int, val color: String)

val colorMax = mapOf(
    "red" to 12,
    "green" to 13,
    "blue" to 14
)

fun toNestedCubes(line: String) =
    line.split(":", ";")
        .drop(1)
        .map {
            it.split(",")
                .map { draw -> draw.trimStart() }
                .map { draw -> draw.split(" ") }
                .map { (amount, color) -> Cube(amount.toInt(), color) }
        }

fun isPossible(line: String) =
    toNestedCubes(line)
        .all {
            it.all { (amount, color) -> amount <= colorMax.getValue(color) }
        }

// ====================================================================

fun toCubes(line: String) = line
    .split(":", ";", ",")
    .drop(1) // drop "Game X"
    .map { it.trimStart() }
    .map { it.split(" ") }
    .map { (amount, color) -> Cube(amount.toInt(), color) }

val colorToZero = mapOf(
    "red" to 0,
    "green" to 0,
    "blue" to 0
)

fun maxAmountOfColors(cubes: List<Cube>) =
    cubes.fold(colorToZero) { acc, (amount, color) ->
        if (amount > acc.getValue(color)) acc + Pair(color, amount) else acc
    }

fun power(colorMap: Map<String, Int>) =
    colorMap.values.reduce { acc, amount -> acc * amount }

fun main() {
    fun partOne(input: List<String>) =
        input.foldIndexed(0) { index, acc, current ->
            if (isPossible(current)) acc + (index + 1) else acc
        }

    fun partTwo(input: List<String>) = input
        .map { toCubes(it) }
        .map { maxAmountOfColors(it) }
        .sumOf { power(it) }


    val input = readInput("Day02")
    //isPossible(input.first())
    //toCubes(input.first()).println()
    partOne(input).println()
    partTwo(input).println()
    //maxAmountOfColors(input[2]).println()
}