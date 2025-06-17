package com.mertyigit0.todoapp.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDos(
    var id: Int ,
    var name:String,
    var image:String
): Parcelable
