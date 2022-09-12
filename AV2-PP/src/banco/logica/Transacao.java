package banco.logica;

import java.text.DecimalFormat;
import java.util.Date;

public class Transacao {
	// declarar atributos.
	private String operacao;
	private float valor;
	private Date dataHora;
	private ContaCorrente contacorrente; 
	
	public Transacao(String _operacao, float _valor, Date _dataHora, ContaCorrente _contacorrente) {
		// metodo construtor com parametros.
		this.operacao = _operacao;
		this.valor = _valor;
		this.dataHora = _dataHora;
		setContaCorrente(_contacorrente);
	}
	//getters e setters.
	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getValor() {
		// transforma o valor float em uma String formatada.
		DecimalFormat formatter = new DecimalFormat("R$ #0.00");
	    return formatter.format(valor);
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
	
	public ContaCorrente getContaCorrente() {
		return contacorrente;
	}

	public void setContaCorrente(ContaCorrente contacorrente) {
		this.contacorrente = contacorrente;
	}
	
}
