import java.util.*;

public class Questao2 {
	
	/**
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
	
	// Use as linhas de c�digo abaixo para fazer um
	// teste simples da fun��o 'n_para_senha_segura':
	
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
