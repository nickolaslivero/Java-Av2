package banco.UI;

import javax.swing.JOptionPane;

import banco.logica.Cliente;
import banco.logica.ContaCorrente;

public class CaixaEletronico {
	public static void main(String[] args) {
		
		int cadastrarsn = JOptionPane.showConfirmDialog(null, "Bem vindo(a) a central do Banco.\nDeseja cadastrar uma conta?", "Cadastrar conta",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		int loopinicial;
		do {
			if (cadastrarsn == 0) {
				String nome = JOptionPane.showInputDialog("Digite seu nome");
				String RG = JOptionPane.showInputDialog("Digite seu RG");
				String CPF = JOptionPane.showInputDialog("Digite seu CPF");
				String Endereco = JOptionPane.showInputDialog("Digite seu Endereco");
				
				Cliente cliente = new Cliente(nome, RG, CPF, Endereco); //Agregaçao: classe "maior"
				
				ContaCorrente conta = new ContaCorrente (cliente); //Agregacao: classe "menor"
				
				if (conta != null && cliente.getNome() != null && cliente.getRg() != null && cliente.getCpf() != null && cliente.getEndereco() != null ) {
					JOptionPane.showMessageDialog(null, "Voce criou sua conta com sucesso!"
					+ "\n-----DADOS DO TITULAR:-----"
					+ "\nNumero do Titular: " + cliente.getNome()
					+ "\nRG: " + cliente.getRg()
					+ "\nCPF: " + cliente.getCpf()
					+ "\nEndereco: " + cliente.getEndereco()
					+ "\n-----DADOS DO BANCO:-----"
					+ "\nNumero da Conta: " + conta.getNumeroConta()
					+ "\nNumero da Agencia: " + conta.getNumeroAgencia() 
					+ "\nSaldo disponivel: " + conta.getSaldo()
					+"\n------------------------------");
					
					int transacaosn = JOptionPane.showConfirmDialog(null, "Deseja fazer uma transacao?\nSaldo: " + conta.getSaldo(), "Transacao",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (transacaosn == 0) {
						do {
							String transacaostring = JOptionPane.showInputDialog("SELECIONE A OPERACAO DESEJADA.\n"
								+ "Depositar ou sacar? Saldo: "+ conta.getSaldo() + "\nDigite APENAS 'D' OU 'S'.\n"
								+ "Aperte em 'Cancel' para imprimir extrato.");
							if (transacaostring != null) {
								if (transacaostring.equals("D")||transacaostring.equals("d")) {
									String valorstring= JOptionPane.showInputDialog("Digite um VALOR a ser DEPOSITADO: ");
									if (valorstring != null) {
										try {
											float valor = Float.parseFloat(valorstring);
											conta.depositar(valor, conta);
										}
										catch(NumberFormatException excecao){
											JOptionPane.showMessageDialog(null, "Digite um numero valido");
										}
									}
								} 
								else if (transacaostring.equals("S")||transacaostring.equals("s")) {
									String valorstring= JOptionPane.showInputDialog("Digite um VALOR a ser SACADO: ");
									if (valorstring != null) {
										try {
											float valor = Float.parseFloat(valorstring);
											conta.sacar(valor, conta);
										}
										catch(NumberFormatException excecao){
											JOptionPane.showMessageDialog(null, "Digite um numero valido");
										}
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Digite uma operacao valida");
								}
							}
							else{
								transacaosn = 1;
							}	
						}while(transacaosn == 0);
					}	
				int imprimirextratosn = JOptionPane.showConfirmDialog(null,"Deseja imprimir o extrato?", "Extrato",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (imprimirextratosn == 0) {
						conta.ImprimirExtrato();
					}
					
					JOptionPane.showMessageDialog(null, "INFORMACOES TOTAIS:"
					+ "\n-----DADOS DO TITULAR:-----"
					+ "\nNome do Titular: " + cliente.getNome()
					+ "\nRG: " + cliente.getRg()
					+ "\nCPF: " + cliente.getCpf()
					+ "\nEndereco: " + cliente.getEndereco()
					+ "\n-----DADOS DO BANCO:-----"
					+ "\nNumero da Conta: " + conta.getNumeroConta()
					+ "\nNumero da Agencia: " + conta.getNumeroAgencia() 
					+ "\nSaldo disponivel: " + conta.getSaldo()
					+ "\nNumero total de transacoes: " + conta.getExtrato().size()
					+"\n------------------------------");
			
					ContaCorrente.salvarContaCorrente(conta);
				}
				else {
					JOptionPane.showMessageDialog(null, "Conta invalida.");
				}
			}
			
			loopinicial = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra conta?", "Cadastrar conta",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}while(loopinicial == 0);
		ContaCorrente.imprimirContas();
		System.exit(0);
	}
}
