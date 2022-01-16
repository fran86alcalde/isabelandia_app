package com.example.isabelandia


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {  //comenzamos el main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var boton_b_datos = findViewById<Button>(R.id.button1) //declaramos los botones

        boton_b_datos.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var ir_actividad2 = Intent(applicationContext, base_datos::class.java)//para ir a otra activiy utilizamos in listener y un intent
                startActivity(ir_actividad2)
            }
        })

       var boton_camara = findViewById<Button>(R.id.button2)

        boton_camara.setOnClickListener(object : View.OnClickListener {//para ir a otra activiy utilizamos in listener y un intent
            override fun onClick(v: View?) {
                var ir_actividad3 = Intent(applicationContext, camara::class.java)
                startActivity(ir_actividad3)
            }
        })

        var boton_imagenes = findViewById<Button>(R.id.button3)

        boton_imagenes.setOnClickListener(object : View.OnClickListener {//para ir a otra activiy utilizamos in listener y un intent
            override fun onClick(v: View?) {
                var ir_actividad4 = Intent(applicationContext, fotos::class.java)
                startActivity(ir_actividad4)
            }
        })


        //la aprte del reproductor, nos servimos de la calse mediaplayer
        lateinit var buttonPlay: Button
        lateinit var buttonStop: Button
        lateinit var mediaPlayer: MediaPlayer


            buttonPlay = findViewById(R.id.button15)
            buttonStop = findViewById(R.id.button14)

            mediaPlayer = MediaPlayer.create(this, R.raw.piano)

            buttonPlay.setOnClickListener{mediaPlayer.start()}
            buttonStop.setOnClickListener{mediaPlayer.pause()}
        }

        }






