package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Cidade;

public class CidadeDAO {
	
	private EntityManagerFactory emf;
	private EntityManager        em;
	
	public CidadeDAO(){
		
		emf = Persistence.
			  createEntityManagerFactory("Prova_Ridineu_de_Moraes_Neto");		
	}
	
	public void salvar(Cidade cidade){
	  em = emf.createEntityManager();
	  em.getTransaction().begin();
	  em.persist(cidade);
	  em.getTransaction().commit();
	  em.close();		
	}
	
	@SuppressWarnings("unchecked")
	public List <Cidade> getAllCidades(){
		List <Cidade> cidades;
		
		em = emf.createEntityManager();
		cidades = em.
				   createQuery("Select c from Cidade c").
				   getResultList();
				   
		em.close();
		
		return cidades;
	}
}
