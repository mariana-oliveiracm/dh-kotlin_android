package com.example.pegeorangoai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CardapiosRecyclerAdapter(val cardapios: List<CardapioModel>, private val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<CardapiosHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapiosHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_recyclerview_cardapio, parent, false)
        return CardapiosHolder(view)
    }

    override fun getItemCount() = cardapios.size

    override fun onBindViewHolder(holder: CardapiosHolder, position: Int) {
        holder.bind(cardapios[position], onItemClicked)
    }

}