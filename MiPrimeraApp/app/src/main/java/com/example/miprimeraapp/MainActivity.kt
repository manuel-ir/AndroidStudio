package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Referencias a los elementos del XML
        val txtMensaje: TextView = findViewById(R.id.txtMensaje)
        val btnPulsar: Button = findViewById(R.id.btnPulsar)
// Acción al pulsar el botón
        btnPulsar.setOnClickListener {
            txtMensaje.text = "¡Has pulsado el botón! "
            Toast.makeText(this, "Botón pulsado", Toast.LENGTH_SHORT).show()
        }
    }
}