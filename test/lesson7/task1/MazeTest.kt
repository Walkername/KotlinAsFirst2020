package lesson7.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MazeTest {

    @Test
    fun maze() {
        Assertions.assertEquals(
            Pair(9, 35),
            maze("input/maze_inBorder.txt", "rllluddurld")  // на границе
        )
        Assertions.assertEquals(
            Pair(10, 37),
            maze("input/maze_inBorder.txt", "drddrrrrddddrr")  // на границе
        )
        Assertions.assertEquals(
            Pair(-1, -1),
            maze("input/maze_notRobot.txt", "drddrrrrddddrr") // нет робота
        )
        Assertions.assertEquals(
            Pair(6, 24),
            maze("input/maze_2.txt", "rllluddurld") // не в первой строке
        )
        Assertions.assertEquals(
            Pair(5, 27),
            maze("input/maze_2.txt", "drddrrrrddddrr") // не в первой строке
        )
        Assertions.assertEquals(
            Pair(5, 27),
            maze("input/maze_2.txt", "rr") // не в первой строке
        )
        Assertions.assertEquals(
            Pair(-1, -1),
            maze("input/maze_moreRobots.txt", "drddrrrrddddrr") // больше одного робота
        )
        Assertions.assertEquals(
            Pair(8, 9),
            maze("input/maze_3.txt", "drddrrrrddddrr") // в начале строки
        )
        Assertions.assertEquals(
            Pair(2, 2),
            maze("input/maze_3.txt", "rllluddurld") // в начале строки
        )
    }
}
