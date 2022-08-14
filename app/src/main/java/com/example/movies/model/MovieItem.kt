package com.example.movies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem(

    val id: Int,
    val image: Image,
    val name: String,
    val summary: String

) : Parcelable