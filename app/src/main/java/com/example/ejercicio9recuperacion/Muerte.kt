package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Muerte : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muerte)

        var pers = intent.getSerializableExtra("personaje") as Personaje
        var button: Button = findViewById(R.id.button3)
        button.setOnClickListener(){
            if(pers.modoCiudad) {
                val intent = Intent(this, Enemigo::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }else{
                val intent = Intent(this, MainActivity6::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
        }
    }
}