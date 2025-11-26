package com.example.p2ud4_5

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Ajustes"

        val swDarkMode = findViewById<Switch>(R.id.swDarkMode)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // Lógica del Switch para Modo Oscuro
        swDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Activa el modo noche en toda la app
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Toast.makeText(this, "Modo oscuro activado", Toast.LENGTH_SHORT).show()
            } else {
                // Vuelve al modo claro
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Toast.makeText(this, "Modo claro activado", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica del botón Restablecer (simulada)
        btnReset.setOnClickListener {
            Toast.makeText(this, "Los datos han sido reiniciados.", Toast.LENGTH_LONG).show()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}