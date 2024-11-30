package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.schoolapp.Data.CalenderDays

import com.example.schoolapp.Presentation.Util.ExpandableButton
import com.example.schoolapp.Presentation.VM.MainViewModel

//=======================================================
//Calender page: Logic & UI                             =
//=======================================================
//underway @MAS #qustion[Answered] || do you have any idea to fill this page?
/*MAS: Check the file calender_1.png for the design of this page
Currently working on it will implement the idea you proposed
Check the current progress on the ExpandableButton.kt file
after click the expandable button
you can try one of those designs
Card design:-
+-------------------------+
| title: event title      |
| Num: event number       |
| date: dd/mm/yyyy        |
| day : day name          |
| event: event description|
+-------------------------+
//todo Check out the latest design and give me feedback
column design:-
+-------------------------+
|No|date|day|title|event  |
|-------------------------|
|1 |13/9|Mon|title|event  |
+-------------------------+
* */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalenderPage(mainViewModel: MainViewModel = MainViewModel(),navController: NavController) {
    //=======================================================
    //variables:local & states                              =
    //=======================================================
    val calendarItems = listOf(
        CalenderDays("Main Events", "A huge Open Day for jobs in tech for the future", {}),
        CalenderDays("Counselor Schedule", "A huge Open Day for jobs in medicine for the future", {}),
        CalenderDays("Semester Schedule", "A huge Open Day for jobs in finance for the future", {})
    )
    //=======================================================
    // logic & UI                                           =
    //=======================================================
    AppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                topBar = {
                    //LT: Yes this is a function which contains the TAB for this page
                    LargeTopAppBar(
                        title = {
                            //main TAB UI: Row //BTW TAB == "top app bar"
                            Row(modifier = Modifier.fillMaxWidth()) {
                                //TAB title
                                Text(
                                    text = "Calender", fontSize = 46.sp,
                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                            }
                        },
                        modifier = Modifier.clip(
                            RoundedCornerShape(
                                bottomEnd = 25.dp,
                                bottomStart = 25.dp
                            )
                        ),
                        colors =
                        TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        navigationIcon = {
                            IconButton(onClick = {
                                navController.popBackStack()
                            }) {
                                Icon(
                                    modifier = Modifier.size(50.dp),
                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = "Localized description",
                                    tint = MaterialTheme.colorScheme.background
                                )
                            }
                        }
                    )
                },
                // Add content padding
            ) { innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    LazyColumn {
                        items(calendarItems) { item ->
                            // ExpandableButton composable
                            ExpandableButton(name = item.day, text = item.event)
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//@Preview
//fun CalenderPagePreview() {
//    CalenderPage()
//}