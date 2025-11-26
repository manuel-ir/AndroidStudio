package com.example.ex

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Conecta este archivo .kt con el archivo .xml
        setContentView(R.layout.activity_main)

        // 1. Obtiene una referencia a las vistas (campos y botón) por su ID
        val etUsuario: EditText = findViewById(R.id.editTextUsuario)
        val btnAcceder: Button = findViewById(R.id.buttonAcceder)

        // 2. Crea un "oyente" de clic para el botón
        btnAcceder.setOnClickListener {

            // 3. Obtiene el texto que el usuario escribió en el campo "Usuario"
            val nombreUsuario = etUsuario.text.toString()

            // 4. Crea el mensaje de bienvenida
            val mensaje = "Bienvenido, $nombreUsuario"

            // 5. Muestra el mensaje Toast en la pantalla
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}