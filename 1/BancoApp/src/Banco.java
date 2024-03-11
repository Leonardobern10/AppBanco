import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

	// Array para armazenar as contas criadas
	private ArrayList<Conta> contasCadastradas = new ArrayList<Conta>();

	// Metodo construtor
	public Banco(ArrayList<Conta> contasCadastradas) {
		this.contasCadastradas = contasCadastradas;
	}

	// Retorna cada conta cadastrada no array que armazena as contas
	public void getContasCadastradas(ArrayList<Conta> contas, String login) {
		// Faz um loop sobre todos as contas cadastradas
		for (Conta conta : contas)
		{
			if (conta.getLogin() == login)
				System.out.println(conta.toString());
		}
	}

	// Define o estado atual do array como sendo definitivo ao objeto
	public void setContasCadastradas(ArrayList<Conta> contasCadastradas) 
	{
		this.contasCadastradas = contasCadastradas;
	}

	// Permite a criação da conta com informações pessoais 
	// e cadastramento de credenciais
	public void criarConta() 
{
		// Gera um numero aleatorio 
		SecureRandom numeroAleatorio = new SecureRandom();
		
		// Permite ler valores inseridos pelo usuario
		Scanner input = new Scanner(System.in);

		
		int nroConta = 1 + numeroAleatorio.nextInt(100); // Gera um numero aleatorio entre 1 e 100 
		int agencia = 1 + numeroAleatorio.nextInt(4);  // Gera um numero aleatorio entre 1 e 4

		System.out.println("Informe seu nome:");   // prompt para o nome
		String nome = input.nextLine();   // Recebe o nome passado pelo usuario

		System.out.println("Informe seu sobrenome:");  // prompt para o sobrenome
		String sobrenome = input.nextLine();  // Recebe o sobrenome passado pelo usuario
		
		System.out.println("Informe sua idade:"); // prompt para a idade
		int idade = input.nextInt();  // recebe a isade passada pelo usuario
		input.nextLine();   // limpa o "input"

		System.out.println("Informe seu cpf:");  // prompt para o cpf
		String cpf = input.nextLine();   // recebe o cpf passado pelo usuario

		System.out.println("Informe seu rg:");
		String rg = input.nextLine();

		System.out.println("Informe seu nome de usuario:");
		String login = input.nextLine();

		System.out.println("Informe sua senha:");
		int senha = input.nextInt();

		Conta conta = new Conta(nome, sobrenome, idade, cpf, rg, nroConta, agencia, 0, login, senha);

		contasCadastradas.add(conta);
		setContasCadastradas(contasCadastradas);

	}
}