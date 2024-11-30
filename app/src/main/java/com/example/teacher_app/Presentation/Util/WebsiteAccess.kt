package com.example.schoolapp.Presentation.Util

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

//used to open the given URL website
fun openWebsite(context: Context, url: String) {
    val customTabsIntent = CustomTabsIntent.Builder().build()
    customTabsIntent.launchUrl(context, Uri.parse(url))
}