package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.schoolapp.Data.CalenderDays
import com.example.schoolapp.Data.MockData.Mock.HomeworkMock
import com.example.schoolapp.Presentation.Util.ExpandableCard
import com.example.schoolapp.Presentation.VM.MainViewModel
import com.example.teacher_app.AppTheme


//=======================================================
//home work page: UI & logic                            =
//=======================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeworkPage(
    homeWorkPageState: MainViewModel = MainViewModel(),
    navController: NavController? = null
) {
    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val state = homeWorkPageState.state.collectAsStateWithLifecycle()
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("Class A") }
    val options = listOf("Class A", "Class B", "Class C")
    val calendarItems = listOf(
        CalenderDays("Main Events", "A huge Open Day for jobs in tech for the future", {}),
        CalenderDays("Counselor Schedule", "A huge Open Day for jobs in medicine for the future", {}),
        CalenderDays("Semester Schedule", "A huge Open Day for jobs in finance for the future", {})
    )

    //=======================================================
    //UI & Logic                                            =
    //=======================================================
    AppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            //main page UI:scaffold
            Scaffold(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                //TAB: UI & Logic
                topBar = {
                    LargeTopAppBar(
                        title = {
                            //TAB Main UI: Row
                            Row(modifier = Modifier.fillMaxWidth()) {
                                //TAB title
                                Text(
                                    text = "Homework", fontSize = 50.sp,
                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                    modifier = Modifier.padding(start = 20.dp)
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

                                navController?.popBackStack()
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
                //main homeWork UI: column
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally

                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .width(350.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                        ) {
                            Text(
                                selectedOptionText,
                                modifier = Modifier.clickable { expanded = true },
                                fontSize = 26.sp
                            )
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                options.forEach { selectionOption ->
                                    DropdownMenuItem(text = { Text(selectionOption) },
                                        onClick = {
                                            selectedOptionText = selectionOption
                                            expanded = false
                                        }
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.size(16.dp))
                            Divider(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(2.dp),
                                color = MaterialTheme.colorScheme.background
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                            Column(modifier = Modifier.fillMaxSize()) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(MaterialTheme.colorScheme.primary)
                                ) {
                                    LazyColumn {
                                        items(HomeworkMock.size) { index ->
                                            // Placeholder will be replaced later with a student card which expands
                                            // to show his homework
                                            ExpandableCard(Data = HomeworkMock[index])
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

//Cant use preview due to the need of navcontroller to be parsed from navhost
@Composable
@Preview
fun HomeworkPagePreview() {
    HomeworkPage()
}