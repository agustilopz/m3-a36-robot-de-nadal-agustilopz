package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.example.models.Robot

/**
 * Funció que genera un taulell personalitzat per fer Unit Testing
 * @author agustí.lópez
 * @since 02/01/2025
 * @return Taulell per fer els tests
 */
fun taulellTest(): Array<Array<Casella>> {
    var taulellTest: Array<Array<Casella>>
    taulellTest = Array(20) { Array(20) { Casella.PARET } }
    taulellTest[16][1] = Casella.ROBOT


    var numRoques = 10
    // Creem una llista de posicions de cel·les (índexs fila-columna)
    val posicionsObstacles = mutableListOf<Pair<Int, Int>>()
    posicionsObstacles.add(Pair(14, 0))
    posicionsObstacles.add(Pair(18, 1))
    posicionsObstacles.add(Pair(10, 1))
    posicionsObstacles.add(Pair(18, 2))
    posicionsObstacles.add(Pair(13, 2))
    posicionsObstacles.add(Pair(19, 3))
    posicionsObstacles.add(Pair(15, 4))
    posicionsObstacles.add(Pair(16, 6))
    posicionsObstacles.add(Pair(16, 7))
    posicionsObstacles.add(Pair(17, 15))
    for (i in taulellTest.indices) {
        for (j in taulellTest[i].indices) {
            // Descartem la posició inicial del robot
            if (i != 16 || j != 1) {
                posicionsObstacles.add(Pair(i, j))
            }
        }
    }

    for (i in 1..numRoques) {
        val (fila, columna) = posicionsObstacles[i]
        taulellTest[fila][columna] = Casella.ROCA
    }

    return taulellTest

    /**
     *                              ----- REFERÈNCIA TAULELL TEST ----
     *         00  01  02   03  04  05  06  07  08   09  10  11  12   13  14  15  16   17  18  19  [X] j
     * 00 (19) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 01 (18) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 02 (17) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 03 (16) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 04 (15) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 05 (14) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 06 (13) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 07 (12) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 08 (11) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 09 (10) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 10 (09) 🧱  🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 11 (08) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 12 (07) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 13 (06) 🧱  🧱  🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 14 (05) 🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 15 (04) 🧱  🧱  🧱  🧱  🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 16 (03) 🧱  🤖  🧱  🧱  🧱  🧱  🚧  🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 17 (02) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🚧  🧱  🧱  🧱  🧱
     * 18 (01) 🧱  🚧  🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 19 (00) 🧱  🧱  🧱  🚧  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * [Y]
     * i
     *
     */
}


class FunctionsKtTest {


    @Test
    fun checkCoordenadesRobotY() {
        var i = 19
        val expected = 0
        val notExpected = 19
        assertEquals(coordenadesRobotY(i), expected)
        assertNotEquals(coordenadesRobotY(i), notExpected)
    }


    // FUNCIÓ DALT
    @Test
    fun daltMouRobotCorrectament() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 2)

        dalt(taulell, robotTest)
        val expected = Casella.ROBOT

        assertEquals(expected, taulell[14][1], "El robot hauria d'estar a la nova posició (14, 1).")
    }

    @Test
    fun daltGameOverCheck() {
        val taulell = taulellTest()
        var robotTest = Robot(velocitat = 4)

        val noGameOver = dalt(taulell, robotTest)

        assertFalse(noGameOver, "El joc no s'hauria d'haber acabat al moure el robot cap a dalt.")

        val taulell2 = taulellTest()
        taulell2[11][1] = Casella.DINAMITA
        robotTest.velocitat = 5
        val gameOver = dalt(taulell2, robotTest)
        assertTrue(gameOver, "El joc s'hauria d'haber acabat al moure el robot cap a dalt (dinamita).")
    }

    @Test
    fun daltDeixaRastreDinamita() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 2)

        dalt(taulell, robotTest)

        assertEquals(Casella.DINAMITA, taulell[15][1], "El robot hauria d'haver deixat dinamita a les pos. prèvies.")
        assertEquals(Casella.DINAMITA, taulell[16][1], "El robot hauria d'haver deixat dinamita a les pos. prèvies.")
        assertNotEquals(Casella.DINAMITA, taulell[17][1], "El robot no hauria d'haver deixat dinamita a la posició")
        assertNotEquals(Casella.DINAMITA, taulell[13][1], "El robot no hauria d'haver deixat dinamita a la posició.")

    }

    @Test
    fun daltEsParaAmbObstacle() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 8)

        dalt(taulell, robotTest)

        assertEquals(Casella.ROBOT, taulell[11][1], "El robot s'hauria d'haber aturat just abans de l'obstacle.")
        assertNotEquals(Casella.ROBOT, taulell[8][1], "El robot s'hauria d'haber aturat just abans de l'obstacle.")
    }


    // FUNCIÓ BAIX
    @Test
    fun baixMouRobotCorrectament() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 3)

        baix(taulell, robotTest)
        val expected = Casella.ROBOT

        assertEquals(expected, taulell[17][1], "El robot hauria d'estar a la nova posició (17, 1).")
    }

    @Test
    fun baixGameOverCheck() {
        val taulell = taulellTest()
        var robotTest = Robot(velocitat = 1)

        val noGameOver = baix(taulell, robotTest)

        assertFalse(noGameOver, "El joc no s'hauria d'haber acabat al moure el robot cap a baix.")

        val taulell2 = taulellTest()
        taulell2[17][1] = Casella.DINAMITA
        robotTest.velocitat = 1
        val gameOver = baix(taulell2, robotTest)
        assertTrue(gameOver, "El joc s'hauria d'haber acabat al moure el robot cap a baix (dinamita).")
    }

    @Test
    fun baixDeixaRastreDinamita() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 1)

        baix(taulell, robotTest)

        assertEquals(Casella.DINAMITA, taulell[16][1], "El robot hauria d'haver deixat dinamita a les pos. prèvies.")
        assertNotEquals(Casella.DINAMITA, taulell[17][1], "El robot no hauria d'haver deixat dinamita a la posició")
    }

    // FUNCIÓ DRETA
    @Test
    fun dretaMouRobotCorrectament() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 5)

        dreta(taulell, robotTest)
        val expected = Casella.ROBOT

        assertEquals(expected, taulell[16][5], "El robot hauria d'estar a la nova posició (16, 5).")
    }

    @Test
    fun dretaGameOverCheck() {
        val taulell = taulellTest()
        var robotTest = Robot(velocitat = 4)

        val noGameOver = dreta(taulell, robotTest)

        assertFalse(noGameOver, "El joc no s'hauria d'haber acabat al moure el robot cap a la dreta.")

        val taulell2 = taulellTest()
        taulell2[16][4] = Casella.DINAMITA
        robotTest.velocitat = 3
        val gameOver = dreta(taulell2, robotTest)
        assertTrue(gameOver, "El joc s'hauria d'haber acabat al moure el robot cap a la dreta (dinamita).")
    }

    @Test
    fun dretaDeixaRastreDinamita() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 4)

        dreta(taulell, robotTest)

        assertEquals(Casella.DINAMITA, taulell[16][1], "El robot hauria d'haver deixat dinamita a les pos. prèvies.")
        assertEquals(Casella.DINAMITA, taulell[16][4], "El robot hauria d'haver deixat dinamita a les pos. prèvies.")
        assertNotEquals(Casella.DINAMITA, taulell[16][5], "El robot no hauria d'haver deixat dinamita a la posició")
    }

    // FUNCIÓ ESQUERRA
    @Test
    fun esquerraMouRobotCorrectament() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 3)

        esquerra(taulell, robotTest)
        val expected = Casella.ROBOT

        assertEquals(expected, taulell[16][0], "El robot hauria d'estar a la nova posició (16, 0).")
    }

    @Test
    fun esquerraGameOverCheck() {
        val taulell = taulellTest()
        var robotTest = Robot(velocitat = 5)

        val noGameOver = esquerra(taulell, robotTest)

        assertFalse(noGameOver, "El joc no s'hauria d'haber acabat al moure el robot cap a l'esquerra.")

        val taulell2 = taulellTest()
        taulell2[16][0] = Casella.DINAMITA
        robotTest.velocitat = 1
        val gameOver = esquerra(taulell2, robotTest)
        assertTrue(gameOver, "El joc s'hauria d'haber acabat al moure el robot cap a l'esquerra (dinamita).")
    }

    @Test
    fun esquerraDeixaRastreDinamita() {
        val taulell = taulellTest()
        val robotTest = Robot(velocitat = 1)

        esquerra(taulell, robotTest)

        assertEquals(Casella.DINAMITA, taulell[16][1], "El robot hauria d'haver deixat dinamita a les pos. prèvies.")
        assertNotEquals(Casella.DINAMITA, taulell[16][0], "El robot no hauria d'haver deixat dinamita a la posició")
    }

}