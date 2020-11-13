package com.example.pegeorangoai

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cardapio_fragment.*

class CardapioFragment : Fragment() {

    private lateinit var viewModel: CardapioViewModel
    private var restaurante: RestauranteModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cardapio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CardapioViewModel::class.java)

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        restaurante = activity?.intent?.getParcelableExtra(MainActivity.KEY_INTENT_RESTAURANTE)
        val cardapios = restaurante?.cardapios

        rvCardapios.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = cardapios?.let {
                CardapiosRecyclerAdapter(it) { position ->
                    val cardapioIntent = Intent(activity, ItemCardapioActivity::class.java)
                    cardapioIntent.putExtra(CardapioFragment.KEY_INTENT_CARDAPIO, cardapios[position])
                    startActivity(cardapioIntent)
                }
            }
        }
    }

    companion object {
        const val KEY_INTENT_CARDAPIO = "cardapio"
    }

}

    /*override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val cardapios = mutableListOf<CardapioModel>()

        val cardapio1 = CardapioModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Couscous-1.jpg/800px-Couscous-1.jpg",
            "Prato1",
            "Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1"
        )
        val cardapio2 = CardapioModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Garnelen_im_Verkauf_fcm.jpg/450px-Garnelen_im_Verkauf_fcm.jpg",
            "Prato2",
            "Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2"
        )
        val cardapio3 = CardapioModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Veggie_burger_flickr_user_bradleyj_creative_commons.jpg/800px-Veggie_burger_flickr_user_bradleyj_creative_commons.jpg",
            "Prato3",
            "Descrição3Descrição3Descrição3Descrição3Descrição3Descrição3"
        )
        val cardapio4 = CardapioModel(
            "https://upload.wikimedia.org/wikipedia/commons/a/ac/Salatteller.JPG",
            "Prato4",
            "Descrição4Descrição4Descrição4Descrição4Descrição4Descrição4Descrição4Descrição4"
        )
        val cardapio5 = CardapioModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Creme_Caramel.jpg/800px-Creme_Caramel.jpg",
            "Prato5",
            "Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5"
        )
        val cardapio6 = CardapioModel(
            "https://upload.wikimedia.org/wikipedia/commons/e/e8/Hamburger_sandwich.jpg",
            "Prato5",
            "Descrição6Descrição6Descrição6Descrição6"
        )

        cardapios.addAll(listOf(cardapio1, cardapio2, cardapio3, cardapio4, cardapio5, cardapio6))


        rvCardapios.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = CardapiosRecyclerAdapter(cardapios) { position ->
                val cardapioIntent = Intent(activity, ItemCardapioActivity::class.java)
                    cardapioIntent.putExtra(CardapioFragment.KEY_INTENT_CARDAPIO, cardapios[position])
                    startActivity(cardapioIntent)
            }
        }
    }

    companion object {
        const val KEY_INTENT_CARDAPIO = "cardapio"
    }

}*/

/* override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
     super.onViewCreated(itemView, savedInstanceState)

     restaurante = bundle.getParcelableExtra(MainActivity.KEY_INTENT_RESTAURANTE)
     val whichRestaurante = restaurante?.chave

     val cardapios = mutableListOf<CardapioModel>()

     if (whichRestaurante == 1) {

         val cardapio1 = CardapioModel(
             "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Couscous-1.jpg/800px-Couscous-1.jpg",
             "Prato1",
             "Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1Descrição1"
         )
         val cardapio2 = CardapioModel(
             "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Garnelen_im_Verkauf_fcm.jpg/450px-Garnelen_im_Verkauf_fcm.jpg",
             "Prato2",
             "Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2Descrição2"
         )
         val cardapio3 = CardapioModel(
             "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Veggie_burger_flickr_user_bradleyj_creative_commons.jpg/800px-Veggie_burger_flickr_user_bradleyj_creative_commons.jpg",
             "Prato3",
             "Descrição3Descrição3Descrição3Descrição3Descrição3Descrição3"
         )
         cardapios.addAll(listOf(cardapio1, cardapio2, cardapio3))
     } else if (whichRestaurante == 2) {
         val cardapio4 = CardapioModel(
             "https://upload.wikimedia.org/wikipedia/commons/a/ac/Salatteller.JPG",
             "Prato4",
             "Descrição4Descrição4Descrição4Descrição4Descrição4Descrição4Descrição4Descrição4"
         )
         val cardapio5 = CardapioModel(
             "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Creme_Caramel.jpg/800px-Creme_Caramel.jpg",
             "Prato5",
             "Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5Descrição5"
         )
         val cardapio6 = CardapioModel(
             "https://upload.wikimedia.org/wikipedia/commons/e/e8/Hamburger_sandwich.jpg",
             "Prato5",
             "Descrição6Descrição6Descrição6Descrição6"
         )

         cardapios.addAll(listOf(cardapio4, cardapio5, cardapio6))
     }


     rvCardapios.apply {
         layoutManager = GridLayoutManager(activity, 2)
         adapter = CardapiosRecyclerAdapter(cardapios) { position ->
             val cardapioIntent = Intent(activity, ItemCardapioActivity::class.java)
             if (!cardapios.isEmpty()) {
                 cardapioIntent.putExtra(
                     CardapioFragment.KEY_INTENT_CARDAPIO,
                     cardapios[position]
                 )
                 startActivity(cardapioIntent)
             } else {
                 Toast.makeText(activity, "Teste Toast", Toast.LENGTH_LONG).show()
             }
         }
     }
 }

 companion object {
     const val KEY_INTENT_CARDAPIO = "cardapio"
 }

}*/