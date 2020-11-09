package Ejecutables;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import model.*;
import Vista.*;

public class Main {

	static int option;
	static Scanner sc = new Scanner(System.in);

	public static EntityManager getEntityManager(){
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Entrega_JPA");
	        EntityManager manager = factory.createEntityManager();
	        return manager;
	 }

	public static void closeEntityManager(EntityManager manager){
		 manager.close();
	 }

	public static void ViewClubes(){
		ViewTablaClubes tablaClubes;
		List<Clube> listaClubes = getEntityManager().createNamedQuery("Clube.findAll").getResultList();
		closeEntityManager(getEntityManager());

		tablaClubes = new ViewTablaClubes(listaClubes);
			tablaClubes.setBounds(10,10,700,300);
			tablaClubes.setVisible(true);
		}

	public static void ViewCrearEquipos(){
		ViewCrearEquipo crearEquipo;
		List<String> listaClubes = getEntityManager().createNamedQuery("Clube.findName").getResultList();
		closeEntityManager(getEntityManager());
		crearEquipo = new ViewCrearEquipo(listaClubes);
			crearEquipo.setBounds(10,10,400,300);
			crearEquipo.setVisible(true);
	}


	public static void AsignarArbitros(){
		List<Participante> listaArbitros = getEntityManager().createNamedQuery("Participante.findArbitros").getResultList();
		List<Partido> listaPartidosDisp = getEntityManager().createNamedQuery("Partido.SinArbis").getResultList();
		for(Participante datos : listaArbitros){
			System.out.println(datos.getId());
			System.out.println(datos.getNombre());
			System.out.println(datos.getTipo());
		}
		for(Partido datos1 : listaPartidosDisp){
			System.out.println(datos1.getId());
			System.out.println(datos1.getLocalidad());
			for(Equipo datos2 : datos1.getEquipos()){
				System.out.println(datos2.getNombre());
			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(option!=7){
			System.out.println("---------------------------------");
			System.out.println("Selecciona la opción que quieras:");
			System.out.println("1.-Mostrar clubes");
			System.out.println("2.-Mostar partidos");
			System.out.println("3.-Asignar arbitros a partido");
			System.out.println("4.-Crear partido");
			System.out.println("5.-Agregar equipo nuevo");
			System.out.println("7.-Salir");
			System.out.println("---------------------------------");
			option=sc.nextInt();
			switch(option){
			case 1:
				ViewClubes();
			break;
			case 2:

				break;
			case 3:
				//AsignarArbitros();
				break;
			case 5:
				ViewCrearEquipos();
				break;
			case 7:
				System.out.println("Adios!");
				break;
			}
		}
	}
}

