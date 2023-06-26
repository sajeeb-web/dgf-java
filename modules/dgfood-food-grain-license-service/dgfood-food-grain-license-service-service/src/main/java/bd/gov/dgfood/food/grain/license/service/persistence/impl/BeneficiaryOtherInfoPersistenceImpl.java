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

import bd.gov.dgfood.food.grain.license.exception.NoSuchBeneficiaryOtherInfoException;
import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo;
import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfoTable;
import bd.gov.dgfood.food.grain.license.model.impl.BeneficiaryOtherInfoImpl;
import bd.gov.dgfood.food.grain.license.model.impl.BeneficiaryOtherInfoModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.BeneficiaryOtherInfoPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.BeneficiaryOtherInfoUtil;
import bd.gov.dgfood.food.grain.license.service.persistence.impl.constants.DGFPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the beneficiary other info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BeneficiaryOtherInfoPersistence.class)
public class BeneficiaryOtherInfoPersistenceImpl
	extends BasePersistenceImpl<BeneficiaryOtherInfo>
	implements BeneficiaryOtherInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BeneficiaryOtherInfoUtil</code> to access the beneficiary other info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BeneficiaryOtherInfoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBybeneficiaryOtherInfoById;
	private FinderPath _finderPathCountBybeneficiaryOtherInfoById;

	/**
	 * Returns the beneficiary other info where id = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo findBybeneficiaryOtherInfoById(long id)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo =
			fetchBybeneficiaryOtherInfoById(id);

		if (beneficiaryOtherInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("id=");
			sb.append(id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBeneficiaryOtherInfoException(sb.toString());
		}

		return beneficiaryOtherInfo;
	}

	/**
	 * Returns the beneficiary other info where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoById(long id) {
		return fetchBybeneficiaryOtherInfoById(id, true);
	}

	/**
	 * Returns the beneficiary other info where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoById(
		long id, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {id};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBybeneficiaryOtherInfoById, finderArgs, this);
		}

		if (result instanceof BeneficiaryOtherInfo) {
			BeneficiaryOtherInfo beneficiaryOtherInfo =
				(BeneficiaryOtherInfo)result;

			if (id != beneficiaryOtherInfo.getId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BENEFICIARYOTHERINFO_WHERE);

			sb.append(_FINDER_COLUMN_BENEFICIARYOTHERINFOBYID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				List<BeneficiaryOtherInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBybeneficiaryOtherInfoById,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {id};
							}

							_log.warn(
								"BeneficiaryOtherInfoPersistenceImpl.fetchBybeneficiaryOtherInfoById(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BeneficiaryOtherInfo beneficiaryOtherInfo = list.get(0);

					result = beneficiaryOtherInfo;

					cacheResult(beneficiaryOtherInfo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BeneficiaryOtherInfo)result;
		}
	}

	/**
	 * Removes the beneficiary other info where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the beneficiary other info that was removed
	 */
	@Override
	public BeneficiaryOtherInfo removeBybeneficiaryOtherInfoById(long id)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo =
			findBybeneficiaryOtherInfoById(id);

		return remove(beneficiaryOtherInfo);
	}

	/**
	 * Returns the number of beneficiary other infos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching beneficiary other infos
	 */
	@Override
	public int countBybeneficiaryOtherInfoById(long id) {
		FinderPath finderPath = _finderPathCountBybeneficiaryOtherInfoById;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BENEFICIARYOTHERINFO_WHERE);

			sb.append(_FINDER_COLUMN_BENEFICIARYOTHERINFOBYID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_BENEFICIARYOTHERINFOBYID_ID_2 =
		"beneficiaryOtherInfo.id = ?";

	private FinderPath _finderPathFetchBybeneficiaryOtherInfoByVerifiedId;
	private FinderPath _finderPathCountBybeneficiaryOtherInfoByVerifiedId;

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param verifiedId the verified ID
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo findBybeneficiaryOtherInfoByVerifiedId(
			long verifiedId)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo =
			fetchBybeneficiaryOtherInfoByVerifiedId(verifiedId);

		if (beneficiaryOtherInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("verifiedId=");
			sb.append(verifiedId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBeneficiaryOtherInfoException(sb.toString());
		}

		return beneficiaryOtherInfo;
	}

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param verifiedId the verified ID
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByVerifiedId(
		long verifiedId) {

		return fetchBybeneficiaryOtherInfoByVerifiedId(verifiedId, true);
	}

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param verifiedId the verified ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByVerifiedId(
		long verifiedId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {verifiedId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBybeneficiaryOtherInfoByVerifiedId, finderArgs,
				this);
		}

		if (result instanceof BeneficiaryOtherInfo) {
			BeneficiaryOtherInfo beneficiaryOtherInfo =
				(BeneficiaryOtherInfo)result;

			if (verifiedId != beneficiaryOtherInfo.getVerifiedId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BENEFICIARYOTHERINFO_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFICIARYOTHERINFOBYVERIFIEDID_VERIFIEDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(verifiedId);

				List<BeneficiaryOtherInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBybeneficiaryOtherInfoByVerifiedId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {verifiedId};
							}

							_log.warn(
								"BeneficiaryOtherInfoPersistenceImpl.fetchBybeneficiaryOtherInfoByVerifiedId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BeneficiaryOtherInfo beneficiaryOtherInfo = list.get(0);

					result = beneficiaryOtherInfo;

					cacheResult(beneficiaryOtherInfo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BeneficiaryOtherInfo)result;
		}
	}

	/**
	 * Removes the beneficiary other info where verifiedId = &#63; from the database.
	 *
	 * @param verifiedId the verified ID
	 * @return the beneficiary other info that was removed
	 */
	@Override
	public BeneficiaryOtherInfo removeBybeneficiaryOtherInfoByVerifiedId(
			long verifiedId)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo =
			findBybeneficiaryOtherInfoByVerifiedId(verifiedId);

		return remove(beneficiaryOtherInfo);
	}

	/**
	 * Returns the number of beneficiary other infos where verifiedId = &#63;.
	 *
	 * @param verifiedId the verified ID
	 * @return the number of matching beneficiary other infos
	 */
	@Override
	public int countBybeneficiaryOtherInfoByVerifiedId(long verifiedId) {
		FinderPath finderPath =
			_finderPathCountBybeneficiaryOtherInfoByVerifiedId;

		Object[] finderArgs = new Object[] {verifiedId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BENEFICIARYOTHERINFO_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFICIARYOTHERINFOBYVERIFIEDID_VERIFIEDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(verifiedId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_BENEFICIARYOTHERINFOBYVERIFIEDID_VERIFIEDID_2 =
			"beneficiaryOtherInfo.verifiedId = ?";

	private FinderPath _finderPathFetchBybeneficiaryOtherInfoByMobileNo;
	private FinderPath _finderPathCountBybeneficiaryOtherInfoByMobileNo;

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo findBybeneficiaryOtherInfoByMobileNo(
			String mobileNo)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo =
			fetchBybeneficiaryOtherInfoByMobileNo(mobileNo);

		if (beneficiaryOtherInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("mobileNo=");
			sb.append(mobileNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBeneficiaryOtherInfoException(sb.toString());
		}

		return beneficiaryOtherInfo;
	}

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByMobileNo(
		String mobileNo) {

		return fetchBybeneficiaryOtherInfoByMobileNo(mobileNo, true);
	}

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByMobileNo(
		String mobileNo, boolean useFinderCache) {

		mobileNo = Objects.toString(mobileNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {mobileNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBybeneficiaryOtherInfoByMobileNo, finderArgs,
				this);
		}

		if (result instanceof BeneficiaryOtherInfo) {
			BeneficiaryOtherInfo beneficiaryOtherInfo =
				(BeneficiaryOtherInfo)result;

			if (!Objects.equals(mobileNo, beneficiaryOtherInfo.getMobileNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BENEFICIARYOTHERINFO_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_BENEFICIARYOTHERINFOBYMOBILENO_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(
					_FINDER_COLUMN_BENEFICIARYOTHERINFOBYMOBILENO_MOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				List<BeneficiaryOtherInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBybeneficiaryOtherInfoByMobileNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {mobileNo};
							}

							_log.warn(
								"BeneficiaryOtherInfoPersistenceImpl.fetchBybeneficiaryOtherInfoByMobileNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BeneficiaryOtherInfo beneficiaryOtherInfo = list.get(0);

					result = beneficiaryOtherInfo;

					cacheResult(beneficiaryOtherInfo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BeneficiaryOtherInfo)result;
		}
	}

	/**
	 * Removes the beneficiary other info where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 * @return the beneficiary other info that was removed
	 */
	@Override
	public BeneficiaryOtherInfo removeBybeneficiaryOtherInfoByMobileNo(
			String mobileNo)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo =
			findBybeneficiaryOtherInfoByMobileNo(mobileNo);

		return remove(beneficiaryOtherInfo);
	}

	/**
	 * Returns the number of beneficiary other infos where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching beneficiary other infos
	 */
	@Override
	public int countBybeneficiaryOtherInfoByMobileNo(String mobileNo) {
		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath =
			_finderPathCountBybeneficiaryOtherInfoByMobileNo;

		Object[] finderArgs = new Object[] {mobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BENEFICIARYOTHERINFO_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_BENEFICIARYOTHERINFOBYMOBILENO_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(
					_FINDER_COLUMN_BENEFICIARYOTHERINFOBYMOBILENO_MOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_BENEFICIARYOTHERINFOBYMOBILENO_MOBILENO_2 =
			"beneficiaryOtherInfo.mobileNo = ?";

	private static final String
		_FINDER_COLUMN_BENEFICIARYOTHERINFOBYMOBILENO_MOBILENO_3 =
			"(beneficiaryOtherInfo.mobileNo IS NULL OR beneficiaryOtherInfo.mobileNo = '')";

	public BeneficiaryOtherInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("verifiedId", "verified_id");
		dbColumnNames.put("maritalStatus", "marital_status");
		dbColumnNames.put("spouseName", "spouse_name");
		dbColumnNames.put("spouseNid", "spouse_nid");
		dbColumnNames.put("spouseSecondNid", "spouse_second_nid");
		dbColumnNames.put("spouseDob", "spouse_dob");
		dbColumnNames.put("fatherNid", "father_nid");
		dbColumnNames.put("motherNid", "mother_nid");
		dbColumnNames.put("mobileNo", "mobile_no");
		dbColumnNames.put("mobileNoRelation", "mobile_no_relation");
		dbColumnNames.put("ecSpouseInfo", "ec_spouse_info");
		dbColumnNames.put("villageName", "village_name");
		dbColumnNames.put("wordNo", "word_no");
		dbColumnNames.put("dealerName", "dealer_name");
		dbColumnNames.put("dealerMobile", "dealer_mobile");
		dbColumnNames.put("mobileVerifiedAt", "mobile_verified_at");
		dbColumnNames.put("familyEarningMember", "family_earning_member");
		dbColumnNames.put("avgFamilyIncome", "avg_family_income");
		dbColumnNames.put("dependentFamilyMember", "dependent_family_member");
		dbColumnNames.put("landSize", "land_size");
		dbColumnNames.put("landUnit", "land_unit");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");
		dbColumnNames.put("dealerSlug", "dealer_slug");
		dbColumnNames.put("dealerId", "dealer_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(BeneficiaryOtherInfo.class);

		setModelImplClass(BeneficiaryOtherInfoImpl.class);
		setModelPKClass(long.class);

		setTable(BeneficiaryOtherInfoTable.INSTANCE);
	}

	/**
	 * Caches the beneficiary other info in the entity cache if it is enabled.
	 *
	 * @param beneficiaryOtherInfo the beneficiary other info
	 */
	@Override
	public void cacheResult(BeneficiaryOtherInfo beneficiaryOtherInfo) {
		entityCache.putResult(
			BeneficiaryOtherInfoImpl.class,
			beneficiaryOtherInfo.getPrimaryKey(), beneficiaryOtherInfo);

		finderCache.putResult(
			_finderPathFetchBybeneficiaryOtherInfoById,
			new Object[] {beneficiaryOtherInfo.getId()}, beneficiaryOtherInfo);

		finderCache.putResult(
			_finderPathFetchBybeneficiaryOtherInfoByVerifiedId,
			new Object[] {beneficiaryOtherInfo.getVerifiedId()},
			beneficiaryOtherInfo);

		finderCache.putResult(
			_finderPathFetchBybeneficiaryOtherInfoByMobileNo,
			new Object[] {beneficiaryOtherInfo.getMobileNo()},
			beneficiaryOtherInfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the beneficiary other infos in the entity cache if it is enabled.
	 *
	 * @param beneficiaryOtherInfos the beneficiary other infos
	 */
	@Override
	public void cacheResult(List<BeneficiaryOtherInfo> beneficiaryOtherInfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (beneficiaryOtherInfos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BeneficiaryOtherInfo beneficiaryOtherInfo :
				beneficiaryOtherInfos) {

			if (entityCache.getResult(
					BeneficiaryOtherInfoImpl.class,
					beneficiaryOtherInfo.getPrimaryKey()) == null) {

				cacheResult(beneficiaryOtherInfo);
			}
		}
	}

	/**
	 * Clears the cache for all beneficiary other infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BeneficiaryOtherInfoImpl.class);

		finderCache.clearCache(BeneficiaryOtherInfoImpl.class);
	}

	/**
	 * Clears the cache for the beneficiary other info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BeneficiaryOtherInfo beneficiaryOtherInfo) {
		entityCache.removeResult(
			BeneficiaryOtherInfoImpl.class, beneficiaryOtherInfo);
	}

	@Override
	public void clearCache(List<BeneficiaryOtherInfo> beneficiaryOtherInfos) {
		for (BeneficiaryOtherInfo beneficiaryOtherInfo :
				beneficiaryOtherInfos) {

			entityCache.removeResult(
				BeneficiaryOtherInfoImpl.class, beneficiaryOtherInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BeneficiaryOtherInfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				BeneficiaryOtherInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BeneficiaryOtherInfoModelImpl beneficiaryOtherInfoModelImpl) {

		Object[] args = new Object[] {beneficiaryOtherInfoModelImpl.getId()};

		finderCache.putResult(
			_finderPathCountBybeneficiaryOtherInfoById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBybeneficiaryOtherInfoById, args,
			beneficiaryOtherInfoModelImpl);

		args = new Object[] {beneficiaryOtherInfoModelImpl.getVerifiedId()};

		finderCache.putResult(
			_finderPathCountBybeneficiaryOtherInfoByVerifiedId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBybeneficiaryOtherInfoByVerifiedId, args,
			beneficiaryOtherInfoModelImpl);

		args = new Object[] {beneficiaryOtherInfoModelImpl.getMobileNo()};

		finderCache.putResult(
			_finderPathCountBybeneficiaryOtherInfoByMobileNo, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBybeneficiaryOtherInfoByMobileNo, args,
			beneficiaryOtherInfoModelImpl);
	}

	/**
	 * Creates a new beneficiary other info with the primary key. Does not add the beneficiary other info to the database.
	 *
	 * @param id the primary key for the new beneficiary other info
	 * @return the new beneficiary other info
	 */
	@Override
	public BeneficiaryOtherInfo create(long id) {
		BeneficiaryOtherInfo beneficiaryOtherInfo =
			new BeneficiaryOtherInfoImpl();

		beneficiaryOtherInfo.setNew(true);
		beneficiaryOtherInfo.setPrimaryKey(id);

		return beneficiaryOtherInfo;
	}

	/**
	 * Removes the beneficiary other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info that was removed
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public BeneficiaryOtherInfo remove(long id)
		throws NoSuchBeneficiaryOtherInfoException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the beneficiary other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the beneficiary other info
	 * @return the beneficiary other info that was removed
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public BeneficiaryOtherInfo remove(Serializable primaryKey)
		throws NoSuchBeneficiaryOtherInfoException {

		Session session = null;

		try {
			session = openSession();

			BeneficiaryOtherInfo beneficiaryOtherInfo =
				(BeneficiaryOtherInfo)session.get(
					BeneficiaryOtherInfoImpl.class, primaryKey);

			if (beneficiaryOtherInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBeneficiaryOtherInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(beneficiaryOtherInfo);
		}
		catch (NoSuchBeneficiaryOtherInfoException noSuchEntityException) {
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
	protected BeneficiaryOtherInfo removeImpl(
		BeneficiaryOtherInfo beneficiaryOtherInfo) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(beneficiaryOtherInfo)) {
				beneficiaryOtherInfo = (BeneficiaryOtherInfo)session.get(
					BeneficiaryOtherInfoImpl.class,
					beneficiaryOtherInfo.getPrimaryKeyObj());
			}

			if (beneficiaryOtherInfo != null) {
				session.delete(beneficiaryOtherInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (beneficiaryOtherInfo != null) {
			clearCache(beneficiaryOtherInfo);
		}

		return beneficiaryOtherInfo;
	}

	@Override
	public BeneficiaryOtherInfo updateImpl(
		BeneficiaryOtherInfo beneficiaryOtherInfo) {

		boolean isNew = beneficiaryOtherInfo.isNew();

		if (!(beneficiaryOtherInfo instanceof BeneficiaryOtherInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(beneficiaryOtherInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					beneficiaryOtherInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in beneficiaryOtherInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BeneficiaryOtherInfo implementation " +
					beneficiaryOtherInfo.getClass());
		}

		BeneficiaryOtherInfoModelImpl beneficiaryOtherInfoModelImpl =
			(BeneficiaryOtherInfoModelImpl)beneficiaryOtherInfo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(beneficiaryOtherInfo);
			}
			else {
				beneficiaryOtherInfo = (BeneficiaryOtherInfo)session.merge(
					beneficiaryOtherInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BeneficiaryOtherInfoImpl.class, beneficiaryOtherInfoModelImpl,
			false, true);

		cacheUniqueFindersCache(beneficiaryOtherInfoModelImpl);

		if (isNew) {
			beneficiaryOtherInfo.setNew(false);
		}

		beneficiaryOtherInfo.resetOriginalValues();

		return beneficiaryOtherInfo;
	}

	/**
	 * Returns the beneficiary other info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the beneficiary other info
	 * @return the beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public BeneficiaryOtherInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBeneficiaryOtherInfoException {

		BeneficiaryOtherInfo beneficiaryOtherInfo = fetchByPrimaryKey(
			primaryKey);

		if (beneficiaryOtherInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBeneficiaryOtherInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return beneficiaryOtherInfo;
	}

	/**
	 * Returns the beneficiary other info with the primary key or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public BeneficiaryOtherInfo findByPrimaryKey(long id)
		throws NoSuchBeneficiaryOtherInfoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the beneficiary other info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info, or <code>null</code> if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public BeneficiaryOtherInfo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the beneficiary other infos.
	 *
	 * @return the beneficiary other infos
	 */
	@Override
	public List<BeneficiaryOtherInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @return the range of beneficiary other infos
	 */
	@Override
	public List<BeneficiaryOtherInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of beneficiary other infos
	 */
	@Override
	public List<BeneficiaryOtherInfo> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryOtherInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of beneficiary other infos
	 */
	@Override
	public List<BeneficiaryOtherInfo> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryOtherInfo> orderByComparator,
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

		List<BeneficiaryOtherInfo> list = null;

		if (useFinderCache) {
			list = (List<BeneficiaryOtherInfo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BENEFICIARYOTHERINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BENEFICIARYOTHERINFO;

				sql = sql.concat(BeneficiaryOtherInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BeneficiaryOtherInfo>)QueryUtil.list(
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
	 * Removes all the beneficiary other infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BeneficiaryOtherInfo beneficiaryOtherInfo : findAll()) {
			remove(beneficiaryOtherInfo);
		}
	}

	/**
	 * Returns the number of beneficiary other infos.
	 *
	 * @return the number of beneficiary other infos
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
					_SQL_COUNT_BENEFICIARYOTHERINFO);

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
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BENEFICIARYOTHERINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BeneficiaryOtherInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the beneficiary other info persistence.
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

		_finderPathFetchBybeneficiaryOtherInfoById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBybeneficiaryOtherInfoById",
			new String[] {Long.class.getName()}, new String[] {"id"}, true);

		_finderPathCountBybeneficiaryOtherInfoById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybeneficiaryOtherInfoById",
			new String[] {Long.class.getName()}, new String[] {"id"}, false);

		_finderPathFetchBybeneficiaryOtherInfoByVerifiedId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBybeneficiaryOtherInfoByVerifiedId",
			new String[] {Long.class.getName()}, new String[] {"verified_id"},
			true);

		_finderPathCountBybeneficiaryOtherInfoByVerifiedId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybeneficiaryOtherInfoByVerifiedId",
			new String[] {Long.class.getName()}, new String[] {"verified_id"},
			false);

		_finderPathFetchBybeneficiaryOtherInfoByMobileNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBybeneficiaryOtherInfoByMobileNo",
			new String[] {String.class.getName()}, new String[] {"mobile_no"},
			true);

		_finderPathCountBybeneficiaryOtherInfoByMobileNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybeneficiaryOtherInfoByMobileNo",
			new String[] {String.class.getName()}, new String[] {"mobile_no"},
			false);

		_setBeneficiaryOtherInfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBeneficiaryOtherInfoUtilPersistence(null);

		entityCache.removeCache(BeneficiaryOtherInfoImpl.class.getName());
	}

	private void _setBeneficiaryOtherInfoUtilPersistence(
		BeneficiaryOtherInfoPersistence beneficiaryOtherInfoPersistence) {

		try {
			Field field = BeneficiaryOtherInfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, beneficiaryOtherInfoPersistence);
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

	private static final String _SQL_SELECT_BENEFICIARYOTHERINFO =
		"SELECT beneficiaryOtherInfo FROM BeneficiaryOtherInfo beneficiaryOtherInfo";

	private static final String _SQL_SELECT_BENEFICIARYOTHERINFO_WHERE =
		"SELECT beneficiaryOtherInfo FROM BeneficiaryOtherInfo beneficiaryOtherInfo WHERE ";

	private static final String _SQL_COUNT_BENEFICIARYOTHERINFO =
		"SELECT COUNT(beneficiaryOtherInfo) FROM BeneficiaryOtherInfo beneficiaryOtherInfo";

	private static final String _SQL_COUNT_BENEFICIARYOTHERINFO_WHERE =
		"SELECT COUNT(beneficiaryOtherInfo) FROM BeneficiaryOtherInfo beneficiaryOtherInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"beneficiaryOtherInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BeneficiaryOtherInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BeneficiaryOtherInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BeneficiaryOtherInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"verifiedId", "maritalStatus", "spouseName", "spouseNid",
			"spouseSecondNid", "spouseDob", "fatherNid", "motherNid",
			"mobileNo", "mobileNoRelation", "ecSpouseInfo", "villageName",
			"wordNo", "dealerName", "dealerMobile", "mobileVerifiedAt",
			"familyEarningMember", "avgFamilyIncome", "dependentFamilyMember",
			"landSize", "landUnit", "userId", "createdAt", "updatedAt",
			"dealerSlug", "dealerId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}