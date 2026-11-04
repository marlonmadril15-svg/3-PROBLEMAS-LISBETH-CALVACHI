package modelo;

public class Mascota {
	private String codigo;
	private String nombre;
	private String tipo;
	private String dueno;

	public Mascota(String codigo, String nombre, String tipo, String dueno) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.dueno = dueno;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDueno() {
		return dueno;
	}
}
