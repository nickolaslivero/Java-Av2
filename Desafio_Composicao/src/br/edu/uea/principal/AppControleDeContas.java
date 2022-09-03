package br.edu.uea.principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import br.edu.uea.contas.*;
import br.edu.uea.usuarios.*;


public class AppControleDeContas {
	
	static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) throws ParseException {
		
		contasBancarias = new ArrayList<Conta>();
		
		while (true) {
		criarConta();
		listarContas();
		}
	}
	
    public static void criarConta() throws ParseException {
        //System.out.println("Você está criando uma conta\n");

        System.out.println("Digite seu Nome: ");
        String nome = input.next();

        System.out.println("Digite seu CPF: ");
        String cpf = input.next();

        System.out.println("Digite seu Salario: ");
        float salarioMensal = input.nextFloat();
        
        Usuario usuario = new Usuario(nome, cpf, salarioMensal);
        
        System.out.println("-------------------------");
        
        System.out.println("Digite seu Codigo: ");
        String codigo = input.next();

        System.out.println("Digite sua Descricao: ");
        String descricao = input.next();

        System.out.println("Digite seu Valor: ");
        float valor = input.nextFloat();
        
        System.out.println("Digite o Vencimento: ");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String venc = input.next();
        Date vencimento = formato.parse(venc);
        

        Conta conta = new Conta( codigo, descricao, valor, vencimento, usuario);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");
    }
    
    public static void listarContas() {
        if(contasBancarias.size() > 0) {
        	System.out.println("--------------------------");
            for(Conta conta: contasBancarias) {
                System.out.println("Codigo:"+conta.getCodigo());
                System.out.println("Descricao: "+conta.getDescricao());
                System.out.println("Valor: "+conta.getValor());
                System.out.println("Vencimento: "+conta.getVencimento());
                System.out.println("Usuario: "+conta.getUsuario());
                System.out.println("--------------------------");

            }
            
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }
    
    
    }
    
    
}