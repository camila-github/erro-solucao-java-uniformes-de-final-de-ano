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