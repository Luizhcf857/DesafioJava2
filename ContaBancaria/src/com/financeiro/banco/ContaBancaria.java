package com.financeiro.banco;

import java.util.Scanner;
import java.util.Random;

public abstract class ContaBancaria {
	
	Scanner entrada = new Scanner(System.in);
	Random random = new Random();
	StringBuilder numero = new StringBuilder();
	
	//atributos da classe mae
	private String titular;
	private String numeroConta;
	private double saldo;
	
	//construtor sem parametros
	public ContaBancaria() {
			
	}
	
	//metodos abstract, que irao receber uma logica nas classes filhas
	public abstract void depositar();
	
	public abstract void sacar();

	public abstract void abrirConta();
	
	//metodo para retirar o dinheiro da conta
	public void diminuirValor(double saldo) {
		this.saldo -= saldo;
		
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
	
	public void setSaldo(double saldo) {
		this.saldo += saldo;
		
	}
	
	public String getTitular() {
		return this.titular;
		
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
		
	}

}
