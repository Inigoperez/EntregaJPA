package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.sun.prism.paint.Color;
import model.Clube;
import model.Partido;

public class ViewPartidos extends JFrame{

	private JLabel label1;
	private JLabel titulo;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] columnNames = {"ID","Nombre","Localidad","Provincia"};
	private Object[][] datos = {};

	public ViewPartidos(java.util.List<Partido> lista) {
		super("Mostrar lista de clubes");
        this.setSize(600,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel contenido = new JPanel();
            titulo = new JLabel("Clubes inscritos");
            titulo.setFont(new Font("titulo", Font.BOLD, 35));
            /////Lista de artistas////////
                dtm = new DefaultTableModel(datos,columnNames);
                table = new JTable(dtm);
                /////////////////////////////
                for(Clube datos : lista){
                	Object[] newRow = {
                			datos.getId(),
                			datos.getNombre(),
                			datos.getLocalidad(),
                			datos.getProvincia()
                	};
                	dtm.addRow(newRow);
            	}
                //////////////////////////////
                table.setPreferredScrollableViewportSize(new Dimension(500,100));
                scrollPane = new JScrollPane(table);
                getContentPane().add(scrollPane, BorderLayout.CENTER);
            //////Lista de artistas////////
        contenido.add(titulo);
        contenido.add(scrollPane);
        this.add(contenido);
	}
}

