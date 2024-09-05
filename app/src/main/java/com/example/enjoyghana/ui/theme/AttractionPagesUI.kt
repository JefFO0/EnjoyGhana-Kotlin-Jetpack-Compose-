package com.example.enjoyghana.ui.theme

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.enjoyghana.AttractionPages
import com.example.enjoyghana.AttractionPagesUIClass
import com.example.enjoyghana.MVModel
import com.example.enjoyghana.R
import com.example.enjoyghana.listOfAttractionPages



@Composable
fun AttractionPagesUI(
    attractionPage: List<AttractionPages> = listOfAttractionPages,
    currentPage: AttractionPagesUIClass,
    navToBottomAttractionPage: (currentPage: Int) -> Unit,
    //    navMenu: () -> Unit,
) {

    val tabNumber = viewModel<MVModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MVModel(
                    num = currentPage.pageIndex
                ) as T
            }
        }
    )

    var selectedTabIndex by remember {
      tabNumber.selectedTabIndex
    }
    val pagerState = rememberPagerState { attractionPage.size }

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
//    var selectedTabIndex by remember { mutableIntStateOf(currentPage.pageIndex) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color
                    (attractionPage[selectedTabIndex].backgroundColour)
//                Color.Blue
            ),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // ATTRACTION PAGE IMAGE
        Box(
            modifier = Modifier
                .fillMaxHeight(.7f)
                .fillMaxWidth()
                .background(
                    Color
                        (attractionPage[selectedTabIndex].backgroundColour)
//                    Color.Green
                ),
            propagateMinConstraints = true,
            contentAlignment = Alignment.TopStart
        ) {
            Image(painter = painterResource(id = R.drawable.menuicon),
                contentDescription = "",
                modifier = Modifier
//                    .clickable { navMenu }
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
//                        Color.Green
                    )
            ) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Transparent)
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 64.dp,
                                bottomEnd = 64.dp
                            )
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = attractionPage[index].iconImage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomStart = 64.dp,
                                    bottomEnd = 64.dp
                                )
                            )
                            .clickable { navToBottomAttractionPage(index) }
                        ,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        // DESCRIPTION
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f)
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = attractionPage[selectedTabIndex].description,
                fontSize = 24.sp,
                color = Color(
                    attractionPage[selectedTabIndex].colorOfInterestsBorder
                ),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = fontFamily,
                maxLines = 2,
                textAlign = TextAlign.Center
            )
        }

        // LAUNCHED EFFECTS
        LaunchedEffect(selectedTabIndex) {
            pagerState.animateScrollToPage(
                page = selectedTabIndex,
                animationSpec = spring(
                    dampingRatio = .5f,
                    stiffness = 200f

                )
            )
        }

        LaunchedEffect(pagerState.targetPage, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress) {
                selectedTabIndex = pagerState.currentPage
            }
            if (pagerState.isScrollInProgress) {
                selectedTabIndex = pagerState.targetPage
            }
        }


        // IMPLEMENTING TAB ROW
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            modifier = Modifier
                .fillMaxHeight(.2f)
        )
        {
            attractionPage.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            text = item.description2,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = fontFamily,
                        )
                    },
                    selectedContentColor = Color.Gray,
                    unselectedContentColor = Color(item.descriptionColor)
                )
            }
        }


    }

}








