package com.example.isabelandia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import java.util.jar.Manifest

class camara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara)



        var haz_foto = findViewById<Button>(R.id.button7)//boton para sacar la foto

        haz_foto.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var Foto = Intent (MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->//nos servimos de la clase media store
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        val REQUEST_IMAGE_CAPTURE = 0
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } } } })

        var boton_volver = findViewById<Button>(R.id.button4)//boton para volver

        boton_volver.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var ir_a_principal = Intent (applicationContext,MainActivity::class.java)
                startActivity(ir_a_principal)
            }})




    }}

