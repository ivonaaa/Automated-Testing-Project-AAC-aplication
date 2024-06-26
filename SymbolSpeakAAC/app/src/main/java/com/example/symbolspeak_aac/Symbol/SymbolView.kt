package com.example.symbolspeak_aac.Symbol

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.symbolspeak_aac.ChosenSymbolsFiles.ChosenSymbols

@Composable
fun SymbolView(
    product : Symbol,
    chosenSymbols: ChosenSymbols,
) {
    Card(
        modifier = Modifier
            .semantics { contentDescription = product.title }
            .padding(3.dp)
            .fillMaxWidth(),
        border = BorderStroke(3.dp, color = colorPicker(type = product.type)),
    ) {
        Button(onClick = { chosenSymbols.add(product) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .semantics { contentDescription = product.title }
                .height(100.dp)
        ) {
            SymbolLayout(product = product)
        }
    }
}

fun colorPicker(type : String): Color {
    return when (type) {
        "Most used" -> Color.Cyan
        "fruit" -> Color.Green
        "vegetable" -> Color.Yellow
        "math" -> Color.Blue
        "feelings" -> Color.Magenta
        "people" -> Color.Red
        "device" -> Color.Black
        "animal" -> Color(176, 207, 165, 255)
        "pronounce" -> Color(202, 92, 92, 255)
        "verbs" -> Color(156, 39, 176, 255)
        "proverb" -> Color(163, 83, 177, 255)
        "sport" -> Color(255, 152, 0, 255)
        "profession" -> Color(0, 150, 136, 255)
        "adjective" -> Color(207, 193, 140, 255)
        "adverb" -> Color(206, 93, 93, 255)
        "noun" -> Color(198, 255, 0, 255)
        "Question words" -> Color(139, 195, 74, 255)
        "event" -> Color(255, 193, 7, 255)
        else -> Color.Gray
    }
}

@Composable
fun SymbolLayout(
    product: Symbol
) {
    Column(
        modifier = Modifier
            .semantics { contentDescription = product.title }
            .padding(1.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = product.title
        )
        Image(
            painter = rememberAsyncImagePainter(product.imageURL),
            contentDescription = "product image",
            modifier = Modifier
                .padding(2.dp)
                .size(60.dp)
                .fillMaxWidth()
        )
    }
}