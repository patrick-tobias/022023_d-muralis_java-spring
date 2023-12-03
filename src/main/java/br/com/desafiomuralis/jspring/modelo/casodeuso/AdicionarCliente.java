package br.com.desafiomuralis.jspring.modelo.casodeuso;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.persistencia.Clientes;

public class AdicionarCliente {
	private Clientes clientes;
	
	public AdicionarCliente(Clientes clientes) {
		this.clientes = clientes;
	}
	
	public void executar(Cliente cliente) {
		try {
			clientes.iniciarTransacao();
			clientes.adicionarCliente(cliente);
			clientes.confirmarTransacao();
			
		} catch(Exception e) {
			clientes.cancelarTransacao();
			throw new RuntimeException(e);
			
		} finally {
			clientes.encerrarConexao();
			
		}
	}
}
