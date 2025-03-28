package com.kuglll.spotify.revamped

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kuglll.spotify.revamped.di.appModule
import com.kuglll.spotify.revamped.ui.screens.PostsScreen
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinApplication(application = { modules(appModule) }) {
                MaterialTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background,
                    ) {
                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                        ) { paddingValues ->
                            PostsScreen(
                                modifier = Modifier.padding(paddingValues),
                            )
                        }
                    }
                }
            }
        }
    }
}