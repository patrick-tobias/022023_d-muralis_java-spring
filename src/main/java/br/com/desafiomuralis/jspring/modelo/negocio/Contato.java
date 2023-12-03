package br.com.desafiomuralis.jspring.modelo.negocio;

public class Contato {
	
	private int id;
	private String tipo;
	private String texto;
	
	public Contato(int id, String tipo, String texto) {
		this.id = id;
		this.tipo = tipo;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
