package com.example.ejercicio9recuperacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var next : Button = findViewById(R.id.siguienteB2)

        var text: TextView = findViewById(R.id.claseText)

        var pers = intent.getSerializableExtra("personaje") as Personaje
        text.text = pers.raza


        next.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("personaje", pers)
            startActivity(intent)
        }

    }
}