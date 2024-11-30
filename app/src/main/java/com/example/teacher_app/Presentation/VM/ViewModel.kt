package com.example.schoolapp.Presentation.VM

import androidx.lifecycle.ViewModel
import com.example.schoolapp.Presentation.VM.States.SignInPageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//todo @LT #simple|| please add usage of this file
class AppViewModel() : ViewModel() {
    //=======================================================
    //variables: local & states                             =
    //=======================================================
    private val _signInState = MutableStateFlow(SignInPageState())
    val signInState: StateFlow<SignInPageState> = _signInState.asStateFlow()

    //=======================================================
    //functions: private & public                           =
    //=======================================================
    /*type:             public
    * parameters:       username,
    * return type:      void
    * logic explain:    todo @LT #simple|| please add the usage*/
    fun onUserNameChange(userName: String) {
        _signInState.update { it.copy(UserName = userName) }
    }

    /*type:             public
    * parameters:       password,
    * return type:      void
    * logic explain:    todo @LT #simple|| please add the usage*/
    fun onPasswordChange(password: String) {
        _signInState.update { it.copy(password = password) }
    }

    /*type:             public
    * parameters:       none
    * return type:      void
    * logic explain:    todo @LT #simple|| please add the usage*/
    fun onPasswordVisibilityChange() {
        _signInState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }
}