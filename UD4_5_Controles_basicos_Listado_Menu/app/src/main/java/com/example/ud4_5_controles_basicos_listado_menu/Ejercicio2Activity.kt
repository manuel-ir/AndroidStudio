package com.example.ud4_5_controles_basicos_listado_menu

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        // Referencias a todas las Vistas
        val etColorFavorito: EditText = findViewById(R.id.etColorFavorito)
        val cbAzul: CheckBox = findViewById(R.id.cbAzul)
        val rgVerde: RadioGroup = findViewById(R.id.rgVerde)
        val btnEnviar: Button = findViewById(R.id.btnEnviar)

        // Lógica del botón Enviar
        btnEnviar.setOnClickListener {
            // 1. Obtiene el texto del EditText
            val colorFavorito = etColorFavorito.text.toString()

            // 2. Obtiene el estado del CheckBox
            val leGustaAzul = if (cbAzul.isChecked) "Sí" else "No"

            // 3. Obtiene la opción seleccionada del RadioGroup
            val idVerdeSeleccionado = rgVerde.checkedRadioButtonId
            val gustaVerde = if (idVerdeSeleccionado == R.id.rbVerdeSi) {
                "Sí"
            } else if (idVerdeSeleccionado == R.id.rbVerdeNo) {
                "No"
            } else {
                "No respondido"
            }

            // 4. Construye el mensaje de resumen
            val mensaje = """
                Tu color: $colorFavorito
                ¿Te gusta el azul?: $leGustaAzul
                ¿Te gusta el verde?: $gustaVerde
            """.trimIndent() // trimIndent() quita los espacios extra

            // 5. Muestra el mensaje Toast
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}