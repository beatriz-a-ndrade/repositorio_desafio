import java.util.*;

public class Exemplo {

	/**
	 * Exemplo de uso da classe Desafio.
	 */
	public static void main(String[] args) {
		
		// Quest�o 1:
		Scanner scan = new Scanner(System.in);
		System.out.println("Quest�o 1:");
		System.out.print("Tamanho da escada: ");
		
		int n_escada = scan.nextInt();
		Desafio.imprime_escada(n_escada);
		
		System.out.println();
		
		// Quest�o 2:
		System.out.println("Quest�o 2:");
		System.out.print("Insira sua senha: ");
		
		String senha = scan.next();
		
		int n_senha = Desafio.n_para_senha_segura(senha);
		System.out.println(String.format("Faltam %d caracteres para uma senha segura.", n_senha));
		
		System.out.println();
		
		// Quest�o 3:
		System.out.println("Quest�o 3:");
		System.out.print("Insira a palavra: ");
		
		String str = scan.next();
		
		int n_anagramas = Desafio.num_pares_anagramas(str);
		System.out.println(String.format("%d pares de anagramas foram encontrados.", n_anagramas));
		
		scan.close();
	}

}
