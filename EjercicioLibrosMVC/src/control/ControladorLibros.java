package control;

import modelo.ModeloLibros;
import vista.VentanaLibros;

public class ControladorLibros {
	private ModeloLibros modelo;
	private VentanaLibros vista;

	public ControladorLibros(ModeloLibros modelo, VentanaLibros vista) {
		this.modelo = modelo;
		this.vista = vista;
		vista.setControlador(this);
		vista.actualizar(modelo.listar());
	}

	public void iniciar() {
		vista.setVisible(true);
	}

	public void registrar() {
		try {
			modelo.registrar(vista.getCodigo(), vista.getTitulo(), vista.getAutor(), vista.getEstado());
			vista.actualizar(modelo.listar());
			vista.limpiar();
			vista.mensaje("Libro guardado.");
		} catch (Exception e) {
			vista.mensaje(e.getMessage());
		}
	}
}
