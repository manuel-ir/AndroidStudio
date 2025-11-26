package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Obtiene el mensaje del Intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE) // Usa la constante

        // Muestra el mensaje en el TextView
        val textView = findViewById<TextView>(R.id.textViewMessage)
        textView.text = message ?: "No message received"
    }
}

