package com.example.enjoyghana.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.enjoyghana.AttractionPages
import com.example.enjoyghana.AttractionPagesUI2Class
import com.example.enjoyghana.R
import com.example.enjoyghana.listOfAttractionPages
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun AttractionPagesUI2(
    attractionPage: List<AttractionPages> = listOfAttractionPages,
    currentPage: AttractionPagesUI2Class
//    navToImagesPage: (
//            attractionPage[currentPage]: AttractionPages,
//            ) -> Unit
) {
    val defaultPadding = WindowInsets.systemBars.asPaddingValues()
    val scrollState = rememberScrollState()
    val pics = attractionPage[currentPage.pageIndex].images.take(4)
    val lifecycleOwner: LifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val fontFamily = FontFamily(
        Font(R.font.suse_regular, FontWeight.Normal),
        Font(R.font.suse_thin, FontWeight.Thin),
        Font(R.font.suse_light, FontWeight.Light),
        Font(R.font.suse_extralight, FontWeight.ExtraLight),
        Font(R.font.suse_medium, FontWeight.Medium),
        Font(R.font.suse_bold, FontWeight.Bold),
        Font(R.font.suse_semibold, FontWeight.SemiBold),
        Font(R.font.suse_extrabold, FontWeight.ExtraBold),

    )

    LaunchedEffect(scrollState) {
        scrollState.animateScrollTo(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color
                    (attractionPage[currentPage.pageIndex].backgroundColour)
//                Color.Blue
            )
            .padding(8.dp, 32.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 64.dp,
                    topEnd = 64.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "IMAGES",
            fontSize = 24.sp,
            letterSpacing = 10.sp,
            color = Color(
                attractionPage[currentPage.pageIndex].colorOfInterestsBorder
            ),
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily,

        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Transparent)
                .wrapContentSize()
                .horizontalScroll(
                    state = rememberScrollState()
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            pics.forEach { image ->
                ImagesFunction(
                    currentImage = image
                )
            }

            SmallFloatingActionButton(
                onClick = {},
                containerColor = Color.White,
                contentColor = Color.Black,
            )
            {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Images Page"
                )
            }

        }
        Spacer(modifier = Modifier.height(24.dp))

        //        HISTORY SECTION
        Text(
            text = "HISTORY",
            fontSize = 24.sp,
            letterSpacing = 10.sp,
             color =Color(
                attractionPage[currentPage.pageIndex].colorOfInterestsBorder
            ),
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily,
            modifier = Modifier
                .padding(12.dp)
        )


        Text(
            text = attractionPage[currentPage.pageIndex].historyDescription,
            fontSize = 16.sp,
            maxLines = 8,
            letterSpacing = 4.sp,
            color = Color(
                attractionPage[currentPage.pageIndex].colorOfInterestsBorder
            ),
            fontWeight = FontWeight.Light,
            fontFamily = fontFamily,
            modifier = Modifier
                .background(color = Color.Black)
                .padding(12.dp)
                .wrapContentSize()
        )

        Spacer(modifier = Modifier.height(24.dp))

        //        INTERESTS SECTION
        Text(
            text = "INTERESTS",
            fontSize = 24.sp,
            letterSpacing = 10.sp,
            color =Color(
                attractionPage[currentPage.pageIndex].colorOfInterestsBorder
            ),
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily,
            modifier = Modifier
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // INTERESTS SECTION
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(24.dp),
                    color = Color(
                        attractionPage[currentPage.pageIndex].colorOfInterestsBorder
                    )
                )
                .background(Color.Transparent)
                .padding(12.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Some Facts",
                fontSize = 24.sp,
                letterSpacing = 2.sp,
                color = Color(
                    attractionPage[currentPage.pageIndex].colorOfInterestsBorder
                ),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = fontFamily,
            )

            Text(
                text = attractionPage[currentPage.pageIndex].factsSection,
                fontSize = 16.sp,
                maxLines = 10,
                letterSpacing = 4.sp,
                color = Color(
                    attractionPage[currentPage.pageIndex].colorOfInterestsBorder
                ),
                fontWeight = FontWeight.Normal,
                fontFamily = fontFamily,
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .padding(12.dp)
                    .wrapContentSize()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Videos",
                fontSize = 24.sp,
                letterSpacing = 4.sp,
                color =Color(
                    attractionPage[currentPage.pageIndex].colorOfInterestsBorder
                ),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = fontFamily,
            )

            // VIDEO OF ATTRACTION PLACE
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(12.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp,
                            bottomStart = 24.dp,
                            bottomEnd = 24.dp
                        )
                    ),
                factory = {
                    YouTubePlayerView(context = it).apply {
                        lifecycleOwner.lifecycle.addObserver(this)
                        addYouTubePlayerListener(
                            object : AbstractYouTubePlayerListener() {
                                override fun onReady(youTubePlayer: YouTubePlayer) {
                                    super.onReady(youTubePlayer)
                                    youTubePlayer.cueVideo(
                                        attractionPage[currentPage.pageIndex].youTubeVideoId,
                                        0f
                                    )
                                }
                            }
                        )
                    }
                }
            )


        }

        Spacer(modifier = Modifier.height(24.dp))
        //        CURRENT WEATHER SECTION
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "CURRENT WEATHER",
                fontSize = 24.sp,
                letterSpacing = 4.sp,
                fontFamily = fontFamily,
                color = Color(
                    attractionPage[currentPage.pageIndex].colorOfInterestsBorder
                ),
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "24°C",
                fontSize = 24.sp,
                letterSpacing = 4.sp,
                fontFamily = fontFamily,
                color =Color(
                    attractionPage[currentPage.pageIndex].colorOfInterestsBorder
                ),
                fontWeight = FontWeight.SemiBold
            )
        }

        // BOTTOM NAVIGATION BAR
//        Scaffold(
//            bottomBar = {
//                NavigationBar{
//                    items.forEachIndexed { index, item ->
//                        NavigationBarItem(
//                            selected = selectedPage.selectedTabIndex == index,,
//                            onClick = {
//                                selectedPage.selectedTabIndex = index
//                            },
//                            icon = {
//                                Icon(
//                                    painter = painterResource(id = item.icon),
//                                    contentDescription = null
//                                )
//                            }
//
//                    }
//                }
//            }
//        )

    }

}




@Composable
fun ImagesFunction(
    currentImage: Int,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .padding(8.dp)
            .clipToBounds()
            .clickable { },
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 24.dp
        ),

        ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
        )
    }
}