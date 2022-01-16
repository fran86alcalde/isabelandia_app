package com.example.isabelandia

import android.provider.BaseColumns

class bases_datos {

    object bases_datos {//aqui declaramos la entrada que recibiremos y que meteremos en la base de datos

        object bases_datos : BaseColumns {
            const val TABLE_NAME = "Ciudades"
            const val Colum1 = "Ciudad"
            const val Colum2 = "Año"
        }
        const val SQL_CREATE_ENTRIES =
                "CREATE TABLE ${bases_datos.TABLE_NAME} (" +
                        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                        "${bases_datos.Colum1} TEXT," +
                        "${bases_datos.Colum2} TEXT)"

        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${bases_datos.TABLE_NAME}"
    }
}