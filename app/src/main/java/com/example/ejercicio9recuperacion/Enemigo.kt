package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import kotlin.random.Random

class Enemigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enemigo)
        var pers = intent.getSerializableExtra("personaje") as Personaje
        var plus:Button = findViewById(R.id.atacar)
        var imageyo:ImageView = findViewById(R.id.imageView3)
        var imageEnemigo:ImageView = findViewById(R.id.enemigoImg)
        var huir :Button = findViewById(R.id.button5)

        imageyo.background= getDrawable(pers.imagenesRazas[pers.imgSelected])

        var miVida:ProgressBar = findViewById(R.id.miVida)
        var enemigo:ProgressBar = findViewById(R.id.vidaEnemigo)
        var tipo = Random.nextInt(1,3)
        var turnos = 0

        var objetos:Button = findViewById(R.id.button6)

        enemigo.progress = 100
        miVida.progress = pers.vida

        if(tipo==1){
            imageEnemigo.background = getDrawable(R.drawable.enemigo)}
        else{
            imageEnemigo.background = getDrawable(R.drawable.boss)
        }


        plus.setOnClickListener(){
            if(turnos<6){
                if(Random.nextInt(1,7)>4){
                    if(tipo==1) {
                        enemigo.progress = enemigo.progress - pers.fuerza}
                    else{
                        enemigo.progress = enemigo.progress - pers.fuerza/2
                    }
                }

                if(tipo==1) {
                    miVida.progress = miVida.progress - 20/pers.defensa
                }else{
                    miVida.progress = miVida.progress - 30/pers.defensa
                }
                turnos++
            }
            if(turnos==6){
                if(enemigo.progress>miVida.progress){
                    /*to do pantalla de muerte*/
                    if (pers.modoCiudad){
                        pers.derrotas++
                    }
                    val intent = Intent(this, Muerte::class.java)
                    intent.putExtra("personaje", pers)
                    startActivity(intent)
                }else{
                    if (pers.modoCiudad){
                        pers.victoriasCiudad++
                    }
                    pers.vida = miVida.progress
                    pers.mochila.add("Pocion")
                    pers.mochila.add("Escudo")
                    pers.mochila.add("Curación")
                    pers.tamMochila= pers.mochila.size
                    pers.monedero = pers.monedero + 10

                    val intent = Intent(this, Victoria::class.java)
                    intent.putExtra("personaje", pers)
                    startActivity(intent)
                }

            }


        }


        objetos.setOnClickListener(){
            if(!(pers.mochila.isEmpty())) {
                pers.vida = miVida.progress +20
                pers.mochila.removeFirst()
                pers.tamMochila= pers.mochila.size
                miVida.progress= pers.vida
            }

        }

        huir.setOnClickListener(){
            if(turnos<6) {
                if (Random.nextInt(1, 9) >= 7) {
                    val intent = Intent(this, MainActivity6::class.java)
                    intent.putExtra("personaje", pers)
                    startActivity(intent)
                } else {
                    if(tipo==1) {
                        miVida.progress = miVida.progress - 20/pers.defensa
                    }else{
                        miVida.progress = miVida.progress - 30/pers.defensa
                    }
                    turnos++
                }
            }else{
                val intent = Intent(this, Muerte::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
        }



    }
}