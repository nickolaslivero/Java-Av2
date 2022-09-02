package br.edu.uea.usuarios;

import java.util.ArrayList;
import java.util.Date;

import br.edu.uea.contas.Conta;

public class Usuario {
	private String nome;
	private String cpf;
	private float salarioMensal;
	private ArrayList<Conta> contas;
	
	
	public Usuario(String _nome, String _cpf, float _salarioMensal) {
		
		this.nome = _nome;
		this.cpf = _cpf;
		this.salarioMensal = _salarioMensal;
		
		contas = new ArrayList<Conta>();
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the salarioMensal
	 */
	public float getSalarioMensal() {
		return salarioMensal;
	}

	/**
	 * @param salarioMensal the salarioMensal to set
	 */
	public void setSalarioMensal(float salarioMensal) {
		this.salarioMensal = salarioMensal;
	}
	
	public void cadastrarConta(String _codigo, String _descricao, float _valor, Date _vencimento, Usuario _usuario) {
		contas.add(new Conta(_codigo, _descricao, _valor, _vencimento, _usuario));
	}
	
	public String listarContas(){
		String retorno = "Relatório de Contas a Pagar\n";
		float valorTotal = 0;
		for(int i=0;i<this.contas.size();i++){
			valorTotal = valorTotal + this.contas.get(i).getValor();
			
			retorno+= "Código: "+this.contas.get(i).getCodigo()+"\n"+"Descrição: "+
			this.contas.get(i).getDescricao()+"\n"+"Valor: "+
			this.contas.get(i).getValor()+"\n"+"Valor Total: "+valorTotal+"\n";		
			
			if (valorTotal > this.salarioMensal) {
				retorno+="ATENÇÃO! VOCÊ ESTÁ INDIVIDADO!";
			}
		}
		return retorno;
	}
	
	public boolean removerConta(String _codigo) {
		for(int i=0;i<this.contas.size();i++){
						
			if (this.contas.get(i).getCodigo().equals(_codigo)){
				contas.remove(i);
				return true;
			}
		}
		return false;
	}
	

}
