package com.example.ejercicio9recuperacion

import kotlin.random.Random

class Personaje:java.io.Serializable {

    var imagenesClases = arrayOf(R.drawable.mago, R.drawable.ladron, R.drawable.guerrero, R.drawable.berserk)
    var imagenesRazas = arrayOf(R.drawable.humano, R.drawable.elfo, R.drawable.enano, R.drawable.gobling)
    var imgSelected = 0
    var clase : String = ""
    var raza : String = ""
    var victorias: Int = 0
    var victoriasCiudad = 0
    var derrotas: Int = 0
    var modoCiudad= false
    var fuerza : Int = Random.nextInt(10,15)
    var defensa : Int = Random.nextInt(1,5)
    var tamMochila : Int =  20
    var vida : Int = 200
    var monedero :Int = 90
    var nombre : String = "Personaje"
    var mochila : MutableList<String> = mutableListOf()
}