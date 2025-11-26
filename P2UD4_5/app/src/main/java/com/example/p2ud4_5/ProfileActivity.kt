package com.example.p2ud4_5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Configuramos la barra superior para mostrar el título y el botón de "atrás"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Perfil"

        // Obtenemos referencias a los campos del formulario
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        // Lógica al pulsar "Guardar"
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()

            // Validación: Comprobamos que el campo nombre no esté vacío
            if (nombre.isNotEmpty()) {
                // Si hay nombre, mostramos mensaje de éxito personalizado
                Toast.makeText(this, "Perfil guardado, ¡bienvenido/a, $nombre!", Toast.LENGTH_LONG).show()

                // Cerramos la actividad actual para volver al menú anterior
                finish()
            } else {
                // Si no hay nombre, mostramos un error
                Toast.makeText(this, "Por favor, escribe tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // Esta función hace que la flecha de "atrás" de la barra superior funcione
    // igual que el botón físico de "atrás" del móvil.
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}