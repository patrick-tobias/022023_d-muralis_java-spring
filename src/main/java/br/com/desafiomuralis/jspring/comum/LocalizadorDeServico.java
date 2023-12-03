package br.com.desafiomuralis.jspring.comum;

import br.com.desafiomuralis.jspring.modelo.casodeuso.AdicionarCliente;
import br.com.desafiomuralis.jspring.modelo.casodeuso.AtualizarCliente;
import br.com.desafiomuralis.jspring.modelo.casodeuso.PesquisarClientes;
import br.com.desafiomuralis.jspring.modelo.casodeuso.RemoverCliente;
import br.com.desafiomuralis.jspring.modelo.persistencia.Clientes;
import br.com.desafiomuralis.jspring.modelo.persistencia.ClientesLocalMemo;

public class LocalizadorDeServico {
	
	public static Clientes clientesRepositorio() {
		return new ClientesLocalMemo();
	}
	
	//C.U. Clientes
	public static AdicionarCliente adicionarCliente() {
		return new AdicionarCliente(clientesRepositorio());
	}
	
	public static AtualizarCliente atualizarCliente() {
		return new AtualizarCliente(clientesRepositorio());
	}
	
	public static PesquisarClientes pesquisarClientes() {
		return new PesquisarClientes(clientesRepositorio());
	}
	
	public static RemoverCliente removerCliente() {
		return new RemoverCliente(clientesRepositorio());
	}

}
