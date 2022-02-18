import java.util.Scanner;

public class Resposta3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Desafio Capgemini - Questão 03:");
		System.out.println();
		System.out.print("Insira a string de entrada: ");
		
		String str = scan.next();
		
		int n = Desafio.Questao3.num_pares_anagramas(str);
		System.out.print(
				String.format("Foram encontrados %d pares de anagramas ",n)
				);
		System.out.println("entre as substrings.");
		System.out.println();
		
		scan.close();
		
		System.out.println();
		System.out.println("Fim do programa Resposta 3.");
	}

}
