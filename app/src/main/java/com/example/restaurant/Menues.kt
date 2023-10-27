package com.example.restaurant

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menues(
    val imgMenu : Int,
    val namaMenu : String,
    var detailMenu : String,
    val imgDesc : Int,
    val descNama : String,
    val descDetail : String,
    val descHarga : String,

    ) : Parcelable
