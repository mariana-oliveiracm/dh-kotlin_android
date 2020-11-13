package com.example.pegeorangoai


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RestauranteRecyclerAdapter(val restaurantes: List<RestauranteModel>, private val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<RestauranteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_recyclerview_restaurante, parent, false)
        return RestauranteHolder(view)
    }
    override fun getItemCount() = restaurantes.size

    override fun onBindViewHolder(holder: RestauranteHolder, position: Int) {
        holder.bind(restaurantes[position], onItemClicked)

    }

}