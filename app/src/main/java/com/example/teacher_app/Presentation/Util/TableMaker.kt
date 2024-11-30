package com.example.schoolapp.Presentation.Util

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//todo @LT #simple || please usage for those
@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        modifier = Modifier
            .weight(weight)
            .padding(top = 12.dp),
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun SimpleTable(tableData: List<List<Any>>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(tableData.size) { rowIndex ->
            Row(modifier = Modifier.fillMaxWidth()) {
                tableData[rowIndex].forEach { cellText ->
                    TableCell(
                        text = cellText.toString(),
                        weight = 1f
                    )
                }
            }
        }
    }
}