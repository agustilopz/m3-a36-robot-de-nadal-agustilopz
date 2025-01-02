package org.example

import org.example.models.Robot
import java.util.*

val scan: Scanner = Scanner(System.`in`)
fun main() {
    var taulell = taulell()
    var gameOver: Boolean = false
    var robot = Robot(x = 0, y = 0, 1)
    println("OPCIONS: " + "POSICIO,BAIX,DRETA,ESQUERRA,ACCELERAR,FRENAR,POSICIO,MOSTRAR,VELOCITAT,REINICIAR,END.")
    do {
        var ordreUsuari = scan.nextLine()

        when (ordreUsuari) {
            "DALT" -> {
                var dalt = dalt(taulell, robot)
                gameOver = gameOver(dalt)
            }

            "BAIX" -> {
                var baix = baix(taulell, robot)
                gameOver = gameOver(baix)
            }

            "DRETA" -> {
                var dreta = dreta(taulell, robot)
                gameOver = gameOver(dreta)
            }

            "ESQUERRA" -> {
                var esquerra = esquerra(taulell, robot)
                gameOver = gameOver(esquerra)
            }

            "ACCELERAR" -> {
                if ((robot.velocitat + 1) <= 5) {
                    robot.velocitat++
                }
            }

            "FRENAR" -> {
                if ((robot.velocitat - 1) >= 0) {
                    robot.velocitat--
                }
            }

            "POSICIO" -> {
                println("La posició del robot és (" + robot.x + ", " + robot.y + ")")
            }

            "MOSTRAR" -> {
                mostrarTaulell(taulell)
            }

            "VELOCITAT" -> {
                println("La velocitat del robot és de ${robot.velocitat} m/s")
            }

            "REINICIAR" -> {
                robot = Robot(x = 0, y = 0, 1)
                taulell = taulell()
            }

            "END" -> {
            }

            else -> {}
        }

        if (gameOver) {
            mostrarGameOver()
        }
    } while (ordreUsuari != "END" || !gameOver)

}