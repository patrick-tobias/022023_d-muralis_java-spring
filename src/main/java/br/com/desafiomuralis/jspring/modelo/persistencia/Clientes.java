package br.com.desafiomuralis.jspring.modelo.persistencia;

import java.util.Collection;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;

public interface Clientes {
	
void iniciarTransacao();
    
    void confirmarTransacao();
    
    void cancelarTransacao();
    
    void encerrarConexao();
	
	
	void adicionarCliente(Cliente cliente);
	
	Collection<Cliente> pesquisarTodosOsClientes();
	
	Cliente pesquisarClientePorId(Integer idCliente) throws Exception;
	
	void atualizarCliente(Cliente cliente) throws Exception;
	
	void removerCliente(Cliente cliente) throws Exception;
	
	

}
