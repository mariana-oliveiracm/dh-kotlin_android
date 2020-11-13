package com.example.pegeorangoai

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_recyclerview_restaurante.view.*

class RestauranteHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(restaurante: RestauranteModel, onItemClicked: (Int) -> Unit) : Unit = with(itemView){
        Glide.with(itemView.context).load(restaurante.imagem).into(imgRestaurante)
        findViewById<TextView>(R.id.txNomeRestaurante).text = restaurante.nome
        findViewById<TextView>(R.id.txEnderecoRestaurante).text = restaurante.endereco
        findViewById<TextView>(R.id.txHorarioRestaurante).text = restaurante.horario

        mvCard.setOnClickListener {
            onItemClicked(this@RestauranteHolder.adapterPosition)
        }
    }



}