import java.util.*;

public class Resposta1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Desafio Capgemini - Questão 01:");
		System.out.println();
		System.out.print("Insira o tamanho da escada (n): ");
		
		int n = scan.nextInt();
		
		Desafio.Questao1.imprime_escada(n);
		
		scan.close();
		
		System.out.println();
		System.out.println("Fim do programa Resposta 1.");
	}

}
