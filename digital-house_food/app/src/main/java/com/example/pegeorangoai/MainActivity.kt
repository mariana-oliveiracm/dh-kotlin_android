package com.example.pegeorangoai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantes = mutableListOf<RestauranteModel>()
        val cardapios1 = mutableListOf<CardapioModel>()
        val cardapios2 = mutableListOf<CardapioModel>()
        val cardapios3 = mutableListOf<CardapioModel>()
        val cardapios4 = mutableListOf<CardapioModel>()
        val cardapios5 = mutableListOf<CardapioModel>()
        val cardapios6 = mutableListOf<CardapioModel>()

        val cardapio1 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Danu_traditional_meal.jpg/800px-Danu_traditional_meal.jpg", "Comida Danu Tradicional", "Danu traditional meal para uma pessoa")
        val cardapio2 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Fried_chicken_meal.jpg/600px-Fried_chicken_meal.jpg", "Petiscos de Frango", "Petiscos de frango em vários modos, acompanha molho especial")
        val cardapio3 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Japanese_Meal.jpg/800px-Japanese_Meal.jpg", "Combo Comida Japonesa", "A japanese meal that includes some possible dangerous products")

        val cardapio4 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/e/ef/Fresh_Seafood.jpg", "Peixes Frescos", "A variety of fresh fish, mollusks, and crustaceans at a market")
        val cardapio5 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/e/e5/Pok_coy_seafood.png", "Frutos do Mar - Pok Coy", "Pok coy seafood")
        val cardapio6 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/e/ed/Nasi_goreng_seafood.png", "Frutos do Mar - Nasi Goreng", "Nasi goreng seafood")
        val cardapio7 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Kimchi_seafood_soup.jpg/600px-Kimchi_seafood_soup.jpg", "Sopa de Frutos do Mar Kimchi", "Kimchi seafood soup. Prato quente.")
        val cardapio8 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Seafood_linguine.jpg/800px-Seafood_linguine.jpg", "Frutos do Mar -  Linguine", "Seafood linguine para uma pessoa")

        val cardapio9 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/b/b6/Lafleur_restaurant_late_night_food_veggie_burgers.jpg", "Hamburguer Vegetariano", "Duas unidades para duas pessoas")
        val cardapio10 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Monstrous_Veggie_Burger.jpg/468px-Monstrous_Veggie_Burger.jpg", "Super Hamburguer Vegano", "Hamburguer grande para uma pessoa")
        val cardapio11 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Food_topic_image_Veggie_burger.jpg/800px-Food_topic_image_Veggie_burger.jpg", "Hamburguer Vegetariano - Lanche", "Hamburguer vegetariano e acompanha batatas")
        val cardapio12 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Veggie_casserole.jpg/800px-Veggie_casserole.jpg", "Caçarola Vegetariana", "Veggie casserole. Prato quente")

        val cardapio13 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Salad_platter.jpg/800px-Salad_platter.jpg", "Prato de Salada - Molho", "A garden salad consisting of lettuce, scallions, cherry tomatoes, olives, sun-dried tomatoes, cheese, cooked beets, bread, and salad dressing.")
        val cardapio14 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/6/6c/Crab_Louie_Salad.jpg", "Prato de Salada com Caranguejo", "A Crab Louie salad.")

        val cardapio15 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Dessert_-_Jaleo_-_Vegas.jpg/800px-Dessert_-_Jaleo_-_Vegas.jpg", "Sobremesa de Las Vegas", "Dessert t Jaleo in Las Vegas, Nevada")
        val cardapio16 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Kemalpa%C5%9Fa_Dessert.jpg/800px-Kemalpa%C5%9Fa_Dessert.jpg", "Sobremesa da Turquia", " Kemal Pasha dessert is a Turkish dessert dish. It originates from the district of Mustafa Kemalpaşa, Bursa, in Turkey. Traditionally it is made using a cheese variety that is particular to the region.")
        val cardapio17 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Dessert_-_Twist_by_Pierre_Gagnaire.jpg/800px-Dessert_-_Twist_by_Pierre_Gagnaire.jpg", "Sobremesa Twist", "Twist. The Mandarin Oriental.")
        val cardapio18 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Ice_Cream_Dessert.JPG/800px-Ice_Cream_Dessert.JPG", "Sorvete de Creme e Chocolate", "Ice cream dessert with chocolate ice, vanilla ice and pears.")
        val cardapio19 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Pavlova_Dessert_with_Fruit.jpg/450px-Pavlova_Dessert_with_Fruit.jpg", "Sobremesa Mix de Berries", "Pavlova dessert with strawberries, blueberries, raspberries and passionfruit and cream on a floral plate")
        val cardapio20 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/e/e1/Blue_Bayou_Dessert.jpg", "Sobremesa Editável Disney", "This was the dessert served after the event dinner. Everything on the plate is edible.\n" +"-Chocolate treasure chest filled with fresh fruit -White chocolate parchment with treasure map and event logo printed on it -Chocolate palm tree and cutlass -Brown sugar sand -Chocolate coins covered in gold leaf -Blue sugar syrup water\n" +"\n" +"-and the bar of gold was chocolate mousse covered with gold leaf.")
        val cardapio21 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Kakigori_Dessert.jpg/800px-Kakigori_Dessert.jpg", "Sobremesa do Japão", "Traditional Japanese shaved ice dessert, flavored with various sorts of fruit syrup such as strawberry, melon, lemon, cherry, blue raspberry")

        val cardapio22 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/NCI_Visuals_Food_Hamburger.jpg/800px-NCI_Visuals_Food_Hamburger.jpg", "Hamburguer Simples - Carne Bovina", "A hamburger with a rim of lettuce sitting on a black plate against a black background with a black and red napkin on a black and white-dotted tablecloth.")
        val cardapio23 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/%C3%9Cbergro%C3%9Fen_hamburger.jpg/450px-%C3%9Cbergro%C3%9Fen_hamburger.jpg", "Hamburguer Alemão", "Hamm Hamburg - An oversized hamburger variant with a thick layer of meat")
        val cardapio24 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Chipotle_chicken_avocado_sandwich_from_Earl_of_Sandwich.jpg/800px-Chipotle_chicken_avocado_sandwich_from_Earl_of_Sandwich.jpg", "Sanduíche de Frango com Chipotle", "Chipotle chicken avocado sandwich from Earl of Sandwich")
        val cardapio25 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/BLT_sandwich_%281%29.jpg/800px-BLT_sandwich_%281%29.jpg", "Tradicional BLT", "The BLT is a variety of sandwich containing Bacon, Lettuce, and Tomato. The sandwich traditionally has about three strips of fried bacon, leaves of lettuce (traditionally iceberg or romaine), and slices of tomato, all sandwiched between slices of bread or toast which is commonly spread with mayonnaise.")
        val cardapio26 = CardapioModel("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Submarine_sandwich_and_chips.jpg/800px-Submarine_sandwich_and_chips.jpg", "Sanduiche Submarino e batata", "Submarine sandwich and chips")

        cardapios1.addAll(listOf(cardapio1, cardapio2, cardapio3))
        cardapios2.addAll(listOf(cardapio4, cardapio5, cardapio6, cardapio7, cardapio8))
        cardapios3.addAll(listOf(cardapio9, cardapio10, cardapio11, cardapio12))
        cardapios4.addAll(listOf(cardapio13, cardapio14))
        cardapios5.addAll(listOf(cardapio15, cardapio16, cardapio17, cardapio18, cardapio19, cardapio20, cardapio21))
        cardapios6.addAll(listOf(cardapio22, cardapio23, cardapio24, cardapio25, cardapio26))

        val restaurante1 = RestauranteModel(cardapios1,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Couscous-1.jpg/800px-Couscous-1.jpg", "Prato Feito", "Endereço1", "Fecha às 17:00")
        val restaurante2 = RestauranteModel(cardapios2,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Garnelen_im_Verkauf_fcm.jpg/450px-Garnelen_im_Verkauf_fcm.jpg", "Sea Food Brasil", "Endereço2", "Fecha às 18:00")
        val restaurante3 = RestauranteModel(cardapios3, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Veggie_burger_flickr_user_bradleyj_creative_commons.jpg/800px-Veggie_burger_flickr_user_bradleyj_creative_commons.jpg", "ComidaVeggie.com", "Endereço3", "Fecha às 19:00")
        val restaurante4 = RestauranteModel(cardapios4, "https://upload.wikimedia.org/wikipedia/commons/a/ac/Salatteller.JPG", "Saladas Ultimate", "Endereçoo", "Fecha às 23:00")
        val restaurante5 = RestauranteModel(cardapios5, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Creme_Caramel.jpg/800px-Creme_Caramel.jpg", "Leve Sobremesas", "Endereço5", "Fecha às 21:00")
        val restaurante6 = RestauranteModel(cardapios6, "https://upload.wikimedia.org/wikipedia/commons/e/e8/Hamburger_sandwich.jpg", "Burguer do Indiano SA", "Endereço5", "Fecha às 21:30")

        restaurantes.addAll(listOf(restaurante1, restaurante2, restaurante3, restaurante4, restaurante5, restaurante6))

        findViewById<RecyclerView>(R.id.rvRestaurantes).apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RestauranteRecyclerAdapter(restaurantes){position ->
                val restauranteIntent = Intent(this@MainActivity, RestauranteActivity::class.java)
                val cardapioIntent = Intent(this@MainActivity, CardapioFragment::class.java)
                cardapioIntent.putExtra(KEY_INTENT_RESTAURANTE, restaurantes[position])
                restauranteIntent.putExtra(KEY_INTENT_RESTAURANTE, restaurantes[position])

                startActivity(restauranteIntent)
            }
        }
    }

    companion object {
        const val KEY_INTENT_RESTAURANTE = "restaurante"
    }
}