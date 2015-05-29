package br.com.scaap.dao.factory;

import javax.persistence.EntityManager;

import junit.framework.TestCase;
import br.com.scaap.jpa.entity.Usuario;
import br.com.scaap.jpa.util.JPAUtil;

public class JPAFactory extends TestCase {
	
	public void testFactory(){
		EntityManager entityManager = JPAUtil.createEntityManager();
		
		Usuario user = new Usuario("rayner", "12345");
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		JPAUtil.closeEntityManagerFactory();
	}

}
