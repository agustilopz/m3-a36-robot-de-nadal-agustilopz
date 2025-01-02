package org.example

import org.example.models.Robot
import utils.*
import kotlin.random.Random

enum class Casella (val codiAscii:String) {
    PARET("\uD83E\uDDF1"), //🧱
    ROBOT("\uD83E\uDD16"), //🤖
    ROCA("\uD83D\uDEA7"), // 🪨 🚧
    DINAMITA("\uD83E\uDDE8") //🧨
}

/**
 * Aquesta funció serveix per generar la distribució inicial del taulell, amb obstacles distribuïts aleatòriament
 * @author agustí.lópez
 * @since 02/01/2025
 */
fun taulell():Array<Array<Casella>> {
    var taulell:Array<Array<Casella>>
    taulell=Array(20){Array(20){Casella.PARET}}
    taulell[19][0]=Casella.ROBOT

    // Distribuïm els obstacles de manera aleatòria
    var numRoques = Random.nextInt(30, 70 + 1)

    // Creem una llista de posicions de cel·les (índexs fila-columna)
    val posicions = mutableListOf<Pair<Int, Int>>()
    for (i in taulell.indices) {
        for (j in taulell[i].indices) {
            // Descartem la posició inicial del robot
            if (i != 19 || j != 0) {
                posicions.add(Pair(i, j))
            }
        }
    }

    // Barregem les posicions de manera aleatòria
    posicions.shuffle()

    for (i in 1..numRoques) {
        val (fila, columna) = posicions[i]
        taulell[fila][columna] = Casella.ROCA
    }

    return taulell

    /**
     *                              ----- REFERÈNCIA TAULELL ----
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
     * 10 (09) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 11 (08) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 12 (07) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 13 (06) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 14 (05) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 15 (04) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 16 (03) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 17 (02) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 18 (01) 🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * 19 (00) 🤖  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱  🧱
     * [Y]
     * i
     *
     * * LIMITS *
     * DALT:    array (col) 00-- / y 19++
     * BAIX:    array (col) 19++ / y 00--
     * DRETA:   array (fil) 19++ / x 19++
     * ESQUERRA: array (fil) 00-- / x 00--
     *
     */
}


/**
 * Aquesta funció serveix per mostrar el taulell del joc amb la distribució actual
 * @author agustí.lópez
 * @since 02/01/2025
 * @param taulell Taulell amb les posicions de cada element, tant el robot com els obstacles
 */
fun mostrarTaulell(taulell:Array<Array<Casella>>) {
    for (i in 0 until taulell.size) {
        for (j in 0 until taulell[i].size) {
            print("${taulell[i][j].codiAscii} ")
        }
        println()
    }

}

/**
 * Aquesta funció serveix per fer avançar el robot cap a dalt tenint en compte tots els paràmetres i obstacles en el camí.
 * @author agustí.lópez
 * @since 02/01/2025
 * @param taulell Taulell amb les posicions de cada element, tant el robot com els obstacles
 * @param robot Data class 'Robot' amb els paràmetres del robot (posició x,y i velocitat)
 * @return Boolean que indica si la partida ha acabat o encara esta en joc
 */
fun dalt(taulell: Array<Array<Casella>>, robot: Robot): Boolean {
    var finalTorn: Boolean = false
    var gameOver: Boolean = false
    var obstacleTrobat: Boolean = false
    for (i in 0 until taulell.size) {
        for (j in 0 until taulell[i].size) {
            if (!finalTorn) {
                if (taulell[i][j] == Casella.ROBOT) {
                    finalTorn = true
                    var novaPosicioY = i - robot.velocitat
                    val posicioActualY = i
                    if (novaPosicioY < 0) {
                        //Límit taulell
                        novaPosicioY = 0
                    }
                    var posicioFinalRobot: Int = novaPosicioY
                    // Mirem si hi ha algun obstacle en el camí
                    for (z in posicioActualY - 1 downTo novaPosicioY) {
                        if (!gameOver && !obstacleTrobat) {
                            if (taulell[z][j] == Casella.DINAMITA) {
                                gameOver = true
                                posicioFinalRobot = z + 1
                            }
                            if (taulell[z][j] == Casella.ROCA) {
                                obstacleTrobat = true
                                posicioFinalRobot =
                                    z + 1 //Si troba un obstacle, el robot es quedarà a la posició prèvia
                            }
                        }
                    }

                    taulell[posicioFinalRobot][j] = Casella.ROBOT
                    robot.y= coordenadesRobotY(posicioFinalRobot)
                    // Si el robot s'ha mogut, deixarem el rastre de dinamita
                    if (posicioFinalRobot < posicioActualY) {
                        for (rastre in posicioFinalRobot + 1..posicioActualY) {
                            taulell[rastre][j] = Casella.DINAMITA
                        }
                    }
                }
            }
        }
    }

    return gameOver
}


/**
 * Aquesta funció serveix per fer avançar el robot cap a baix tenint en compte tots els paràmetres i obstacles en el camí.
 * @author agustí.lópez
 * @since 02/01/2025
 * @param taulell Taulell amb les posicions de cada element, tant el robot com els obstacles
 * @param robot Data class 'Robot' amb els paràmetres del robot (posició x,y i velocitat)
 * @return Boolean que indica si la partida ha acabat o encara esta en joc
 */
fun baix(taulell: Array<Array<Casella>>, robot: Robot): Boolean {
    var finalTorn: Boolean = false
    var gameOver: Boolean = false
    var obstacleTrobat: Boolean = false
    for (i in 0 until taulell.size) {
        for (j in 0 until taulell[i].size) {
            if (!finalTorn) {
                if (taulell[i][j] == Casella.ROBOT) {
                    finalTorn = true
                    var novaPosicioY = i + robot.velocitat
                    val posicioActualY = i
                    if (novaPosicioY > 19) {
                        //Límit taulell
                        novaPosicioY = 19
                    }
                    var posicioFinalRobot: Int = novaPosicioY
                    // Mirem si hi ha algun obstacle en el camí
                    for (z in posicioActualY + 1..novaPosicioY) {
                        if (!gameOver && !obstacleTrobat) {
                            if (taulell[z][j] == Casella.DINAMITA) {
                                gameOver = true
                                posicioFinalRobot = z - 1
                            }
                            if (taulell[z][j] == Casella.ROCA) {
                                obstacleTrobat = true
                                posicioFinalRobot =
                                    z - 1 //Si troba un obstacle, el robot es quedarà a la posició prèvia
                            }
                        }
                    }

                    taulell[posicioFinalRobot][j] = Casella.ROBOT
                    robot.y= coordenadesRobotY(posicioFinalRobot)
                    // Si el robot s'ha mogut, deixarem el rastre de dinamita
                    if (posicioFinalRobot > posicioActualY) {
                        for (rastre in posicioFinalRobot - 1 downTo posicioActualY) {
                            taulell[rastre][j] = Casella.DINAMITA
                        }
                    }
                }
            }
        }
    }
    return gameOver
}

/**
 * Aquesta funció serveix per fer avançar el robot cap a la dreta tenint en compte tots els paràmetres i obstacles en el camí.
 * @author agustí.lópez
 * @since 02/01/2025
 * @param taulell Taulell amb les posicions de cada element, tant el robot com els obstacles
 * @param robot Data class 'Robot' amb els paràmetres del robot (posició x,y i velocitat)
 * @return Boolean que indica si la partida ha acabat o encara esta en joc
 */
fun dreta(taulell: Array<Array<Casella>>, robot: Robot): Boolean {
    var finalTorn: Boolean = false
    var gameOver: Boolean = false
    var obstacleTrobat: Boolean = false
    for (i in 0 until taulell.size) {
        for (j in 0 until taulell[i].size) {
            if (!finalTorn) {
                if (taulell[i][j] == Casella.ROBOT) {
                    finalTorn = true
                    var novaPosicioX = j + robot.velocitat
                    val posicioActualX = j
                    if (novaPosicioX > 19) {
                        //Límit taulell
                        novaPosicioX = 19
                    }
                    var posicioFinalRobot: Int = novaPosicioX
                    // Mirem si hi ha algun obstacle en el camí
                    for (z in posicioActualX + 1..novaPosicioX) {
                        if (!gameOver && !obstacleTrobat) {
                            if (taulell[i][z] == Casella.DINAMITA) {
                                gameOver = true
                                posicioFinalRobot = z - 1
                            }
                            if (taulell[i][z] == Casella.ROCA) {
                                obstacleTrobat = true
                                posicioFinalRobot =
                                    z - 1 //Si troba un obstacle, el robot es quedarà a la posició prèvia
                            }
                        }
                    }

                    taulell[i][posicioFinalRobot] = Casella.ROBOT
                    robot.x=posicioFinalRobot
                    // Si el robot s'ha mogut, deixarem el rastre de dinamita
                    if (posicioFinalRobot > posicioActualX) {
                        for (rastre in posicioFinalRobot - 1 downTo posicioActualX) {
                            taulell[i][rastre] = Casella.DINAMITA
                        }
                    }
                }
            }
        }
    }

    return gameOver
}

/**
 * Aquesta funció serveix per fer avançar el robot cap a l'esquerra' tenint en compte tots els paràmetres i obstacles en el camí.
 * @author agustí.lópez
 * @since 02/01/2025
 * @param taulell Taulell amb les posicions de cada element, tant el robot com els obstacles
 * @param robot Data class 'Robot' amb els paràmetres del robot (posició x,y i velocitat)
 * @return Boolean que indica si la partida ha acabat o encara esta en joc
 */
fun esquerra(taulell: Array<Array<Casella>>, robot: Robot): Boolean {
    var finalTorn: Boolean = false
    var gameOver: Boolean = false
    var obstacleTrobat: Boolean = false
    for (i in 0 until taulell.size) {
        for (j in 0 until taulell[i].size) {
            if (!finalTorn) {
                if (taulell[i][j] == Casella.ROBOT) {
                    finalTorn = true
                    var novaPosicioX = j - robot.velocitat
                    val posicioActualX = j
                    if (novaPosicioX < 0) {
                        //Límit taulell
                        novaPosicioX = 0
                    }
                    var posicioFinalRobot: Int = novaPosicioX
                    // Mirem si hi ha algun obstacle en el camí
                    for (z in posicioActualX - 1 downTo novaPosicioX) {
                        if (!gameOver && !obstacleTrobat) {
                            if (taulell[i][z] == Casella.DINAMITA) {
                                gameOver = true
                                posicioFinalRobot = z + 1
                            }
                            if (taulell[i][z] == Casella.ROCA) {
                                obstacleTrobat = true
                                posicioFinalRobot =
                                    z + 1 //Si troba un obstacle, el robot es quedarà a la posició prèvia
                            }
                        }
                    }

                    taulell[i][posicioFinalRobot] = Casella.ROBOT
                    robot.x=posicioFinalRobot
                    // Si el robot s'ha mogut, deixarem el rastre de dinamita
                    if (posicioFinalRobot < posicioActualX) {
                        for (rastre in posicioFinalRobot + 1..posicioActualX) {
                            taulell[i][rastre] = Casella.DINAMITA
                        }
                    }
                }
            }
        }
    }
    return gameOver
}

/**
 * Aquesta funció serveix per validar si el robot ha trepitjat la dinamita i per tant s'ha acabat el joc
 * @author agustí.lópez
 * @since 02/01/2025
 * @param moviment Acció realitzada pel robot
 * @return Boolean que indica si la partida ha acabat
 */
fun gameOver(moviment:Boolean):Boolean {
    val gameOver=moviment
    return gameOver

}

/**
 * Aquesta funció serveix per obtenir les coordenades del robot en Y invertint els números de fila de la matriu
 * @author agustí.lópez
 * @since 02/01/2025
 * @param i Posició de la matriu en i (fila)
 * @param numFiles Número total de files que te la matriu
 * @return Boolean que indica si la partida ha acabat o encara esta en joc
 */
fun coordenadesRobotY(i:Int,numFiles:Int=20):Int {
    return numFiles - 1 -i
}





