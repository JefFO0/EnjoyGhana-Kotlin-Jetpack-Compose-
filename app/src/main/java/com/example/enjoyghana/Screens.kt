package com.example.enjoyghana

import androidx.lifecycle.ViewModel
import kotlinx.serialization.Serializable

@Serializable
object NavigationMenuClass

@Serializable
data class AttractionPagesUIClass(
    var pageIndex : Int
)

@Serializable
data class AttractionPagesUI2Class(
    var pageIndex : Int
)