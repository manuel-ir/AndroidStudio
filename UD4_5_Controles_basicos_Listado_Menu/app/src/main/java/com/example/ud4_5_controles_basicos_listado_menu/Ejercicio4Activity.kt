package com.example.ud4_5_controles_basicos_listado_menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Ejercicio4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio4)

        // Configura la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    // 1. "Inflar" (crear) el menú en la Toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    // 2. Maneja los clics en las opciones del menú [cite: 2904]
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_inicio -> {
                mostrarMensaje("Has seleccionado Inicio")
                true
            }
            R.id.menu_perfil -> {
                mostrarMensaje("Has seleccionado Perfil")
                true
            }
            R.id.menu_config -> {
                mostrarMensaje("Has seleccionado Configuración")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Función auxiliar para mostrar el Toast
    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}