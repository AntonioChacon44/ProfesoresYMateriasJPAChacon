package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;


public class DocenteController {
	
	/**
	 * 
	 */
	public static List<Docente> findByNombre (String cadena) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM docente where lower(nombreCompleto) like ?", Docente.class);
		q.setParameter(1, "%" + cadena + "%");
		List<Docente> lista = (List<Docente>) q.getResultList();
		
		em.close();
		
		return lista;
	}
	
}
