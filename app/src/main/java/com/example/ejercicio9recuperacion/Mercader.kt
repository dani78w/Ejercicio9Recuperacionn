package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class Mercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercader)

        var state = 1
        var rand = Random.nextInt(0,3)
        var pers = intent.getSerializableExtra("personaje") as Personaje
        var fotos = arrayOf(R.drawable.pocion,R.drawable.arco,R.drawable.escudo)
        var nombre = arrayOf("pocion","arco","escudo")
        var imageView : ImageView = findViewById(R.id.imageViewObjeto)
        var text: TextView = findViewById(R.id.textViewObjeto)
        var mochila: TextView = findViewById(R.id.mochila)
        var indicador: TextView = findViewById(R.id.indicadorObjeto)
        var volver: Button = findViewById(R.id.volverObjeto)
        var comprar: Button = findViewById(R.id.comprarObjeto)
        var back :Button = findViewById(R.id.back)
        var vender: Button = findViewById(R.id.vender)
        var comerciar: Button = findViewById(R.id.comerciarObjeto)
        var pasta: TextView = findViewById(R.id.pasta)
        pasta.text = "Tienes ${pers.monedero} monedas"
        comprar.isEnabled= false
        back.isEnabled=false
        vender.isEnabled=false

        comerciar.setOnClickListener(){
            if(state==1){

                comprar.isEnabled = true
                back.isEnabled=true
                vender.isEnabled=true
                comerciar.isEnabled=false
                volver.isEnabled=false
                state=1

                if(pers.monedero<10) {
                    indicador.text= "NO TIENES SUFICIENTE DINERO"
                    comprar.isEnabled = false
                }else {
                    if ((pers.tamMochila - 10) >= 0) {

                        indicador.text = "Puedes recoger el objeto"
                        comprar.setOnClickListener() {
                            pers.monedero = pers.monedero - 10
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
            else{
                comprar.isEnabled = false
                back.isEnabled=false
                vender.isEnabled=false
                comerciar.isEnabled=true
                volver.isEnabled=true
                state=0
            }
        }
        back.setOnClickListener(){
                comprar.isEnabled = false
                back.isEnabled=false
                vender.isEnabled=false
                comerciar.isEnabled=true
                volver.isEnabled=true
        }
        vender.setOnClickListener(){
            if(!pers.mochila.isEmpty()){
                pers.mochila.removeAt(0)
                pers.monedero = pers.monedero + 5
                pers.tamMochila = pers.tamMochila + 10
                val intent = Intent(this, MainActivity6::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
            else{
                indicador.text = "No tienes objetos"
            }
        }
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








    }
}