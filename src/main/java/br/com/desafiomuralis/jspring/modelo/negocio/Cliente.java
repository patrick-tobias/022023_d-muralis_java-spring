package br.com.desafiomuralis.jspring.modelo.negocio;

public class Cliente {
	
	private int id;
	private String nome;
	private String dataCadastro;
	
	private Contato contato;

	public Cliente(int id, String nome, String dataCadastro, Contato contato) {
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.contato = contato;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

	public void atualizarCliente(Cliente cliente) {
		setNome(cliente.getNome());
		this.contato.setTipo(cliente.getContato().getTipo());
		this.contato.setTexto(cliente.getContato().getTexto());
		
	}
	
	
	
	
}
