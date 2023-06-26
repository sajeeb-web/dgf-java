/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bd.gov.dgfood.food.grain.license.service.persistence.impl;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfBnkChllnDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls;
import bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfBnkChllnDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfBnkChllnDtlsUtil;
import bd.gov.dgfood.food.grain.license.service.persistence.impl.constants.DGFPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dgf bnk chlln dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfBnkChllnDtlsPersistence.class)
public class DgfBnkChllnDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfBnkChllnDtls>
	implements DgfBnkChllnDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfBnkChllnDtlsUtil</code> to access the dgf bnk chlln dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfBnkChllnDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DgfBnkChllnDtlsPersistenceImpl() {
		setModelClass(DgfBnkChllnDtls.class);

		setModelImplClass(DgfBnkChllnDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfBnkChllnDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf bnk chlln dtls in the entity cache if it is enabled.
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 */
	@Override
	public void cacheResult(DgfBnkChllnDtls dgfBnkChllnDtls) {
		entityCache.putResult(
			DgfBnkChllnDtlsImpl.class, dgfBnkChllnDtls.getPrimaryKey(),
			dgfBnkChllnDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf bnk chlln dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfBnkChllnDtlses the dgf bnk chlln dtlses
	 */
	@Override
	public void cacheResult(List<DgfBnkChllnDtls> dgfBnkChllnDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfBnkChllnDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfBnkChllnDtls dgfBnkChllnDtls : dgfBnkChllnDtlses) {
			if (entityCache.getResult(
					DgfBnkChllnDtlsImpl.class,
					dgfBnkChllnDtls.getPrimaryKey()) == null) {

				cacheResult(dgfBnkChllnDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf bnk chlln dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfBnkChllnDtlsImpl.class);

		finderCache.clearCache(DgfBnkChllnDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf bnk chlln dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfBnkChllnDtls dgfBnkChllnDtls) {
		entityCache.removeResult(DgfBnkChllnDtlsImpl.class, dgfBnkChllnDtls);
	}

	@Override
	public void clearCache(List<DgfBnkChllnDtls> dgfBnkChllnDtlses) {
		for (DgfBnkChllnDtls dgfBnkChllnDtls : dgfBnkChllnDtlses) {
			entityCache.removeResult(
				DgfBnkChllnDtlsImpl.class, dgfBnkChllnDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfBnkChllnDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfBnkChllnDtlsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf bnk chlln dtls with the primary key. Does not add the dgf bnk chlln dtls to the database.
	 *
	 * @param bnkChllnId the primary key for the new dgf bnk chlln dtls
	 * @return the new dgf bnk chlln dtls
	 */
	@Override
	public DgfBnkChllnDtls create(long bnkChllnId) {
		DgfBnkChllnDtls dgfBnkChllnDtls = new DgfBnkChllnDtlsImpl();

		dgfBnkChllnDtls.setNew(true);
		dgfBnkChllnDtls.setPrimaryKey(bnkChllnId);

		return dgfBnkChllnDtls;
	}

	/**
	 * Removes the dgf bnk chlln dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public DgfBnkChllnDtls remove(long bnkChllnId)
		throws NoSuchDgfBnkChllnDtlsException {

		return remove((Serializable)bnkChllnId);
	}

	/**
	 * Removes the dgf bnk chlln dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public DgfBnkChllnDtls remove(Serializable primaryKey)
		throws NoSuchDgfBnkChllnDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfBnkChllnDtls dgfBnkChllnDtls = (DgfBnkChllnDtls)session.get(
				DgfBnkChllnDtlsImpl.class, primaryKey);

			if (dgfBnkChllnDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfBnkChllnDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfBnkChllnDtls);
		}
		catch (NoSuchDgfBnkChllnDtlsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DgfBnkChllnDtls removeImpl(DgfBnkChllnDtls dgfBnkChllnDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfBnkChllnDtls)) {
				dgfBnkChllnDtls = (DgfBnkChllnDtls)session.get(
					DgfBnkChllnDtlsImpl.class,
					dgfBnkChllnDtls.getPrimaryKeyObj());
			}

			if (dgfBnkChllnDtls != null) {
				session.delete(dgfBnkChllnDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfBnkChllnDtls != null) {
			clearCache(dgfBnkChllnDtls);
		}

		return dgfBnkChllnDtls;
	}

	@Override
	public DgfBnkChllnDtls updateImpl(DgfBnkChllnDtls dgfBnkChllnDtls) {
		boolean isNew = dgfBnkChllnDtls.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfBnkChllnDtls);
			}
			else {
				dgfBnkChllnDtls = (DgfBnkChllnDtls)session.merge(
					dgfBnkChllnDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfBnkChllnDtlsImpl.class, dgfBnkChllnDtls, false, true);

		if (isNew) {
			dgfBnkChllnDtls.setNew(false);
		}

		dgfBnkChllnDtls.resetOriginalValues();

		return dgfBnkChllnDtls;
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public DgfBnkChllnDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfBnkChllnDtlsException {

		DgfBnkChllnDtls dgfBnkChllnDtls = fetchByPrimaryKey(primaryKey);

		if (dgfBnkChllnDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfBnkChllnDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfBnkChllnDtls;
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or throws a <code>NoSuchDgfBnkChllnDtlsException</code> if it could not be found.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public DgfBnkChllnDtls findByPrimaryKey(long bnkChllnId)
		throws NoSuchDgfBnkChllnDtlsException {

		return findByPrimaryKey((Serializable)bnkChllnId);
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls, or <code>null</code> if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public DgfBnkChllnDtls fetchByPrimaryKey(long bnkChllnId) {
		return fetchByPrimaryKey((Serializable)bnkChllnId);
	}

	/**
	 * Returns all the dgf bnk chlln dtlses.
	 *
	 * @return the dgf bnk chlln dtlses
	 */
	@Override
	public List<DgfBnkChllnDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @return the range of dgf bnk chlln dtlses
	 */
	@Override
	public List<DgfBnkChllnDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf bnk chlln dtlses
	 */
	@Override
	public List<DgfBnkChllnDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBnkChllnDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf bnk chlln dtlses
	 */
	@Override
	public List<DgfBnkChllnDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBnkChllnDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DgfBnkChllnDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfBnkChllnDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFBNKCHLLNDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFBNKCHLLNDTLS;

				sql = sql.concat(DgfBnkChllnDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfBnkChllnDtls>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dgf bnk chlln dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfBnkChllnDtls dgfBnkChllnDtls : findAll()) {
			remove(dgfBnkChllnDtls);
		}
	}

	/**
	 * Returns the number of dgf bnk chlln dtlses.
	 *
	 * @return the number of dgf bnk chlln dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFBNKCHLLNDTLS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "bnkChllnId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFBNKCHLLNDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfBnkChllnDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf bnk chlln dtls persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setDgfBnkChllnDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfBnkChllnDtlsUtilPersistence(null);

		entityCache.removeCache(DgfBnkChllnDtlsImpl.class.getName());
	}

	private void _setDgfBnkChllnDtlsUtilPersistence(
		DgfBnkChllnDtlsPersistence dgfBnkChllnDtlsPersistence) {

		try {
			Field field = DgfBnkChllnDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfBnkChllnDtlsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DGFPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DGFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DGFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DGFBNKCHLLNDTLS =
		"SELECT dgfBnkChllnDtls FROM DgfBnkChllnDtls dgfBnkChllnDtls";

	private static final String _SQL_COUNT_DGFBNKCHLLNDTLS =
		"SELECT COUNT(dgfBnkChllnDtls) FROM DgfBnkChllnDtls dgfBnkChllnDtls";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfBnkChllnDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfBnkChllnDtls exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfBnkChllnDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}