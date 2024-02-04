package com.example.symbolspeak_aac.Navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector,
    val modifier: Modifier
)
