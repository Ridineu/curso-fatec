package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Time;

public class TimeDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public TimeDAO() {

		emf = Persistence.createEntityManagerFactory("Ridineu_0030481521033");
	}

	public void salvar(Time time) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(time);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Time> getAllTimes() {
		List<Time> times;

		em = emf.createEntityManager();
		times = em.createQuery("Select c from Time c").getResultList();

		em.close();

		return times;
	}
}
