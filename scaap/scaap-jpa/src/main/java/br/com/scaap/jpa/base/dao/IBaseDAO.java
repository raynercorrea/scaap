package br.com.scaap.jpa.base.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.scaap.jpa.base.entity.IBaseEntity;

public interface IBaseDAO extends Serializable{

	public <E extends IBaseEntity> E insert(E model) throws Exception;

	public <E extends IBaseEntity> E update(E model) throws Exception;

	public <E extends IBaseEntity> void delete(E model) throws Exception;

	public <E extends IBaseEntity> boolean isPersistent(E model) throws Exception;

	public <E extends IBaseEntity> E findById(Class<E> clazz, Integer id) throws Exception;

	public <E extends IBaseEntity> E findById(Class<E> clazz, Integer id, boolean detach) throws Exception;

	public <E extends IBaseEntity> Long getRowCount(Class<E> clazz) throws Exception;

	public <E extends IBaseEntity> List<E> findAll(Class<E> clazz) throws Exception;

	public void flush() throws Exception;

	public void refresh(Object object) throws Exception;

	public EntityManager getEntityManager() throws Exception;
	
}
