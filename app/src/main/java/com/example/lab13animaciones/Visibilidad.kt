package com.example.lab13animaciones

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
fun Visibilidad() {
    var visible by remember { mutableStateOf(true) }
    Text("Ejercicio 1 · Visibilidad", style = MaterialTheme.typography.titleLarge)
    Button(onClick = { visible = !visible }) { Text(if (visible) "Ocultar cuadro" else "Mostrar cuadro") }
    AnimatedVisibility(visible, enter = fadeIn(tween(550)), exit = fadeOut(tween(450))) {
        Box(Modifier.size(110.dp).background(Color(0xFF5E40A2), RoundedCornerShape(16.dp)))
    }
}
