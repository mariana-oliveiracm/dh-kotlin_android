fun main() {
    var nomeDoLivro1 = Livro(1, "Codigo Limpo", "Robert C. Martin", 2011, 89, 5, 0)
    var nomeDoLivro2 = Livro(1, "Codigo Limpo", "Robert C. Martin", 2011, 89, 5, 0)
    var nomeDoLivro3 = Livro(2, "Codigo meio/limpo", "Martin Robert ", 2019, 19, 2, 1)
    var nomeDoLivro4 = Livro(2, "Codigo meio/limpo", "Martin Robert ", 2019, 19, 2, 1)
    var nomeDoLivro5 = Livro(3, "Codigo Sujo", "Roberto Martinho", 2015, 189, 10, 2)
    var nomeDoLivro6 = Livro(3, "Codigo Sujo", "Roberto Martinho", 2015, 189, 10, 2)
    var umaLivrariaQualquer = LivrariaBliblioteca("Saraiva", 23092020)
    umaLivrariaQualquer.cadastrarLivro(nomeDoLivro1)
    umaLivrariaQualquer.cadastrarLivro(nomeDoLivro2)
    umaLivrariaQualquer.cadastrarLivro(nomeDoLivro3)
    umaLivrariaQualquer.cadastrarLivro(nomeDoLivro4)
    umaLivrariaQualquer.cadastrarLivro(nomeDoLivro5)
    umaLivrariaQualquer.cadastrarLivro(nomeDoLivro6)
    umaLivrariaQualquer.mostrarLivros()
    //umaLivrariaQualquer.consultarLivro("Codigo Limpo");
    //umaLivrariaQualquer.alugarLivro(1);
    //umaLivrariaQualquer.alugarLivro(2);
    //umaLivrariaQualquer.alugarLivro(3);
    umaLivrariaQualquer.verificarEstoque();
}
class LivrariaBliblioteca(var nome: String, var data: Int) {
    var listaDeLivros = mutableListOf<Livro>()
    fun cadastrarLivro(livro: Livro) {
        listaDeLivros.add(livro)
    }
    fun mostrarLivros() {
        println(listaDeLivros)
    }
    fun consultarLivro(filtro: Any) {
        val livroEncontrado = listaDeLivros.filter {
            it.codigo == filtro || it.titulo == filtro
        }
        if (livroEncontrado.size > 0) {
            println(livroEncontrado)
        } else {
            println("Livro/coleção não encontrado")
        }
    }
    fun alugarLivro(codigo: Int) {
        val livroEncontrado = listaDeLivros.filter {
            it.codigo == codigo
        }[0]
        if (livroEncontrado.status == 0) {
            livroEncontrado.status = 2;
            println("Você Comprou o livro: ${livroEncontrado.titulo}")
        } else {
            println("Livro/coleção não encontrado")
        }
    }
    fun comprarLivro(codigo: Int) {
        val livroEncontrado = listaDeLivros.filter {
            it.codigo == codigo
        }[0]
        if (livroEncontrado.status == 0) {
            livroEncontrado.status = 1;
            println("Você Alugou o livro: ${livroEncontrado.titulo}")
        } else {
            println("Livro/coleção não encontrado")
        }
    }
//     fun estadoLivro(status: Int){
//         return listaDeLivros.filter {
//             it.status == status
//         }
//     }
    fun verificarEstoque() {
        var livrosDisponiveis = listaDeLivros.filter { it.status == 0 }
        var qtdLivrosDisponiveis = livrosDisponiveis.size
        var livrosAlugados = listaDeLivros.filter { it.status == 1 }
        var qtdLivrosAlugados = livrosDisponiveis.size
        var livrosVendido = listaDeLivros.filter { it.status == 2 }
        var qtdLivrosVendido = livrosDisponiveis.size
//      var numberList = listOf(1,2,3,4,5)
// 		var sum = numberList.reduce { count, number -> count + number }
// 		println("The sum of the numbers is: " + sum) //15
        //println( livrosVendido.reduce { sum, e.precoDeVenda -> sum + e.precoDeVenda })
        println("Quantidade de livros disponiveis $qtdLivrosDisponiveis")
        println("Qauntidade de livros Alugados $qtdLivrosAlugados")
        println("QauntidadeqtdLivrosVendido $qtdLivrosVendido")
//         if (livroEncontrado.status == 0) {
//             livroEncontrado.status = 1;
//             println("Você Alugou o livro: ${livroEncontrado.titulo}")
//         } else {
//             println("Livro/coleção não encontrado")
//         }
    }
    fun cadastrarColecao() {}
}
//status 0 = disponivel, 1 = alugado, 2 vendido
class Livro(
    var codigo: Int, var titulo: String, var autor: String,
    var anoLancamento: Int, var precoVenda: Int,
    var precoAluguelDia: Int, var status: Int
) {
    override fun toString(): String {
        return "\n Código: $codigo, Título: $titulo, Autor: $autor, Ano: $anoLancamento, Preço: $precoVenda, Aluguel: $precoAluguelDia, Status: $status"
    }
}
// class Cliente(var nome: String, var rg: String, var historico: MutableList<Any>()) {
// }
// class Funcionario(var nome: String, var rg: String, var historico: MutableList<Any>()) {
// }