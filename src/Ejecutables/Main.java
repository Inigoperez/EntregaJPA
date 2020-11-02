package Ejecutables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Clube;

public class Main {

	 public static EntityManager getEntityManager(){
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BD-Liga");
	        EntityManager manager = factory.createEntityManager();
	        return manager;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = getEntityManager();

		TypedQuery<Clube> consultaClub= manager.createNamedQuery("Clube.findAll", Clube.class);
		java.util.List<Clube> lista= consultaClub.getResultList();

		for (Clube a : lista) {

			System.out.println(a.getId()+"," +a.getNombre());

		}
		manager.close();
	}

}
