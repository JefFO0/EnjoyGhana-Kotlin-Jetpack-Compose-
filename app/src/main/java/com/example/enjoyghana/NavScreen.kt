package com.example.enjoyghana

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.enjoyghana.ui.theme.AttractionPagesUI
import com.example.enjoyghana.ui.theme.AttractionPagesUI2
import com.example.enjoyghana.ui.theme.NavigationMenu

@Composable
fun NavScreen() {
val myController = rememberNavController()

   NavHost(navController = myController,
       startDestination = NavigationMenuClass ) {
       composable<NavigationMenuClass>{
           NavigationMenu(
               attractionPages = listOfAttractionPages,
               navigateToAttractionPage = {
                   myController.navigate(AttractionPagesUIClass(pageIndex = it))
               }
           )

       }

       composable<AttractionPagesUIClass>{ it ->
           val pageIndex = it.toRoute<AttractionPagesUIClass>()
           AttractionPagesUI(
               currentPage = pageIndex,
               navToBottomAttractionPage = {
                   myController.navigate(AttractionPagesUI2Class(pageIndex = it))
               },

           )

       }

       composable<AttractionPagesUI2Class>{
           val pageIndex = it.toRoute<AttractionPagesUI2Class>()
           AttractionPagesUI2(
               currentPage = pageIndex
           )

       }
   }
}





