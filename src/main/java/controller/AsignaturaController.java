package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;


public class AsignaturaController {
	
	private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("profesoresymaterias");
	
	/**
	 * 
	 * @return
	 */
	public static List<Asignatura> findAllAsignaturas () {
		List<Asignatura> entities = new ArrayList<Asignatura>();
		EntityManager em = entityManagerFactory.createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM asignatura", Asignatura.class);
			entities = (List<Asignatura>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
}
