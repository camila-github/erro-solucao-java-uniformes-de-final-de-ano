## Exercicio (Java): Uniformes de final de ano

O exercicio publicado é referente ao treinamento do Bootcamp Java Developer - Ordenação e Filtros em Java 
(https://digitalinnovation.one)

#### Descrição do Desafio:

O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano. Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou vermelho. Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma das turmas, relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.

#### Entrada: 

Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que indica a quantidade de uniformes a serem feitas para aquela turma. As próximas N linhas contém informações de cada um dos uniformes (serão duas linhas de informação para cada uniforme). A primeira linha irá conter o nome do estudante e a segunda linha irá conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e pelo tamanho do uniforme "P" "M" ou "G". A entrada termina quando o valor de N for igual a zero (0) e esta valor não deverá ser processado.

#### Saída: 

Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor em ordem ascendente, seguido pelos tamanhos em ordem descendente e por último por ordem ascendente de nome, conforme o exemplo abaixo.


Exemplos de Entrada  | Exemplos de Saída
------------- | -------------
9 | branco P Cezar Torres Mo
Maria Jose | branco P Maria Jose
branco P | branco M JuJu Mentina
Mangojata Mancuda | branco G Adabi Finho
vermelho P | branco G Severina Rigudinha
Cezar Torres Mo | vermelho P Amaro Dinha
branco P | vermelho P Baka Lhau
Baka Lhau | vermelho P Carlos Chade Losna
vermelho P | vermelho P Mangojata Mancuda
JuJu Mentina | 
branco M |
Amaro Dinha |
vermelho P |
Adabi Finho |
branco G |
Severina Rigudinha |
branco G |
Carlos Chade Losna |
vermelho P |
0 |


#### Java　

```java
//SOLUCAO 1
import java.io.IOException;
import java.util.*;

public class UniformesFinalDeAno {  
  private String nome;
  private String tamanhoUniforme;
  private String corUniforme;
  
  public UniformesFinalDeAno(String nome, String corUniforme, String tamanhoUniforme) {
    this.nome = nome;
    this.corUniforme = corUniforme;
    this.tamanhoUniforme = tamanhoUniforme;
  }

  public void imprimirInfoAluno() {
      System.out.println(this.corUniforme + " " + tamanhoUniforme + " " + nome);
  }
  
  public static void main(String[] args) throws IOException {  
    Scanner scanner = new Scanner(System.in);
    int casosTeste = scanner.nextInt(); 
    scanner.nextLine();
    ArrayList<UniformesFinalDeAno> arrayUniforme = new ArrayList<>(casosTeste);
    String nome, detalheUniforme, corUniforme, tamanhoUniforme;

    for(int i = 0; i < casosTeste; i++) {  
      nome = scanner.nextLine(); 
      detalheUniforme = scanner.nextLine();  
      corUniforme = detalheUniforme.split(" ")[0];
      tamanhoUniforme = detalheUniforme.split(" ")[1];
      arrayUniforme.add(new UniformesFinalDeAno(nome, corUniforme, tamanhoUniforme));
    }

    scanner.close();
    Collections.sort(arrayUniforme, new UniformeComparar());

    for(var item : arrayUniforme) item.imprimirInfoAluno();
  }

  static class UniformeComparar implements Comparator<UniformesFinalDeAno> {  
      public int compare(UniformesFinalDeAno alunoUm, UniformesFinalDeAno alunoDois) {  
      
      int resultado = alunoUm.corUniforme.compareTo(alunoDois.corUniforme);
      if(resultado == 0) {
        resultado = alunoUm.tamanhoUniforme.compareTo(alunoDois.tamanhoUniforme);
        
        if(resultado == 0) {  
          resultado = alunoUm.nome.compareTo(alunoDois.nome);
        } else {
          resultado = -resultado;
        }
      }
      return resultado;
    }
  }
}
```

