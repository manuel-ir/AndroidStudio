package com.example.p2ud4_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Configuramos la navegación para cada uno de los 3 botones.
        // Pasamos el ID del botón, el mensaje a mostrar y la clase de la actividad destino.
        setupNavigation(R.id.btnPerfil, "Sección Perfil", ProfileActivity::class.java)
        setupNavigation(R.id.btnTareas, "Sección Tareas", TasksActivity::class.java)
        setupNavigation(R.id.btnAjustes, "Sección Ajustes", SettingsActivity::class.java)
    }

    // Función auxiliar para evitar repetir código.
    // Recibe el botón, el mensaje y la pantalla de destino.
    private fun setupNavigation(btnId: Int, mensaje: String, activityClass: Class<*>) {
        findViewById<Button>(btnId).setOnClickListener {
            // Mostramos un mensaje flotante (Toast) indicando dónde vamos
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()

            // Iniciamos la actividad correspondiente
            startActivity(Intent(this, activityClass))
        }
    }
}
