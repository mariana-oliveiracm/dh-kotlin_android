import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun main(args: Array<String>) {  

  var gustavo = ProfessorAdjunto("Gustavo", "Farias", 5, 55, 40);
  var teodoro = ProfessorTitular("Teodoro", "Fonseca", 32, 555, "Android");
  var renata = ProfessorAdjunto("Renata", "Andrade", 1, 77, 32);
  var talita = ProfessorTitular("Talita", "Oliveira", 32, 777, "UI Design");
  var alunaRaquel = Aluno("Raquel", "Andrade", 3);
  var alunoTadeu = Aluno("Tadeu", "Rocha", 4);
  var cursoKotlin = Curso("Kotlin Avançado", 1, 1);
  var cursoJava = Curso("Java para Android", 2, 110);
  var matriculaRaquelKotlin = Matricula(alunaRaquel, cursoKotlin);
  var escola = DigitalHouseManager();

  println("Alunos");
  println(alunaRaquel);
  println(alunoTadeu);
  println("\n\n\n");

  println("Cursos");
  println(cursoKotlin);
  println(cursoJava);
  println("\n");
  println("Adicionar aluno ao curso Kotlin");
  cursoKotlin.adicionarUmAluno(alunaRaquel);
  cursoKotlin.adicionarUmAluno(alunoTadeu);
  println("\n");
  println("Alunos no curso Java");
  cursoJava.adicionarUmAluno(alunaRaquel);
  cursoJava.adicionarUmAluno(alunoTadeu);
  cursoJava.verAlunos();
  cursoJava.excluirAluno(alunaRaquel);
  cursoJava.verAlunos();
  println("\n\n\n");

  println("Matricula");
  println(matriculaRaquelKotlin);
  println("\n\n\n");

  println("Professores");
  println(gustavo);
  println(teodoro);
  println(renata);
  println(talita);
  println("\n\n\n"); 

  println("Manager: registrar cursos");
  escola.registrarCurso(cursoKotlin);
  escola.registrarCurso(cursoJava);
  escola.criarCurso("React Native", 3, 140)
  escola.mostrarCursos();
  println("\n");
  println("Manager: registrar professores");
  escola.registrarProfessorAdjunto(renata);
  escola.registrarProfessorAdjunto(gustavo);
  escola.registrarProfessorTitular(teodoro);
  escola.registrarProfessorTitular(talita);
  escola.criarProfessorAdjunto("Marina", "Lima", 88);
  escola.criarProfessorTitular("Rafaela", "Sobrado", 888, "Javascript");
  escola.mostrarProfessores();
  escola.excluirProfessor(renata);
  escola.excluirProfessorPorCodigo(88);
  escola.mostrarProfessores();
  println("\n");
  println("Manager: registrar alunos");
  escola.registrarAluno(alunaRaquel);
  escola.registrarAluno(alunoTadeu);
  escola.criarAluno("Yara", "Otoni", 9)
  escola.mostrarAlunos();
  println("\n");
  println("Manager: matricular alunos");
  escola.matricularAluno(4, 1);
  escola.matricularAluno(9, 3);
  escola.matricularAluno(999, 3);
  escola.matricularAluno(9, 333);
  escola.mostrarMatriculas();
  println("\n");
  println("Manager: alocar professores");
  escola.alocarProfessores(1, 555, 55);
  escola.alocarProfessores(60, 555, 55);
  escola.alocarProfessores(1, 5555, 55);
  escola.alocarProfessores(1, 555, 55555);
}

class Aluno (var nome: String, var sobrenome: String, var codigoAluno: Int){
  override fun toString(): String {
    return "\nNome Completo: $nome $sobrenome | Código: $codigoAluno";
  }
    
}

class Curso(var nome: String, var codigoCurso: Int, var qtdMaxAlunos: Int){
  var alunosMatriculados = mutableListOf<Aluno>();
  var professorTitular : Professor? = null;
  var professorAdjunto : Professor? = null;

  fun adicionarUmAluno(aluno: Aluno){  
    if (alunosMatriculados.size < qtdMaxAlunos){
      alunosMatriculados.add(aluno);
    } else {
      println("Não foi possível de adicionar um aluno. Curso na sua capacidade máxima")
    }    
  }

  fun excluirAluno(aluno: Aluno){
    alunosMatriculados.remove(aluno);
  }
  fun verAlunos(){
    println(alunosMatriculados);
  }  

  fun detalhesProfessores(){
    println("O curso $nome tem os professores $professorTitular e $professorAdjunto")
  }

  override fun toString(): String {
    return "\nNome do Curso: $nome";
  }
}

class Matricula (var aluno: Aluno?, var curso: Curso?){
  val dataAtual = LocalDateTime.now();
  val formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
  val dataMatricula = dataAtual.format(formatador);
  
  override fun toString(): String {
    return "Aluno: $aluno | \nCurso: $curso \nData da Matrícula: $dataMatricula";
    }
}

interface Professor {
  var nome: String;
  var sobrenome: String;
  var tempoCasa: Int;
  var codigoProfessor: Int
}

class ProfessorTitular (nome: String, sobrenome: String, tempoCasa: Int, codigoProfessor: Int, especialidade: String) : Professor {

  override var nome = nome;
  override var sobrenome = sobrenome;
  override var tempoCasa = tempoCasa;
  override var codigoProfessor = codigoProfessor;
  var especialidade = especialidade;
  
  override fun toString(): String {
    return "\nNome Completo: $nome $sobrenome | Tempo de Casa: $tempoCasa | Código: $codigoProfessor | Especialidade: $especialidade";
  }
} 

class ProfessorAdjunto (override var nome: String, override var sobrenome: String, override var tempoCasa: Int, override var codigoProfessor: Int, var qtdHorasMonitoria: Int) : Professor {
  
  override fun toString(): String {
    return "\nNome Completo: $nome $sobrenome | Tempo de Casa: $tempoCasa | Código: $codigoProfessor | Quantidade de Horas em Monitoria: $qtdHorasMonitoria";
  }
} 

class DigitalHouseManager (){
  var listaAlunos = mutableListOf<Aluno>();
  var listaProfessores = mutableListOf<Professor>();
  var listaCursos = mutableListOf<Curso>();
  var listaMatriculas = mutableListOf<Matricula>();

  fun criarAluno(nome: String, sobrenome: String, codigoAluno: Int){
    var novoAluno = Aluno(nome, sobrenome, codigoAluno);
    registrarAluno(novoAluno);
  }  
  fun registrarAluno(aluno: Aluno){
    listaAlunos.add(aluno);
  }
  fun mostrarAlunos() {
    println(listaAlunos);
  }

  fun criarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int){
    var tempoCasa = 0;
    var qtdHorasMonitoria = 0;

    var novoProfessorAdjunto = ProfessorAdjunto(nome, sobrenome, tempoCasa, codigoProfessor, qtdHorasMonitoria);
    registrarProfessorAdjunto(novoProfessorAdjunto);
  }
  fun criarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
    var tempoCasa = 0;

    var novoProfessorTitular = ProfessorTitular(nome, sobrenome, tempoCasa, codigoProfessor, especialidade);
    registrarProfessorTitular(novoProfessorTitular);
  }
  fun registrarProfessorAdjunto(professorAdjunto: ProfessorAdjunto){
    listaProfessores.add(professorAdjunto);
  }
  fun registrarProfessorTitular(professorTitular: ProfessorTitular){
    listaProfessores.add(professorTitular);
  }
  fun excluirProfessor(professor: Professor){
    listaProfessores.remove(professor);
  }
  fun excluirProfessorPorCodigo(codigoExcluir: Int){
    var removerProfessor = listaProfessores.find{it.codigoProfessor == codigoExcluir};
    listaProfessores.remove(removerProfessor);
  }
  fun mostrarProfessores() {
    println(listaProfessores);
  }

  fun criarCurso(nome: String, codigoCurso: Int, qtdMaxAlunos: Int){
    var novoCurso = Curso(nome, codigoCurso, qtdMaxAlunos);
    registrarCurso(novoCurso);
  }  
  fun registrarCurso(curso: Curso){
    listaCursos.add(curso);
  }
  fun excluirCurso(curso: Curso){
    listaCursos.remove(curso);
  }
  fun mostrarCursos() {
    println(listaCursos);
  }

  fun matricularAluno(codigoAlunoAlocar: Int, codigoCursoAlocar: Int){
    var findAluno = listaAlunos.find{it.codigoAluno == codigoAlunoAlocar};
    var findCurso = listaCursos.find{it.codigoCurso == codigoCursoAlocar};
    
    if (findAluno != null && findCurso != null){
      var qtdMaxAlunosFindCurso = findCurso.qtdMaxAlunos.toInt();
      var qtdAlunosMatriculadosFindCurso = findCurso.alunosMatriculados.size.toInt();
      if (qtdAlunosMatriculadosFindCurso < qtdMaxAlunosFindCurso){
        var novaMatricula = Matricula(findAluno, findCurso);
        listaMatriculas.add(novaMatricula);
      } else {
        println("Não foi possível de adicionar um aluno. Curso na sua capacidade máxima")
      }
      } else if (findAluno == null){
        println("Aluno não encontrado")
      } else if (findCurso == null){
        println("Curso não encontrado")
    }
    
  }

  fun mostrarMatriculas() {
    println(listaMatriculas);
  }

  fun alocarProfessores(codigoCursoAlocar: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
    var findCurso = listaCursos.find{it.codigoCurso == codigoCursoAlocar};
    var findProfTitular = listaProfessores.find{it.codigoProfessor == codigoProfessorTitular};
    var findProfAdjunto = listaProfessores.find{it.codigoProfessor == codigoProfessorAdjunto};
    if (findCurso != null && findProfTitular != null && findProfAdjunto != null){
      findCurso.professorTitular = findProfTitular;
      findCurso.professorAdjunto = findProfAdjunto; 
      findCurso.detalhesProfessores();
    } else if (findCurso == null) {
      println("Curso não encontrado")
    } else if (findProfTitular == null) {
      println("Professor titular não encontrado")
    } else if (findProfAdjunto == null) {
      println("Professor adjunto não encontrado")
    }
    
  }

}