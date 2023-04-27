package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

public class AsignaturaPorDocenteController {
	
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("profesoresymaterias");
	
	/**
	 * 
	 * @param cadena
	 * @return
	 */
	public static List<Asignaturaspordocente> findByIdDocente (Docente idDocente) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM asignaturaspordocente where idDocente = ?", Asignaturaspordocente.class);
		q.setParameter(1, idDocente);
		List<Asignaturaspordocente> lista = (List<Asignaturaspordocente>) q.getResultList();
		
		em.close();
		
		return lista;
	}
	
	/** 
	 * 
	 */
	public static Asignaturaspordocente findBySomeId(Docente idDocente, Asignatura idAsignatura) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Asignaturaspordocente o = null;

		try {
			Query q = em.createNativeQuery(
					"SELECT * FROM asignaturaspordocente where idDocente = ? and idAsignatura = ?;",
					Asignaturaspordocente.class);
			q.setParameter(1, idDocente);
			q.setParameter(2, idDocente);

			o = (Asignaturaspordocente) q.getSingleResult();
		} catch (Exception e) {
		}

		em.close();

		return o;
	}
	
	/**
	 * 
	 * @param o
	 */
	public static void update(Asignaturaspordocente o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param o
	 */
	public static void insert(Asignaturaspordocente o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
