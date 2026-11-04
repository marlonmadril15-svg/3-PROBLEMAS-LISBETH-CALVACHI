package control;

import modelo.ModeloEstudiantes;
import vista.VentanaEstudiantes;

public class Main {
	public static void main(String[] args) {
		ModeloEstudiantes modelo = new ModeloEstudiantes();
		VentanaEstudiantes vista = new VentanaEstudiantes();
		ControladorEstudiantes controlador = new ControladorEstudiantes(modelo, vista);
		controlador.iniciar();
	}
}
