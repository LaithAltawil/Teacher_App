package com.example.schoolapp.Data.MockData

import com.example.schoolapp.Data.Class
import com.example.schoolapp.Data.Event
import com.example.schoolapp.Data.Exam
import com.example.schoolapp.Data.Homework
import com.example.schoolapp.Data.Marks

//=======================================================
//Object class for mock data                            =
//=======================================================
object Mock {

    //todo @MAS #medium || insert the complete homework mock data after the related task is finished
    val HomeworkMock = listOf<Homework>(
        Homework(
            "Math",
            "Solve equations 1-20",
            "2023-12-24",
            false
        ),
        Homework(
            "Math",
            "Complete worksheet on fractions",
            "2023-12-28",
            true
        ),
        Homework(
            "Science",
            "Chapter 5 review questions",
            "2024-01-05",
            false
        ),
        Homework(
            "Science",
            "Prepare for science fair project",
            "2024-01-15", false
        ),
        Homework(
            "History",
            "Read chapter 3 and write a summary", "2023-12-22",
            true
        ),
        Homework(
            "English",
            "Essay on Shakespeare's Hamlet",
            "2024-01-10",
            false
        ),
        Homework(
            "English",
            "Poetry analysis worksheet",
            "2023-12-29",
            false
        )
    )
    //made for profile page will be deleted in the next days to be replaced with a better one
    val profilePageTable = listOf(
        listOf("name :- ", "Laith"),
        listOf("email :- ", "john.tyler@examplepetstore.com"),
        listOf("phone :- ", "0123456789"),
        listOf("address :- ", "123 Main Street"),
        listOf("gender :- ", "Male"),
        listOf("dob :- ", "01/01/2000"),
        listOf("nationality :- ", "Kenyan"),
        listOf("language :- ", "English"),
        listOf("religion :- ", "Christian"),
    )
    val daysOfWeek = listOf(
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday"
    )
    //todo @MAS #medium || insert the complete classList mock data after the related task is finished
    val classList = listOf(
        Class("Math", "Mr.Smith", "9:00 AM"),
        Class("Science", "Ms.Johnson", "10:30 AM"),
        Class("English", "Mrs.Williams", "1:00 PM"),
        Class("History", "Mr.Brown", "2:30 PM")
        // Add more classes as needed
    )
    val classList1 = listOf(
        Class("Science", "Ms.Johnson", "10:30 AM"),
        Class("English", "Mrs.Williams", "1:00 PM"),
        Class("History", "Mr.Brown", "2:30 PM"),
        Class("Math", "Mr.Smith", "9:00 AM"),
        Class("Science", "Ms.Johnson", "10:30 AM")
    )
    val classList2 = listOf(
        Class("Math", "Mr.Smith", "9:00 AM"),
        Class("Science", "Ms.Johnson", "10:30 AM"),
        Class("English", "Mrs.Williams", "1:00 PM"),
        Class("History", "Mr.Brown", "2:30 PM")

    )
    val ClassesList = listOf(
        classList,
        classList1,
        classList2

    )
    val mockExamList = listOf(
        Exam("Mathematics", "2023-12-15", "10:00 AM", "Room A101"),
        Exam("Physics", "2023-12-16", "02:00 PM", "Room B202"),
        Exam("Chemistry", "2023-12-17", "09:00 AM", "Lab C303"),
        Exam("Biology", "2023-12-18", "11:00 AM", "Hall D404"),
        Exam("Computer Science", "2023-12-19", "03:00 PM", "Room E505")
    )
    val PersonalInfo: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("Name", "Laith Altawil"),
        mutableListOf("Class", "12th"),
        mutableListOf("DOB", "11/01/2002"),
        mutableListOf("Student Number", "23120"),
        mutableListOf("Age", "19")
    )
    val ParentsDetails: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("Name", "Ahmad"),
        mutableListOf("Phone Number", "58280430"),
        mutableListOf("E-mail", "laithaltawil@gmail.com"),
        mutableListOf("Age", "50"),
        mutableListOf("relation", "Father")
    )
    val StudentDetails: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("Name", "Ahmad"),
        mutableListOf("Phone Number", "58380430"),
        mutableListOf("E-mail", "laithaltawil@gmail.com"),
        mutableListOf("Age", "50"),
        mutableListOf("relation", "Father")
    )
    val OtherDetails: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("Name", "Ahmad"),
        mutableListOf("Phone Number", "58310430"),
        mutableListOf("E-mail", "laithaltawil@gmail.com"),
        mutableListOf("Age", "50"),
        mutableListOf("relation", "Father")
    )
    val AllDetails: MutableList<MutableList<MutableList<String>>> = mutableListOf(
        StudentDetails,
        ParentsDetails,
        OtherDetails
    )
    val Titles = listOf(
        "Personal Information",
        "Parents Details",
        "Other Details"
    )
    val mockEvents = listOf(
        Event("Opening Ceremony", 1, "15/12/2023", "Friday", "The grand opening of the event."),
        Event("Workshop A", 2, "16/12/2023", "Saturday", "A hands-on workshop on topic A."),
        Event("Conference", 3, "17/12/2023", "Sunday", "A conference featuring industry experts."),
        Event("Networking Session", 4, "18/12/2023", "Monday", "An opportunity to connect with other attendees."),
        Event("Closing Ceremony", 5, "19/12/2023", "Tuesday", "The closing ceremony of the event.")
    )
    val Mark= listOf(
        Marks(
            22,22,50
        ),
        Marks(
            22,22,50
        ),
        Marks(
            22,22,50),
        Marks(
            22,22,59)
        ,Marks(
                22,22,59)
        ,Marks(
            22,22,59)
        ,Marks(
            22,22,59)

    )
}