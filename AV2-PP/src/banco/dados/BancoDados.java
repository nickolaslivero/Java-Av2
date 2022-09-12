package banco.dados;

import banco.logica.ContaCorrente;

public class BancoDados {
	// salva as contas em um arraylist.
	public static ContaCorrente salvar(ContaCorrente contacorrente) {
		ContaCorrente.getContas().add(contacorrente);
		return contacorrente;
	}
}
