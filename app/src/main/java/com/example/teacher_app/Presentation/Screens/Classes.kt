package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.schoolapp.Data.MockData.Mock.ClasseList
import com.example.teacher_app.AppTheme
import com.example.schoolapp.Data.MockData.Mock.ClassesList
import com.example.schoolapp.Data.MockData.Mock.classList
import com.example.schoolapp.Data.MockData.Mock.daysOfWeek
import com.example.schoolapp.Presentation.VM.MainViewModel

//=======================================================
//sessions table: Logic & UI                            =
//=======================================================
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun StudentClass(
//    mainViewModel: MainViewModel = MainViewModel(),
//    navController: NavController
//) {
//    //=======================================================
//    //variables: local & stats                              =
//    //=======================================================
//    val state by mainViewModel.Classesstate.collectAsState()
//    var selectedItemIndex by remember { mutableStateOf(0) }
//    val lazyListState = rememberLazyListState()
//    //=======================================================
//    // Logic & UI                                           =
//    //=======================================================
//    LaunchedEffect(selectedItemIndex) {
//        lazyListState.scrollToItem(selectedItemIndex)
//    }
//    AppTheme {
//        Surface(
//            modifier = Modifier
//                .fillMaxSize(),
//            color = MaterialTheme.colorScheme.primaryContainer
//        ) {
//            Scaffold(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                //TAB main UI & Logic
//                topBar = {
//                    LargeTopAppBar(
//                        title = {
//                            //TAB main :Row
//                            Row(modifier = Modifier.fillMaxWidth()) {
//                                //TAB title
//                                Text(
//                                    text = "Classes", fontSize = 60.sp,
//                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
//                                    modifier = Modifier.padding(start = 40.dp)
//                                )
//                            }
//                        },
//                        modifier = Modifier.clip(
//                            RoundedCornerShape(
//                                bottomEnd = 25.dp,
//                                bottomStart = 25.dp
//                            )
//                        ),
//                        colors =
//                        TopAppBarDefaults.topAppBarColors(
//                            containerColor = MaterialTheme.colorScheme.primary,
//                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
//                        ),
//                        navigationIcon = {
//                            IconButton(onClick = {
//                                navController.popBackStack()
//                            }) {
//                                Icon(
//                                    modifier = Modifier.size(50.dp),
//                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
//                                    contentDescription = "Localized description",
//                                    tint = MaterialTheme.colorScheme.background
//                                )
//                            }
//                        }
//                    )
//                },
//                // Add content padding
//            ) {
//                //Main page UI: column
//                Column(
//                    modifier = Modifier
//                        .padding(it)
//                        .fillMaxSize()
//                ) {
//                    //Main column
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(16.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        //child column of the lazyColumn
//
//                        //represent the day name
//                        //underway @LT #meduim || please consider changing the design here with @MAS
//                        //LT:please if you have any idea please provide because i am out of them :(
//                        /*MAS: you may do it like the whole day for the whole page
//                        * with buttons to switch
//                        * check session.png*/
//                        //Currently under work, currently did a day and will add a button to switch days
//                        Column(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(start = 10.dp, end = 10.dp),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//
//                            ) {
//                            Text(
//                                text = daysOfWeek[selectedItemIndex],
//                                fontSize = 24.sp,
//                                modifier = Modifier.padding(bottom = 8.dp)
//                            )
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(16.dp),
//                                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
//                            ) {
//                                Button(
//                                    onClick = {
//                                        selectedItemIndex =
//                                            (selectedItemIndex - 1).coerceAtLeast(0)
//                                    }, modifier = Modifier
//                                        .width(150.dp)
//                                        .height(40.dp)
//                                ) {
//                                    Text("Previous")
//                                }
//                                Button(
//                                    onClick = {
//                                        selectedItemIndex =
//                                            (selectedItemIndex + 1).coerceAtMost(classList.lastIndex + 1)
//                                    },
//                                    modifier = Modifier
//                                        .width(150.dp)
//                                        .height(40.dp),
//
//                                    ) {
//                                    Text("Next")
//                                }
//                            }
//                            Column(
//                                modifier = Modifier
//                                    .clip(RoundedCornerShape(26.dp))
//                                    .background(MaterialTheme.colorScheme.primary)
//                                    .fillMaxSize()
//                                    .padding(16.dp),
//                                horizontalAlignment = Alignment.CenterHorizontally,
//
//                                ) {
//                                LazyColumn(
//                                    state = lazyListState, modifier = Modifier
//                                        .fillMaxWidth()
//                                ) {
//
//                                    items(ClassesList) { List -> // Iterate through outer list
//                                        Column(
//                                            modifier = Modifier
//                                                .clip(RoundedCornerShape(36.dp))
//                                                .fillMaxSize().clickable {  }.
//                                                    padding(top = 8.dp, bottom = 8.dp)
//                                                .background(MaterialTheme.colorScheme.primaryContainer),
//                                            horizontalAlignment = Alignment.CenterHorizontally
//                                        ) {
//
//                                            Text(
//                                                text = List[selectedItemIndex].subjectName,
//                                                fontSize = 26.sp,
//                                                modifier = Modifier.padding(bottom = 8.dp),
//                                                color = MaterialTheme.colorScheme.onPrimaryContainer
//                                            )
//                                            Spacer(modifier = Modifier.height(8.dp))
//                                            Text(
//                                                text = List[selectedItemIndex].teacher,
//                                                fontSize = 22.sp,
//                                                modifier = Modifier.padding(bottom = 8.dp),
//                                                color = MaterialTheme.colorScheme.onPrimaryContainer
//
//                                            )
//                                            Spacer(modifier = Modifier.height(8.dp))
//                                            Text(
//                                                text = List[selectedItemIndex].time,
//                                                fontSize = 18.sp,
//                                                modifier = Modifier.padding(bottom = 8.dp),
//                                                color = MaterialTheme.colorScheme.onPrimaryContainer
//
//                                            )
//
//
//                                        }
//
//
//                                    }
//
//
//                                }
//
//                            }
//
//
//                        }
//                    }
//
//                }
//
//
//            }
//        }
//    }
//}

//
//@Composable
//@Preview
//fun StudentClassPreview() {
//    StudentClass()
//}

//TODO DONE ARABIC Version
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentClass(
    mainViewModel: MainViewModel = MainViewModel(),
    navController: NavController
) {
    val state by mainViewModel.Classesstate.collectAsState()
    var selectedItemIndex by remember { mutableStateOf(0) }
    val lazyListState = rememberLazyListState()

    LaunchedEffect(selectedItemIndex) {
        lazyListState.scrollToItem(selectedItemIndex)
    }

    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                topBar = {
                    LargeTopAppBar(
                        title = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = "الحصص",
                                    fontSize = 60.sp,
                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                    modifier = Modifier.padding(end = 40.dp),
                                    textAlign = TextAlign.End
                                )
                            }
                        },
                        modifier = Modifier.clip(
                            RoundedCornerShape(
                                bottomEnd = 25.dp,
                                bottomStart = 25.dp
                            )
                        ),
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    modifier = Modifier.size(50.dp),
                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = "رجوع",
                                    tint = MaterialTheme.colorScheme.background
                                )
                            }
                        }
                    )
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp, end = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = arabicDaysOfWeek[selectedItemIndex],
                            fontSize = 24.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    selectedItemIndex = (selectedItemIndex + 1).coerceAtMost(classList.lastIndex + 1)
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(40.dp)
                            ) {
                                Text("التالي")
                            }
                            Button(
                                onClick = {
                                    selectedItemIndex = (selectedItemIndex - 1).coerceAtLeast(0)
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(40.dp)
                            ) {
                                Text("السابق")
                            }
                        }

                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(26.dp))
                                .background(MaterialTheme.colorScheme.primary)
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            LazyColumn(
                                state = lazyListState,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                items(ClasseList) { list ->
                                    Column(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(36.dp))
                                            .fillMaxSize()
                                            .clickable { }
                                            .padding(top = 8.dp, bottom = 8.dp)
                                            .background(MaterialTheme.colorScheme.primaryContainer),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = list[selectedItemIndex].subjectNameArabic,
                                            fontSize = 26.sp,
                                            modifier = Modifier.padding(bottom = 8.dp),
                                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                                            textAlign = TextAlign.End
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = list[selectedItemIndex].teacherArabic,
                                            fontSize = 22.sp,
                                            modifier = Modifier.padding(bottom = 8.dp),
                                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                                            textAlign = TextAlign.End
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = list[selectedItemIndex].timeArabic,
                                            fontSize = 18.sp,
                                            modifier = Modifier.padding(bottom = 8.dp),
                                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                                            textAlign = TextAlign.End
                                        )
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

// Add this to your existing data class or create new ones
val arabicDaysOfWeek = listOf("الأحد", "الإثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة", "السبت")