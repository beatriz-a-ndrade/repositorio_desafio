/**
 * Esta classe contem os algoritmos dos exerc�cios do 
 * Desafio de Programa��o Capgamini expressos como m�todos 
 * static. A inten��o � facilitar os testes desses algoritmos.
 * 
 * Quest�o 01: Esta quest�o � resolvida pelo m�todo 'imprime_escada' (ver documenta��o desse m�todo abaixo);
 * Quest�o 02: Esta quest�o � resolvida pelo m�todo 'n_para_senha_segura' (ver documenta��o desse m�todo abaixo);
 * Quest�o 03: Esta quest�o � resolvida pelo m�todo 'num_pares_anagramas' (ver documenta��o desse m�todo abaixo);
 * 
 */

import java.util.*;

public class Desafio {
	
	/**
	 * Quest�o 1:
	 * 
	 * Recebe um valor inteiro 'n' e imprime uma escada de tamanho 'n'.
	 * @param n Tamanho da escada.
	 * @return N�o retorna nenhum valor (void).
	 */
	public static void imprime_escada(int n) {
		
		if(n < 0) {
			System.out.println("N�o � permitido entradas menores que 0 (zero).");
			return;
		}
		
		String bs = " "; // Backspace
		String star = "*"; // Asterisco
		
		// Imprime na linha corrente i (n - i) X Backspace + i X Asterisco:
		for(int i = 1; i <= n; i++) {
			System.out.println(bs.repeat(n - i) + star.repeat(i));
		}
	}
	
	/**
	 * Quest�o 2:
	 * 
	 * Recebe uma String 'senha' e retorna um n�mero inteiro indicando 
	 * quantos caracteres faltam para uma senha segura.
	 * 
	 * @param senha Senha a ser avaliada.
	 * @return n N�mero de caracteres que faltam para uma senha segura.
	 */
	public static int n_para_senha_segura(String senha) {
		
		Boolean[] conds = new Boolean[4]; 							// Array de condi��es para uma senha segura
		String[] sc_list = new String("!@#$%^&*()-+").split(""); 	// Lista de caracteres especiais
		
		
		conds[0] = senha.chars().anyMatch(c -> Character.isDigit((char) c));		// Verifica se contem d�gitos
		conds[1] = senha.chars().anyMatch(c -> Character.isLowerCase((char) c));	// Verifica se contem letras min�sculas
		conds[2] = senha.chars().anyMatch(c -> Character.isUpperCase((char) c));	// Verifica se contem letras mai�sculas
		conds[3] = Arrays.stream(sc_list).anyMatch(senha::contains);				// Verifica se contem caracteres especiais
		
		
		// Conta quantas condi��es de 'conds' n�o foram atendidas:
		int cont = (int) Arrays.stream(conds).filter(cond -> cond == false).count();
		
		
		// Se o n�mero de condi��es n�o atendidas � maior do que a quantidade de caracteres
		// que faltam para o m�nimo de 6, ent�o n = cont; caso contr�rio, n ser� o n�mero de
		// caracteres que faltam para 6 caracteres:
		int n = cont <= 6 - senha.length()? 6 - senha.length():cont;
		
		// retorna 'n':
		return n;
	}
	
	/**
	 * Quest�o 3 (m�todo auxiliar):
	 * 
	 * Recebe uma String 'str_in' e retorna uma ArrayList contendo
	 * todas as substrings poss�veis.
	 * 
	 * @param str_in String de entrada.
	 * @return sub_str ArrayList contendo todas as substrings.
	 */
	public static ArrayList<String> all_substrings(String str_in) {
		
		ArrayList<String> sub_str = new ArrayList<String>();
		int len = str_in.length();
		
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j <= len; j++) {
				sub_str.add(str_in.substring(i, j));
			}
		}
		
		return sub_str;
	}
	
	/**
	 * Quest�o 3 (m�todo auxiliar):
	 * 
	 * Recebe duas String's 'str1' e 'str2' retorna um valor booleano indicando
	 *  se o par de entrada � um anagrama.
	 * 
	 * @param str1 primeira String de entrada.
	 * @param str2 segunda String de entrada.
	 * @return booleano indicando se o par � anagrama.
	 */
	public static boolean eh_anagrama(String str1, String str2) {
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		return Arrays.equals(ch1, ch2);
	}
	
	/**
	 * Quest�o 3 (m�todo PRINCIPAL):
	 * 
	 * Recebe uma String 'str_in' e retorna a contagem de todos os pares de 
	 * anagrama poss�veis entre suas substrings.
	 * 
	 * Obs: Esta fun��o, como inferido pelo problema, n�o faz considera��es
	 * acerca da repeti��o de subtrings!
	 * 
	 * @param str_in String de entrada.
	 * @return cont inteiro indicando a contagem de anagramas.
	 */
	public static int num_pares_anagramas(String str_in) {
		
		ArrayList<String> sub_str = all_substrings(str_in);
		
		int numel = sub_str.size();
		
		int cont = 0; // Contador
		
		for(int i = 0; i < numel; i++) {
			for(int j = i + 1; j < numel; j++) {
				if(eh_anagrama(sub_str.get(i), sub_str.get(j))) {
					
					// Caso queira saber os pares, descomente a linha abaixo:
					
					// System.out.println(String.format("%s, %s", sub_str.get(i), sub_str.get(j)));
					cont += 1;
				}
			}
		}
		
		return cont;
	}
	
}
