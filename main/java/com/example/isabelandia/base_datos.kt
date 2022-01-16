package com.example.isabelandia

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.widget.EditText
import com.example.isabelandia.bases_datos.bases_datos.bases_datos.Colum1
import com.example.isabelandia.bases_datos.bases_datos.bases_datos.Colum2
import com.example.isabelandia.bases_datos.bases_datos.bases_datos.TABLE_NAME



class base_datos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_datos)
        val dbHelper = Sirviente(this)//utilizamos esta variable como helper
        var et2=findViewById<EditText>(R.id.et2)
        var et1=findViewById<EditText>(R.id.et1)

        val toast1 = Toast.makeText(applicationContext,
                "Entrando en Activity 2", Toast.LENGTH_SHORT)//aqui tenemos el mensaje de entrando en act2

        toast1.show()

        var boton_volver = findViewById<Button>(R.id.button16)

        boton_volver.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var ir_a_principal = Intent (applicationContext,MainActivity::class.java)
                startActivity(ir_a_principal)
            }})

        var crear = findViewById<Button>(R.id.button7)

        crear.setOnClickListener(object: View.OnClickListener{//aqui creamos
            override fun onClick(v: View?) {

                val db = dbHelper.writableDatabase
                val values = ContentValues().apply {
                    put(bases_datos.bases_datos.bases_datos.Colum1,et2.getText().toString())
                    put(bases_datos.bases_datos.bases_datos.Colum2,et1.getText().toString())
                }

                // Insert the new row, returning the primary key value of the new row
                val newRowId = db?.insert(bases_datos.bases_datos.bases_datos.TABLE_NAME, null, values)
            }


            })

        var insertar = findViewById<Button>(R.id.button8)

        insertar.setOnClickListener(object: View.OnClickListener{//aqui introduciriamos en la tabla, realiza la misma funcion que crear

            override fun onClick(v: View?) {

                val db = dbHelper.writableDatabase
                val values = ContentValues().apply {
                    put(bases_datos.bases_datos.bases_datos.Colum1,et2.getText().toString())
                    put(bases_datos.bases_datos.bases_datos.Colum2,et1.getText().toString())
                }

                // Insert the new row, returning the primary key value of the new row
                val newRowId = db?.insert(bases_datos.bases_datos.bases_datos.TABLE_NAME, null, values)
            }

        })
        var consultar = findViewById<Button>(R.id.button9)

        consultar.setOnClickListener(object: View.OnClickListener{

            override fun onClick(v: View?) {
                val dbHelper = Sirviente(applicationContext)//utilizamos sirviente
                val db = dbHelper.readableDatabase
                val projection = arrayOf(bases_datos.bases_datos.bases_datos.Colum1, bases_datos.bases_datos.bases_datos.Colum2)//metemos en el array
                val selection = "${bases_datos.bases_datos.bases_datos.Colum1} = ?"
                val selectionArgs = arrayOf(et2.getText().toString())
                val cursor = db.query(//consultamos
                        bases_datos.bases_datos.bases_datos.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                )

                val itemIds = mutableListOf<Long>()//recorremos con un cursor
                with(cursor) {
                    while (moveToNext()) {
                        et2.setText(cursor.getString(0))
                    }
                }


            }
        })
    } }


