package modelo;

public class Libro {
	private String codigo;
	private String titulo;
	private String autor;
	private String estado;

	public Libro(String codigo, String titulo, String autor, String estado) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEstado() {
		return estado;
	}
}
