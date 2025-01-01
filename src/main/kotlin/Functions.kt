package org.example

import utils.*
import kotlin.random.Random


enum class Casella (val codiAscii:String) {
    PARET("\uD83E\uDDF1"), //🧱
    ROBOT("\uD83E\uDD16"), //🤖
    ROCA("\uD83E\uDEA8\uFE0F"), // 🪨
    DINAMITA("\uD83E\uDDE8") //🧨
}

fun taulell():Array<Array<Casella>> {
    var planol:Array<Array<Casella>>
    planol=Array(20){Array(20){Casella.PARET}}
    planol[19][0]=Casella.ROBOT
    /**        00  01 02 03 04 05 06  07 08 09 10 11  12 13 14 15 16 17  18 19
     * 00 (19) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 01 (18) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 02 (17) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 03 (16) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 04 (15) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 05 (14) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 06 (13) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 07 (12) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 08 (11) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 09 (10) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 10 (09) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 11 (08) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 12 (07) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 13 (06) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 14 (05) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 15 (04) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 16 (03) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 17 (02) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 18 (01) 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     * 19 (00) 🤖 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱 🧱
     *
     */

    /**        00  01  02   03  04  05  06  07  08   09  10  11  12   13  14  15  16   17  18  19  [X]
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
     *
     * * LIMITS *
     * DALT:    array (col) 00-- / y 19++
     * BAIX:    array (col) 19++ / y 00--
     * DRETA:   array (fil) 19++ / x 19++
     * ESQUERRA: array (fil) 00-- / x 00--
     *
     */

    return planol
}


fun taulellInicial(taulell:Array<Array<Casella>>):Array<Array<Casella>> {
    val taulellInicial=taulell
var numRoques=Random.nextInt(30,70+1)

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
        val (fila,columna) =posicions[i]
        taulellInicial[fila][columna]=Casella.ROCA

    }

    return taulellInicial

}

fun mostrarTaulell(taulell:Array<Array<Casella>>) {
    for (i in 0 until taulell.size) {
        for (j in 0 until taulell[i].size) {
            print("${taulell[i][j].codiAscii} ")
        }
        println()
    }

}

