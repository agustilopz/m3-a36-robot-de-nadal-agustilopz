package org.example
import org.example.models.Robot
import java.util.*

val scan: Scanner = Scanner(System.`in`)
fun main() {
    var taulell=taulell()
    taulell= taulellInicial(taulell)
    do {
        var ordreUsuari=scan.nextLine()
        val robot=Robot(x=0,y=0,1)

        when (ordreUsuari) {
            "DALT" -> {
                dalt(taulell, robot)
            }

            "BAIX" -> {
                baix(taulell, robot)
            }

            "DRETA" -> {
                dreta(taulell, robot)
            }

            "ESQUERRA" -> {
                esquerra(taulell, robot)
            }

            "ACCELERAR" -> {}
            "FRENAR" -> {}
            "POSICIO" -> {}
            "MOSTRAR" -> {
                mostrarTaulell(taulell)
            }

            "VELOCITAT" -> {}
            "REINICIAR" -> {}
            "END" -> {}
            else -> {}
        }

        mostrarTaulell(taulell)
    }while (ordreUsuari != "END")

}