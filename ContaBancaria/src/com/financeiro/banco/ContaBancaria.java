package com.financeiro.banco;

import java.util.Scanner;

public abstract class ContaBancaria {
	
	Scanner entrada = new Scanner(System.in);
	
	//atributos da classe mae
	private String numeroConta;
	private String titular;
	private double saldo;
	
	//construtor sem parametros
	public ContaBancaria() {
			
	}
	
	//metodos abstract, que irao receber uma logica nas classes filhas
	public abstract void depositar();
	
	public abstract void sacar();
	
	public void exibirDados() {
		
	}
	
	public void abrirConta() {
		System.out.println("Digite seu nome: ");
		titular = entrada.nextLine();
		
	}
	
	//metodo para retirar o dinheiro da conta
	public void diminuirValor(double valor) {
		this.saldo -= valor;
		
	}
	
	public void fecharScanner() {
		entrada.close();
		
	}
	
	
	
	
	// Get e set dos atributos
	public String getNumeroConta() {
		return this.numeroConta;
		
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
		
	}
	
	public double getSaldo() {
		return this.saldo;
		
	}
	
	public void setSaldo(double Saldo) {
		this.saldo += saldo;
		
	}
	
	public String getTitular() {
		return this.titular;
		
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
		
	}

}
