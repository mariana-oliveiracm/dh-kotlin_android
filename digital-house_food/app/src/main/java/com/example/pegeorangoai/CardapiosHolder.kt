package com.example.pegeorangoai

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_restaurante.*
import kotlinx.android.synthetic.main.card_recyclerview_cardapio.view.*


class CardapiosHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(cardapio: CardapioModel, onItemClicked: (Int) -> Unit) : Unit = with(itemView){
        Glide.with(itemView.context).load(cardapio.imagem).into(imgCardapios)
        findViewById<TextView>(R.id.tvTituloComida).text = cardapio.titulo

        cardCardapio.setOnClickListener {
            onItemClicked(this@CardapiosHolder.adapterPosition)
        }
    }
}
