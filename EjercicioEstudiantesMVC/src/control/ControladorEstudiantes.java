package control;

import modelo.ModeloEstudiantes;
import vista.VentanaEstudiantes;

public class ControladorEstudiantes {
	private ModeloEstudiantes modelo;
	private VentanaEstudiantes vista;

	public ControladorEstudiantes(ModeloEstudiantes modelo, VentanaEstudiantes vista) {
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
			int nota = Integer.parseInt(vista.getNota());
			modelo.registrar(vista.getCodigo(), vista.getNombre(), nota);
			vista.actualizar(modelo.listar());
			vista.limpiar();
			vista.mensaje("Estudiante guardado.");
		} catch (NumberFormatException e) {
			vista.mensaje("Escriba un n�mero para la nota.");
		} catch (Exception e) {
			vista.mensaje(e.getMessage());
		}
	}
}
