package Ejecutables;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;

import model.Clube;
import Vista.ViewTablaClubes;

public class Main {

	 public static EntityManager getEntityManager(){
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Entrega_JPA");
	        EntityManager manager = factory.createEntityManager();
	        return manager;
	 }

	 public static void closeEntityManager(EntityManager manager){
		 manager.close();
	 }

	 static ViewTablaClubes tablaClubes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Clube> lista = getEntityManager().createNamedQuery("Clube.findAll").getResultList();
		closeEntityManager(getEntityManager());

		tablaClubes = new ViewTablaClubes(lista);
			tablaClubes.setBounds(10,10,700,300);
			tablaClubes.setVisible(true);
		}

	}
