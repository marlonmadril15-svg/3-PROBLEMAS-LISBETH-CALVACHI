package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloMascotas {
	private ArrayList<Mascota> mascotas = new ArrayList<>();
	private File archivo = new File("datos/mascotas.txt");

	public ModeloMascotas() {
		cargar();
	}

	public void registrar(String codigo, String nombre, String tipo, String dueno) throws Exception {
		if (codigo.isEmpty() || nombre.isEmpty() || tipo.isEmpty() || dueno.isEmpty())
			throw new Exception("Complete todos los campos.");
		if (buscar(codigo))
			throw new Exception("Ese c�digo ya existe.");
		mascotas.add(new Mascota(codigo, nombre, tipo, dueno));
		guardar();
	}

	private boolean buscar(String codigo) {
		for (Mascota m : mascotas)
			if (m.getCodigo().equalsIgnoreCase(codigo))
				return true;
		return false;
	}

	public ArrayList<Mascota> listar() {
		return mascotas;
	}

	private void guardar() throws Exception {
		archivo.getParentFile().mkdirs();
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		for (Mascota m : mascotas)
			salida.println(m.getCodigo() + ";" + m.getNombre() + ";" + m.getTipo() + ";" + m.getDueno());
		salida.close();
	}

	private void cargar() {
		try {
			if (!archivo.exists())
				return;
			Scanner lector = new Scanner(archivo);
			while (lector.hasNextLine()) {
				String[] datos = lector.nextLine().split(";");
				if (datos.length == 4)
					mascotas.add(new Mascota(datos[0], datos[1], datos[2], datos[3]));
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer mascotas.txt");
		}
	}
}
