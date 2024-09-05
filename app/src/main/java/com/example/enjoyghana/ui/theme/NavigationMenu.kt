package com.example.enjoyghana.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.enjoyghana.AttractionPages
import com.example.enjoyghana.R


@Composable
fun NavigationMenu(
    attractionPages:List<AttractionPages>,
    modifier: Modifier = Modifier,
    navigateToAttractionPage: (currentPage: Int) -> Unit
)
{
    val lazyGridState = rememberLazyGridState()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ghflag),
            contentDescription = "Gh Flag",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Transparent
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .background(color = Color.Transparent),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = lazyGridState,
                    contentPadding = PaddingValues(all = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    itemsIndexed(attractionPages) { index, item ->
                        NavIcons(
                            currentPageIndex = index,
                            attractionPage = item,
                            navigateToAttractionPage = navigateToAttractionPage
                        )
                    }
                }
            }
        }
    }
}


    @Composable
    fun NavIcons(
        currentPageIndex: Int,
        attractionPage: AttractionPages,
        navigateToAttractionPage: ( currentPage : Int) -> Unit
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
                .height(150.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 64.dp,
                        bottomStart = 64.dp,
                        bottomEnd = 0.dp
                    )
                )
                .clickable { navigateToAttractionPage(currentPageIndex) },
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 64.dp,
                bottomStart = 64.dp,
                bottomEnd = 0.dp
            ),
            border = BorderStroke(6.dp, Color.Black)
        ) {
            Image(
                painter = painterResource(id = attractionPage.iconImage),
                contentDescription = "",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()

            )
        }
    }


