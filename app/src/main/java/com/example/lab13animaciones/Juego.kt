package com.example.lab13animaciones

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Juego() {
    var energy by remember { mutableIntStateOf(0) }
    val launched = energy == 3
    val altitude by animateDpAsState(if (launched) 14.dp else 128.dp, tween(1100), label = "altura")
    val sky by animateColorAsState(if (launched) Color(0xFF121431) else Color(0xFF263F70), tween(850), label = "cielo")
    Text("Misión Órbita", style = MaterialTheme.typography.titleLarge)
    Text("Carga tres puntos de energía para despegar.")
    Spacer(Modifier.height(12.dp))
    Box(Modifier.fillMaxWidth().height(200.dp).background(sky, RoundedCornerShape(20.dp))) {
        Box(Modifier.align(Alignment.TopCenter).offset(y = altitude).size(54.dp).background(Color(0xFFFAB95A), CircleShape), contentAlignment = Alignment.Center) {
            Text("🚀")
        }
        AnimatedVisibility(launched, Modifier.align(Alignment.BottomCenter).padding(14.dp), enter = fadeIn(tween(600)), exit = fadeOut()) {
            Text("¡Misión cumplida!", color = Color.White)
        }
    }
    AnimatedContent(energy, label = "energía") { value -> Text("Energía: $value / 3", Modifier.padding(top = 10.dp)) }
    Button(onClick = { energy = if (launched) 0 else energy + 1 }) {
        Text(if (launched) "Reiniciar" else "Cargar energía")
    }
}
