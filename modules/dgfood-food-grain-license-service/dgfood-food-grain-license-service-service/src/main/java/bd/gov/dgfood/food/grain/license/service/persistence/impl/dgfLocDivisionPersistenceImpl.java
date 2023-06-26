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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocDivisionException;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivisionTable;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocDivisionImpl;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocDivisionModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocDivisionPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocDivisionUtil;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dgf loc division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = dgfLocDivisionPersistence.class)
public class dgfLocDivisionPersistenceImpl
	extends BasePersistenceImpl<dgfLocDivision>
	implements dgfLocDivisionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>dgfLocDivisionUtil</code> to access the dgf loc division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		dgfLocDivisionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public dgfLocDivisionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(dgfLocDivision.class);

		setModelImplClass(dgfLocDivisionImpl.class);
		setModelPKClass(long.class);

		setTable(dgfLocDivisionTable.INSTANCE);
	}

	/**
	 * Caches the dgf loc division in the entity cache if it is enabled.
	 *
	 * @param dgfLocDivision the dgf loc division
	 */
	@Override
	public void cacheResult(dgfLocDivision dgfLocDivision) {
		entityCache.putResult(
			dgfLocDivisionImpl.class, dgfLocDivision.getPrimaryKey(),
			dgfLocDivision);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf loc divisions in the entity cache if it is enabled.
	 *
	 * @param dgfLocDivisions the dgf loc divisions
	 */
	@Override
	public void cacheResult(List<dgfLocDivision> dgfLocDivisions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfLocDivisions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (dgfLocDivision dgfLocDivision : dgfLocDivisions) {
			if (entityCache.getResult(
					dgfLocDivisionImpl.class, dgfLocDivision.getPrimaryKey()) ==
						null) {

				cacheResult(dgfLocDivision);
			}
		}
	}

	/**
	 * Clears the cache for all dgf loc divisions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(dgfLocDivisionImpl.class);

		finderCache.clearCache(dgfLocDivisionImpl.class);
	}

	/**
	 * Clears the cache for the dgf loc division.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(dgfLocDivision dgfLocDivision) {
		entityCache.removeResult(dgfLocDivisionImpl.class, dgfLocDivision);
	}

	@Override
	public void clearCache(List<dgfLocDivision> dgfLocDivisions) {
		for (dgfLocDivision dgfLocDivision : dgfLocDivisions) {
			entityCache.removeResult(dgfLocDivisionImpl.class, dgfLocDivision);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(dgfLocDivisionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(dgfLocDivisionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf loc division with the primary key. Does not add the dgf loc division to the database.
	 *
	 * @param id the primary key for the new dgf loc division
	 * @return the new dgf loc division
	 */
	@Override
	public dgfLocDivision create(long id) {
		dgfLocDivision dgfLocDivision = new dgfLocDivisionImpl();

		dgfLocDivision.setNew(true);
		dgfLocDivision.setPrimaryKey(id);

		return dgfLocDivision;
	}

	/**
	 * Removes the dgf loc division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division that was removed
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	@Override
	public dgfLocDivision remove(long id) throws NoSuchdgfLocDivisionException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf loc division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf loc division
	 * @return the dgf loc division that was removed
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	@Override
	public dgfLocDivision remove(Serializable primaryKey)
		throws NoSuchdgfLocDivisionException {

		Session session = null;

		try {
			session = openSession();

			dgfLocDivision dgfLocDivision = (dgfLocDivision)session.get(
				dgfLocDivisionImpl.class, primaryKey);

			if (dgfLocDivision == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdgfLocDivisionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfLocDivision);
		}
		catch (NoSuchdgfLocDivisionException noSuchEntityException) {
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
	protected dgfLocDivision removeImpl(dgfLocDivision dgfLocDivision) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfLocDivision)) {
				dgfLocDivision = (dgfLocDivision)session.get(
					dgfLocDivisionImpl.class,
					dgfLocDivision.getPrimaryKeyObj());
			}

			if (dgfLocDivision != null) {
				session.delete(dgfLocDivision);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfLocDivision != null) {
			clearCache(dgfLocDivision);
		}

		return dgfLocDivision;
	}

	@Override
	public dgfLocDivision updateImpl(dgfLocDivision dgfLocDivision) {
		boolean isNew = dgfLocDivision.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfLocDivision);
			}
			else {
				dgfLocDivision = (dgfLocDivision)session.merge(dgfLocDivision);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			dgfLocDivisionImpl.class, dgfLocDivision, false, true);

		if (isNew) {
			dgfLocDivision.setNew(false);
		}

		dgfLocDivision.resetOriginalValues();

		return dgfLocDivision;
	}

	/**
	 * Returns the dgf loc division with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf loc division
	 * @return the dgf loc division
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	@Override
	public dgfLocDivision findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdgfLocDivisionException {

		dgfLocDivision dgfLocDivision = fetchByPrimaryKey(primaryKey);

		if (dgfLocDivision == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdgfLocDivisionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfLocDivision;
	}

	/**
	 * Returns the dgf loc division with the primary key or throws a <code>NoSuchdgfLocDivisionException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	@Override
	public dgfLocDivision findByPrimaryKey(long id)
		throws NoSuchdgfLocDivisionException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf loc division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division, or <code>null</code> if a dgf loc division with the primary key could not be found
	 */
	@Override
	public dgfLocDivision fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf loc divisions.
	 *
	 * @return the dgf loc divisions
	 */
	@Override
	public List<dgfLocDivision> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @return the range of dgf loc divisions
	 */
	@Override
	public List<dgfLocDivision> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc divisions
	 */
	@Override
	public List<dgfLocDivision> findAll(
		int start, int end,
		OrderByComparator<dgfLocDivision> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc divisions
	 */
	@Override
	public List<dgfLocDivision> findAll(
		int start, int end, OrderByComparator<dgfLocDivision> orderByComparator,
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

		List<dgfLocDivision> list = null;

		if (useFinderCache) {
			list = (List<dgfLocDivision>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFLOCDIVISION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFLOCDIVISION;

				sql = sql.concat(dgfLocDivisionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<dgfLocDivision>)QueryUtil.list(
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
	 * Removes all the dgf loc divisions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (dgfLocDivision dgfLocDivision : findAll()) {
			remove(dgfLocDivision);
		}
	}

	/**
	 * Returns the number of dgf loc divisions.
	 *
	 * @return the number of dgf loc divisions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFLOCDIVISION);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFLOCDIVISION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return dgfLocDivisionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf loc division persistence.
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

		_setdgfLocDivisionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setdgfLocDivisionUtilPersistence(null);

		entityCache.removeCache(dgfLocDivisionImpl.class.getName());
	}

	private void _setdgfLocDivisionUtilPersistence(
		dgfLocDivisionPersistence dgfLocDivisionPersistence) {

		try {
			Field field = dgfLocDivisionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfLocDivisionPersistence);
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

	private static final String _SQL_SELECT_DGFLOCDIVISION =
		"SELECT dgfLocDivision FROM dgfLocDivision dgfLocDivision";

	private static final String _SQL_COUNT_DGFLOCDIVISION =
		"SELECT COUNT(dgfLocDivision) FROM dgfLocDivision dgfLocDivision";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfLocDivision.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No dgfLocDivision exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		dgfLocDivisionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}