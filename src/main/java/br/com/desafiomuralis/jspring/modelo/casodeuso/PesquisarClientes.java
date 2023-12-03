package br.com.desafiomuralis.jspring.modelo.casodeuso;

import java.util.Collection;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.persistencia.Clientes;

public class PesquisarClientes {
	private Clientes clientes;
	
	public PesquisarClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	
	public Collection<Cliente> pesquisarTodosOsClientes(){
		try {
			return clientes.pesquisarTodosOsClientes();
			
		} catch(Exception e) {
			clientes.cancelarTransacao();
			throw new RuntimeException(e);
			
		} finally {
			clientes.encerrarConexao();
		}
	}
	
	public Cliente pesquisarClientePorId(Integer idCliente) throws Exception {
		try {
			return clientes.pesquisarClientePorId(idCliente);
			
		} catch(Exception e) {
			clientes.cancelarTransacao();
			throw new RuntimeException(e);
			
		} finally {
			clientes.encerrarConexao();
		}
	}
}
