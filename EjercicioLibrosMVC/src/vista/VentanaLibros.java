package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import control.ControladorLibros;
import modelo.Libro;

public class VentanaLibros extends JFrame {
	private static final Color AZUL = new Color(35, 75, 112);
	private static final Color VERDE = new Color(45, 130, 100);
	private static final Color FONDO = new Color(247, 249, 251);
	private JTextField codigo = new JTextField();
	private JTextField titulo = new JTextField();
	private JTextField autor = new JTextField();
	private JComboBox<String> estado = new JComboBox<>(new String[] { "Disponible", "Prestado" });
	private DefaultTableModel tablaModelo = new DefaultTableModel(
			new String[] { "C�digo", "T�tulo", "Autor", "Estado" }, 0);
	private JTable tabla = new JTable(tablaModelo);
	private ControladorLibros controlador;

	public VentanaLibros() {
		setTitle("Cat�logo de libros");
		setSize(800, 560);
		setMinimumSize(new Dimension(700, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel principal = new JPanel(new BorderLayout(0, 16));
		principal.setBackground(FONDO);
		principal.setBorder(BorderFactory.createEmptyBorder(22, 24, 22, 24));
		principal.add(crearEncabezado(), BorderLayout.NORTH);
		principal.add(crearContenido(), BorderLayout.CENTER);
		setContentPane(principal);
	}

	private JPanel crearEncabezado() {
		JPanel encabezado = new JPanel(new BorderLayout());
		encabezado.setBackground(AZUL);
		encabezado.setBorder(BorderFactory.createEmptyBorder(14, 18, 14, 18));
		JPanel textos = new JPanel(new GridLayout(2, 1, 0, 4));
		textos.setOpaque(false);
		JLabel titulo = new JLabel("Cat�logo de libros");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 22));
		JLabel subtitulo = new JLabel("Registro de libros y disponibilidad");
		subtitulo.setForeground(new Color(225, 235, 244));
		textos.add(titulo);
		textos.add(subtitulo);
		encabezado.add(textos, BorderLayout.WEST);
		return encabezado;
	}

	private JPanel crearContenido() {
		JPanel contenido = new JPanel(new BorderLayout(0, 12));
		contenido.setOpaque(false);
		contenido.add(crearFormulario(), BorderLayout.NORTH);
		JPanel registros = new JPanel(new BorderLayout(0, 8));
		registros.setOpaque(false);
		JLabel tituloTabla = new JLabel("Registros guardados");
		tituloTabla.setFont(new Font("Arial", Font.BOLD, 14));
		registros.add(tituloTabla, BorderLayout.NORTH);
		registros.add(crearTabla(), BorderLayout.CENTER);
		contenido.add(registros, BorderLayout.CENTER);
		return contenido;
	}

	private JPanel crearFormulario() {
		JPanel formulario = new JPanel(new BorderLayout(0, 12));
		formulario.setBackground(Color.WHITE);
		formulario
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(215, 222, 230)),
						BorderFactory.createEmptyBorder(12, 14, 12, 14)));
		JLabel tituloFormulario = new JLabel("Datos del registro");
		tituloFormulario.setFont(new Font("Arial", Font.BOLD, 14));
		formulario.add(tituloFormulario, BorderLayout.NORTH);

		JPanel campos = new JPanel(new GridLayout(2, 4, 12, 8));
		campos.setOpaque(false);
		campos.add(crearEtiqueta("C�digo"));
		campos.add(codigo);
		campos.add(crearEtiqueta("T�tulo"));
		campos.add(titulo);
		campos.add(crearEtiqueta("Autor"));
		campos.add(autor);
		campos.add(crearEtiqueta("Estado"));
		campos.add(estado);
		formulario.add(campos, BorderLayout.CENTER);

		JButton guardar = crearBoton("Guardar", VERDE);
		JButton limpiar = crearBoton("Limpiar", new Color(225, 234, 242));
		limpiar.setForeground(AZUL);
		JPanel botones = new JPanel();
		botones.setOpaque(false);
		botones.add(guardar);
		botones.add(limpiar);
		formulario.add(botones, BorderLayout.SOUTH);

		guardar.addActionListener(e -> controlador.registrar());
		limpiar.addActionListener(e -> limpiar());
		return formulario;
	}

	private JScrollPane crearTabla() {
		tabla.setRowHeight(28);
		tabla.setFont(new Font("Arial", Font.PLAIN, 13));
		tabla.setFillsViewportHeight(true);
		tabla.setSelectionBackground(new Color(220, 235, 246));
		tabla.setGridColor(new Color(220, 226, 232));
		JTableHeader encabezado = tabla.getTableHeader();
		encabezado.setBackground(new Color(229, 238, 246));
		encabezado.setForeground(AZUL);
		encabezado.setFont(new Font("Arial", Font.BOLD, 12));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(700, 220));
		return scroll;
	}

	private JLabel crearEtiqueta(String texto) {
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 12));
		etiqueta.setForeground(new Color(55, 65, 75));
		return etiqueta;
	}

	private JButton crearBoton(String texto, Color fondo) {
		JButton boton = new JButton(texto);
		boton.setBackground(fondo);
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Arial", Font.BOLD, 13));
		boton.setFocusPainted(false);
		return boton;
	}

	public void setControlador(ControladorLibros controlador) {
		this.controlador = controlador;
	}

	public String getCodigo() {
		return codigo.getText().trim();
	}

	public String getTitulo() {
		return titulo.getText().trim();
	}

	public String getAutor() {
		return autor.getText().trim();
	}

	public String getEstado() {
		return estado.getSelectedItem().toString();
	}

	public void limpiar() {
		codigo.setText("");
		titulo.setText("");
		autor.setText("");
		estado.setSelectedIndex(0);
	}

	public void actualizar(ArrayList<Libro> lista) {
		tablaModelo.setRowCount(0);
		for (Libro libro : lista) {
			tablaModelo
					.addRow(new Object[] { libro.getCodigo(), libro.getTitulo(), libro.getAutor(), libro.getEstado() });
		}
	}

	public void mensaje(String texto) {
		JOptionPane.showMessageDialog(this, texto, "Cat�logo de libros", JOptionPane.INFORMATION_MESSAGE);
	}
}
