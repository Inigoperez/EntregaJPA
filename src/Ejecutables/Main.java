package Ejecutables;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Clube;

public class Main {

	 public static EntityManager getEntityManager(){
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Entrega_JPA");
	        EntityManager manager = factory.createEntityManager();
	        return manager;
	 }

	 public static void closeEntityManager(EntityManager manager){
		 manager.close();
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Clube> lista = getEntityManager().createNamedQuery("Clube.findAll").getResultList();
		for(Clube datos : lista){
			System.out.println(datos.getId());
			System.out.println(datos.getNombre());
			System.out.println(datos.getLocalidad());
			System.out.println(datos.getProvincia());
		}
		closeEntityManager(getEntityManager());
	}
}
