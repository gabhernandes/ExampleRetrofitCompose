package com.gabrielhernandes.retrofitcompose.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.gabrielhernandes.retrofitcompose.response.DigimonListItem

@Composable
fun listScreen(viewModel: ListViewModel = hiltViewModel()) {
    LazyColumn {
        itemsIndexed(viewModel.list.value) { _, item ->
            screen(item = item)
        }
    }
}

@Composable
private fun screen(item: DigimonListItem) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Image(
            painter = rememberImagePainter(item.img),
            contentDescription = "",
            modifier = Modifier.height(80.dp)
        )
        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}