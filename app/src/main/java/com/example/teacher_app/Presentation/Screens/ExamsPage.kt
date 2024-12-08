package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.schoolapp.Data.Exam
import com.example.schoolapp.Data.Subjects
import com.example.schoolapp.Presentation.VM.MainViewModel
import com.example.teacher_app.AppTheme
import com.example.teacher_app.Presentation.Screens.ScreensPieces.ExamsCard
import com.example.teacher_app.R

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
        Subjects("Class 5",
            painterResource(id = R.drawable.math),
            exam = listOf(
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101")
            ),
            onClick = {}
        ),
        Subjects("Class 6", painterResource(id = R.drawable.science),
            exam = listOf(
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101")
            ),
            onClick = {}),
        Subjects("Class 7", painterResource(id = R.drawable.english),
            exam = listOf(
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101")
            ),
            onClick = {}),
        Subjects(
            "Class 8",
            painterResource(id = R.drawable.history),
            exam = listOf(
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101")
            ),
            onClick = {}
        ),
        Subjects(
            "Class 9",
            painterResource(id = R.drawable.arabic),
            exam = listOf(
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
                Exam("Mathematics", "2023-11-15", "10:00 AM", "Room A101")
            ),
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
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        itemsIndexed(mainMenuItem) { index, items ->
                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary
                                ),
                                onClick = {
                                    mainViewModel.updateBottomSheetState(index, true)
                                }
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = mainMenuItem[index].name,
                                        fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                                        fontSize = 26.sp,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )

                                    if (state.value.BottomSheet[index]) {
                                        ModalBottomSheet(containerColor = MaterialTheme.colorScheme.primary,
                                            onDismissRequest = {
                                                mainViewModel.updateBottomSheetState(index, false)
                                            }
                                        ) {
                                            // Bottom sheet content
                                            LazyColumn {
                                                itemsIndexed(items.exam!!) { index, item ->
                                                    ExamsCard(exam = items.exam!![index])
                                                }
                                            }


                                        }

                                    }

                                }

                            }
//                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
//
//                        //controls the lazy size
//                        itemsIndexed(mainMenuItem) { index,item ->
//                            //hold the subject details
//                            Card(
//                                colors = CardDefaults.cardColors(
//                                    containerColor = MaterialTheme.colorScheme.primary
//                                ),
//                                modifier = Modifier
//                                    .padding(16.dp)
//                                    .wrapContentHeight()
//                                    .size(200.dp)
//                                    .width(100.dp)
//                                    .clickable {
//                                        mainViewModel.updateBottomSheetState(index, true)
//                                    },
//                            ) {
//                                //main card UI
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .padding(16.dp)
//                                        .wrapContentSize(Alignment.Center),
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.Center
//                                ) {
//                                    //solved @LT:Icon will be changed when we find all the required icons
//                                    //they will be in a list with the subject names
//                                    mainMenuItem[index].imagePath?.let {
//                                        Icon(
//                                            painter =
//                                            it,
//                                            contentDescription = null
//                                        )
//                                    }
//                                    //subject name
//                                    Text(
//                                        modifier = Modifier.padding(10.dp),
//                                        text = mainMenuItem[index].name,
//                                        fontSize = 24.sp,
//                                        color = Color.White,
//                                        textAlign = TextAlign.Center,
//                                        overflow = TextOverflow.Visible
//                                    )
//                                }
//                            }
//                            //this is an if statement which by using the state showBottomSheet
//                            //it will either show or hide the bottom sheet
//                            if (state.value.BottomSheet[index]) {
//                                ModalBottomSheet(containerColor = MaterialTheme.colorScheme.primary,
//                                    onDismissRequest = {
//                                        mainViewModel.updateBottomSheetState(index,false)
//                                    }
//                                ) {
//                                    // Bottom sheet content
//                                    Column(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(16.dp)
//                                    ) {
//                                        //todo @LT #qustion[not answered] || what to do here?
//                                        Row(modifier = Modifier.fillMaxWidth()) {
//                                            Text(text = "Date:")
//                                            Spacer(modifier = Modifier.width(8.dp))
//                                            Text(text = mainMenuItem[index].exam!!.date)
//                                        }
//                                        Row(modifier = Modifier.fillMaxWidth()) {
//                                            Text(text = "time:")
//                                            Spacer(modifier = Modifier.width(8.dp))
//                                            Text(text = mainMenuItem[index].exam!!.time)
//                                        }
//                                        Row(modifier = Modifier.fillMaxWidth()) {
//                                            Text(text = "Location:")
//                                            Spacer(modifier = Modifier.width(8.dp))
//                                            Text(text = mainMenuItem[index].exam!!.location)
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
                        }
                    }
                }
            }
        }
    }
}
