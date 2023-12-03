package br.com.desafiomuralis.jspring.modelo.casodeuso;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.persistencia.Clientes;

public class AtualizarCliente {
	private Clientes clientes;
	
	public AtualizarCliente(Clientes clientes){
		this.clientes = clientes;
	}
	
	public void executar(Cliente cliente) throws Exception {
		try {
			clientes.atualizarCliente(cliente);
			
		} catch(Exception e) {
			clientes.cancelarTransacao();
			throw new RuntimeException(e);
			
		} finally {
			clientes.encerrarConexao();
		}
	}
}
