package br.com.desafiomuralis.jspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.desafiomuralis.jspring.modelo.persistencia.banco.Banco;

@SpringBootApplication
public class JspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspringApplication.class, args);
		
		//população do "banco de dados" simulado
		Banco banco = new Banco();
	}

}
