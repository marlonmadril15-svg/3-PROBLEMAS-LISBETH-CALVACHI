package modelo;

public class Estudiante {
	private String codigo;
	private String nombre;
	private int nota;

	public Estudiante(String codigo, String nombre, int nota) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota = nota;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNota() {
		return nota;
	}

	public String getResultado() {
		if (nota >= 14)
			return "Aprobado";
		return "Reprobado";
	}
}
