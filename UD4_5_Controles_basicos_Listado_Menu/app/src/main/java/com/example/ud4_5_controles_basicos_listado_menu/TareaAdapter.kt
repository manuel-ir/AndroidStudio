package com.example.ud4_5_controles_basicos_listado_menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareaAdapter(
    private var tareas: List<Tarea>,
    private val onTareaCompletada: (Tarea, Boolean) -> Unit,
    private val onTareaEliminada: (Tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    class TareaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cbCompletada: CheckBox = view.findViewById(R.id.cbCompletada)
        val tvTextoTarea: TextView = view.findViewById(R.id.tvTextoTarea)
        val btnEliminar: Button = view.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_tarea_compleja, parent, false)
        return TareaViewHolder(view)
    }

    override fun getItemCount() = tareas.size

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = tareas[position]

        // Asignar datos
        holder.tvTextoTarea.text = tarea.texto

        holder.cbCompletada.setOnCheckedChangeListener(null)

        // 2. Asignamos el estado del CheckBox
        holder.cbCompletada.isChecked = tarea.completada

        // 3. Volvemos a asignar el listener para que el usuario
        //    pueda interactuar con él.
        holder.cbCompletada.setOnCheckedChangeListener { _, isChecked ->
            onTareaCompletada(tarea, isChecked)
        }


        holder.btnEliminar.setOnClickListener {
            onTareaEliminada(tarea)
        }
    }

    // Función para actualizar la lista
    fun actualizarLista(nuevaLista: List<Tarea>) {
        tareas = nuevaLista
        notifyDataSetChanged()
    }
}