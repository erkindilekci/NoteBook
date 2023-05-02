package com.erkindilekci.notebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.erkindilekci.notebook.noteaddscreen.NoteAddScreen
import com.erkindilekci.notebook.notedetailscreen.NoteDetailScreen
import com.erkindilekci.notebook.notelistscreen.NoteListScreen
import com.erkindilekci.notebook.room.Note
import com.google.android.gms.ads.MobileAds
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}

        setContent {
            ComposeNavigation()
        }
    }
}


@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "notelist") {
        composable("notelist") {
            NoteListScreen(navController = navController)
        }
        composable("noteadd") {
            NoteAddScreen(navController = navController)
        }
        composable("notedetail/{note}", arguments = listOf(
            navArgument("note") { NavType.StringType }
        )) {
            val json = it.arguments?.getString("note")
            val sentNote = Gson().fromJson(json, Note::class.java)
            NoteDetailScreen(navController = navController, sentNote = sentNote)
        }
    }
}

