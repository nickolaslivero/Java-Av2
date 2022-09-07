package banco.dados;

import banco.logica.ContaCorrente;

public class BancoDados {
	
	public BancoDados() {}
	
	public static ContaCorrente salvar(ContaCorrente contacorrente) {
		ContaCorrente.getContas().add(contacorrente);
		return contacorrente;
	}
}
