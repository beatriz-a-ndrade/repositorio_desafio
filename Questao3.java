import java.util.*;

public class Questao3 {
	
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
	
	// Use as linhas de código abaixo para fazer um 
	// teste simples da função 'numpares_anagramas':
	/*

	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Insira a palavra: ");
		String str = scan.next();
		
		int cont = num_pares_anagramas(str);
		System.out.println(cont);
		
		scan.close();
		
	}
	*/
}
