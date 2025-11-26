package com.example.ud4_5_controles_basicos_listado_menu

// Data class para guardar el estado de cada tarea
data class Tarea(
    val id: Long,
    val texto: String,
    var completada: Boolean = false
)