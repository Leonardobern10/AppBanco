import java.util.ArrayList;
import java.util.Scanner;

public class BancoApp {
	public static void main(String[] args)
	{
		ArrayList<Conta> contas = new ArrayList<Conta>(); 		// Armazenamento das contas criadas
		Banco banco = new Banco(contas);		// Cria um instancia de banco
		Scanner input = new Scanner(System.in);		// Objeto que permite receber valores do usuario
		int opcao = 0;   // Inicializa a variavel que determina a opção escolhida pelo usuario no menu inicial
		
		while (opcao != 3) { // Determina que o programa executa enquanto a opçao "3" não é escolhida
			menuInicial(); // Função que executa o prompt inicial
			opcao = input.nextInt();  // Recebe um valor do usuario e o armazena na varivel opcao
			if (opcao == 1)
			{
				cadastrarConta(banco); // Função responsável por cadastrar contas
			}
			if (opcao == 2)
			{
				verificarCadastro(contas);  // Verifica se o usuario ja é cliente e mostra um menu personalizado
			}
		}
		input.close();
		
	}
	
	// Função que permite a criação de contas
	public static void cadastrarConta(Banco banco)
	{
		banco.criarConta();
	}
	
	// Função que mostra o prompt inicial ao usuario
	public static void menuInicial()
	{
		System.out.println("Olá! Bem vindo ao app do SEUBANCO!\n\n"
				+ "[1] - Criar conta\n" + "[2] - Já sou cliente\n" + "[3] - Sair\n");
	}
	
	// Função que verifica se um usuario ja é cliente e mostra um menu personalizado
	public static void verificarCadastro(ArrayList<Conta> contas)
	{
		Scanner input = new Scanner(System.in);  // Objeto que permite receber valores do usuario
		int contaAtual = 0;   // Variavel que armazena a posição da conta criada no array
		
		System.out.println("\nPor favor, informe seu login:");   // prompt para receber o login
		String login = input.nextLine();   // recebe a escrita do usuario na nova linha
		
		System.out.println("\nPor favor informe sua senha:\n"); // prompt para receber a senha
		int senha = input.nextInt();   // recebe a senha do usuario na nova linha
		
		// Procura os dados do usuario no Banco
		boolean encontrado = autenticacao(contas, login, senha, contaAtual);
		
		// Se encontrado...
		if (encontrado)
		{
			menuUsuario(encontrado, contaAtual, contas); // Função que trata o usuario encontrado
		}
		else
			System.out.println("As credenciais passadas são inválidas! Tente novamente ou crie uma conta!"); // Prompt para usuario nao encontrado
			
	}
	
	// Função que trata da autenticação do usuario
	public static boolean autenticacao(ArrayList<Conta> contas, String login, int senha, int contaAtual)
	{
		// Inicializa como não encontrando o usuario no Banco
		boolean encontrado = false;
		// Faz um loop pelo Banco
		for (Conta conta : contas)
		{
			// Determina se o login e a senha existem no Banco
			if (conta.getLogin().equals(login) && (conta.getSenha() == senha))
					{
						// Determina encontrado como "sim" (true)
						encontrado = true;
						// Retorna o indice no qual a conta se encontra 
						contaAtual = contas.indexOf(conta);
						// determina que o usuario foi encontrado
						return encontrado;
					}
		}
		// Caso o usuario nao tenha sido encontrado
		return encontrado;
	}
	
	// Função que armazena todas as operações do usuario
	public static void operacoes(int operacao, int contaAtual, ArrayList<Conta> contas)
	{
		Scanner input = new Scanner(System.in);
		switch (operacao)
		{
		case(1):
			System.out.println("Informe o valor do saque:");
			double valorSaque = input.nextDouble();
			contas.get(contaAtual).saque(valorSaque);
		break;
		
		case(2):
			System.out.println("Informe o valor do deposito:");
			double valorDeposito = input.nextDouble();
			contas.get(contaAtual).deposito(valorDeposito);
		break;
		
		case(3):
			System.out.printf("Saldo: %,.2f%n", contas.get(contaAtual).getSaldo());
		break;
		
		case(4):
			contas.get(contaAtual).getExtrato();
		break;
		
		}
		
	}
	
	// Faz a procura do usuario no Banco
	public static void menuUsuario(boolean encontrado, int contaAtual, ArrayList<Conta> contas)
	{
		if (encontrado) {
			System.out.println("Seja bem vindo de volta!");
			int operacao = 0;
			while (operacao != 5) {				
				Scanner input = new Scanner(System.in);
				System.out.printf("%20s%n%s%n%s%n%s%n%s%n%s%n",
						"Como poderiamos te ajudar hoje?", "[1] - Saque",
						"[2] - Deposito", "[3] - Consultar saldo", "[4] - Extrato",
						"[5] - Menu inicial");
				operacao = input.nextInt();
				operacoes(operacao, contaAtual,  contas);
			}
	}
	}
}
