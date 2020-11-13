package com.example.pegeorangoai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item_cardapio.*
import kotlinx.android.synthetic.main.activity_restaurante.*

class ItemCardapioActivity : AppCompatActivity() {

    private var cardapio: CardapioModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_cardapio)

        setupItemCardapio()
        initComponents()
    }

    private fun setupItemCardapio() {
        cardapio = intent.getParcelableExtra(CardapioFragment.KEY_INTENT_CARDAPIO)
        Glide.with(this).load(cardapio?.imagem).into(cardapioImagem)
        tvNomePrato.text = cardapio?.titulo
        tvDescricaoPrato.text = cardapio?.descricao
    }

    private fun initComponents(){
        supportActionBar?.hide()

        voltarCardapio.setOnClickListener(){
            finish()
        }
    }

}