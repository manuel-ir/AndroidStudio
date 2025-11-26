package com.example.ud4_5_controles_basicos_listado_menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.atomic.AtomicLong

class ProyectoActivity : AppCompatActivity() {

    // Lista principal con TODAS las tareas
    private val listaCompletaTareas = mutableListOf<Tarea>()
    // Adaptador para el RecyclerView
    private lateinit var tareaAdapter: TareaAdapter
    // Contador simple para IDs únicos de tareas
    private var idCounter = AtomicLong(0)

    // Estado actual del filtro
    private var filtroActual = Filtro.TODAS

    enum class Filtro { TODAS, PENDIENTES, COMPLETADAS }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proyecto)

        // Referencias a vistas
        val toolbar: Toolbar = findViewById(R.id.toolbarProyecto)
        val etNuevaTarea: EditText = findViewById(R.id.etNuevaTareaProyecto)
        val btnAgregar: Button = findViewById(R.id.btnAgregarProyecto)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTareas)

        // 1. Configura Toolbar y Menú
        setSupportActionBar(toolbar)

        // 2. Configura el Adaptador y RecyclerView
        tareaAdapter = TareaAdapter(
            tareas = obtenerListaFiltrada(),
            onTareaCompletada = { tarea, completada ->
                // Lógica para marcar como completada
                tarea.completada = completada
                actualizarVista()
            },
            onTareaEliminada = { tarea ->
                // Lógica para eliminar
                listaCompletaTareas.remove(tarea)
                actualizarVista()
                Toast.makeText(this, "Tarea eliminada", Toast.LENGTH_SHORT).show()
            }
        )
        recyclerView.adapter = tareaAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 3. Lógica para agregar tarea
        btnAgregar.setOnClickListener {
            val textoTarea = etNuevaTarea.text.toString()
            if (textoTarea.isNotEmpty()) {
                val nuevaTarea = Tarea(
                    id = idCounter.incrementAndGet(),
                    texto = textoTarea,
                    completada = false
                )
                listaCompletaTareas.add(nuevaTarea)
                actualizarVista()
                etNuevaTarea.setText("")
            }
        }
    }

    // 4. Crea y manejar el Menú
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.proyecto_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        filtroActual = when (item.itemId) {
            R.id.menu_filtro_pendientes -> Filtro.PENDIENTES
            R.id.menu_filtro_completadas -> Filtro.COMPLETADAS
            else -> Filtro.TODAS // Incluye R.id.menu_filtro_todas
        }
        actualizarVista()
        return true
    }

    // 5. Lógica de Filtrado y Actualización
    private fun obtenerListaFiltrada(): List<Tarea> {
        return when (filtroActual) {
            Filtro.TODAS -> listaCompletaTareas
            Filtro.PENDIENTES -> listaCompletaTareas.filter { !it.completada }
            Filtro.COMPLETADAS -> listaCompletaTareas.filter { it.completada }
        }
    }

    private fun actualizarVista() {
        // Le pasa la lista ya filtrada al adaptador
        tareaAdapter.actualizarLista(obtenerListaFiltrada())
    }
}