package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Constante para la clave del extra (equivalente a public static final en Java)
    companion object {
        const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun sendMessage(view: View) {
        // 1. Crea el Intent
        val intent = Intent(this, DisplayMessageActivity::class.java)

        // 2. Obtiene la referencia al EditText y leer el texto
        val editText = findViewById<EditText>(R.id.campo1)
        val message = editText.text.toString()

        // 3. Añade el mensaje como extra al Intent
        intent.putExtra(EXTRA_MESSAGE, message)

        // 4. Inicia la nueva Activity
        startActivity(intent)
    }
}