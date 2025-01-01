package com.example.schoolapp.Presentation.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teacher_app.AppTheme
import com.example.schoolapp.Presentation.VM.AppViewModel
import com.example.teacher_app.R


//=======================================================
//Sign in page: Logic & UI                              =
//=======================================================
@Composable
fun SignIn(viewModel: AppViewModel = AppViewModel(), onClick: () -> Unit = {}) {
    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val state = viewModel.signInState.collectAsState()

    //=======================================================
    //Logic & UI                                            =
    //=======================================================
    AppTheme {
        //Main page UI: Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .background(color = Color(0xFFFFE368)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //main UI: Box
            Box(
                modifier = Modifier
                    .width(360.dp)
                    .height(430.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(color = Color(0xFF6E5D00)),
                contentAlignment = Alignment.Center
            ) {
                //Main Box UI:Column
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "اهلا بك مجددا",
                        color = Color(0xFFFFFFFF),
                        style = MaterialTheme.typography.displayMedium,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    //TextFields = 2 and a button
                    TextField(
                        label = { Text(text = "اسم المستخدم") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        //save value to the ViewModel
                        value = state.value.UserName,
                        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                        onValueChange = {
                            viewModel.onUserNameChange(it)
                        })
                    Spacer(modifier = Modifier.size(15.dp))
                    TextField(
                        label = { Text(text = "كلمة السر") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        //store value to the viewModel
                        value = state.value.password,
                        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                        onValueChange = {
                            viewModel.onPasswordChange(it)
                        },
                        visualTransformation = if (state.value.isPasswordVisible)
                            VisualTransformation.None else PasswordVisualTransformation(),
                        //password eye logic
                        trailingIcon = {
                            val image = if (state.value.isPasswordVisible) {
                                painterResource(id = R.drawable.visibility)
                            } else {
                                painterResource(id = R.drawable.visibility_off)
                            }
                            val description =
                                if (state.value.isPasswordVisible) "Hide password" else "Show password"
                            IconButton(onClick = {
                                viewModel.onPasswordVisibilityChange()
                            }) {
                                Icon(painter = image, contentDescription = description)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Button(modifier = Modifier.clip(RoundedCornerShape(1.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFE368),
                            contentColor = Color(0xFFFFFFFF)
                            //solved @LT #simple-medium|| fix this...
                        ), onClick = {
                            onClick()
                        }) {
                        Text(
                            text = "تسجيل دخول",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun SignInPage() {
    SignIn()
}