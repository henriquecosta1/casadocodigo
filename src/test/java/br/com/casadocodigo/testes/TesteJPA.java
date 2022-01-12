package br.com.casadocodigo.testes;

import javax.persistence.Persistence;


public class TesteJPA {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("casadocodigo");
		

	}

}
