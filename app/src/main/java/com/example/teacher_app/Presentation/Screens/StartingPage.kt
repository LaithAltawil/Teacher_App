package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.schoolapp.Presentation.Util.openWebsite
import com.example.schoolapp.R

//=======================================================
//Start Page: UI & logic                                =
//=======================================================
@Composable
fun StartPage(onSignInClick: () -> Unit={}) {

    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val context = LocalContext.current
    val url = "https://www.ammanhighschool.org/"

    //=======================================================
    // Logic & UI                                           =
    //=======================================================
    AppTheme {
        //main page UI: Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //the main UI: Box
            Box(
                modifier = Modifier
                    .width(370.dp)
                    .height(400.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
                    .background(color = MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                //main box UI: Column
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    //solved @LT #simple|| replace with logo

//                    Text(
//                        text = "Amman High School",
//                        color = MaterialTheme.colorScheme.onPrimary,
//                        style = MaterialTheme.typography.displayMedium,
//                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
//                        textAlign = TextAlign.Center
//                    )
                    //logo for a bit until
                    Image(
                        painter = painterResource(id = R.drawable.math),
                        contentDescription = "logo",
                        modifier = Modifier.size(150.dp)

                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    //sign in button
                    Button(
                        modifier = Modifier.size(275.dp, 43.dp),
                        onClick = {onSignInClick() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            contentColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Text(
                            text = "Sign in",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.size(15.dp))
                    //not a student button
                    Button(
                        onClick = { openWebsite(context, url) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            contentColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Text(
                            text = "Not A student? Click Here ",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun EnterPage(){
    StartPage()
}