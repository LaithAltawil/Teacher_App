package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.schoolapp.Data.MockData.Mock.AllDetails
import com.example.schoolapp.Data.MockData.Mock.Titles
import com.example.schoolapp.Presentation.Screens.ScreensPieces.ProfilePageBox
import com.example.schoolapp.R

//solved @LT #qustion[not answered] || do you want me to organize this for you or leave it as is XD?
//LT: please do :))
//THE New Profile page design

@Composable
fun Profile_page(navController: NavController) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Scaffold(containerColor = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .width(450.dp)
                                .height(200.dp)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = androidx.compose.ui.Alignment.TopStart,


                            ) {
                            Button(onClick = { navController.popBackStack() }, modifier = Modifier.padding(top = 40.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onSecondary
                                )
                            ) {
                                Icon(
                                    Icons.Filled.ArrowBack,
                                    contentDescription = "Localized description",
                                    modifier = Modifier.size(40.dp)
                                )

                            }


                        }
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .size(200.dp)
                                .offset(x = (-10).dp, y = (-100).dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onPrimary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            )
                        ) {
                            Image(
                                painter = androidx.compose.ui.res.painterResource(id = R.drawable.contact_us),
                                contentDescription = null
                            )
                        }
                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Laith Altawil",
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier.offset(x = 125.dp, y = -90.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxSize(),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
                        ) {
                            LazyColumn(modifier = Modifier) {
                                itemsIndexed(AllDetails) { index, item->

                                    Box(
                                        modifier = Modifier
                                            .padding(bottom= 10.dp)
                                            .size(350.dp)
                                            .clip(RoundedCornerShape(26.dp))
                                            .background(MaterialTheme.colorScheme.primary),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        ProfilePageBox(Titles[index],AllDetails,index)



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
//@Composable
//@Preview
//fun preview(){
//    Profile_page()
//}


//Keep in case of errors
//Box(modifier = Modifier
//
//.clip(RoundedCornerShape(26.dp))
//.border(3.dp, Color.White,
//shape = RoundedCornerShape(26.dp))
//.size(337.dp)
//
//.background(MaterialTheme.colorScheme.primary)){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 20.dp),
//        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
//    ) {
//        Text(text = "Personal Information",
//            style = MaterialTheme.typography.headlineLarge,
//            fontWeight = FontWeight.Bold,
//            color = Color.White)
//        Spacer(modifier = Modifier.height(20.dp))
//        Row(horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
//            , modifier = Modifier) {
//            Text(
//                text = "Name : ",
//                style = MaterialTheme.typography.headlineSmall,
//                color = Color.White
//            )
//            Text(
//                text = "Laith Altawil",
//                style = MaterialTheme.typography.headlineSmall,
//                color = Color.White
//            )
//        }
//        Spacer(modifier = Modifier.height(10.dp))
//        Row {
//            Text(
//                text = "Age : ",
//                style = MaterialTheme.typography.headlineSmall
//                ,
//                color = Color.White
//            )
//            Text(
//                text = "20",
//                style = MaterialTheme.typography.headlineSmall
//                ,
//                color = Color.White
//            )
//
//        }
//        Spacer(modifier = Modifier.height(10.dp))
//        Row {
//            Text(
//                text = "Gender : ",
//                style = MaterialTheme.typography.headlineSmall
//                ,
//                color = Color.White
//            )
//            Text(
//                text = "Male",
//                style = MaterialTheme.typography.headlineSmall
//                ,
//                color = Color.White
//            )
//
//        }
//        Spacer(modifier = Modifier.height(10.dp))
//        Row {
//            Text(
//                text = "Email : ",
//                style = MaterialTheme.typography.headlineSmall
//                ,
//                color = Color.White
//            )
//            Text(
//                text = "",
//                style = MaterialTheme.typography.headlineSmall
//                ,
//                color = Color.White
//            )
//        }
//
//
//
//    }
//}