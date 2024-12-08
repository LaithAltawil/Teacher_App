package com.example.teacher_app.Presentation.Screens.ScreensPieces

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.schoolapp.Data.Exam
import com.example.teacher_app.R


@Composable
fun ExamsCard(exam:Exam){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        Row(modifier = Modifier.fillMaxSize().padding(10.dp),horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier) {
                Text(text = exam.subject, fontStyle = MaterialTheme.typography.titleLarge.fontStyle)
                Text(text = exam.date)
            }
            Column(modifier = Modifier) {
                Text(text=exam.time)
                Text(text=exam.location)

            }




        }






    }



}