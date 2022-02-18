/**
 * Esta classe contem os algoritmos dos exercícios do 
 * Desafio de Programação Capgemini expressos como métodos 
 * static. A intenção é facilitar os testes desses algoritmos. 
 */

import java.util.*;

public class Desafio {
	
	
	/**
	 * Esta classe contém os métodos implementados como solução da Questão 1.
	 */
	public static class Questao1 {
		
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
	}
	
	
	/**
	 * Esta classe contém os métodos implementados como solução da Questão 2.
	 */
	public static class Questao2 {
		
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
	}
	
	
	/**
	 * Esta classe contém os métodos implementados como solução da Questão 3.
	 */
	public static class Questao3 {
		
		/**
		 * Recebe uma String 'str_in' e retorna uma ArrayList contendo
		 * todas as substrings possíveis.
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
		 * Questão 3 (método auxiliar):
		 * 
		 * Recebe duas String's 'str1' e 'str2' retorna um valor booleano indicando
		 *  se o par de entrada é um anagrama.
		 * 
		 * @param str1 primeira String de entrada.
		 * @param str2 segunda String de entrada.
		 * @return booleano indicando se o par é anagrama.
		 */
		public static boolean eh_anagrama(String str1, String str2) {
			
			char[] ch1 = str1.toCharArray();
			char[] ch2 = str2.toCharArray();
			
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			
			return Arrays.equals(ch1, ch2);
		}
		
		/**
		 * Questão 3 (método PRINCIPAL):
		 * 
		 * Recebe uma String 'str_in' e retorna a contagem de todos os pares de 
		 * anagrama possíveis entre suas substrings.
		 * 
		 * Obs: Esta função, como inferido pelo problema, não faz considerações
		 * acerca da repetição de subtrings!
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
	
}
