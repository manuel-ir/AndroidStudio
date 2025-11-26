package com.example.p2ud4_5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TasksActivity : AppCompatActivity() {

    private val allTasks = mutableListOf<Task>()
    private lateinit var adapter: TasksAdapter
    private var filterMode = FilterMode.ALL
    private var idCounter = 0L

    enum class FilterMode { ALL, COMPLETED, PENDING }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarTasks)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Flecha atrás

        // RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvTasks)
        adapter = TasksAdapter(allTasks,
            onTaskChecked = { task, isChecked ->
                task.completada = isChecked
                applyFilter()
            },
            onTaskDeleted = { task ->
                allTasks.remove(task)
                applyFilter()
                Toast.makeText(this, "Tarea eliminada", Toast.LENGTH_SHORT).show()
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Botón Añadir
        val etTask = findViewById<EditText>(R.id.etTask)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val text = etTask.text.toString()
            if (text.isNotEmpty()) {
                allTasks.add(Task(idCounter++, text))
                etTask.text.clear()
                applyFilter()
            } else {
                Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_SHORT).show()
            }
        }

        // Filtros
        val rgFilter = findViewById<RadioGroup>(R.id.rgFilter)
        rgFilter.setOnCheckedChangeListener { _, checkedId ->
            filterMode = when (checkedId) {
                R.id.rbCompleted -> FilterMode.COMPLETED
                R.id.rbPending -> FilterMode.PENDING
                else -> FilterMode.ALL
            }
            applyFilter()
        }
    }

    private fun applyFilter() {
        val filteredList = when (filterMode) {
            FilterMode.ALL -> allTasks
            FilterMode.COMPLETED -> allTasks.filter { it.completada }
            FilterMode.PENDING -> allTasks.filter { !it.completada }
        }
        adapter.updateList(filteredList)
    }

    // Acción de la flecha atrás
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}