package com.example.casopracticoadicional_mir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val btnIrMenu = findViewById<Button>(R.id.btnIrMenu)

        val nombre = intent.getStringExtra("nombreUsuario")
        tvSaludo.text = "Hola, $nombre!"

        btnIrMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}