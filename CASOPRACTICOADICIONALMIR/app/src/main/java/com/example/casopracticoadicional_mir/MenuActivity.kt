package com.example.casopracticoadicional_mir

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.btnPerfil).setOnClickListener {
            Toast.makeText(this, "Sección Perfil", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnAjustes).setOnClickListener {
            Toast.makeText(this, "Sección Ajustes", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnCerrar).setOnClickListener {
            finish()
        }
    }
}