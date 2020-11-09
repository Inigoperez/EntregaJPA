package Vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.List;
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import com.sun.prism.paint.Color;
	import model.Clube;

public class ViewCrearEquipo extends JFrame{

	private JLabel label_despegable;
	private JLabel titulo;
	private JLabel label_nombre;
	private JLabel label_categoria;
	private JTextField  inputNombre;
	private JTextField  inputCategoria;
	private JComboBox<String> desplegable;

	public ViewCrearEquipo(java.util.List lista){
		super("Mostrar lista de clubes");
	        this.setSize(600,400);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        JPanel contenido = new JPanel();
	            titulo = new JLabel("Insertar equipo nuevo");
	            titulo.setFont(new Font("titulo", Font.BOLD, 35));
	        ////////// FORMULARIO //////////
            JPanel formulario = new JPanel();
            	/////Seleccion de club////////////
            	label_despegable = new JLabel("Elige el club al que pertenece");
	            String[] listaclubes = (String[]) lista.toArray(new String[lista.size()]);
				desplegable = new JComboBox<String>(listaclubes);
				//////////////////////////////////
				///// Nombre de equipo////////////
				label_nombre = new JLabel("Inserte el nombre del equipo");
				inputNombre = new JTextField();
                inputNombre.setBounds(225,100,150,20);
				//////////////////////////////////
	            ///// Categoria de equipo/////////
				label_categoria = new JLabel("Inserta la categoria del equipo");
				inputCategoria = new JTextField();
				inputCategoria.setBounds(225,100,150,20);
	            //////////////////////////////////
		        //////////////////////////////////
	        contenido.add(titulo);
	        formulario.add(label_despegable);
	        formulario.add(desplegable);
	        formulario.add(label_nombre);
	        formulario.add(label_nombre);
	        formulario.add(inputNombre);
	        formulario.add(label_categoria);
	        formulario.add(label_categoria);
	        formulario.add(inputCategoria);
	        contenido.add(formulario);
	        this.add(contenido);
	}
}
