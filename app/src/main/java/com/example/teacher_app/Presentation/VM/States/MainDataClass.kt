package com.example.schoolapp.Presentation.VM.States

import androidx.compose.runtime.mutableStateListOf
import com.example.schoolapp.Data.Subjects
import com.example.schoolapp.Data.Homework

//Data source
sealed class MainDataClass{

    //todo @LT #simple|| "Id" [13:13] must start with small latter
    //todo @LT #simple|| add usage
    data class CounselorsPageState1(
        val isTopAppBarVisible: Boolean = false,
        var selectedDate: String = "",
        var Id: String = "",
        val openDialog: Boolean = false
    ) :MainDataClass()

    //todo @LT #simple|| "subjects" [22:21] must start with small latter
    //todo @LT #simple|| add usage
    data class ExamPageState1(
        val Subjects: List<String> = listOf(
            "Math",
            "Science",
            "History",
            "English",
            "Spanish",
            "French",
            "Arabic",
            "Computer Science"
        ),

        var BottomSheet: MutableList<Boolean>
        = mutableStateListOf(false, false, false, false, false, false, false)
        ) :MainDataClass()

    //todo @LT #simple|| add usage
    data class HomeworkPageState1(
        val homework: List<Homework> = emptyList(),
        val isTopBarVisible: Boolean = false,
    ) : MainDataClass()

    //todo @LT #simple|| "MarkspageState1" [45:21] must start with capital latter
    //todo @LT #simple|| "subjects" [46:13] must start with small latter
    //todo @LT #simple|| "MarksItems" [52:13] must start with small latter
    //todo @LT #simple|| add usage
    data class MarkspageState1(
        val Subjects: List<String> = listOf(
            "Math",
            "Science",
            "History",
            "English"
        ),
        val MarksItems: List<Subjects> = listOf(
            Subjects("Maths",onClick = { }) ,
            Subjects("Science",onClick = { }) ,
            Subjects("English",onClick = { }) ,
            Subjects("History",onClick = { }) ,
            Subjects("Arabic",onClick = { }) ,
            Subjects("Computer Science",onClick = { }) ,
            Subjects("Geography",onClick = { })
        ),
        val isTopBarVisible: Boolean = false,
        var BottomSheet: MutableList<Boolean>
        = mutableStateListOf(false, false, false, false, false, false, false)
    ) :MainDataClass()

    //todo @LT #simple|| add usage
    data class SettingsPageState1(
        var showAlertDialog: MutableList<Boolean>
        = mutableStateListOf(false, false, false, false, false, false, false)
    ) :MainDataClass()

    //todo @LT #simple|| "subjects" [82:13] must start with small latter
    //todo @LT #simple|| add usage
    data class ResourcesPageState(
        val isTopAppBarVisible: Boolean = false,
        val Subjects: List<Subjects> = listOf(
            Subjects("Maths",onClick = { }) ,
            Subjects("Science",onClick = { }) ,
            Subjects("English",onClick = { }) ,
            Subjects("History",onClick = { }) ,
            Subjects("Arabic",onClick = { }) ,
            Subjects("Computer Science",onClick = { }) ,
            Subjects("Geography",onClick = { })
        ),
        var BottomSheet1: MutableList<Boolean>
        = mutableStateListOf(false, false, false, false, false, false, false)
    ) : MainDataClass()

    //todo @LT #simple|| add usage
    data class ClassesPageState(
        val isTopAppBarVisible: Boolean = false,
    ) : MainDataClass()

    //todo @LT #simple|| add usage
    data class CalenderPage(
        val isTopAppBarVisible: Boolean = false,
        ) : MainDataClass()
}