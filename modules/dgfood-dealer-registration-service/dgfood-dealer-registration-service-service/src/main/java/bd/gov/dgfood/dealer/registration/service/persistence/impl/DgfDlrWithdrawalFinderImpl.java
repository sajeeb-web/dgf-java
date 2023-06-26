package bd.gov.dgfood.dealer.registration.service.persistence.impl;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourcePermissionTable;
import com.liferay.portal.kernel.model.Role;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtlsTable;
import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawalTable;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrWithdrawalFinder;
import bd.gov.dgfood.dealer.registration.util.DateMakerUtil;
import bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil;

@Component(service = DgfDlrWithdrawalFinder.class)
public class DgfDlrWithdrawalFinderImpl extends DgfDlrWithdrawalFinderBaseImpl implements DgfDlrWithdrawalFinder{
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	public List<Map<String, Object>> findBySearchCriteria(String dateFrom, String dateTo,
			String nid, long union, String programType, int status) {
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Session session = null;
		try {
			
			DSLQuery dslQuery = DSLQueryFactoryUtil.select(DgfDlrWithdrawalTable.INSTANCE.dlrWithdrawalId,DgfDlrWithdrawalTable.INSTANCE.reason,  
					DgfDlrWithdrawalTable.INSTANCE.dealerName, DgfDlrWithdrawalTable.INSTANCE.mobileNo, DgfDlrWithdrawalTable.INSTANCE.createdDate,
					DgfDlrWithdrawalTable.INSTANCE.modifiedDate, DgfDlrWithdrawalTable.INSTANCE.licenseNo, DgfDlrWithdrawalTable.INSTANCE.nationalId,
					DgfDlrWithdrawalTable.INSTANCE.programType, DgfDlrWithdrawalTable.INSTANCE.status, DgfDlrRegDtlsTable.INSTANCE.sapBuCode,
					DgfDlrRegDtlsTable.INSTANCE.unionName).
					from(DgfDlrWithdrawalTable.INSTANCE)
					.innerJoinON(DgfDlrRegDtlsTable.INSTANCE, DgfDlrRegDtlsTable.INSTANCE.nationalId.eq(DgfDlrWithdrawalTable.INSTANCE.nationalId))
					.innerJoinON(ResourcePermissionTable.INSTANCE, ResourcePermissionTable.INSTANCE.primKeyId.eq(DgfDlrWithdrawalTable.INSTANCE.dlrWithdrawalId))
					.where(() -> gePredicate(programType, new AtomicInteger().addAndGet(status), dateFrom, dateTo, new AtomicLong().addAndGet(union)));
	
			session = openSession();
			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(dslQuery);
			Iterator<Object[]> iterator = sqlQuery.iterate();
			while (iterator.hasNext()) {
				Object[] array = iterator.next();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("dlrWithdrawalId", array[0]);
				map.put("withdrawReason", array[1]);
				map.put("dealerName", array[2]);
				map.put("mobileNo", array[3]);
				map.put("createdDate", array[4]);
				map.put("modifyDate",  array[5]);
				map.put("licenseNo", array[6]);
				map.put("nid", array[7]);
				map.put("program", array[8]);
				BigDecimal statusBig = new BigDecimal(array[9].toString());
				System.out.println("statusBig==="+statusBig);
				map.put("status", statusBig.intValue());
				map.put("dealerBussinessCode", array[10]);
				map.put("dealerUnion", array[11]);
				dataList.add(map);
			}
		} catch (Exception e) {
			log.error("Error retrieving : " + e.getMessage());
		}finally {
			session.close();
		}
		return dataList;
	}

	private Predicate gePredicate(String programType, int status, String dateFromStr, String dateToStr, long union) {
		Role role = PrincipalRoleAndLocationUtil.principalRole();
		Predicate predicate = DgfDlrWithdrawalTable.INSTANCE.dlrWithdrawalId.neq(0L);
		
		if(status >=0) {
			predicate = predicate.and(DgfDlrWithdrawalTable.INSTANCE.status.eq(status));
		}
				
		if(programType != null) {
				predicate = predicate.and(DgfDlrWithdrawalTable.INSTANCE.programType.eq(programType));
		}
		
		if(union > 0) {
			predicate = predicate.and(DgfDlrRegDtlsTable.INSTANCE.unionName.eq(union));
		}
		
		if(dateFromStr != null && !dateFromStr.isEmpty()) {
			Date dateFrom = DateMakerUtil.dateMaker(dateFromStr);
			predicate = predicate.and(DgfDlrWithdrawalTable.INSTANCE.createdDate.gt(dateFrom));
		}
		
		if(dateToStr != null && !dateToStr.isEmpty()) {
			Date dateTo = DateMakerUtil.dateMaker(dateToStr);
			predicate = predicate.and(DgfDlrWithdrawalTable.INSTANCE.createdDate.lt(dateTo));
		}
		
		if(role != null) {
			predicate = predicate.and(ResourcePermissionTable.INSTANCE.roleId.eq(role.getRoleId()));
		}
		
		String location = PrincipalRoleAndLocationUtil.principalUserLocationWithPrefixByRole(role.getName());
		if(location != null && !location.isEmpty()) {
			predicate = predicate.and(ResourcePermissionTable.INSTANCE.primKey.like("%_"+location));
		}
		
		return predicate;
	}
}
