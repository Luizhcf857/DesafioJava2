package com.financeiro.banco;

//Classe filha da ContaBancaria
public class ContaCorrente extends ContaBancaria {
	
	//Atributo da classe
	private double limiteChequeEspecial;
	private double inserirSaldo;
	
	//Coostrutor sem parametros
	public ContaCorrente() {
		
	}
	@Override
	public void depositar() {
		
	}
	
	@Override
	public void sacar() {
		
	}
		
		
	@Override
	public void abrirConta() {
		System.out.print("\nDigite seu nome: ");
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
	
	public double getInserirSaldo() {
		return this.inserirSaldo;
		
	}
	
	public void setInserirSaldo(double inserirSaldo) {
		this.inserirSaldo += inserirSaldo;
		
	}
	
}
