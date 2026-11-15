package com.example.lab13animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { LabScreen() } }
    }
}

@Composable
private fun LabScreen() {
    val titles = listOf("Visibilidad", "Color", "Tamaño y posición", "Contenido", "Juego")
    var selected by rememberSaveable { mutableIntStateOf(0) }
    Surface(Modifier.fillMaxSize()) {
        Column(Modifier.safeDrawingPadding().padding(16.dp)) {
            Text("Lab 13 · Animaciones", style = MaterialTheme.typography.headlineSmall)
            ScrollableTabRow(selectedTabIndex = selected, edgePadding = 0.dp) {
                titles.forEachIndexed { index, title ->
                    Tab(selected == index, { selected = index }, text = { Text(title) })
                }
            }
            Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(top = 20.dp)) {
                when (selected) {
                    0 -> Visibilidad()
                    1 -> ColorAnimado()
                    2 -> TamanoPosicion()
                    3 -> ContenidoAnimado()
                    4 -> Juego()
                }
            }
        }
    }
}
