package br.edu.uea.contacorrente;

import br.edu.uea.cliente.Cliente;
import br.edu.uea.transacao.Transacao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class ContaCorrente {
	private float saldo;
	private String numeroConta;
	private String numeroAgencia;
	private ArrayList<Transacao> transacoes = new ArrayList<Transacao>(); //Composicao: classe "menor" Transacao e classe "maior" ContaCorrente.
	private Cliente cliente;
	
	public ContaCorrente(String _numeroConta, String _numeroAgencia, Cliente _cliente) {
		this.numeroConta = _numeroConta;
		this.numeroAgencia = _numeroAgencia;
		setSaldo(0.0f);
		setCliente(_cliente);
	}

	public void depositar(float v, ContaCorrente contacorrente) {
		saldo += v;
		Date data = new Date();
		Transacao t = new Transacao("Deposito", v, data, contacorrente);
		registrarTransacao(t);
	}
	
	public boolean sacar(float v, ContaCorrente contacorrente) {
		saldo -= v;
		if (saldo < 0.0f) {
			saldo += v;
			JOptionPane.showMessageDialog(null, "Saldo negativo, operacao falhou.");
			Date data = new Date();
			Transacao t = new Transacao("FALHOU", v, data, contacorrente);
			registrarTransacao(t);
			return false;
		}
		else {
			Date data = new Date();
			Transacao t = new Transacao("Saque", v, data, contacorrente);
			registrarTransacao(t);
			return true;
		}
	}
	
	public void registrarTransacao(Transacao t) {
		transacoes.add(t);
	}
	
	public ArrayList<Transacao> getExtrato() {
		return transacoes;
	}
	
	public void setExtrato(ArrayList<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	public void ImprimirExtrato() {
		String ExtratoTotal = "EXTRATO TOTAL:\n----------------------------";
		if(transacoes.size() > 0) {
			for (int i = 0; i < transacoes.size(); i++) {
				String aux = "\nTipo de Operacao " + (i+1) + ": " + transacoes.get(i).getOperacao() 
						+ "\nValor: " + transacoes.get(i).getValor()
						+ "\nHorario: " + transacoes.get(i).getDataHora()
						+ "\n----------------------------";
				ExtratoTotal = ExtratoTotal.concat(aux);
				}
			JOptionPane.showMessageDialog(null, ExtratoTotal);
        }
		else {
			JOptionPane.showMessageDialog(null, "Nao há transacoes cadastradas");
        }
	}
	
	public static String gerarNumeroConta() {
		int auxint1 = (int)(Math.random()*10000000);
		String auxstr1 = String.valueOf(auxint1);
		DecimalFormat formatter = new DecimalFormat("#00000000");
	    auxstr1 = formatter.format(auxint1);
	    
	    int auxint2 = (int)(Math.random()*9);
		String auxstr2 = String.valueOf(auxint2);
		
		String numeroContaRand = auxstr1.concat("-" + auxstr2);
		return numeroContaRand;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getSaldo() {
	    DecimalFormat formatter = new DecimalFormat("R$ #0.00");
	    return formatter.format(saldo);
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
}
