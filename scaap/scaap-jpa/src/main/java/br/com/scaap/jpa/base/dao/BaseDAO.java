package br.com.scaap.jpa.base.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import br.com.scaap.jpa.base.entity.IBaseEntity;

public class BaseDAO implements IBaseDAO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getRootLogger();

	@PersistenceContext(unitName = "scaap")
	protected EntityManager em;

	@Override
	public <E extends IBaseEntity> E insert(E model) throws Exception {
		try {
			em.persist(model);
			return model;
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro de persist�ncia.", e);
			throw new Exception("Ocorreu um erro inesperado na inser��o dos dados.");
		}
	}

	@Override
	public <E extends IBaseEntity> E update(E model) throws Exception {
		try {
			return em.merge(model);
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro de persist�ncia.", e);
			throw new Exception("Ocorreu um erro inesperado na atualiza��o dos dados.");
		}
	}

	@Override
	public <E extends IBaseEntity> void delete(E model) throws Exception {
		try {
			if (model == null) {
				return;
			}
			if (!em.contains(model)) {
				model = em.merge(model);
			}
			em.remove(model);
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro de persist�ncia.", e);
			throw new Exception("Ocorreu um erro inesperado na remo��o dos dados.");
		}
	}

	@Override
	public <E extends IBaseEntity> boolean isPersistent(E model) throws Exception {
		try {
			return em.contains(model);
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro de persist�ncia.", e);
			throw new Exception("Ocorreu um erro inesperado na verifica��o de percistencia dos dados.");
		}
	}

	@Override
	public <E extends IBaseEntity> E findById(Class<E> clazz, Integer id) throws Exception {
		try {
			return em.find(clazz, id);
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro ao pequisar por id a classe.", e);
			throw new Exception("Ocorreu um erro ao pequisar por id a classe.");
		}
	}
	
	@Override
	public <E extends IBaseEntity> E findById(Class<E> clazz, Integer id, boolean detach) throws Exception {
		try {
			E model = em.find(clazz, id);
			if (detach && isPersistent(model)) {
				em.detach(model);
			}
			return model;
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro ao pequisar por id a classe.", e);
			throw new Exception("Ocorreu um erro ao pequisar por id a classe.");
		}
	}

	@Override
	public <E extends IBaseEntity> List<E> findAll(Class<E> clazz) throws Exception {
		try {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<E> criteria = criteriaBuilder.createQuery(clazz);
			Root<E> root = criteria.from(clazz);
			criteria.select(root).from(clazz);
			criteria.orderBy(criteriaBuilder.asc(root.get("id")));

			TypedQuery<E> query = em.createQuery(criteria);
			return query.getResultList();
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro de persist�ncia.", e);
			throw new Exception("Ocorreu um erro inesperado na recupera��o de dados.");
		}
	}

	/**
	 * O m�todo retorna a contagem de resultados da Entidade recebida
	 */
	@Override
	public <E extends IBaseEntity> Long getRowCount(Class<E> clazz) throws Exception {
		try {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
			Root<E> root = criteria.from(clazz);
			CriteriaQuery<Long> select = criteria.select(criteriaBuilder.count(root));

			TypedQuery<Long> query = em.createQuery(select);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			logger.error("Ocorreu um erro de persist�ncia.", e);
			throw new Exception("Ocorreu um erro inesperado na recupera��o de dados.");
		}
    }

    public void flush() throws Exception {
		try {
			em.flush();
		} catch (PersistenceException e) {
			throw new Exception("Ocorreu um erro inesperado no flush. "+e.getMessage());
		}
    }

    public void refresh(Object object) throws Exception {
		try {
			em.refresh(object);
		} catch (PersistenceException e) {
			throw new Exception("Ocorreu um erro inesperado no refresh. "+e.getMessage());
		}
    }

	public EntityManager getEntityManager() {
		return em;
	}
		
}