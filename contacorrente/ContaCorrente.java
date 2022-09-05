package br.edu.uea.contacorrente;

import br.edu.uea.cliente.Cliente;
import br.edu.uea.transacao.Transacao;

import java.util.ArrayList;

public class ContaCorrente {
	private float saldo;
	private String numeroConta;
	private String numeroAgencia;
	private static ArrayList<Transacao> transacoes;
	
	public ContaCorrente(float _saldo, String _numeroConta, String _numeroAgencia, Cliente _cliente) {
		transacoes = new ArrayList<Transacao>();
		this.saldo = _saldo = 0.0f;
		this.numeroConta = _numeroConta;
		this.numeroAgencia = _numeroAgencia;
		setCliente(_cliente);
	}

	public void depositar(float v) {
		saldo += v;
		Transacao t = new Transacao("Deposito", v, "00:00");
		registrarTransacao(t);
	}
	
	public boolean sacar(float v) {
		saldo -= v;
		if (saldo < 0.0f) {
			saldo += v;
			System.out.println("Saldo negativo, operacao falhou.");
			return false;
		}
		else {
		Transacao t = new Transacao("Saque", v, "00:01");
		registrarTransacao(t);
		return true;
		}
	}
	
	public static void registrarTransacao(Transacao t) {
		transacoes.add(t);
		System.out.println("Transacao feita com sucesso!");
	}
	
	public ArrayList<Transacao> getExtrato() {
			return transacoes;
	}
	
	public void ImprimirExtrato() {
		if(transacoes.size() > 0) {
			for (int i = 0; i < transacoes.size(); i++) {
				System.out.println("Operacao " + (i+1) + ": " + transacoes.get(i).getOperacao() 
				+ "\nValor movimentado: " + transacoes.get(i).getValor()
				+ "\nHorario da transacao: " + transacoes.get(i).getDataHora());
				System.out.println("-------------");
				}
        }
		else {
            System.out.println("Nao há transacoes cadastradas");
        }
	}

	public void setCliente(Cliente cliente) {
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
}
