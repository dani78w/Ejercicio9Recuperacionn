package com.example.ejercicio9recuperacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var selected = 0
        var personaje = intent.getSerializableExtra("personaje") as Personaje

        var imagen: ImageView = findViewById(R.id.imageButton)
        var magoButton: Button = findViewById(R.id.magoButton)
        var ladronButton: Button = findViewById(R.id.ladronButton)
        var guerreroButton: Button = findViewById(R.id.guerreroButton)
        var berserkerButton: Button = findViewById(R.id.berserkerButton)
        var siguienteButton: Button = findViewById(R.id.siguienteB)

        magoButton.setOnClickListener {
            imagen.setImageResource(R.drawable.mago)
            personaje.raza = "mago"
        }
        ladronButton.setOnClickListener {
            imagen.setImageResource(R.drawable.ladron)
            personaje.raza = "ladron"
        }
        guerreroButton.setOnClickListener {
            imagen.setImageResource(R.drawable.guerrero)
            personaje.raza = "guerrero"
        }
        berserkerButton.setOnClickListener {
            imagen.setImageResource(R.drawable.berserk)
            personaje.raza = "berserker"
        }

        siguienteButton.setOnClickListener {
            if(!(personaje.raza=="")){
                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra("personaje", personaje)
                startActivity(intent)
            }
        }



    }
}