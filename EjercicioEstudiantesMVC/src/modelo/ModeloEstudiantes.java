package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloEstudiantes {
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	private File archivo = new File("datos/estudiantes.txt");

	public ModeloEstudiantes() {
		cargar();
	}

	public void registrar(String codigo, String nombre, int nota) throws Exception {
		if (codigo.isEmpty() || nombre.isEmpty())
			throw new Exception("Complete todos los campos.");
		if (nota < 1 || nota > 20)
			throw new Exception("La nota debe estar entre 1 y 20.");
		if (buscar(codigo))
			throw new Exception("Ese c�digo ya existe.");
		estudiantes.add(new Estudiante(codigo, nombre, nota));
		guardar();
	}

	private boolean buscar(String codigo) {
		for (Estudiante e : estudiantes)
			if (e.getCodigo().equalsIgnoreCase(codigo))
				return true;
		return false;
	}

	public ArrayList<Estudiante> listar() {
		return estudiantes;
	}

	private void guardar() throws Exception {
		archivo.getParentFile().mkdirs();
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		for (Estudiante e : estudiantes)
			salida.println(e.getCodigo() + ";" + e.getNombre() + ";" + e.getNota());
		salida.close();
	}

	private void cargar() {
		try {
			if (!archivo.exists())
				return;
			Scanner lector = new Scanner(archivo);
			while (lector.hasNextLine()) {
				String[] datos = lector.nextLine().split(";");
				if (datos.length == 3)
					estudiantes.add(new Estudiante(datos[0], datos[1], Integer.parseInt(datos[2])));
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer estudiantes.txt");
		}
	}
}
