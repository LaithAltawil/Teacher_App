package com.example.schoolapp.Presentation.Util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schoolapp.Data.MockData.Mock.mockEvents
import com.example.schoolapp.Presentation.Screens.ScreensPieces.EventCard

//=======================================================
//solved @LT #simple || explain this fun logic here       =
//THis is expandable button
//WHEN Clicked it expands and when clicked again it collapses
//by using expanded variable to know when to do so and
// if statement to know when to do so
//=======================================================
//solved @LT #simple || @(36:36)=="Text" variable name must start with small litter

//todo @LT #medium~#hard || try adding the @preview notation to be able to use the design tab
//LT:not needed
@Composable
fun ExpandableButton(name: String, text: String) {

    //=======================================================
    //variables: local & states                             =
    //=======================================================
    var expanded by remember { mutableStateOf(false) }

    //=======================================================
    //UI & Logic                                            =
    //=======================================================
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth().width(500.dp).height(70.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = name, fontSize = 28.sp)
                Icon(imageVector =Icons.Default.KeyboardArrowDown , contentDescription =null )
            }

        }
        Spacer(modifier = Modifier.fillMaxWidth())
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Card(modifier = Modifier
                .width(500.dp)
                ,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    EventCard(event = mockEvents[0])
                    EventCard(event = mockEvents[1])
                    EventCard(event = mockEvents[2])
                    EventCard(event = mockEvents[3])
                    EventCard(event = mockEvents[4])
                }
            }
        }
    }
}