package com.example.p2ud4_5

// Data class: una clase diseñada solo para guardar datos.
data class Task(
    val id: Long,           // Identificador único para cada tarea
    val texto: String,      // El texto de la tarea (ej. "Comprar leche")
    var completada: Boolean = false // Estado de la tarea (marcada o no). Por defecto es falso.
)