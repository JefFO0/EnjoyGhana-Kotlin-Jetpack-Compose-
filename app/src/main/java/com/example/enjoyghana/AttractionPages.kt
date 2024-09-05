package com.example.enjoyghana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AttractionPages (
    val id: Int,
    val backgroundColour: Long,
    val iconImage: Int,
    val titleImage: Int,
    val images: List<Int>,
    val historyDescription: String,
    val factsSection: String,
    val youTubeVideoId: String,
    val colorOfInterestsBorder: Long,
    val description: String,
    val description2: String,
    val descriptionColor: Long,
):Parcelable

data class BottomNavigationIcons(
    val homeIcon: Int,
    val imagesPageIcon: Int,
    val locationIcon: Int,
)
