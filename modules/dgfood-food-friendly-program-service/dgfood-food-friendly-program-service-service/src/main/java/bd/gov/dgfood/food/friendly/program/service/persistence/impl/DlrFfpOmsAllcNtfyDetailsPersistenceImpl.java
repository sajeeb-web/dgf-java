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

package bd.gov.dgfood.food.friendly.program.service.persistence.impl;

import bd.gov.dgfood.food.friendly.program.exception.NoSuchDlrFfpOmsAllcNtfyDetailsException;
import bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails;
import bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetailsTable;
import bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsImpl;
import bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl;
import bd.gov.dgfood.food.friendly.program.service.persistence.DlrFfpOmsAllcNtfyDetailsPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.DlrFfpOmsAllcNtfyDetailsUtil;
import bd.gov.dgfood.food.friendly.program.service.persistence.impl.constants.FFPBPersistenceConstants;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dlr ffp oms allc ntfy details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DlrFfpOmsAllcNtfyDetailsPersistence.class)
public class DlrFfpOmsAllcNtfyDetailsPersistenceImpl
	extends BasePersistenceImpl<DlrFfpOmsAllcNtfyDetails>
	implements DlrFfpOmsAllcNtfyDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DlrFfpOmsAllcNtfyDetailsUtil</code> to access the dlr ffp oms allc ntfy details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DlrFfpOmsAllcNtfyDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DlrFfpOmsAllcNtfyDetailsPersistenceImpl() {
		setModelClass(DlrFfpOmsAllcNtfyDetails.class);

		setModelImplClass(DlrFfpOmsAllcNtfyDetailsImpl.class);
		setModelPKClass(String.class);

		setTable(DlrFfpOmsAllcNtfyDetailsTable.INSTANCE);
	}

	/**
	 * Caches the dlr ffp oms allc ntfy details in the entity cache if it is enabled.
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 */
	@Override
	public void cacheResult(DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {
		entityCache.putResult(
			DlrFfpOmsAllcNtfyDetailsImpl.class,
			dlrFfpOmsAllcNtfyDetails.getPrimaryKey(), dlrFfpOmsAllcNtfyDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dlr ffp oms allc ntfy detailses in the entity cache if it is enabled.
	 *
	 * @param dlrFfpOmsAllcNtfyDetailses the dlr ffp oms allc ntfy detailses
	 */
	@Override
	public void cacheResult(
		List<DlrFfpOmsAllcNtfyDetails> dlrFfpOmsAllcNtfyDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dlrFfpOmsAllcNtfyDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails :
				dlrFfpOmsAllcNtfyDetailses) {

			if (entityCache.getResult(
					DlrFfpOmsAllcNtfyDetailsImpl.class,
					dlrFfpOmsAllcNtfyDetails.getPrimaryKey()) == null) {

				cacheResult(dlrFfpOmsAllcNtfyDetails);
			}
		}
	}

	/**
	 * Clears the cache for all dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DlrFfpOmsAllcNtfyDetailsImpl.class);

		finderCache.clearCache(DlrFfpOmsAllcNtfyDetailsImpl.class);
	}

	/**
	 * Clears the cache for the dlr ffp oms allc ntfy details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {
		entityCache.removeResult(
			DlrFfpOmsAllcNtfyDetailsImpl.class, dlrFfpOmsAllcNtfyDetails);
	}

	@Override
	public void clearCache(
		List<DlrFfpOmsAllcNtfyDetails> dlrFfpOmsAllcNtfyDetailses) {

		for (DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails :
				dlrFfpOmsAllcNtfyDetailses) {

			entityCache.removeResult(
				DlrFfpOmsAllcNtfyDetailsImpl.class, dlrFfpOmsAllcNtfyDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DlrFfpOmsAllcNtfyDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DlrFfpOmsAllcNtfyDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dlr ffp oms allc ntfy details with the primary key. Does not add the dlr ffp oms allc ntfy details to the database.
	 *
	 * @param allocNtfyId the primary key for the new dlr ffp oms allc ntfy details
	 * @return the new dlr ffp oms allc ntfy details
	 */
	@Override
	public DlrFfpOmsAllcNtfyDetails create(String allocNtfyId) {
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails =
			new DlrFfpOmsAllcNtfyDetailsImpl();

		dlrFfpOmsAllcNtfyDetails.setNew(true);
		dlrFfpOmsAllcNtfyDetails.setPrimaryKey(allocNtfyId);

		return dlrFfpOmsAllcNtfyDetails;
	}

	/**
	 * Removes the dlr ffp oms allc ntfy details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 * @throws NoSuchDlrFfpOmsAllcNtfyDetailsException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public DlrFfpOmsAllcNtfyDetails remove(String allocNtfyId)
		throws NoSuchDlrFfpOmsAllcNtfyDetailsException {

		return remove((Serializable)allocNtfyId);
	}

	/**
	 * Removes the dlr ffp oms allc ntfy details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 * @throws NoSuchDlrFfpOmsAllcNtfyDetailsException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public DlrFfpOmsAllcNtfyDetails remove(Serializable primaryKey)
		throws NoSuchDlrFfpOmsAllcNtfyDetailsException {

		Session session = null;

		try {
			session = openSession();

			DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails =
				(DlrFfpOmsAllcNtfyDetails)session.get(
					DlrFfpOmsAllcNtfyDetailsImpl.class, primaryKey);

			if (dlrFfpOmsAllcNtfyDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDlrFfpOmsAllcNtfyDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dlrFfpOmsAllcNtfyDetails);
		}
		catch (NoSuchDlrFfpOmsAllcNtfyDetailsException noSuchEntityException) {
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
	protected DlrFfpOmsAllcNtfyDetails removeImpl(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dlrFfpOmsAllcNtfyDetails)) {
				dlrFfpOmsAllcNtfyDetails =
					(DlrFfpOmsAllcNtfyDetails)session.get(
						DlrFfpOmsAllcNtfyDetailsImpl.class,
						dlrFfpOmsAllcNtfyDetails.getPrimaryKeyObj());
			}

			if (dlrFfpOmsAllcNtfyDetails != null) {
				session.delete(dlrFfpOmsAllcNtfyDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dlrFfpOmsAllcNtfyDetails != null) {
			clearCache(dlrFfpOmsAllcNtfyDetails);
		}

		return dlrFfpOmsAllcNtfyDetails;
	}

	@Override
	public DlrFfpOmsAllcNtfyDetails updateImpl(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		boolean isNew = dlrFfpOmsAllcNtfyDetails.isNew();

		if (!(dlrFfpOmsAllcNtfyDetails instanceof
				DlrFfpOmsAllcNtfyDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dlrFfpOmsAllcNtfyDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dlrFfpOmsAllcNtfyDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dlrFfpOmsAllcNtfyDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DlrFfpOmsAllcNtfyDetails implementation " +
					dlrFfpOmsAllcNtfyDetails.getClass());
		}

		DlrFfpOmsAllcNtfyDetailsModelImpl dlrFfpOmsAllcNtfyDetailsModelImpl =
			(DlrFfpOmsAllcNtfyDetailsModelImpl)dlrFfpOmsAllcNtfyDetails;

		if (isNew && (dlrFfpOmsAllcNtfyDetails.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dlrFfpOmsAllcNtfyDetails.setCreateDate(date);
			}
			else {
				dlrFfpOmsAllcNtfyDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dlrFfpOmsAllcNtfyDetails);
			}
			else {
				dlrFfpOmsAllcNtfyDetails =
					(DlrFfpOmsAllcNtfyDetails)session.merge(
						dlrFfpOmsAllcNtfyDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DlrFfpOmsAllcNtfyDetailsImpl.class, dlrFfpOmsAllcNtfyDetails, false,
			true);

		if (isNew) {
			dlrFfpOmsAllcNtfyDetails.setNew(false);
		}

		dlrFfpOmsAllcNtfyDetails.resetOriginalValues();

		return dlrFfpOmsAllcNtfyDetails;
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details
	 * @throws NoSuchDlrFfpOmsAllcNtfyDetailsException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public DlrFfpOmsAllcNtfyDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDlrFfpOmsAllcNtfyDetailsException {

		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails = fetchByPrimaryKey(
			primaryKey);

		if (dlrFfpOmsAllcNtfyDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDlrFfpOmsAllcNtfyDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dlrFfpOmsAllcNtfyDetails;
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key or throws a <code>NoSuchDlrFfpOmsAllcNtfyDetailsException</code> if it could not be found.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details
	 * @throws NoSuchDlrFfpOmsAllcNtfyDetailsException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public DlrFfpOmsAllcNtfyDetails findByPrimaryKey(String allocNtfyId)
		throws NoSuchDlrFfpOmsAllcNtfyDetailsException {

		return findByPrimaryKey((Serializable)allocNtfyId);
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details, or <code>null</code> if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public DlrFfpOmsAllcNtfyDetails fetchByPrimaryKey(String allocNtfyId) {
		return fetchByPrimaryKey((Serializable)allocNtfyId);
	}

	/**
	 * Returns all the dlr ffp oms allc ntfy detailses.
	 *
	 * @return the dlr ffp oms allc ntfy detailses
	 */
	@Override
	public List<DlrFfpOmsAllcNtfyDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @return the range of dlr ffp oms allc ntfy detailses
	 */
	@Override
	public List<DlrFfpOmsAllcNtfyDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dlr ffp oms allc ntfy detailses
	 */
	@Override
	public List<DlrFfpOmsAllcNtfyDetails> findAll(
		int start, int end,
		OrderByComparator<DlrFfpOmsAllcNtfyDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dlr ffp oms allc ntfy detailses
	 */
	@Override
	public List<DlrFfpOmsAllcNtfyDetails> findAll(
		int start, int end,
		OrderByComparator<DlrFfpOmsAllcNtfyDetails> orderByComparator,
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

		List<DlrFfpOmsAllcNtfyDetails> list = null;

		if (useFinderCache) {
			list = (List<DlrFfpOmsAllcNtfyDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DLRFFPOMSALLCNTFYDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DLRFFPOMSALLCNTFYDETAILS;

				sql = sql.concat(
					DlrFfpOmsAllcNtfyDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DlrFfpOmsAllcNtfyDetails>)QueryUtil.list(
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
	 * Removes all the dlr ffp oms allc ntfy detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails : findAll()) {
			remove(dlrFfpOmsAllcNtfyDetails);
		}
	}

	/**
	 * Returns the number of dlr ffp oms allc ntfy detailses.
	 *
	 * @return the number of dlr ffp oms allc ntfy detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DLRFFPOMSALLCNTFYDETAILS);

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
		return "allocNtfyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DLRFFPOMSALLCNTFYDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DlrFfpOmsAllcNtfyDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dlr ffp oms allc ntfy details persistence.
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

		_setDlrFfpOmsAllcNtfyDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDlrFfpOmsAllcNtfyDetailsUtilPersistence(null);

		entityCache.removeCache(DlrFfpOmsAllcNtfyDetailsImpl.class.getName());
	}

	private void _setDlrFfpOmsAllcNtfyDetailsUtilPersistence(
		DlrFfpOmsAllcNtfyDetailsPersistence
			dlrFfpOmsAllcNtfyDetailsPersistence) {

		try {
			Field field = DlrFfpOmsAllcNtfyDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dlrFfpOmsAllcNtfyDetailsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FFPBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FFPBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FFPBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DLRFFPOMSALLCNTFYDETAILS =
		"SELECT dlrFfpOmsAllcNtfyDetails FROM DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails";

	private static final String _SQL_COUNT_DLRFFPOMSALLCNTFYDETAILS =
		"SELECT COUNT(dlrFfpOmsAllcNtfyDetails) FROM DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dlrFfpOmsAllcNtfyDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DlrFfpOmsAllcNtfyDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DlrFfpOmsAllcNtfyDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}