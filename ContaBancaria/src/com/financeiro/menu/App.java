package com.financeiro.menu;

import com.financeiro.controles.Controller;

public class App {

	public static void main(String[] args) {
		Controller dados = new Controller();
		
		dados.sistema();
		dados.fecharScanner();
		
	}

}
