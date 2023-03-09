package com.example.ejercicio9recuperacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlin.random.Random

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        var pers = intent.getSerializableExtra("personaje") as Personaje
        var dado :ImageView = findViewById(R.id.dado)



        dado.setOnClickListener(){

            var rand = Random.nextInt(1,5)
            if(rand==1){
                val intent = Intent(this, Objeto::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
            if(rand==2){
                val intent = Intent(this, Mercader::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
            if(rand==3){
                val intent = Intent(this, Enemigo::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }
            if(rand==4){
                val intent = Intent(this, Ciudad::class.java)
                intent.putExtra("personaje", pers)
                startActivity(intent)
            }


        }


    }
}