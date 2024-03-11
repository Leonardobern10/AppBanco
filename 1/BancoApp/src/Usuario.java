public class Usuario {
	
	private String nome; // Registra o nome do usuario
	private String sobrenome; // Registra o sobrenome do usuario
	private int idade; // Registra a idade do usuario
	private String cpf; // Registra o cpf do usuario
	private String rg; // Registra o rg do usuario
	
	// Método construtor 
	public Usuario (String nome, String sobrenome, String cpf, String rg, int idade)
	{		
		// Verifica se o dado é válido, garantindo que sejam positivos ou menores que 100
		if (idade < 0 || idade > 100)
			// Se não for, lança uma exceção que trata de dados fora dos parâmetros aceitaveis
			throw new IllegalArgumentException("Valor inserido inválido!");
			
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
		this.sobrenome = sobrenome;
	}

	// Retorna o nome
	public String getNome() {
		return nome;
	}

	// Define o nome
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Retorna a idade
	public int getIdade() {
		return idade;
	}

	// Define a idade
	public void setIdade(int idade) {		
		// Faz a verificação de aplicação novamente
		if (idade < 0 || idade > 100)
			throw new IllegalArgumentException("Valor inserido inválido!");
		this.idade = idade;
	}

	// Retorna o cpf
	public String getCpf() {
		return cpf;
	}

	// Define o cpf
	public void setCpf(String cpf) {		
		this.cpf = cpf;
	}

	// Retorna o rp
	public String getRg() {
		return rg;
	}

	// Define o rg
	public void setRg(String rg) {
		this.rg = rg;
	}

	// Retorna o sobrenome
	public String getSobrenome() {
		return sobrenome;
	}

	// Define o sobrenome
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
