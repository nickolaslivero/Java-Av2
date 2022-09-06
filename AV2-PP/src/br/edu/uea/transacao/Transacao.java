package br.edu.uea.transacao;

import java.util.Date;

public class Transacao {
	private String operacao;
	private float valor;
	private Date dataHora;
	
	public Transacao(String _operacao, float _valor, Date _dataHora) {
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

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
}
