import java.util.*;

public class Questao2 {
	
	/**
	 * Recebe uma String 'senha' e retorna um número inteiro indicando 
	 * quantos caracteres faltam para uma senha segura.
	 * 
	 * @param senha Senha a ser avaliada.
	 * @return n Número de caracteres que faltam para uma senha segura.
	 */
	public static int n_para_senha_segura(String senha) {
		
		Boolean[] conds = new Boolean[4]; 							// Array de condições para uma senha segura
		String[] sc_list = new String("!@#$%^&*()-+").split(""); 	// Lista de caracteres especiais
		
		
		conds[0] = senha.chars().anyMatch(c -> Character.isDigit((char) c));		// Verifica se contem dígitos
		conds[1] = senha.chars().anyMatch(c -> Character.isLowerCase((char) c));	// Verifica se contem letras minúsculas
		conds[2] = senha.chars().anyMatch(c -> Character.isUpperCase((char) c));	// Verifica se contem letras maiúsculas
		conds[3] = Arrays.stream(sc_list).anyMatch(senha::contains);				// Verifica se contem caracteres especiais
		
		
		// Conta quantas condições de 'conds' não foram atendidas:
		int cont = (int) Arrays.stream(conds).filter(cond -> cond == false).count();
		
		
		// Se o número de condições não atendidas é maior do que a quantidade de caracteres
		// que faltam para o mínimo de 6, então n = cont; caso contrário, n será o número de
		// caracteres que faltam para 6 caracteres:
		int n = cont <= 6 - senha.length()? 6 - senha.length():cont;
		
		// retorna 'n':
		return n;
	}
	
	// Use as linhas de código abaixo para fazer um
	// teste simples da função 'n_para_senha_segura':
	
	/*
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite sua senha: ");
		String senha = (String) scan.next();
		
		int n = n_para_senha_segura(senha);
		
		// Output:
		System.out.print(String.format("Faltam %d caracteres para uma senha segura.", n));
		
		scan.close();
	}
	*/

}
