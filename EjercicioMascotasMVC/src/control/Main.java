package control;

import modelo.ModeloMascotas;
import vista.VentanaMascotas;

public class Main {
	public static void main(String[] args) {
		ModeloMascotas modelo = new ModeloMascotas();
		VentanaMascotas vista = new VentanaMascotas();
		ControladorMascotas controlador = new ControladorMascotas(modelo, vista);
		controlador.iniciar();
	}
}
