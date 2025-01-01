package com.example.schoolapp.Presentation.Screens

import android.content.Context
import android.content.Intent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.schoolapp.Data.MockData.Mock
import com.example.schoolapp.Data.MockData.Mock.HomeworkMock
import com.example.teacher_app.Presentation.Screens.ScreensPieces.ExpandableCard
import com.example.schoolapp.Presentation.VM.MainViewModel
import com.example.teacher_app.AppTheme
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.File


//=======================================================
//home work page: UI & logic                            =
//=======================================================
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeworkPage(
//    homeWorkPageState: MainViewModel = MainViewModel(),
//    navController: NavController? = null
//) {
//    //=======================================================
//    //variables: local & states                             =
//    //=======================================================
//    val state = homeWorkPageState.state.collectAsStateWithLifecycle()
//    var expanded by remember { mutableStateOf(false) }
//    var selectedOptionText by remember { mutableStateOf("Class A") }
//    val options = listOf("Class A", "Class B", "Class C")
//
//
//    //=======================================================
//    //UI & Logic                                            =
//    //=======================================================
//    AppTheme {
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxSize(),
//            color = MaterialTheme.colorScheme.primaryContainer
//        ) {
//            //main page UI:scaffold
//            Scaffold(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                //TAB: UI & Logic
//                topBar = {
//                    LargeTopAppBar(
//                        title = {
//                            //TAB Main UI: Row
//                            Row(modifier = Modifier.fillMaxWidth()) {
//                                //TAB title
//                                Text(
//                                    text = "Homework", fontSize = 50.sp,
//                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
//                                    modifier = Modifier.padding(start = 20.dp)
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
//
//                                navController?.popBackStack()
//                            }) {
//                                Icon(
//                                    modifier = Modifier.size(50.dp),
//                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
//                                    contentDescription = "Localized description",
//                                    tint = MaterialTheme.colorScheme.background
//                                )
//
//                            }
//
//                        }
//                    )
//
//                },
//                // Add content padding
//            ) { innerPadding ->
//                //main homeWork UI: column
//                Column(
//                    modifier = Modifier
//                        .padding(innerPadding)
//                        .fillMaxSize(),
//                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
//
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .padding(top = 10.dp)
//                            .width(350.dp),
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth(),
//                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
//                        ) {
//                            Text(
//                                selectedOptionText,
//                                modifier = Modifier.clickable { expanded = true },
//                                fontSize = 26.sp
//                            )
//                            DropdownMenu(
//                                expanded = expanded,
//                                onDismissRequest = { expanded = false }
//                            ) {
//                                options.forEach { selectionOption ->
//                                    DropdownMenuItem(text = { Text(selectionOption) },
//                                        onClick = {
//                                            selectedOptionText = selectionOption
//                                            expanded = false
//                                        }
//                                    )
//
//                                }
//                            }
//                            Spacer(modifier = Modifier.size(16.dp))
//                            Divider(
//                                modifier = Modifier
//                                    .width(300.dp)
//                                    .height(2.dp),
//                                color = MaterialTheme.colorScheme.background
//                            )
//                            Spacer(modifier = Modifier.size(16.dp))
//                            Column(modifier = Modifier.fillMaxSize()) {
//                                Box(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .clip(RoundedCornerShape(20.dp))
//                                        .background(MaterialTheme.colorScheme.primary)
//                                ) {
//                                    LazyColumn {
//                                        items(HomeworkMock.size) { index ->
//                                            // Placeholder will be replaced later with a student card which expands
//                                            // to show his homework
//                                            ExpandableCard(Data = HomeworkMock[index])
//                                        }
//                                    }
//                                }
//                            }
//                        }
//
//                    }
//
//
//                }
//
//
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeworkPage(
    homeWorkPageState: MainViewModel = MainViewModel(),
    navController: NavController? = null
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("الصف الأول") }
    val options = listOf("الصف الأول", "الصف الثاني", "الصف الثالث")

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
                                    text = "الواجبات",
                                    fontSize = 50.sp,
                                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                    modifier = Modifier.padding(end = 20.dp),
                                    textAlign = TextAlign.End
                                )
                            }
                        },
                        modifier = Modifier.clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        navigationIcon = {
                            IconButton(onClick = { navController?.popBackStack() }) {
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
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                selectedOptionText,
                                modifier = Modifier
                                    .clickable { expanded = true }
                                    .padding(8.dp),
                                fontSize = 26.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                options.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option, textAlign = TextAlign.End) },
                                        onClick = {
                                            selectedOptionText = option
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(HomeworkMock) { homework ->
                            HomeworkCard(homework)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeworkCard(homework: Mock.HomeworkItem) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = homework.subjectArabic,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.Done else Icons.Default.Done,
                    contentDescription = if (expanded) "عرض أقل" else "عرض المزيد",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = homework.descriptionArabic,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.End
                )
                Text(
                    text = "تاريخ التسليم: ${homework.dueDateArabic}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(top = 8.dp),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}