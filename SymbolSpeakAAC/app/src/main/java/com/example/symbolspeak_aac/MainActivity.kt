package com.example.symbolspeak_aac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.symbolspeak_aac.CustomSentences.SentenceDatabase
import com.example.symbolspeak_aac.CustomSentences.SentenceViewModel
import com.example.symbolspeak_aac.History.History
import com.example.symbolspeak_aac.Navigation.*
import com.example.symbolspeak_aac.ui.theme.SymbolSpeakAACTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            SentenceDatabase::class.java,
            "sentences.db"
        ).build()
    }

    private val viewModel by viewModels<SentenceViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SentenceViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SymbolSpeakAACTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                val history by remember { mutableStateOf(History()) }

                val state by viewModel.state.collectAsState()
                Card(
                    modifier = Modifier.semantics { contentDescription = "appBar" },
                ){
                Scaffold(
                    modifier = Modifier.semantics { contentDescription = "appBar" },
                    scaffoldState = scaffoldState,
                    topBar = {
                        com.example.symbolspeak_aac.Navigation.AppBar(
                            navController = navController,
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            },
                            modifier = Modifier.semantics { contentDescription = "appBar" },
                        )
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home,
                                    modifier = Modifier.testTag("homeMenuItem")
                                ),
                                MenuItem(
                                    id = "CustomSentences",
                                    title = "Custom Sentences",
                                    contentDescription = "Go to custom sentences screen",
                                    icon = Icons.Default.Add,
                                    modifier = Modifier.testTag("customMenuItem")
                                ),
                                MenuItem(
                                    id = "Settings",
                                    title = "Settings",
                                    contentDescription = "Go to settings screen",
                                    icon = Icons.Default.Settings,
                                    modifier = Modifier.testTag("settingsMenuItem")
                                ),
                                MenuItem(
                                    id = "AboutAAC",
                                    title = "What is AAC?",
                                    contentDescription = "Learn about AAC screen",
                                    icon = Icons.Default.Info,
                                    modifier = Modifier.testTag("infoMenuItem")
                                ),
                            ),
                            onItemClick = {
                                when (it.id) {
                                    "home" -> {
                                        navController.navigate(NavRoute.Home.path)
                                        scope.launch {
                                            scaffoldState.drawerState.close()
                                        }
                                    }
                                    "Settings" -> {
                                        navController.navigate(NavRoute.Settings.path)
                                        scope.launch {
                                            scaffoldState.drawerState.close()
                                        }
                                    }
                                    "AboutAAC" -> {
                                        navController.navigate(NavRoute.Info.path)
                                        scope.launch {
                                            scaffoldState.drawerState.close()
                                        }
                                    }
                                    "CustomSentences" -> {
                                        navController.navigate(NavRoute.CustomSentences.path)
                                        scope.launch {
                                            scaffoldState.drawerState.close()
                                        }
                                    }
                                }
                            }
                        )
                    }
                ) { paddingValues ->
                    NavGraph(
                        modifier = Modifier.padding(
                            bottom = paddingValues.calculateBottomPadding()
                        ),
                        navController = navController,
                        state = state,
                        onEvent = viewModel::onEvent,
                        history = history
                    )
                }
            }
            }
        }
    }
}
