package br.com.desafiomuralis.jspring.controle.dto;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.negocio.Contato;

public record ClienteDTOSaida(int id, String nome, String dataCadastro, Contato contato) {
	
	public ClienteDTOSaida(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getDataCadastro(), cliente.getContato());
	}
}
