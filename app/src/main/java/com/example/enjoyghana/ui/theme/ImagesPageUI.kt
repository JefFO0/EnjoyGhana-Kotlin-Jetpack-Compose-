package com.example.enjoyghana.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.enjoyghana.AttractionPages

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesPageUI(
    attractionPage: AttractionPages){
    val pagerState = rememberPagerState { attractionPage.images.size }
   Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
    )
   {
        HorizontalPager(state = pagerState) {

        }
    }
}