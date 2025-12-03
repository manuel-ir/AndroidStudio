package com.example.simulacro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Referencias
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val spinnerOrigen = findViewById<Spinner>(R.id.spinnerOrigen)
        val spinnerDestino = findViewById<Spinner>(R.id.spinnerDestino)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)

        // 2. Configuración de los Spinners
        val monedas = arrayOf("EUR", "USD", "GBP")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, monedas)

        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter

        // 3. Lógica del Botón Convertir
        btnConvertir.setOnClickListener {
            // Convertimos el texto a número decimal (Double). Si falla, devuelve null.
            val cantidad = etCantidad.text.toString().toDoubleOrNull()

            if (cantidad != null) {
                val monedaOrigen = spinnerOrigen.selectedItem.toString()
                val monedaDestino = spinnerDestino.selectedItem.toString()

                // Llamamos a la función que calcula el cambio real
                val resultado = calcularCambio(cantidad, monedaOrigen, monedaDestino)

                // Formateamos a 2 decimales (ej: 10.50 en vez de 10.503923)
                val resultadoFormateado = String.format("%.2f", resultado)

                val mensaje = "Resultado: $cantidad $monedaOrigen = $resultadoFormateado $monedaDestino"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, introduce una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Función privada para calcular el cambio de moneda.
     * Usa el EURO como moneda puente (base).
     */
    private fun calcularCambio(cantidad: Double, origen: String, destino: String): Double {
        // Tasas de cambio aproximadas (Referencia: 1 EUR)
        val tasaUSD = 1.05
        val tasaGBP = 0.83

        // Paso 1: Convierte la moneda de ORIGEN a EUROS
        val cantidadEnEuros = when (origen) {
            "USD" -> cantidad / tasaUSD // Si tengo dólares, divido para saber cuántos euros son
            "GBP" -> cantidad / tasaGBP // Si tengo libras, divido para saber cuántos euros son
            else -> cantidad            // Si ya son EUR, se queda igual
        }

        // Paso 2: Convierte de EUROS a la moneda de DESTINO
        val resultadoFinal = when (destino) {
            "USD" -> cantidadEnEuros * tasaUSD // De Euros a Dólares, multiplico
            "GBP" -> cantidadEnEuros * tasaGBP // De Euros a Libras, multiplico
            else -> cantidadEnEuros            // Si el destino es EUR, se queda igual
        }

        return resultadoFinal
    }
}