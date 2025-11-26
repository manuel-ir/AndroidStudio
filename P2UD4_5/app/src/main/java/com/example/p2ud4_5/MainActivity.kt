package com.example.p2ud4_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vincula esta clase con su diseño visual (activity_main.xml)
        setContentView(R.layout.activity_main)

        // Buscamos el botón "Empezar" por su ID
        val btnEmpezar = findViewById<Button>(R.id.btnEmpezar)

        // Configuramos qué pasa al hacer clic en el botón
        btnEmpezar.setOnClickListener {
            // Creamos un Intent (una intención de ir a otro sitio)
            // Desde: esta pantalla (this) -> Hasta: MenuActivity
            val intent = Intent(this, MenuActivity::class.java)

            // Iniciamos la nueva actividad
            startActivity(intent)
        }
    }
}