package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloLibros {
	private ArrayList<Libro> libros = new ArrayList<>();
	private File archivo = new File("datos/libros.txt");

	public ModeloLibros() {
		cargar();
	}

	public void registrar(String codigo, String titulo, String autor, String estado) throws Exception {
		if (codigo.isEmpty() || titulo.isEmpty() || autor.isEmpty())
			throw new Exception("Complete todos los campos.");
		if (buscar(codigo))
			throw new Exception("Ese c�digo ya existe.");
		libros.add(new Libro(codigo, titulo, autor, estado));
		guardar();
	}

	private boolean buscar(String codigo) {
		for (Libro l : libros)
			if (l.getCodigo().equalsIgnoreCase(codigo))
				return true;
		return false;
	}

	public ArrayList<Libro> listar() {
		return libros;
	}

	private void guardar() throws Exception {
		archivo.getParentFile().mkdirs();
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		for (Libro l : libros)
			salida.println(l.getCodigo() + ";" + l.getTitulo() + ";" + l.getAutor() + ";" + l.getEstado());
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
					libros.add(new Libro(datos[0], datos[1], datos[2], datos[3]));
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer libros.txt");
		}
	}
}
