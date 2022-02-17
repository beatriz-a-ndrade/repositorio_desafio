import java.util.*;

public class Questao1 {
		
	/**
	 * Recebe um valor inteiro 'n' e imprime uma escada de tamanho 'n'.
	 * @param n Tamanho da escada.
	 * @return Não retorna nenhum valor (void).
	 */
	public static void imprime_escada(int n) {
		
		if(n < 0) {
			System.out.println("Não é permitido entradas menores que 0 (zero).");
			return;
		}
		
		String bs = " "; // Backspace
		String star = "*"; // Asterisco
		
		// Imprime na linha corrente i (n - i) X Backspace + i X Asterisco:
		for(int i = 1; i <= n; i++) {
			System.out.println(bs.repeat(n - i) + star.repeat(i));
		}
	}

	// Use as linhas de código abaixo para fazer um 
	// teste simples da função 'imprime_escada':
	
	/*
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Número de linhas (n): ");
		int n = scan.nextInt();
		
		imprime_escada(n);
		
		scan.close();
	}
	*/
}
