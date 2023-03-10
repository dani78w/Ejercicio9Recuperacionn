package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Victoria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victoria)

        var pers = intent.getSerializableExtra("personaje") as Personaje
        pers.monedero = pers.monedero + 10
        pers.vida=pers.vida+50
        pers.victorias++

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