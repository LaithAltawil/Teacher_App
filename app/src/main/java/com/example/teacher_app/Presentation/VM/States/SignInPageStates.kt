package com.example.schoolapp.Presentation.VM.States

//todo @LT #simple|| "UserName" [06:09] must start with small latter
//todo @LT #simple|| add usage
//todo @LT #simple|| please move to the related file
data class SignInPageState(
    val UserName: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val signInError: String? = null,
    val isLoading: Boolean = false
)