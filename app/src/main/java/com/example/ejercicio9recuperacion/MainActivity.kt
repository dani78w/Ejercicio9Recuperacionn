package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selected = 0
        var personaje = Personaje()
        var imagen: ImageView = findViewById(R.id.imageButton)
        var elfoButton: Button = findViewById(R.id.elfoButton)
        var humanoButton: Button = findViewById(R.id.humanoButton)
        var enanoButton: Button = findViewById(R.id.enanoButton)
        var goblingButton: Button = findViewById(R.id.goblingButton)
        var siguienteButton: Button = findViewById(R.id.siguienteB)


        elfoButton.setOnClickListener {
            imagen.setImageResource(R.drawable.elfo)
            personaje.clase = "Elfo"
        }
        humanoButton.setOnClickListener {
            imagen.setImageResource(R.drawable.humano)
            personaje.clase = "Humano"
        }
        enanoButton.setOnClickListener {
            imagen.setImageResource(R.drawable.enano)
            personaje.clase = "Enano"
        }
        goblingButton.setOnClickListener {
            imagen.setImageResource(R.drawable.gobling)
            personaje.clase = "Gobling"
        }

        siguienteButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("personaje", personaje)
            startActivity(intent)
        }



    }
}