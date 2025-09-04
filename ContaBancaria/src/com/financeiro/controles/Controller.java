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
	public void abrirConta() {		
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
				contaCorrente.abrirConta();
				
				break;
			
			
			}
		}while(opcao != 4);
		
		
		
	}

	

}
