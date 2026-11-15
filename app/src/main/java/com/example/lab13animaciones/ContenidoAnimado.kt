package com.example.lab13animaciones

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private enum class Estado(val titulo: String, val mensaje: String) {
    Cargando("Cargando", "Buscando datos…"),
    Contenido("Contenido", "Los datos están listos."),
    Error("Error", "No se pudieron cargar los datos.")
}

@Composable
fun ContenidoAnimado() {
    var estado by remember { mutableStateOf(Estado.Cargando) }
    Text("Ejercicio 4 · Contenido", style = MaterialTheme.typography.titleLarge)
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Estado.entries.forEach { opcion ->
            FilterChip(estado == opcion, { estado = opcion }, { Text(opcion.titulo) })
        }
    }
    AnimatedContent(
        targetState = estado,
        transitionSpec = { fadeIn(tween(500, delayMillis = 150)) togetherWith fadeOut(tween(180)) },
        label = "estado del contenido"
    ) { actual ->
        Card(Modifier.fillMaxWidth().height(118.dp)) {
            Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(actual.titulo, style = MaterialTheme.typography.titleLarge)
                Text(actual.mensaje)
            }
        }
    }
}
