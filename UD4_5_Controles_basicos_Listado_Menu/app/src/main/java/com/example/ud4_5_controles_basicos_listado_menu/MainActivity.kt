package com.example.ud4_5_controles_basicos_listado_menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asigna los botones
        val btnEj1: Button = findViewById(R.id.btnEjercicio1)
        val btnEj2: Button = findViewById(R.id.btnEjercicio2)
        val btnEj3: Button = findViewById(R.id.btnEjercicio3)
        val btnEj4: Button = findViewById(R.id.btnEjercicio4)
        val btnEj5: Button = findViewById(R.id.btnEjercicio5)

        // Configura el clic para cada botón

        btnEj1.setOnClickListener {
            // Lanza la Actividad del Ejercicio 1
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        btnEj2.setOnClickListener {
            // Lanza la Actividad del Ejercicio 2
            val intent = Intent(this, Ejercicio2Activity::class.java)
            startActivity(intent)
        }

        btnEj3.setOnClickListener {
            // Lanza la Actividad del Ejercicio 3
            val intent = Intent(this, Ejercicio3Activity::class.java)
            startActivity(intent)
        }

        btnEj4.setOnClickListener {
            // Lanza la Actividad del Ejercicio 4
            val intent = Intent(this, Ejercicio4Activity::class.java)
            startActivity(intent)
        }

        btnEj5.setOnClickListener {
            // Lanza la Actividad del Ejercicio 5 (Proyecto)
            val intent = Intent(this, ProyectoActivity::class.java)
            startActivity(intent)
        }
    }
}