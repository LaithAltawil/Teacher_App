package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.schoolapp.Data.Exam
import com.example.schoolapp.Data.Subjects
import com.example.schoolapp.Presentation.VM.MainViewModel
import com.example.schoolapp.R

//=======================================================
//Exam Page: UI & logic                                 =
//=======================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamsPage(mainViewModel: MainViewModel = MainViewModel(), navController: NavController) {
    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val state = mainViewModel.Examstate.collectAsStateWithLifecycle()

    //todo @MAS #medium|| put the right data here form the database
    val mainMenuItem = listOf(
        Subjects("Maths", painterResource(id = R.drawable.math),
            exam = Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
            onClick = {}
        ),
        Subjects("Science", painterResource(id = R.drawable.science),
            exam = Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
            onClick = {}),
        Subjects("English", painterResource(id = R.drawable.english),
            exam = Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
            onClick = {}),
        Subjects(
            "History",
            painterResource(id = R.drawable.history),
            exam = Exam("History", "2023-12-20", "11:00 AM", "Room F606"),
            onClick = {}
        ),
        Subjects(
            "Arabic",
            painterResource(id = R.drawable.arabic),
            exam = Exam("Arabic", "2023-12-21", "03:00 PM", "Room G707"),
            onClick = {}
        ),
        Subjects(
            "Computer Science",
            painterResource(id = R.drawable.science),
            exam = Exam("Computer Science", "2023-12-22", "09:00 AM", "Lab H808"),
            onClick = {}
        ),
        Subjects(
            "Geography",
            painterResource(id = R.drawable.geography),
            exam = Exam("Geography", "2023-12-23", "02:00 PM", "Hall I909"),
            onClick = {}
        )
    )

    //=======================================================
    //UI & logic                                            =
    //=======================================================
    AppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            //Main page UI: Scaffold
            Scaffold(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                //TAB
                topBar = {
                    LargeTopAppBar(
                        title = {
                            //TAB main UI: Row
                            Row(modifier = Modifier.fillMaxWidth()) {
                                //TAB title
                                Text(
                                    text = "Exams", fontSize = 60.sp,
                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                    modifier = Modifier.padding(start = 40.dp)
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
                //subjects
                Column(
                    modifier = Modifier.padding(innerPadding),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    //lazy grid to hold the data logic & UI design
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

                        //controls the lazy size
                        itemsIndexed(mainMenuItem) { index,item ->
                            //hold the subject details
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                modifier = Modifier
                                    .padding(16.dp)
                                    .wrapContentHeight()
                                    .size(200.dp)
                                    .width(100.dp)
                                    .clickable {
                                        mainViewModel.updateBottomSheetState(index, true)
                                    },
                            ) {
                                //main card UI
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                        .wrapContentSize(Alignment.Center),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    //solved @LT:Icon will be changed when we find all the required icons
                                    //they will be in a list with the subject names
                                    mainMenuItem[index].imagePath?.let {
                                        Icon(
                                            painter =
                                            it,
                                            contentDescription = null
                                        )
                                    }
                                    //subject name
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = mainMenuItem[index].name,
                                        fontSize = 24.sp,
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        overflow = TextOverflow.Visible
                                    )
                                }
                            }
                            //this is an if statement which by using the state showBottomSheet
                            //it will either show or hide the bottom sheet
                            if (state.value.BottomSheet[index]) {
                                ModalBottomSheet(containerColor = MaterialTheme.colorScheme.primary,
                                    onDismissRequest = {
                                        mainViewModel.updateBottomSheetState(index,false)
                                    }
                                ) {
                                    // Bottom sheet content
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        //todo @LT #qustion[not answered] || what to do here?
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Text(text = "Date:")
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(text = mainMenuItem[index].exam!!.date)
                                        }
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Text(text = "time:")
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(text = mainMenuItem[index].exam!!.time)
                                        }
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Text(text = "Location:")
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(text = mainMenuItem[index].exam!!.location)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
//Trial and error work to display
//working will be moving it to relative file in the next days
@Composable
fun ExamDetailsColumn(subject: String, date: String, time: String, location: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Subject: ${subject}", style = MaterialTheme.typography.displayMedium)
        Text("Date: ${date}", style = MaterialTheme.typography.displayMedium)
        Text("Time: ${time}", style = MaterialTheme.typography.displayMedium)
        Text("Location: ${location}", style = MaterialTheme.typography.displayMedium)
    }
}
//@Composable
//@Preview
//fun ExamsPagePreview() {
//    ExamsPage()
//}