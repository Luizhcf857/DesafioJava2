package com.financeiro.banco;

//Classe filha da ContaBancaria
public class ContaCorrente extends ContaBancaria {
	
	//Atributo da classe
	private double limiteChequeEspecial;
	
	//Coostrutor sem parametros
	public ContaCorrente() {
		
	}
	@Override
	public void depositar() {
		//Nessa linha o usuario digita o valor, e o valor eh adicionado pelo set
		System.out.print("\nDigite o valor que voce deseja depositar: ");
		setSaldo(entrada.nextDouble());
		
	}
	
	@Override
	public void sacar() {
		//Usuario informa qual saldo deseja sacar
		System.out.println("--- Sacar dinheiro ---");
		System.out.println("\n1. Sacar Saldo");
		System.out.println("2. Sacar Cheque especial");
		System.out.print("\nDigite a opcao desejada: ");
		int opcao = entrada.nextInt();
		
		//Um switch para verificar a escolha dele
		switch(opcao) {
		
		//caso 1 de sacar saldo
		case 1:
			//verificar qual valor o usuario deseja sacar
			System.out.println("\nDigite o valor que voce deseja sacar: ");
			double valorSaldo = entrada.nextDouble();
			
			//condicional para verificar se ha saldo disponivel
			if(valorSaldo > getSaldo()) {
				System.out.println("Valor indisponivel!");
				
			}else {
				System.out.println("Saque realizado com sucesso!");
				diminuirValor(valorSaldo);
				
				System.out.printf("Seu saldo atual eh: $.2f", getSaldo());
				
				System.out.println("Digite [v] para voltar: ");
				char opcaoSaldo = entrada.next().charAt(0);
			}
			
			break;
			
		// caso 2 para sacar o cheque especial
		case 2:
			//verificar qual valor o usuario deseja sacar
			System.out.println("Digite o valor que voce deseja sacar: ");
			double valorCheque = entrada.nextDouble();
			
			//verificar se ha valor disponivel
			if(valorCheque > limiteChequeEspecial) {
				System.out.println("Valor indisponivel!");
				
			}else {
				//Aqui ira informar uma menssagem de sucesso, e diminuir o valor do cheque especial
				System.out.println("Saque realizado com sucesso!");
				limiteChequeEspecial -= valorCheque;
				
				//aqui ira mostrar o valor do cheque especial
				System.out.printf("\nSeu saldo atual no limite especial eh: %.2f", limiteChequeEspecial);
				
				//e uma menssagem para voltar
				System.out.println("Digite [v] para voltar: ");
				char opcaoChequeEspecial = entrada.next().charAt(0);
				
				
			}
			
			break;
		
		//caso nenhum criterio for atendido
		default:
			System.out.println("Opcao invalida!");
			
			break;
		
		}
		
		
	}
	@Override
	public void abrirConta() {
		System.out.println("Digite seu nome: ");
		setTitular(entrada.nextLine());
		
		//gerar numero da conta
		for(int i = 0; i < 7; i++) {
			numero.append(random.nextInt(10));
			
		}
		//Trasnformar os numeros aleatorios em string
		setNumeroConta(numero.toString());
		
		//atribuir um valor ao criar a conta
		setSaldo(50.00);
	}
	@Override
	public void exibirDados(){
		System.out.println("\nNome do cliente: " + getTitular());
		System.out.println("Numero da conta: "+ getNumeroConta());
		System.out.println("Saldo disponivel: "+ getSaldo());
		System.out.println("Limite cheque especial: "+ limiteChequeEspecial);
		
	}
	
	
	@Override
	public void fecharScanner() {
		fecharScanner();
		
	}
	
	//Get e set do atributo
	public double getLimiteChequeEspecial() {
		return this.limiteChequeEspecial;
		
	}
	
	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
		
	}
	
	
}
