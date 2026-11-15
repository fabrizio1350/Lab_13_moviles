package com.example.lab13animaciones

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TamanoPosicion() {
    var moved by remember { mutableStateOf(false) }
    val size by animateDpAsState(if (moved) 116.dp else 64.dp, tween(850), label = "tamaño")
    val x by animateDpAsState(if (moved) 100.dp else 12.dp, tween(850), label = "posición")
    Text("Ejercicio 3 · Tamaño y posición", style = MaterialTheme.typography.titleLarge)
    Button(onClick = { moved = !moved }) { Text(if (moved) "Regresar cuadro" else "Mover y ampliar") }
    Box(Modifier.fillMaxWidth().height(150.dp).border(1.dp, Color.Gray, RoundedCornerShape(12.dp))) {
        Box(Modifier.offset(x = x, y = 14.dp).size(size).background(Color(0xFFAA4723), RoundedCornerShape(12.dp)))
    }
}
