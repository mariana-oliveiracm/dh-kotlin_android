package com.example.pegeorangoai

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf

import com.bumptech.glide.Glide
import com.example.pegeorangoai.MainActivity.Companion.KEY_INTENT_RESTAURANTE
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity() {
    private var restaurante: RestauranteModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        setupRestaurante()
        initComponents()
    }

    private fun setupRestaurante() {
        restaurante = intent.getParcelableExtra(KEY_INTENT_RESTAURANTE)
        Glide.with(this).load(restaurante?.imagem).into(restauranteImagem)
        nomeRestaurante.text = restaurante?.nome
    }

    private fun loadFragment(fragment: Fragment, bundle: Bundle = Bundle()){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun initComponents(){
        supportActionBar?.hide()

        voltarRestaurante.setOnClickListener(){
            finish()
        }

        loadFragment(CardapioFragment())
    }




}