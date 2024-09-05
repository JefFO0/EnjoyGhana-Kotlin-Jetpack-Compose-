package com.example.enjoyghana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.enjoyghana.ui.theme.AttractionPagesUI
import com.example.enjoyghana.ui.theme.AttractionPagesUI2
import com.example.enjoyghana.ui.theme.EnjoyGhanaTheme
import com.example.enjoyghana.ui.theme.NavigationMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnjoyGhanaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   NavScreen(7)
                }
            }
        }
    }
}