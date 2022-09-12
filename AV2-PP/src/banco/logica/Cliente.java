package banco.logica;

public class Cliente {
	// declarar atributos.
	private String nome;
	private String rg;
	private String cpf;
	private String endereco;
	
	public Cliente(String _nome,String _rg, String _cpf, String _endereco) {
		// metodo construtor com parametros.
		this.nome = _nome;
		this.rg = _rg;
		this.cpf = _cpf;
		this.endereco = _endereco;
	}
	// getters e setters.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
