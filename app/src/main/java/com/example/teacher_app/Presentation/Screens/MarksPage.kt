package com.example.schoolapp.Presentation.Screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import com.example.teacher_app.AppTheme
import com.example.schoolapp.Data.Exam
import com.example.schoolapp.Data.Marks
import com.example.schoolapp.Data.MarksSubjects
import com.example.schoolapp.Data.MockData.Mock.Classes
import com.example.schoolapp.Data.Subjects
import com.example.schoolapp.Presentation.VM.MainViewModel
import com.example.teacher_app.Presentation.Screens.ScreensPieces.StudentCard
import com.example.teacher_app.R

//Will be replaced in the later days

//=======================================================
//solved @LT #simple || explain this fun logic here       =
//a Lazy grid with each row having 2 items and when pressed it will open a bottom sheet with the exam name and details
//=======================================================
//solved @LT #simple || @(44:15)=="MainViewModel" variable name must start with small litter
//solved @LT #medium~#hard || try adding the @preview notation to be able to use the design tab
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarksPage(mainviewmodel: MainViewModel = MainViewModel(),
              navController: NavController?=null) {

    //todo @MAS #simple || please add the usage after answering the referred todo task


    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val state = mainviewmodel.Marksstate.collectAsStateWithLifecycle()
    val mainMenuItem = listOf(
        MarksSubjects("Maths", painterResource(id = R.drawable.math),
            Marks = Marks(25, 22, 50),
            onClick = {

            }
        ),
        MarksSubjects("Science",
            painterResource(id = R.drawable.science),
            Marks = Marks(22, 32, 50),
            onClick = {}),
        MarksSubjects("English", painterResource(id = R.drawable.english),
            Marks = Marks(32, 22, 60),
            onClick = {}),
        MarksSubjects(
            "History",
            painterResource(id = R.drawable.history),
            Marks = Marks(22, 29, 50),
            onClick = {}
        ),
        MarksSubjects(
            "Arabic",
            painterResource(id = R.drawable.arabic),
            Marks = Marks(22, 26, 50),
            onClick = {}
        ),
        MarksSubjects(
            "Computer Science",
            painterResource(id = R.drawable.science),
            Marks = Marks(29, 26, 50),
            onClick = {}
        ),
        MarksSubjects(
            "Geography",
            painterResource(id = R.drawable.geography),
            Marks = Marks(28, 22, 50),
            onClick = {}
        )
    )

    //=======================================================
    //Logic & UI                                            =
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
                    LargeTopAppBar(
                        title = {
                            //TAB Main UI: Row
                            Row(modifier = Modifier.fillMaxWidth()) {
                                //TAB title
                                Text(
                                    text = "My Students", fontSize = 60.sp,
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
            ) { innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    //lazy grid to hold the data logic & UI design
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        //controls the lazy size
                        itemsIndexed(Classes) { index, item ->
                            //hold the subject details
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clickable {
                                        mainviewmodel.updateBottomSheetState1(index, true)
                                    },
                            ) {
                                //main card UI
                                Row(modifier = Modifier
                                    .fillMaxSize()
                                    .padding(10.dp),horizontalArrangement = Arrangement.SpaceBetween
                                    ,verticalAlignment = Alignment.CenterVertically) {
                                    Text(text = item.name, fontStyle = MaterialTheme.typography.titleLarge.fontStyle, fontSize = 40.sp)
                                }



                            }
                            //this is an if statement which by using the state showBottomSheet
                            //it will either show or hide the bottom sheet
                            if (state.value.BottomSheet[index]) {
                                ModalBottomSheet(containerColor = MaterialTheme.colorScheme.primary,
                                    onDismissRequest = {
                                        mainviewmodel.updateBottomSheetState1(index, false)
                                    }
                                ) {
                                    // Bottom sheet content
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        LazyColumn {
                                            items(item.Student){
                                                items ->
                                                StudentCard()





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
    }

@Composable
@Preview
fun MarksPagePreview() {
    MarksPage()
}
//
//Text(
//text = items.name,
//fontSize = 40.sp
//)
//Spacer(modifier = Modifier.height(8.dp))
//Divider(modifier = Modifier
//.fillMaxWidth()
//.size(1.dp))
//Spacer(modifier = Modifier.height(8.dp))
////todo @LT #qustion[not answered] || what to do here?
//Row(modifier = Modifier.fillMaxWidth()) {
//    Text(text = "First Exam:", fontSize = 30.sp)
//    Spacer(modifier = Modifier.width(8.dp))
//    Text(
//        text = items.FirstMark.toString(),
//        fontSize = 30.sp
//    )
//}
//Row(modifier = Modifier.fillMaxWidth()) {
//    Text(text = "Second Exam:", fontSize = 30.sp)
//    Spacer(modifier = Modifier.width(8.dp))
//    Text(
//        text =items.SecondMark.toString(),
//        fontSize = 30.sp
//    )
//}
//Row(modifier = Modifier.fillMaxWidth()) {
//    Text(text = "Final Exam:", fontSize = 30.sp)
//    Spacer(modifier = Modifier.width(8.dp))
//    Text(
//        text = items.FinalMark.toString(),
//        fontSize = 30.sp
//    )
//}
