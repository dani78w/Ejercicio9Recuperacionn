package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Ciudad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudad)

        var button: ImageButton = findViewById(R.id.imageButton4)
        var pers = intent.getSerializableExtra("personaje") as Personaje
        pers.modoCiudad=true

        if (pers.victoriasCiudad==4){
            pers.modoCiudad=false
            pers.victoriasCiudad=0
            pers.derrotas=0

            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("personaje", pers)
            startActivity(intent)
        }

        if (pers.derrotas==8){
            pers.modoCiudad=false
            pers.victoriasCiudad=0
            pers.derrotas=0

            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("personaje", pers)
            startActivity(intent)
        }

        button.setOnClickListener(){
            val intent = Intent(this, Enemigo::class.java)
            intent.putExtra("personaje", pers)
            startActivity(intent)
        }
    }

}