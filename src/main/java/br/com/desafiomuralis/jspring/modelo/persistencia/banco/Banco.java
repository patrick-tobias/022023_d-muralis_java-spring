package br.com.desafiomuralis.jspring.modelo.persistencia.banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.github.javafaker.Faker;

import br.com.desafiomuralis.jspring.modelo.negocio.Cliente;
import br.com.desafiomuralis.jspring.modelo.negocio.Contato;

public class Banco {
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static Integer chave = 1;
	
	static {
		Faker faker = new Faker();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem-vindo(a)"
				+ "\n\n"
				+"***************"
				+ "\n\n"
				+ "Digite uma quantidade de contatos para popular o banco de dados");
		
		int quantidade = scanner.nextInt();
		for(int i=0; i<quantidade; i++) {
			LocalDate date = LocalDate.now();
			
			Contato contato = new Contato(chave++, "email", (faker.name().lastName().toLowerCase() + "@fatec.sp.gov.br"));
			Cliente cliente = new Cliente(chave++, faker.name().fullName(), date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), contato);
			
			clientes.add(cliente);
		}
		
		scanner.close();
		System.out.println("Banco populado com sucesso!");
	}
	
	public static void adicionarCliente(Cliente cliente) {
		cliente.setId(Banco.chave++);
		cliente.getContato().setId(Banco.chave++);
		clientes.add(cliente);
	}
	
	public static Collection<Cliente> pesquisarTodosOsClientes() {
		return Banco.clientes;
	}
	
	public static Cliente pesquisarClientePorId(Integer idCliente) throws Exception {
		Optional<Cliente> clienteOpt = Banco.clientes
										.stream()
										.filter(cliente -> idCliente.equals(cliente.getId()))
										.findFirst();
		if(clienteOpt.isPresent()) {
			return (Cliente) clienteOpt.get();
		} else {
			throw new RuntimeException("Cliente não encontrado para id fornecido!");
		}
	}
	
	public static void atualizarCliente(Cliente cliente) throws Exception {
		Optional<Cliente> clienteOpt = Banco.clientes
										.stream()
										.filter(c -> c.getId() == cliente.getId())
										.findFirst();
		if(clienteOpt.isPresent()) {
			clienteOpt.get().atualizarCliente(cliente);
			return;
		} else {
			throw new RuntimeException("Cliente não encontrado para atualização!");
		}
	}
	
	public static void removerCliente(Cliente cliente) throws Exception {
		Optional<Cliente> clienteOpt = Banco.clientes
										.stream()
										.filter(c -> c.getId() == cliente.getId())
										.findFirst();
		if(clienteOpt.isPresent()) {
			Banco.clientes.remove(clienteOpt.get());
			return;
		} else {
			throw new RuntimeException("Cliente não encontrado para exclusão");
		}
	}

}
