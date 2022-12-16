enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val nome : String, val email : String, val telefone : Long, val id : Int)


data class ConteudoEducacional(val nome : String, val duracaoCurso : Int, val nivel : Nivel)

data class Formacao(val nome : String,val duracaoFormacao : Int, val conteudos : List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    
    
    fun matricular(usuario : Usuario) {
        inscritos.add(usuario)
    }
}

data class MasterClass(val nome : String, val formacoes : List<Formacao>, val duracao : Int){
    
    val inscritos = mutableListOf<Usuario>()
    
    
    
    fun matricular(usuario : Usuario) {
        inscritos.add(usuario)
    }
}


fun main() {
    //Criar alguns cursos predefinidos
    
    val cursoKotlin = ConteudoEducacional("Desmistificando o Kotlin", 60, Nivel.BASICO)
    val cursoSQL = ConteudoEducacional("SQL sem segredos", 40, Nivel.BASICO)
    val cursoOO = ConteudoEducacional("Introdução a Orientação a Objetos", 30, Nivel.BASICO)
    val cursoFuncoesKotlin = ConteudoEducacional("O poder das funções em Kotlin", 60, Nivel.INTERMEDIARIO)
    
    //Criar formações
    
    val formacaoAndroid = Formacao("Formação Android", cursoKotlin.duracaoCurso + cursoFuncoesKotlin.duracaoCurso + cursoOO.duracaoCurso + cursoSQL.duracaoCurso, listOf(cursoKotlin, cursoFuncoesKotlin, cursoOO, cursoSQL)) 
    
    //Criando uma MasterClass
    
    val masterDevMobile = MasterClass("Master class Dev Mobile", listOf(formacaoAndroid), formacaoAndroid.duracaoFormacao)
    
    //Criando alguns inscritos
    
    val usuario1 = Usuario("Gelson", "gelson@gmail.com",67992401600, 1)
    val usuario2 = Usuario("Paula", "Paulaa@gmail.com", 67992401234, 2)
    val usuario3 = Usuario("Rodrigo", "digo@gmail.com", 67992401600, 3)
    
      
    //Realizar matriculas
    formacaoAndroid.matricular(usuario1)
    formacaoAndroid.matricular(usuario2)
    formacaoAndroid.matricular(usuario3)
    
    masterDevMobile.matricular(usuario1)
    
    //Testes
    
    //Teste para ConteudoEducacional
    
    println("Testes para ConteudoEducacional:\n")
    
    println("Nome do curso: ${cursoFuncoesKotlin.nome}")
    println("A duração do curso é de ${cursoFuncoesKotlin.duracaoCurso} Segundos")
    println("\n")
    
    //Teste para formações
    
    println("Testes para Formações:\n")
    
    println("Existem ${formacaoAndroid.inscritos.size} alunos inscritos na formação ${formacaoAndroid.nome}")
    println("Cursos da formação: ${formacaoAndroid.conteudos.map { it.nome }}")
    
    println("\n")
    
    
    //testes para masterClass
 	println("Testes para MasterClass:\n")
      
    println("A MasterClass ${masterDevMobile.nome} tem ${masterDevMobile.formacoes.size} formação(ões) inclusas")
    println("A MasterClass ${masterDevMobile.nome} tem ${masterDevMobile.inscritos.size} aluno(s) Matriculados") 
    println("\n")
    
}
