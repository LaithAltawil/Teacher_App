package com.example.teacher_app.Presentation.Screens.ScreensPieces

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.example.schoolapp.Data.Homework
import com.example.teacher_app.R
import java.io.File


//=======================================================
//todo @LT #simple || explain this fun logic here       =
//=======================================================
//todo @LT #simple || @(43:20)=="Data" variable name must start with small litter
//todo @LT #medium~#hard || try adding the @preview notation to be able to use the design tab
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableCard(Data: Homework) {

    //=======================================================
    //variables: local & states                             =
    //=======================================================
    val context = LocalContext.current
    val file = File(context.filesDir, "my_file.pdf")
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri = result.data?.data // The selected file's URI
            // Handle the URI and save the file to the database
        }
    }
    var isExpanded by remember { mutableStateOf(false) }

    //=======================================================
    //Logic & UI                                            =
    //=======================================================
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .combinedClickable {
                isExpanded = !isExpanded
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Text(
                    text = Data.Student_Name,
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                //LT: this date will be replaced with the actual date when database is setup
                Text(
                    text = Data.dueDate,
                    style = MaterialTheme.typography.labelLarge
                )

            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = Data.Student_Name,
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Button(

                        enabled = if (Data.isCompleted) true else false,
                        onClick = {
                            val uri = FileProvider.getUriForFile(
                                context,
                                "${context.packageName}.fileprovider", file
                            )
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                setDataAndType(uri, "application/pdf") // Set MIME type accordingly
                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            context.startActivity(intent)
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            contentColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("Download File")
                    }

                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter =
                        if (Data.isCompleted) {
                            painterResource(id = R.drawable.baseline_check_circle_24)

                        } else {
                            painterResource(id = R.drawable.baseline_radio_button_unchecked_24)
                        }, contentDescription = null
                    )


                }
            }
        }
    }
}