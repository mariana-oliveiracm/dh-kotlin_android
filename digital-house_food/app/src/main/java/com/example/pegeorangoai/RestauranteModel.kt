package com.example.pegeorangoai

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestauranteModel (

    val cardapios: List<CardapioModel>,
    val imagem: String,
    val nome: String,
    val endereco: String,
    val horario: String

) : Parcelable