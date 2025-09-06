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
				//criando um novo objeto de conta corrente para não sobrescrever
				ContaCorrente novaCorrente = new ContaCorrente();
				
				//pegando o metodo de conta corrente de abrir conta
				novaCorrente.abrirConta();
				
				//atribuir os dados dentro do array
				dadosCorrente.add(novaCorrente);
				
				//aqui foi criada um scanner so para o usuário voltar
				System.out.println("\nConta criada com sucesso!");
				System.out.print("\nDigite [v] para voltar: ");
				char opcaoDeVoltar = entrada.next().charAt(0);
				
				break;
				
			case 2:
				//Criando um novo objeto de conta poupança para não sobrescrever
				ContaPoupanca novaPoupanca = new ContaPoupanca();
				
				//pegando o metodo de abrir conta da conta poupanca
				novaPoupanca.abrirConta();			
				
				//atribuir os valores no arraylist
				dadosPoupanca.add(novaPoupanca);
				
				//aqui foi criada um scanner so para o usuário voltar
				System.out.println("\nConta criada com sucesso!");
				System.out.print("\nDigite [v] para voltar: ");
				opcaoDeVoltar = entrada.next().charAt(0);
				
				break;
				
			case 3:
				//como sera inserido alguns loop for, foi criada logo o i, para controle
				int i = 0;
				
				//um mini menu para colocar o switch
				System.out.println("\n1. Conta Corrente");
				System.out.println("2. Conta Poupanca");
				System.out.print("Digite qual conta voce deseja acessar: ");
				int opcaoDeAcesso = entrada.nextInt();
				
				//para limpar o buffer e não ocorrer erro
				entrada.nextLine();																																																																	
				
				switch(opcaoDeAcesso) {
				
				case 1:
					//status da conta, para verificar se existe
					boolean status = false;
					//foi criada um novo objeto dad conta corrente, para salvar os atributos para acesso, e salvar, para conseguir manipular
					ContaCorrente contaEncontradaCorrente = new ContaCorrente();
					
					//inserir o nome da conta
					System.out.print("\nDigite seu nome: ");
					String nomeCorrente = entrada.nextLine();
					
					//laco para procurar o nome dentro do arraylist
					for(i = 0; i <= dadosCorrente.size() -1; i++) {
						
						//condicional para verificar se o nome foi achado
						if(nomeCorrente.equalsIgnoreCase(dadosCorrente.get(i).getTitular())) {
							status = true;//status recebe verdadeiro
							contaEncontradaCorrente = dadosCorrente.get(i);//colocar os atributos dentro da conta encontrada
							break;
							
						//caso o arraylist estiver vazio, ira mostrar a mensagem de erro erro
						}else if(dadosCorrente.isEmpty()){
							System.out.println("Conta nao encontrada!");
							break;
							
							
						}
						
					}
					
					//foi declada essa variavel para manipular as opcoes do menu de conta corrente
					int opcoesCorrente;
					
					//uma condicional, caso tenha achado o nome
					if(status == true) {
						
						//do while para controlar as interações
						do {
							//a primeira impressão ira mostrar o nome do titular que foi procurado e achado
							System.out.println("\nBem vindo a sua conta corrente, " + contaEncontradaCorrente.getTitular());
							System.out.println("1. Sacar dinheiro");
							System.out.println("2. Depositar dinheiro");
							System.out.println("3. Exibir dados");
							System.out.println("4. Voltar");
							System.out.print("Selecione a opcao desejada: ");
							opcoesCorrente = entrada.nextInt();
							
							entrada.nextLine();
							
							//switch para controlar as opções
							switch(opcoesCorrente) {
								
							case 1:
								//Inserir uma variável provisoria apenas para fazer comparação
								System.out.print("\nDigite o valor que você deseja sacar: ");
								double sacarCorrente = entrada.nextDouble();
								
								//condicional para verificar se o valor está diponível, para não zerar a conta
								if(sacarCorrente > contaEncontradaCorrente.getSaldo()) {
									System.out.println("Valor indisponível");
									
								}else {
									//um metodo para realizar o saque, dentro da condicional else
									contaEncontradaCorrente.diminuirValor(sacarCorrente);
									System.out.println("Saque realizado com sucesso!");
									System.out.printf("\nSaldo disponível: R$ %.2f\n", contaEncontradaCorrente.getSaldo());
									
								}
								break;
								
							case 2:
								System.out.print("\nDigite o valor que você deseja depositar: ");
								
								//foi criada uma varável provisoria, apenas para saber qual o valor do deposito, para mostrar na mensagem
								double depositoCorrente = entrada.nextDouble();
								contaEncontradaCorrente.setSaldo(depositoCorrente);
								System.out.printf("\nVocê realizou um deposito de R$ %.2f\n", depositoCorrente);
								break;
								
							case 3:
								//aqui sera exibido todos os dados
								System.out.println("\nTitular: "+ contaEncontradaCorrente.getTitular());
								System.out.println("Número da conta: "+ contaEncontradaCorrente.getNumeroConta());
								System.out.println("Saldo: R$ "+ contaEncontradaCorrente.getSaldo());
								System.out.println("Cheque especial: "+ contaEncontradaCorrente.getLimiteChequeEspecial());
								break;
							
							//caso nenhuma opção for atendida, entrará no default
							default:
								System.out.println("\nOpção inválida!");
								break;
							}
							
							
						}while(opcoesCorrente != 4);
						
					//caso o status não seja true, entrará no else
					}else {
						System.out.println("\nConta nao encontrada!");
						
					}
					
					break;
					
				case 2:
					
					//criando um objeto de conta poupança, para quando achar a conta que procura, salvar os atributos nela
					ContaPoupanca contaEncontradaPoupanca = new ContaPoupanca();
					
					//status para saber se a conta é verdadeira ou falsa
					status = false;
					
					System.out.print("\nDigite seu nome: ");
					String nomePoupanca = entrada.nextLine();
					
					//laço para percorrer o arraylist
					for(i = 0; i <= dadosPoupanca.size() -1; i++) {
						
						//condicional para procurar o nome
						if(nomePoupanca.equalsIgnoreCase(dadosPoupanca.get(i).getTitular())) {
							//caso ache o nome, o status recebe verdadeiro
							status = true;
							
							//Salvar os atributos da conta que estava procurando, dentro do novo objeto
							contaEncontradaPoupanca = dadosPoupanca.get(i);
							break;
						
						//caso o arraylist esteja vazio, mostrar uma mensagem de erro
						}else if(dadosPoupanca.isEmpty()) {
							System.out.println("Conta nao encontrada");
							break;
							
						}
						
					}
					
					//variável para controlar o mini menu da conta poupança
					int opcoesPoupanca;
					
					//caso o status da conta poupança for verdadeiro
					if(status == true) {
						
						//laço do while para controlar as opções e interações
						do {
							System.out.println("\nBem vindo a sua conta poupanca, "+ contaEncontradaPoupanca.getTitular()+"\n");
							System.out.println("1. Sacar dinheiro");
							System.out.println("2. Depositar dinheiro");
							System.out.println("3. Exibir dados");
							System.out.println("4. Voltar");
							System.out.print("\nSelecione a opcao desejada: ");
							opcoesPoupanca = entrada.nextInt();
							
							//switch para controle de opções
							switch(opcoesPoupanca) {
							
							case 1:
								//uma variável para fazer a condicional
								System.out.println("Digite o valor que você deseja sacar: ");
								double sacarPoupanca = entrada.nextDouble();
								
								//condicional para verificar se há valor diponível
								if(sacarPoupanca > contaEncontradaPoupanca.getSaldo()) {
									System.out.println("\nValor indisponível!");
									
								}else {
									contaEncontradaPoupanca.diminuirValor(sacarPoupanca);
									System.out.println("\nSaque realizado com sucesso!");
									System.out.printf("\nSaque disponível R$ %.2f \n", contaEncontradaPoupanca.getSaldo());
									
								}
								
								break;
								
							case 2:
								System.out.print("\nDigite o valor que você deseja depositar: ");
								
								//foi criada uma variável temporaria para mostrar qual o valor do deposito
								double depositoPoupanca = entrada.nextDouble();
								
								System.out.printf("Você realizou um deposito de R$ %.2f\n", depositoPoupanca);
								break;
								
							case 3:
								//aqui será exibido todos os dados da conta poupança
								System.out.println("\nTitular: "+ contaEncontradaPoupanca.getTitular());
								System.out.println("Número da conta: "+ contaEncontradaPoupanca.getNumeroConta());
								System.out.println("Saldo: R$ "+ contaEncontradaPoupanca.getSaldo());
								break;
								
							default:
								
								//caso nenhuma opção for atendida
								System.out.println("Opcao invalida!");
								break;
							}
							
						}while(opcoesPoupanca != 4);

						
					}
					
					
					break;
				
				}
				
				break;
				
			default:
				System.out.println("Opção inválida!");
				break;
			
			
			}
		}while(opcao != 4);
		System.out.println("\nObrigado por usar o banco Java!...");
		
	}
	//metodo para fechar o scanner
	public void fecharScanner() {
		entrada.close();
		
	}

	

}
