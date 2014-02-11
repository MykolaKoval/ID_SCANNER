package org.kdev.idscanner.domain.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

import org.kdev.idscanner.domain.entity.AbstractEntity;

import com.google.inject.persist.Transactional;

@SuppressWarnings("rawtypes")
public abstract class GenericDaoImpl<E extends AbstractEntity, P> implements
		GenericDao<E, P> {

	@Inject 
	private Provider<EntityManager> emProvider;

	@SuppressWarnings("unchecked")
	@Transactional
	public P insert(E entity) {
		getEntityManager().persist(entity);
		return (P) entity.getId();
	}

	@Transactional
	public E find(P id) {
		return getEntityManager().find(getEntityClass(), id);
	}

	@Transactional
	public void update(E entity) {
		getEntityManager().merge(entity);
	}

	@Transactional
	public void delete(E entity) {
		getEntityManager().remove(entity);
	}

	public EntityManager getEntityManager() {
		return emProvider.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return getEntityManager().createNamedQuery(
				getEntityClass().getSimpleName() + ".GetAll").getResultList();
	}
	
	@Override
	public abstract Class<E> getEntityClass();
}
