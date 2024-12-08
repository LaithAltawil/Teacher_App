package com.example.schoolapp.Data

import android.net.Uri
import androidx.compose.ui.graphics.painter.Painter

//=======================================================
//Declaring data classes                               =
//=======================================================
//*todo @MAS #meduim || recreate data class to match the database
data class Homework(
    val Student_Name: String,
    val dueDate: String,
    val isCompleted: Boolean,
    val descvription: String? = null,
    val file: Uri? = null
)
//*todo @MAS #meduim || recreate data class to match the database
data class Assignment(
    val isCompleted: Boolean,
    val file: Uri? = null
)
//*todo @MAS #meduim || recreate data class to match the database
data class Subjects(
    val name: String,
    val imagePath: Painter? = null,
    val onClick: () -> Unit,
    val exam: List<Exam>?=null
)
data class MainMenuItems(
    val name: String,
    val imagePath: Painter? = null,
    val onClick: () -> Unit,
    val exam: Exam
)
data class MarksSubjects(
    val name: String,
    val imagePath: Painter? = null,
    val onClick: () -> Unit,
    val Marks: Marks? = null
)

data class StudentsClasses(
    val name: String,
    val onClick: () -> Unit,
    val Student: List<Studentmark>
)
data class Studentmark(
    val name: String,
    val FirstMark: Int,
    val SecondMark: Int,
    val FinalMark: Int=FirstMark+SecondMark,

)
/*LT: to add dates and events from the database to the Calender page
MAS: I think we won't need it but I'll leave it until its time 👍*/
//*todo @MAS #meduim || recreate data class to match the database
data class CalenderDays(
    val day: String,
    val event: String,
    val onClick: () -> Unit
)
/*LT:this is the main menu item data class, where you use it to give a name and an icon to each item in the main menu
LT: for the main memory*/
data class MainMenuItem(
    val title: String,
    val icon: Painter,
    val onClick: () -> Unit
)
//todo @MAS #meduim || recreate data class to match the database
data class Class(
    val subjectName: String,
    val teacher: String,
    val time: String
)
//todo @MAS #meduim || recreate data class to match the database
data class Exam(
    val subject: String,
    val date: String,
    val time: String,
    val location: String
)
data class Event(val title: String,
                 val num: Int,
                 val date: String,
                 val day: String,
                 val event: String
)
data class Marks(
    val firstMark:Int,
    val secondMark:Int,
    val finalMark:Int
)