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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfAttachmentsException;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfAttachmentsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfAttachmentsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfAttachmentsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfAttachmentsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfAttachmentsUtil;
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
 * The persistence implementation for the dgf attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfAttachmentsPersistence.class)
public class DgfAttachmentsPersistenceImpl
	extends BasePersistenceImpl<DgfAttachments>
	implements DgfAttachmentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfAttachmentsUtil</code> to access the dgf attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfAttachmentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DgfAttachmentsPersistenceImpl() {
		setModelClass(DgfAttachments.class);

		setModelImplClass(DgfAttachmentsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfAttachmentsTable.INSTANCE);
	}

	/**
	 * Caches the dgf attachments in the entity cache if it is enabled.
	 *
	 * @param dgfAttachments the dgf attachments
	 */
	@Override
	public void cacheResult(DgfAttachments dgfAttachments) {
		entityCache.putResult(
			DgfAttachmentsImpl.class, dgfAttachments.getPrimaryKey(),
			dgfAttachments);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf attachmentses in the entity cache if it is enabled.
	 *
	 * @param dgfAttachmentses the dgf attachmentses
	 */
	@Override
	public void cacheResult(List<DgfAttachments> dgfAttachmentses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfAttachmentses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfAttachments dgfAttachments : dgfAttachmentses) {
			if (entityCache.getResult(
					DgfAttachmentsImpl.class, dgfAttachments.getPrimaryKey()) ==
						null) {

				cacheResult(dgfAttachments);
			}
		}
	}

	/**
	 * Clears the cache for all dgf attachmentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfAttachmentsImpl.class);

		finderCache.clearCache(DgfAttachmentsImpl.class);
	}

	/**
	 * Clears the cache for the dgf attachments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfAttachments dgfAttachments) {
		entityCache.removeResult(DgfAttachmentsImpl.class, dgfAttachments);
	}

	@Override
	public void clearCache(List<DgfAttachments> dgfAttachmentses) {
		for (DgfAttachments dgfAttachments : dgfAttachmentses) {
			entityCache.removeResult(DgfAttachmentsImpl.class, dgfAttachments);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfAttachmentsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfAttachmentsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf attachments with the primary key. Does not add the dgf attachments to the database.
	 *
	 * @param attchmId the primary key for the new dgf attachments
	 * @return the new dgf attachments
	 */
	@Override
	public DgfAttachments create(long attchmId) {
		DgfAttachments dgfAttachments = new DgfAttachmentsImpl();

		dgfAttachments.setNew(true);
		dgfAttachments.setPrimaryKey(attchmId);

		return dgfAttachments;
	}

	/**
	 * Removes the dgf attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments that was removed
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	@Override
	public DgfAttachments remove(long attchmId)
		throws NoSuchDgfAttachmentsException {

		return remove((Serializable)attchmId);
	}

	/**
	 * Removes the dgf attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf attachments
	 * @return the dgf attachments that was removed
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	@Override
	public DgfAttachments remove(Serializable primaryKey)
		throws NoSuchDgfAttachmentsException {

		Session session = null;

		try {
			session = openSession();

			DgfAttachments dgfAttachments = (DgfAttachments)session.get(
				DgfAttachmentsImpl.class, primaryKey);

			if (dgfAttachments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfAttachmentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfAttachments);
		}
		catch (NoSuchDgfAttachmentsException noSuchEntityException) {
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
	protected DgfAttachments removeImpl(DgfAttachments dgfAttachments) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfAttachments)) {
				dgfAttachments = (DgfAttachments)session.get(
					DgfAttachmentsImpl.class,
					dgfAttachments.getPrimaryKeyObj());
			}

			if (dgfAttachments != null) {
				session.delete(dgfAttachments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfAttachments != null) {
			clearCache(dgfAttachments);
		}

		return dgfAttachments;
	}

	@Override
	public DgfAttachments updateImpl(DgfAttachments dgfAttachments) {
		boolean isNew = dgfAttachments.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfAttachments);
			}
			else {
				dgfAttachments = (DgfAttachments)session.merge(dgfAttachments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfAttachmentsImpl.class, dgfAttachments, false, true);

		if (isNew) {
			dgfAttachments.setNew(false);
		}

		dgfAttachments.resetOriginalValues();

		return dgfAttachments;
	}

	/**
	 * Returns the dgf attachments with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf attachments
	 * @return the dgf attachments
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	@Override
	public DgfAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfAttachmentsException {

		DgfAttachments dgfAttachments = fetchByPrimaryKey(primaryKey);

		if (dgfAttachments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfAttachmentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfAttachments;
	}

	/**
	 * Returns the dgf attachments with the primary key or throws a <code>NoSuchDgfAttachmentsException</code> if it could not be found.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	@Override
	public DgfAttachments findByPrimaryKey(long attchmId)
		throws NoSuchDgfAttachmentsException {

		return findByPrimaryKey((Serializable)attchmId);
	}

	/**
	 * Returns the dgf attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments, or <code>null</code> if a dgf attachments with the primary key could not be found
	 */
	@Override
	public DgfAttachments fetchByPrimaryKey(long attchmId) {
		return fetchByPrimaryKey((Serializable)attchmId);
	}

	/**
	 * Returns all the dgf attachmentses.
	 *
	 * @return the dgf attachmentses
	 */
	@Override
	public List<DgfAttachments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @return the range of dgf attachmentses
	 */
	@Override
	public List<DgfAttachments> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf attachmentses
	 */
	@Override
	public List<DgfAttachments> findAll(
		int start, int end,
		OrderByComparator<DgfAttachments> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf attachmentses
	 */
	@Override
	public List<DgfAttachments> findAll(
		int start, int end, OrderByComparator<DgfAttachments> orderByComparator,
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

		List<DgfAttachments> list = null;

		if (useFinderCache) {
			list = (List<DgfAttachments>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFATTACHMENTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFATTACHMENTS;

				sql = sql.concat(DgfAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfAttachments>)QueryUtil.list(
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
	 * Removes all the dgf attachmentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfAttachments dgfAttachments : findAll()) {
			remove(dgfAttachments);
		}
	}

	/**
	 * Returns the number of dgf attachmentses.
	 *
	 * @return the number of dgf attachmentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFATTACHMENTS);

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
		return "attchmId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFATTACHMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfAttachmentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf attachments persistence.
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

		_setDgfAttachmentsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfAttachmentsUtilPersistence(null);

		entityCache.removeCache(DgfAttachmentsImpl.class.getName());
	}

	private void _setDgfAttachmentsUtilPersistence(
		DgfAttachmentsPersistence dgfAttachmentsPersistence) {

		try {
			Field field = DgfAttachmentsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfAttachmentsPersistence);
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

	private static final String _SQL_SELECT_DGFATTACHMENTS =
		"SELECT dgfAttachments FROM DgfAttachments dgfAttachments";

	private static final String _SQL_COUNT_DGFATTACHMENTS =
		"SELECT COUNT(dgfAttachments) FROM DgfAttachments dgfAttachments";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfAttachments.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfAttachments exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfAttachmentsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}