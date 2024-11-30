package com.example.teacher_app.Navigation

//=======================================================
// Binding every page with specific route               =
//=======================================================
/*LT: used to doing like this ever since i started android development
MAS: Sealed class is some way is data class*/
sealed class Screen(val route: String) {
    object StartPage : Screen("start_page")
    object SignInPage : Screen("sign_in_page")
    object MainMenu : Screen("main_menu")
    object CalenderPage : Screen("calender_page")
    object CounselorPage : Screen("counselor_page")
    object HomeworkPage : Screen("homework_page")
    object ProfilePage : Screen("profile_page")
    object SettingsPage : Screen("settings_page")
    object ResourcesPage : Screen("resources_page")
    object MarksPage : Screen("marks_page")
    object ExamsPage : Screen("exams_page")
    object ClassesPage : Screen("classes_page")
}