package com.example.pegeorangoai
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardapioModel (

    val imagem: String,
    var titulo: String,
    val descricao: String

) : Parcelable