package com.example.schoolapp.Presentation.Screens

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
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
import androidx.compose.ui.tooling.preview.Preview
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
//solved @LT #simple || explain this fun logic here       =
//Will be removed
/* this is resoruces page where the user will be able to find resources to help him study
very similar to the exams page*/

//=======================================================
//solved @LT #simple || @(44:19)=="MainViewModel" variable name must start with small litter
//solved @LT #medium~#hard || try adding the @preview notation to be able to use the design tab
//quite lost here will return once i find the solution
@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourcesPage(mainviewmodel: MainViewModel = MainViewModel(),navController: NavController?=null) {

    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val state = mainviewmodel.Resourcesstate.collectAsStateWithLifecycle()
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
   //will change depending on number of subjects


    //create A state for the Resources page and add it to the main view model


    //=======================================================
    //Logic & UI,todo @MAS @LT #simple || add usage        =
    //=======================================================
    AppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.onPrimary,
                topBar = {
                    LargeTopAppBar(
                        title = {
                            //TAB Main UI: Row
                            Row(modifier = Modifier.fillMaxWidth()) {
                                //TAB title
                                Text(
                                    text = "Resources", fontSize = 60.sp,
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
                                if (navController != null) {
                                    navController.popBackStack()
                                }
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
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    {
                        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                            //here we will enter cards which will be the exams coming set in order from left to right depending of its date
                            itemsIndexed(mainMenuItem) { index,item ->
                                Card(colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                    modifier = Modifier.fillMaxSize()
                                        .padding(16.dp)
                                        .wrapContentHeight()
                                        .size(200.dp)
                                        .width(100.dp)
                                        .clickable {
                                            mainviewmodel.updateBottomSheetState2(index, true)

                                        }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .wrapContentSize(Alignment.Center),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        mainMenuItem[index].imagePath?.let {
                                            Icon(
                                                painter =
                                                it,
                                                contentDescription = null
                                            )
                                        }
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
                                if (
                                    state.value.BottomSheet1[index]
                                ) {
                                    ModalBottomSheet(
                                        containerColor = MaterialTheme.colorScheme.primary,
                                        onDismissRequest = {
                                            mainviewmodel.updateBottomSheetState2(index, false)
                                            // Handle dismiss

                                        }
                                    ) {
                                        // Bottom sheet content
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(16.dp)
                                        ) {
                                            Text(
                                                text = state.value.Subjects[index].name,
                                                fontSize = 30.sp
                                            )
                                            //Mock Data to preview how would they look like
                                            Text("Event Details", style = MaterialTheme.typography.titleLarge)
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Text("Date: 15/12/2023")
                                            Text("Time: 10:00 AM")
                                            Text("Location: Main Hall")
                                            Spacer(modifier = Modifier.height(16.dp))
                                            Divider()
                                            Spacer(modifier = Modifier.height(16.dp))
                                            Text("Description:", style = MaterialTheme.typography.headlineLarge)
                                            Text("This is a detailed description of the event.")

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

@Composable
@Preview
fun ResourcesPagePreview() {
    ResourcesPage()

}