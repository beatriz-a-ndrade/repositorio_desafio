import java.util.*;

public class Resposta2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Desafio Capgemini - Questão 02:");
		System.out.println();
		System.out.print("Insira sua senha: ");
		
		String senha = scan.next();
		
		int n = Desafio.Questao2.n_para_senha_segura(senha);
		System.out.println(
				String.format("Faltam %d caracteres para uma senha segura.",n)
				);
		System.out.println();
		
		scan.close();
		
		System.out.println();
		System.out.println("Fim do programa Resposta 2.");
	}

}
