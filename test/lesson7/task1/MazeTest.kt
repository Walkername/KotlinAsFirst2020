package lesson7.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MazeTest {

    @Test
    fun maze() {
        Assertions.assertEquals(
            Pair(2, 2),
            maze("input/maze.txt", "rllluddurld") // r - right, l - left, u - up, d - down
        )
        Assertions.assertEquals(
            Pair(8, 9),
            maze("input/maze.txt", "drddrrrrddddrr") // r - right, l - left, u - up, d - down
        )
    }
}