package br.edu.uea.caixaeletronico;

import br.edu.uea.cliente.Cliente;
import br.edu.uea.contacorrente.*;

public class CaixaEletronico {
	public static void main(String[] args) {
		Cliente clienteteste = new Cliente("Farias Barbosa", "0000000-0", "000.000.000-00", "Reserva Inglesa");
		ContaCorrente contateste = new ContaCorrente(0.0f, "00000000-1", "0001", clienteteste);
		
		contateste.depositar(1600.00f);
		contateste.sacar(600.00f);
		
		System.out.println("--------------------------");
		System.out.println("Numero da Conta: " + contateste.getNumeroConta()
				+ "\nNumero da Agencia: " + contateste.getNumeroAgencia() 
				+ "\nSaldo disponivel: " + contateste.getSaldo()+ ".");
		System.out.println("--------------------------");
		
		contateste.ImprimirExtrato();
	}
}
