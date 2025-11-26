package com.example.ud4_5_controles_basicos_listado_menu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        // Referencias a las vistas
        val etNombre: EditText = findViewById(R.id.etNombre)
        val btnEnviar: Button = findViewById(R.id.btnEnviar)

        // Configura el clic del botón
        btnEnviar.setOnClickListener {
            // Obtiene el nombre ingresado
            val nombre = etNombre.text.toString()

            // Crea el mensaje de bienvenida
            val mensaje = "¡Bienvenido, $nombre!"

            // Muestra el mensaje Toast
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}