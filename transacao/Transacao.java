package br.edu.uea.transacao;

public class Transacao {
	private String operacao;
	private float valor;
	private String dataHora;
	
	public Transacao(String _operacao, float _valor, String _dataHora) {
		this.operacao = _operacao;
		this.valor = _valor;
		this.dataHora = _dataHora;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
}
