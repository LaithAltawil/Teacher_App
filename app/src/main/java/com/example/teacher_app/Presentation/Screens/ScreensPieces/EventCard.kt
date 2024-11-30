package com.example.schoolapp.Presentation.Screens.ScreensPieces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.schoolapp.Data.Event

@Composable
fun EventCard(event: Event) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

    ) {
        Column(modifier = Modifier.padding(16.dp)){
            Text(text = event.title, style = MaterialTheme.typography.displayMedium)
            Text(text = "Event Num: ${event.num}")
            Text(text = "Event Date: ${event.date}")
            Text(text = "Event Day: ${event.day}")
            Text(text = event.event)
        }
    }
}