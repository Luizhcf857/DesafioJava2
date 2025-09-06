package com.financeiro.banco;

public class ContaPoupanca extends ContaBancaria {
	 
	//Atributo da classe
	private double taxaRendimento;
	
	//Construtor sem parametros
	public ContaPoupanca() {
		
		
	}
	@Override
	public void abrirConta() {
		System.out.print("\nDigite seu nome: ");
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
		//metodo foi criado vazio, porque vai receber uma logica dentro do controller
	}
	@Override
	public void sacar() {
		//metodo foi criado vazio, porque vai receber uma logica dentro do controller
	}
	
	//metodo para dar rendimento se tiver 1000 de saldo
	public void calcularRendimento() {
		if(getSaldo() > 1000.00) {
			setSaldo(34.00);
		}	
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
