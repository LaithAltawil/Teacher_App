package com.example.teacher_app.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.schoolapp.Presentation.Screens.CalenderPage
import com.example.schoolapp.Presentation.Screens.ExamsPage
import com.example.schoolapp.Presentation.Screens.HomeworkPage
import com.example.schoolapp.Presentation.Screens.MainMenu
import com.example.schoolapp.Presentation.Screens.MarksPage
import com.example.schoolapp.Presentation.Screens.Profile_page
import com.example.schoolapp.Presentation.Screens.ResourcesPage
import com.example.schoolapp.Presentation.Screens.SettingPage
import com.example.schoolapp.Presentation.Screens.SignIn
import com.example.schoolapp.Presentation.Screens.StartPage
import com.example.schoolapp.Presentation.Screens.StudentClass
import com.example.schoolapp.Presentation.VM.AppViewModel
import com.example.schoolapp.Presentation.VM.MainViewModel

//=======================================================
//navigation logic                                      =
//=======================================================
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {

    //=======================================================
    //viewModel                                             =
    //=======================================================
    val viewModel = viewModel<MainViewModel>()

    //=======================================================
    //navigation                                            =
    //=======================================================
    //function created from navController library*/
    val navController = rememberNavController()

    //navigation logic
    NavHost(navController = navController, startDestination = "Start") {

        //starter navigation map
        navigation(
            startDestination = Screen.StartPage.route,
            route = "Start"
        ) {

            //start page navigation
            composable(Screen.StartPage.route) {
                StartPage() {
                    //solved @LT #qustion|| here are you parsing the navigation as function?
                    //This function will be used to navigate to the sign in page
                    navController.navigate(Screen.SignInPage.route)
                }
            }

            //sign in page navigation & Home map navigation
            composable(Screen.SignInPage.route) { entry ->
                val viewModel = entry.AppViewModel<AppViewModel>(navController)
                SignIn(viewModel) {
                    //solved @LT #qustion|| here are you parsing the navigation map as function?
                    //we will use navcontroller to move the user to the Home route containing the rest of the app
                    navController.navigate("Home")
                }
            }
        }

        //home map navigation
        navigation(
            startDestination = Screen.MainMenu.route,
            route = "Home"
        ) {
            //main menu navigation
            composable(Screen.MainMenu.route) {
                //solved @LT #qustion|| here are you parsing the navigation as function?
                //passing the navcontroller to help me navigate from this menu to the rest of the app
                MainMenu(navController)
            }

            //profile page navigation
            composable(Screen.ProfilePage.route) {
                //solved @LT #qustion|| what is this?
                //whenever we press a button this composable will be used to navigate to the profile page
                Profile_page(
                    navController = navController
                )
            }


            composable(Screen.CalenderPage.route) {
                CalenderPage(
                    //solved @LT #qustion|| why didn't you parse the navigation instead of the viewModel?
                    //will parse the navigation to be able to return to the main menu after finishing because parsing it rn will prevent us from
                    //using preview
                    mainViewModel = viewModel,
                    navController = navController
                )
            }
            composable(Screen.CounselorPage.route) {
                //CounselorPage(
                    //todo @LT #qustion|| why didn't you parse the navigation instead of the viewModel?
                    //LT:Not needed to be parsed, but might parse it later depending on its need
                    //MAS: so I understand the need of injecting the viewModel but what is happening
                    //MAS: when you inject navigation or ProfilePage like in [89,17]?
                    //after some consideration i decided to parse navigation but after finishing each respective page
                  //  mainViewModel = viewModel
                //)
            }
            composable(Screen.HomeworkPage.route) {
                HomeworkPage(
                    //solved @LT #qustion|| why didn't you parse the navigation instead of the viewModel?
                    //LT:Not needed to be parsed, but might parse it later depending on its need
                    homeWorkPageState = viewModel,
                    navController = navController
                )
            }
            composable(Screen.SettingsPage.route) {
                SettingPage(
                    //solved @LT #qustion|| why didn't you parse the navigation instead of the viewModel?
                    //LT:Not needed to be parsed, but might parse it later depending on its need
                    mainviewmodel = viewModel,
                    navController = navController
                )

            }
            composable(Screen.MarksPage.route) {
                MarksPage(
                    //solved @LT #qustion|| why didn't you parse the navigation instead of the viewModel?
                    //MAS: note it was MainViewModel then I fixed it to mainviewmodel
                    ////LT:Not needed to be parsed, but might parse it later depending on its need
                    mainviewmodel = viewModel,
                    navController = navController
                )

            }
            composable(Screen.ResourcesPage.route) {
                ResourcesPage(
                    mainviewmodel = viewModel,
                    navController = navController
                )

            }
            composable(Screen.ExamsPage.route) {
                ExamsPage(
                    //solved @LT #qustion|| why didn't you parse the navigation instead of the viewModel?
                    mainViewModel = viewModel,
                    navController = navController
                )

            }
            composable(Screen.ClassesPage.route) {
                StudentClass(
                    mainViewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}

//todo @LT #meduim || explain this comments :)
//=======================================================
//obtain a ViewModel scoped to a navigation graph       =
//=======================================================
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.AppViewModel(
    navController: NavHostController,
): T {
    // Get the route of the parent navigation graph
    val navGraphRoute = destination.parent?.route ?: return viewModel()

    // Get the NavBackStackEntry for the parent navigation graph
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    // Return the ViewModel scoped to the parent entry
    return viewModel(parentEntry)
}

//=======================================================
//obtain a ViewModel scoped to a navigation graph       =                                                     =
//=======================================================
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.MainViewModel(
    navController: NavHostController,
): T {
    // Get the route of the parent navigation graph
    val navGraphRoute = destination.parent?.route ?: return viewModel()

    // Get the NavBackStackEntry for the parent navigation graph
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    // Return the ViewModel scoped to the parent entry
    return viewModel(parentEntry)
}