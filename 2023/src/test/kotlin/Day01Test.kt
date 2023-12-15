import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun partOneTest() {
        exampleOne.forEach {
                (line, value) -> assertEquals(value, firstLastDigit(line))
        }
    }

    @Test
    fun partTwoTest() {
        exampleTwo.forEach {
                (line, value) -> assertEquals(value, firstLastDigitWithText(line))
        }
    }
}


