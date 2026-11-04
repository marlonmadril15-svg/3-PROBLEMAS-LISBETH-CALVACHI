package control;

import modelo.ModeloLibros;
import vista.VentanaLibros;

public class Main {
	public static void main(String[] args) {
		ModeloLibros modelo = new ModeloLibros();
		VentanaLibros vista = new VentanaLibros();
		ControladorLibros controlador = new ControladorLibros(modelo, vista);
		controlador.iniciar();
	}
}
