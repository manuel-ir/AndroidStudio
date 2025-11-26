package com.example.ud4_5_controles_basicos_listado_menu

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3Activity : AppCompatActivity() {

    // Lista en memoria para guardar las tareas
    private val listaTareas = ArrayList<String>()
    // Adaptador para conectar la lista (ArrayList) con la vista (ListView)
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        // Referencias a las vistas
        val etNuevaTarea: EditText = findViewById(R.id.etNuevaTarea)
        val btnAgregar: Button = findViewById(R.id.btnAgregar)
        val listViewTareas: ListView = findViewById(R.id.listViewTareas)

        // 1. Configura el adaptador
        // Usamos un layout simple de Android para cada fila
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTareas)
        listViewTareas.adapter = adapter

        // 2. Lógica para agregar tareas
        btnAgregar.setOnClickListener {
            val nuevaTarea = etNuevaTarea.text.toString()
            if (nuevaTarea.isNotEmpty()) {
                listaTareas.add(nuevaTarea)
                // Notifica al adaptador que los datos cambiaron
                adapter.notifyDataSetChanged()
                // Limpia el campo de texto
                etNuevaTarea.setText("")
            } else {
                Toast.makeText(this, "Escribe una tarea", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Lógica para eliminar tareas
        // (Se eliminará al hacer clic sobre la tarea)
        listViewTareas.setOnItemClickListener { parent, view, position, id ->
            val tareaEliminada = listaTareas.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Tarea '$tareaEliminada' eliminada", Toast.LENGTH_SHORT).show()
        }
    }
}