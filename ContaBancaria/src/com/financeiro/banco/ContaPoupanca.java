package com.financeiro.banco;

public class ContaPoupanca extends ContaBancaria {
	 
	//Atributo da classe
	private double taxaRendimento;
	
	//Construtor sem parametros
	public ContaPoupanca() {
		
		
	}
	@Override
	public void abrirConta() {
		System.out.println("Digite seu nome: ");
		setTitular(entrada.nextLine());
		
		//gerar um numero para a conta
		for(int i = 0; i < 7; i++) {
			numero.append(random.nextInt(10));
			
		}
		
		//transformar os valores em string
		setNumeroConta(numero.toString());
		
		//atribuir um valor no saldo
		setSaldo(150.00);
		
	}
	@Override
	public void depositar() {
		//O usuario ira digitar o valor de deposito
		System.out.println("Digite o valor que voce deseja depositar: ");
		setSaldo(entrada.nextDouble());
		
	}
	@Override
	public void sacar() {
		//Aqui o usuario ira digitar o valor para saque
		System.out.println("Digite o valor  que voce deseja sacar: ");
		double valor = entrada.nextDouble();
		
		//condicional para verificar se ha valor para saque
		if(valor > getSaldo()) {
			System.out.println("Valor indisponivel!");
			
		}else {
			System.out.println("Saque realizado com sucesso!");
			diminuirValor(valor);
			
			System.out.printf("\nSeu saldo atual eh %.2f", getSaldo());
			
			System.out.println("nDigite [v] para voltar: ");
			char opcao = entrada.next().charAt(0);
			
		}
		
		
	}
	
	//metodo para dar rendimento se tiver 1000 de saldo
	public void calcularRendimento() {
		if(getSaldo() > 1000.00) {
			setSaldo(34.00);
		}	
	}
	@Override
	public void exibirDados() {
		System.out.println("Nome do titular: "+ getTitular());
		System.out.println("Numero da conta: "+ getNumeroConta());
		System.out.println("Saldo da conta: "+ getSaldo());
		
	}
		
	
	@Override
	public void fecharScanner() {
		fecharScanner();
		
	}
	
	//get e set do atributo
	public double getTaxaRendimento() {
		return this.taxaRendimento;
		
	}
	
	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
		
	}
	
}
