package org.example
import org.example.models.Robot
import java.util.*

val scan: Scanner = Scanner(System.`in`)
fun main() {
    var taulell=taulell()
    //taulell= taulellInicial(taulell)
    //var gameOver:Boolean=false
    var robot=Robot(x=0,y=0,1)
    do {
        var ordreUsuari=scan.nextLine()


        when (ordreUsuari) {
            "DALT" -> {
                var dalt=dalt(taulell, robot)
                var gameOver=gameOver(dalt)
                if(gameOver==true){
                    println("GAME OVER")
                }
            }

            "BAIX" -> {
                var baix=baix(taulell, robot)
                var gameOver=gameOver(baix)
                if(gameOver==true){
                    println("GAME OVER")
                }

            }

            "DRETA" -> {
                var dreta=dreta(taulell, robot)
                var gameOver=gameOver(dreta)
                if(gameOver==true){
                    println("GAME OVER")
                }
            }

            "ESQUERRA" -> {
                var esquerra=esquerra(taulell, robot)
                var gameOver=gameOver(esquerra)
                if(gameOver==true){
                    println("GAME OVER")
                }
            }

            "ACCELERAR" -> {
                if((robot.velocitat+1)<=5) {
                    robot.velocitat++
                }
            }
            "FRENAR" -> {
                if((robot.velocitat-1)>=0) {
                    robot.velocitat--
                }
            }
            "POSICIO" -> {
                println("X: "+ robot.x + " Y: " + robot.y)
            }
            "MOSTRAR" -> {
                mostrarTaulell(taulell)
            }

            "VELOCITAT" -> {
                println(robot.velocitat)
            }
            "REINICIAR" -> {
                robot=Robot(x=0,y=0,1)
            }
            "END" -> {
                println("EXIT")
            }
            else -> {}
        }

        mostrarTaulell(taulell)
    }while (ordreUsuari != "END")

}