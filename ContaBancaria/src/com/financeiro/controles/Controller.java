package com.financeiro.controles;

import com.financeiro.banco.ContaCorrente;
import com.financeiro.banco.ContaPoupanca;
import java.util.ArrayList;
import java.util.Scanner;


public class Controller {
	//criando os objetos para a classe
	ContaCorrente contaCorrente = new ContaCorrente();
	ContaPoupanca contaPoupanca = new ContaPoupanca();
	Scanner entrada = new Scanner(System.in);
	
	//Criando os ArraysLists
	ArrayList<ContaCorrente> dadosCorrente = new ArrayList<>();
	ArrayList<ContaPoupanca> dadosPoupanca = new ArrayList<>();
	
	//metodo de abrirConta
	public void sistema() {		
		System.out.println("Bem vindo ao banco Java!");
		
		//variavel para controlar o laco de criar ou acessar conta
		int opcao;
		
		//laco do while para finalizar o programa caso o usario assim queira
		do {
			System.out.println("\n1. Criar conta corrente");
			System.out.println("2. Criar conta poupanca");
			System.out.println("3. Acessar sua conta");
			System.out.println("4. Sair");
			System.out.print("Selecione a opcao desejada: ");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			
			case 1:
				//pegando o metodo de conta corrente de abrir conta
				contaCorrente.abrirConta();
				
				//atribuir os dados dentro do array
				dadosCorrente.add(contaCorrente);
				
				System.out.println("\nConta criada com sucesso!");
				System.out.print("\nDigite [v] para voltar: ");
				char opcaoDeVoltar = entrada.next().charAt(0);
				
				break;
				
			case 2:
				//pegando o metodo de abrir conta da conta poupanca
				contaPoupanca.abrirConta();			
				
				//atribuir os valores no array
				dadosPoupanca.add(contaPoupanca);
				
				System.out.println("\nConta criada com sucesso!");
				System.out.print("\nDigite [v] para voltar: ");
				opcaoDeVoltar = entrada.next().charAt(0);
				
				break;
				
			case 3:
				int i = 0;
				
				System.out.println("1. Conta Corrente");
				System.out.println("2. Conta Poupanca");
				System.out.print("Digite qual conta voce deseja acessar: ");
				int opcaoDeAcesso = entrada.nextInt();
				
				entrada.nextLine();																																																																	
				
				switch(opcaoDeAcesso) {
				
				case 1:
					boolean status = false;
					
					System.out.print("\nDigite seu nome: ");
					String nomeCorrente = entrada.nextLine();
					
					for(i = 0; i < dadosCorrente.size(); i++) {
						if(nomeCorrente.equalsIgnoreCase(dadosCorrente.get(i).getTitular())) {
							status = true;
							
							
							
						}else if(dadosCorrente.isEmpty()){
							System.out.println("Conta nao encontrada!");
							
							
						}
						
					}
					
					int opcoesCorrente;
					
					if(status == true) {
						do {
							System.out.println("\nBem vindo a sua conta corrente " + contaCorrente.getTitular());
							System.out.println("1. Sacar dinheiro");
							System.out.println("2. Depositar dinheiro");
							System.out.println("3. Exibir dados");
							System.out.println("4. Voltar");
							System.out.print("Selecione a opcao desejada: ");
							opcoesCorrente = entrada.nextInt();
							
							entrada.nextLine();
							
							switch(opcoesCorrente) {
								
							case 1:
								contaCorrente.sacar();
								break;
								
							case 2:
								contaCorrente.depositar();
								break;
								
							case 3:
								contaCorrente.exibirDados();
								break;
							}
							
							
						}while(opcoesCorrente != 4);
						
					}else {
						System.out.println("\nConta nao encontrada!");
						
					}
					
					
					break;
				case 2:
					
					status = false;
					
					System.out.print("\nDigite seu nome: ");
					String nomePoupanca = entrada.nextLine();
					
					for(i = 0; i < dadosPoupanca.size(); i++) {
						
						if(nomePoupanca.equalsIgnoreCase(dadosPoupanca.get(i).getTitular())) {
							status = true;
							
						}else if(dadosPoupanca.isEmpty()) {
							System.out.println("Conta nao encontrada");
							break;
							
						}
						
					}
					
					int opcoesPoupanca;
					if(status == true) {
						
						do {
							System.out.println("\nBem vindo a sua conta poupanca "+ dadosPoupanca.get(i).getTitular()+"\n");
							System.out.println("1. Sacar dinheiro");
							System.out.println("2. Depositar dinheiro");
							System.out.println("3. Exibir dados");
							System.out.println("4. Voltar");
							System.out.print("\nSelecione a opcao desejada: ");
							opcoesPoupanca = entrada.nextInt();
							
							switch(opcoesPoupanca) {
							
							case 1:
								contaPoupanca.sacar();
								break;
								
							case 2:
								contaPoupanca.depositar();
								break;
								
							case 3:
								contaPoupanca.exibirDados();
								break;
							default:
								System.out.println("Opcao invalida!");
								break;
							}
							
						}while(opcoesPoupanca != 4);

						
					}
					
					
					break;
				
				}
				
				break;
			
			
			}
		}while(opcao != 4);
		
		
		
	}

	

}
