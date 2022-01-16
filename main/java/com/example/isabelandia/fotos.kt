package com.example.isabelandia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class fotos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {//en esta activity solo tenemos la logica del volver
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fotos)

        val boton_volver = findViewById<Button>(R.id.button11)

        boton_volver.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                onBackPressed()
            }})
    }
}