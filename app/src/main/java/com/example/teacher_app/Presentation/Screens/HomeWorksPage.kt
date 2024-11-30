package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.schoolapp.Data.MockData.Mock.HomeworkMock
import com.example.schoolapp.Presentation.Util.ExpandableCard
import com.example.schoolapp.Presentation.VM.MainViewModel

//=======================================================
//home work page: UI & logic                            =
//=======================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeworkPage(homeWorkPageState: MainViewModel= MainViewModel(),navController: NavController) {
    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val state = homeWorkPageState.state.collectAsStateWithLifecycle()

    //=======================================================
    //UI & Logic                                            =
    //=======================================================
    AppTheme{
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
                                    text = "HomeWork", fontSize = 60.sp,
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
                //main homeWork UI: column
                Column(
                    modifier = Modifier.padding(innerPadding),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    //lazy column to hold the data logic & UI design
                    LazyColumn {
                        //controls the lazy size
                        items(HomeworkMock.size) { index ->
                            //done homeWork card UI & Logic
                            //todo @LT #medium|| please add more details like this:-
                            /*
                            * +---------------------------+
                            * |subject name     due date* |
                            * +---------------------------+
                            * due date can be the general format or day counter example: 2 day to submit       */
                            ExpandableCard(
                                Data = HomeworkMock[index],
                                //viewmodel = homeWorkPageState
                            )
                        }
                    }
                }
            }
        }
    }
}
//Cant use preview due to the need of navcontroller to be parsed from navhost
//@Composable
//@Preview
//fun HomeworkPagePreview() {
//    HomeworkPage()
//}