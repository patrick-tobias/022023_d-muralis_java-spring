package br.com.desafiomuralis.jspring.modelo.persistencia;

import java.util.Collection;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.persistencia.banco.Banco;

public class ClientesLocalMemo implements Clientes {

	@Override
	public void iniciarTransacao() {}

	@Override
	public void confirmarTransacao() {}

	@Override
	public void cancelarTransacao() {}

	@Override
	public void encerrarConexao() {}

	@Override
	public void adicionarCliente(Cliente cliente) {
		Banco.adicionarCliente(cliente);
	}

	@Override
	public Collection<Cliente> pesquisarTodosOsClientes() {
		return Banco.pesquisarTodosOsClientes();
	}

	@Override
	public Cliente pesquisarClientePorId(Integer idCliente) throws Exception {
		return Banco.pesquisarClientePorId(idCliente);
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws Exception{
		Banco.atualizarCliente(cliente);
	}

	@Override
	public void removerCliente(Cliente cliente) throws Exception {
		Banco.removerCliente(cliente);
	}

}
