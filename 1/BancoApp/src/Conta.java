import java.util.ArrayList;

public class Conta extends Usuario{
	private int numeroConta;
	private int agencia;
	private double saldo;
	private ArrayList<String> extrato;
	private String login; // Registra o nome de login do usuario
	private int senha; // Registra a senha do usuario
	
	// Método construtor da classe Conta
	public Conta (String nome, String sobrenome, int idade, String cpf, String rg, int numeroConta, int agencia, double saldo, String login, int senha)
	{
		super(nome, sobrenome, cpf, rg, idade);
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.login = login;
		this.senha = senha;
		this.extrato = new ArrayList<String>();
	}
	
	// Retorna o numero da conta
	public int getNumeroConta() {
		return numeroConta;
	}
	
	// define o numero da conta
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	// Retorna o numero da agencia
	public int getAgencia() {
		return agencia;
	}
	
	// Define o numero da agencia
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	// Obtem o histórico de transações
	public void getExtrato() {
		for (int i = 0; i < extrato.size(); i++)
		{
			System.out.println(extrato.get(i));
		}
	}
	
	// Define o historico de extrato
	public void setExtrato(ArrayList<String> extrato) {
		this.extrato = extrato;
	}
	
	// Retorna o nome de usuario 
	public String getLogin() {
		return login;
	}
	
	// Define o nome de usuario
	public void setLogin(String login) {
		this.login = login;
	}
	
	// Retorna a senha
	public int getSenha() {
		return senha;
	}
	
	// Define a senha do usuario
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	// Metodo que permite a aplicação do método de saque
	public void saque(double valor)
	{
		if (saldo < valor)
			throw new IllegalArgumentException ("Saldo insuficiente!");
		
		this.saldo = saldo - valor;
		String registroOperacao = String.format("Saque: %,.2f%20sSaldo: %,.2f", valor, "", this.saldo);
		extrato.add(registroOperacao);
		setExtrato(extrato);
	}
	
	// Metodo que permite a realização de deposito
	public void deposito(double valor)
	{
		if (valor < 0)
			throw new IllegalArgumentException ("Valor inválido!");
		
		this.saldo = saldo + valor;
		
		String registroOperacao = String.format("Depósito: %,.2f%20sSaldo: %,.2f", valor, "", this.saldo);
		extrato.add(registroOperacao);
		setExtrato(extrato);
	}
	
	// Metodo que define o saldo
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	
	// Metodo que retorna o saldo atual
	public double getSaldo()
	{
		return saldo;
	}
	
	public String nomeCompleto ()
	{
		return String.format("%s %s%n", this.getNome(), this.getSobrenome());
	}
	
	// Criação da representação de Conta
	@Override
	public String toString()
	{
		return String.format("%nNumero de conta: %03d%nAgencia: %04d%nSaldo: %,.2f%nProprietario: %s%n",
				getNumeroConta(), getAgencia(), getSaldo(), (getNome() + " " + getSobrenome()) );
	}
	
}
