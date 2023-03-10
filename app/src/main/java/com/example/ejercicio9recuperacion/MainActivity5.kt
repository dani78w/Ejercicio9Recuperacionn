package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var pers = intent.getSerializableExtra("personaje") as Personaje
        var imagen1: ImageView = findViewById(R.id.imageView2)
        var imagen2: ImageView = findViewById(R.id.imageViewObjeto)
        var textView = findViewById<TextView>(R.id.textView3)
        var textView2 = findViewById<TextView>(R.id.textView4)


        if (pers.raza == "guerrero") {
            imagen1.setImageResource(R.drawable.guerrero)
        } else if (pers.raza == "ladron") {
            imagen1.setImageResource(R.drawable.ladron)
        } else if (pers.raza == "mago") {
            imagen1.setImageResource(R.drawable.mago)
        } else if (pers.raza == "berserker") {
            imagen1.setImageResource(R.drawable.berserk)
        }
        textView.text=pers.raza.uppercase()

        if (pers.clase == "Humano") {
            imagen2.setImageResource(R.drawable.humano)
            pers.imgSelected = 0
        } else if (pers.clase == "Elfo") {
            imagen2.setImageResource(R.drawable.elfo)
            pers.imgSelected = 1
        } else if (pers.clase == "Enano") {
            imagen2.setImageResource(R.drawable.enano)
            pers.imgSelected = 2
        } else if (pers.clase == "Gobling") {
            imagen2.setImageResource(R.drawable.gobling)
            pers.imgSelected = 3
        }
        textView2.text=pers.clase.uppercase()

        var textView4 = findViewById<TextView>(R.id.textView6)
        var textView5 = findViewById<TextView>(R.id.textView7)
        var textView6 = findViewById<TextView>(R.id.textView8)
        var textView7 = findViewById<TextView>(R.id.textView9)

        textView4.text="Fuerza : "+pers.fuerza.toString()
        textView5.text="Defensa : "+pers.defensa.toString()
        textView6.text="Tamaño de la mochila: "+pers.tamMochila.toString()
        textView7.text="Vida : "+pers.vida.toString()

        var button: Button = findViewById(R.id.button)
        var button2: Button = findViewById(R.id.button2)

        var editText : EditText = findViewById(R.id.editTextTextPersonName2)

        editText.doAfterTextChanged{
            pers.nombre=editText.text.toString()
        }

        button.setOnClickListener {

            if(editText.text.toString().isEmpty()){
                editText.setError("Introduce un nombre")
            }else{

                val intent = Intent(this, MainActivity6::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
        }
        button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("personaje", pers)
            startActivity(intent)
        }


    }
}