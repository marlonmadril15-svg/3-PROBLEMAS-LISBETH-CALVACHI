package control;

import modelo.ModeloMascotas;
import vista.VentanaMascotas;

public class ControladorMascotas {
	private ModeloMascotas modelo;
	private VentanaMascotas vista;

	public ControladorMascotas(ModeloMascotas modelo, VentanaMascotas vista) {
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
			modelo.registrar(vista.getCodigo(), vista.getNombre(), vista.getTipo(), vista.getDueno());
			vista.actualizar(modelo.listar());
			vista.limpiar();
			vista.mensaje("Mascota guardada.");
		} catch (Exception e) {
			vista.mensaje(e.getMessage());
		}
	}
}
