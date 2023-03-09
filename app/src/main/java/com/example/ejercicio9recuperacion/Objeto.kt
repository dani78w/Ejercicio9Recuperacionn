package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class Objeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)


        var rand = Random.nextInt(0,3)
        var pers = intent.getSerializableExtra("personaje") as Personaje
        var fotos = arrayOf(R.drawable.pocion,R.drawable.arco,R.drawable.escudo)
        var nombre = arrayOf("pocion","arco","escudo")
        var imageView :ImageView = findViewById(R.id.imageViewObjeto)
        var text:TextView = findViewById(R.id.textViewObjeto)
        var mochila:TextView = findViewById(R.id.mochila)
        var indicador:TextView = findViewById(R.id.indicadorObjeto)
        var volver: Button = findViewById(R.id.volverObjeto)
        var comprar: Button = findViewById(R.id.comprarObjeto)
        comprar.isEnabled= false
        //peso 5 valor 10 vida 20
        imageView.background = getDrawable(fotos[rand])
        text.text = nombre[rand]

        if(mochila.text == "[]"){
            mochila.text = "Mochila vacia"
        }
        else{
            mochila.text = pers.mochila.toString()
        }

        volver.setOnClickListener(){
            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("personaje", pers)
            startActivity(intent)
        }



            if ((pers.tamMochila - 10) >= 0) {
                comprar.isEnabled = true

                indicador.text = "Puedes recoger el objeto"
                comprar.setOnClickListener() {
                    pers.tamMochila = pers.tamMochila - 10
                    pers.mochila.add(nombre[rand])
                    pers.vida = pers.vida + 20
                    val intent = Intent(this, MainActivity6::class.java)
                    intent.putExtra("personaje", pers)
                    startActivity(intent)

                }
            } else {
                indicador.text = "No te cabe en la mochila"
            }






    }
}