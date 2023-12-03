package br.com.desafiomuralis.jspring.modelo.casodeuso;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.persistencia.Clientes;

public class RemoverCliente {
	private Clientes clientes;
	
	public RemoverCliente(Clientes clientes) {
		this.clientes = clientes;
	}
	
	public void executar(Cliente cliente) {
		try {
			clientes.removerCliente(cliente);
			
		} catch(Exception e) {
			clientes.cancelarTransacao();
			throw new RuntimeException(e);
			
		} finally {
			clientes.encerrarConexao();
		}
	}

}
