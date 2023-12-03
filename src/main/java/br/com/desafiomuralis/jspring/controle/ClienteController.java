package br.com.desafiomuralis.jspring.controle;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiomuralis.jspring.comum.LocalizadorDeServico;
import br.com.desafiomuralis.jspring.controle.dto.ClienteDTOEntrada;
import br.com.desafiomuralis.jspring.controle.dto.ClienteDTOSaida;
import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.negocio.Contato;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping
	public Collection<ClienteDTOSaida> buscarTodosOsClientes() {
		Collection<Cliente> clientes = LocalizadorDeServico.pesquisarClientes().pesquisarTodosOsClientes();
		
		List<ClienteDTOSaida> clientesDTO = clientes
												.stream()
												.map(ClienteDTOSaida :: new)
												.toList();
		
		return clientesDTO;
		
	}
	
	@PostMapping
	public void cadastrarCliente(@RequestBody ClienteDTOEntrada clienteDTO) {
		
		String nome = clienteDTO.nome();
		String dataCadastro = clienteDTO.dataCadastro();
		
		String tipo = clienteDTO.contato().tipo();
		String texto = clienteDTO.contato().texto();
		
		Contato contato = new Contato(0, tipo, texto);
		Cliente cliente = new Cliente(0, nome, dataCadastro, contato);
		
		LocalizadorDeServico.adicionarCliente().executar(cliente);
	}
	
	@PutMapping
	public void atualizarCliente(@RequestBody ClienteDTOEntrada clienteDTO) {
		try {
			int idCliente = Integer.valueOf(clienteDTO.id());
			
			Cliente cliente = LocalizadorDeServico.pesquisarClientes().pesquisarClientePorId(idCliente);
			
			String nome = clienteDTO.nome();
			String dataCadastro = clienteDTO.dataCadastro();
			
			String tipo = clienteDTO.contato().tipo();
			String texto = clienteDTO.contato().texto();
			
			Contato contato = new Contato(0, tipo, texto);
			Cliente clienteAtualizado = new Cliente(0, nome, dataCadastro, contato);
			
			cliente.atualizarCliente(clienteAtualizado);
			
			LocalizadorDeServico.atualizarCliente().executar(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DeleteMapping("/{idCliente}")
	public void removerCliente(@PathVariable(name = "idCliente") Integer idCliente) {
		try {
			Cliente cliente = LocalizadorDeServico.pesquisarClientes().pesquisarClientePorId(idCliente);
			LocalizadorDeServico.removerCliente().executar(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
