package org.kdev.idscanner.domain.dao;

import org.junit.After;
import org.junit.Before;
import org.kdev.idscanner.domain.entity.AbstractEntity;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("rawtypes")
public class BaseDaoTest<E extends AbstractEntity> {

	@Inject
	GenericDao<E, Long> dao;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new TestAppPersistenceModule());
		injector.injectMembers(this);
		dao.getEntityManager().getTransaction().begin();
	}

	@After
	public void tearDown() throws Exception {
		dao.getEntityManager().getTransaction().rollback();
	}
	
}
