package com.example.schoolapp.Data.MockData

import com.example.schoolapp.Data.Class
import com.example.schoolapp.Data.Event
import com.example.schoolapp.Data.Exam
import com.example.schoolapp.Data.Homework
import com.example.schoolapp.Data.Marks
import com.example.schoolapp.Data.Studentmark
import com.example.schoolapp.Data.StudentsClasses

//=======================================================
//Object class for mock data                            =
//=======================================================
object Mock {

    //todo @MAS #medium || insert the complete homework mock data after the related task is finished
    class ClassInfo(
        val subjectName: String,
        val subjectNameArabic: String,
        val teacher: String,
        val teacherArabic: String,
        val time: String,
        val timeArabic: String
    )

    // Mock data for different days
    val sundayClasses = listOf(
        ClassInfo(
            "Mathematics", "الرياضيات",
            "Dr. Ahmed", "د. أحمد",
            "8:00 AM - 9:30 AM", "٨:٠٠ ص - ٩:٣٠ ص"
        ),
        ClassInfo(
            "Physics", "الفيزياء",
            "Dr. Mohammed", "د. محمد",
            "10:00 AM - 11:30 AM", "١٠:٠٠ ص - ١١:٣٠ ص"
        ),
        ClassInfo(
            "Chemistry", "الكيمياء",
            "Dr. Fatima", "د. فاطمة",
            "12:00 PM - 1:30 PM", "١٢:٠٠ م - ١:٣٠ م"
        )
    )

    val mondayClasses = listOf(
        ClassInfo(
            "Biology", "الأحياء",
            "Dr. Sarah", "د. سارة",
            "9:00 AM - 10:30 AM", "٩:٠٠ ص - ١٠:٣٠ ص"
        ),
        ClassInfo(
            "English", "اللغة الإنجليزية",
            "Mr. Hassan", "أ. حسن",
            "11:00 AM - 12:30 PM", "١١:٠٠ ص - ١٢:٣٠ م"
        )
    )
    val tuesdayClasses = listOf(
        ClassInfo(
            "Math",
            "الرياضيات",
            "Ms. Amina", "أ. أمينة",
            "9:00 AM - 10:30 AM",
            "٩:٠٠ ص - ١٠:٣٠ ص"
        ),
        ClassInfo(
            "Physics",
            "الفيزياء",
            "Dr. Khaled",
            "د. خالد",
            "11:00 AM - 12:30 PM",
            "١١:٠٠ ص - ١٢:٣٠ م"
        )
    )
    val wednesdayClasses = listOf( ClassInfo( "Chemistry", "الكيمياء", "Dr. Layla", "د. ليلى", "9:00 AM - 10:30 AM", "٩:٠٠ ص - ١٠:٣٠ ص" ), ClassInfo( "History", "التاريخ", "Mr. Ali", "أ. علي", "11:00 AM - 12:30 PM", "١١:٠٠ ص - ١٢:٣٠ م" ) )
    val thursdayClasses = listOf( ClassInfo( "Geography", "الجغرافيا", "Ms. Rania", "أ. رانيا", "9:00 AM - 10:30 AM", "٩:٠٠ ص - ١٠:٣٠ ص" ), ClassInfo( "Art", "الفنون", "Mr. Omar", "أ. عمر", "11:00 AM - 12:30 PM", "١١:٠٠ ص - ١٢:٣٠ م" ) )
    // Complete weekly schedule
    val ClasseList = listOf(
        sundayClasses,
        mondayClasses,
        tuesdayClasses,
        wednesdayClasses,
        thursdayClasses
        // Add more days as needed
    )
    data class HomeworkItem(
        val subject: String,
        val subjectArabic: String,
        val description: String,
        val descriptionArabic: String,
        val dueDate: String,
        val dueDateArabic: String
    )

    val HomeworkMock = listOf(
        HomeworkItem(
            "Mathematics",
            "الرياضيات",
            "Complete exercises 1-10 from Chapter 3",
            "إكمال التمارين ١-١٠ من الفصل الثالث",
            "Tomorrow, 2:00 PM",
            "غداً، ٢:٠٠ م"
        ),
        HomeworkItem(
            "Physics",
            "الفيزياء",
            "Write a lab report on the pendulum experiment",
            "كتابة تقرير مختبر عن تجربة البندول",
            "Next Monday, 9:00 AM",
            "الإثنين القادم، ٩:٠٠ ص"
        ),
        HomeworkItem(
            "Arabic",
            "اللغة العربية",
            "Read pages 45-50 and summarize the main ideas",
            "قراءة الصفحات ٤٥-٥٠ وتلخيص الأفكار الرئيسية",
            "Wednesday, 11:30 AM",
            "الأربعاء، ١١:٣٠ ص"
        )
    )

//    val HomeworkMock = listOf(
//        Homework(
//            "Laith Altawil",
//            "2023-12-24",
//            true,
//
//
//            ),
//        Homework(
//            "Laith Altawil",
//            "2023-12-24",
//            true,
//
//            ),
//        Homework(
//            "Laith Altawil",
//            "2023-12-24",
//            true,
//
//            ),
//        Homework(
//            "Laith Altawil",
//            "2023-12-24",
//            true,
//
//            ),
//        Homework(
//            "Laith Altawil",
//            "2023-12-26",
//            true,
//
//            ),
//        Homework(
//            "Laith Altawil",
//            "2023-12-24",
//            true,
//
//            ),
//        Homework(
//            "Laith Altawil",
//            "2023-12-24",
//            true,
//
//            )
//    )

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
    val Classes = listOf(
        StudentsClasses(
            "12th Grade",
            onClick = {},
            Student = listOf<Studentmark>(
                Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                )


            )
        ),
        StudentsClasses(
            "11th Grade",
            onClick = {},
            Student = listOf<Studentmark>(
                Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                )


            )
        ),
        StudentsClasses(
            "10th Grade",
            onClick = {},
            Student = listOf<Studentmark>(
                Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                ), Studentmark(
                    "Laith",
                    22,
                    22,
                )


            )

        )

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
        Event(
            "Networking Session",
            4,
            "18/12/2023",
            "Monday",
            "An opportunity to connect with other attendees."
        ),
        Event("Closing Ceremony", 5, "19/12/2023", "Tuesday", "The closing ceremony of the event.")
    )
    val Mark = listOf(
        Marks(
            22, 22, 50
        ),
        Marks(
            22, 22, 50
        ),
        Marks(
            22, 22, 50
        ),
        Marks(
            22, 22, 59
        ), Marks(
            22, 22, 59
        ), Marks(
            22, 22, 59
        ), Marks(
            22, 22, 59
        )

    )
}