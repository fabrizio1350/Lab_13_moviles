package com.example.lab13animaciones

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimado() {
    var green by remember { mutableStateOf(false) }
    var useSpring by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (green) Color(0xFF2E7D55) else Color(0xFF275DAB),
        animationSpec = if (useSpring) spring(stiffness = 45f) else tween(750),
        label = "color del cuadro"
    )
    Text("Ejercicio 2 · Color", style = MaterialTheme.typography.titleLarge)
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        FilterChip(!useSpring, { useSpring = false }, { Text("Tween") })
        FilterChip(useSpring, { useSpring = true }, { Text("Spring") })
    }
    Button(onClick = { green = !green }) { Text(if (green) "Cambiar a azul" else "Cambiar a verde") }
    Box(Modifier.size(110.dp).background(color, RoundedCornerShape(16.dp)))
}
