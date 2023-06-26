package bd.gov.dgfood.food.grain.license.service.persistence.impl;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourcePermissionTable;
import com.liferay.portal.kernel.model.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDFormTable;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrictTable;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnionTable;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegsTable;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportDFormFinder;
import bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil;

@Component(service = DgfUsersFortnightReportDFormFinder.class)
public class DgfUsersFortnightReportDFormFinderImpl extends DgfUsersFortnightReportDFormFinderBaseImpl implements DgfUsersFortnightReportDFormFinder{
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	public List<Map<String, Object>> findBySearchCriteria(String bussinessType,String endDate, long subdistrict, long union) {
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	
		Session session = null;
		try {
			
			DSLQuery dslQuery = DSLQueryFactoryUtil.select(DgfUsersFortnightReportDFormTable.INSTANCE.reportId,DgfUsersFortnightReportDFormTable.INSTANCE.bussinessType,  
					DgfUsersFortnightReportDFormTable.INSTANCE.screenName,DgfUsersFortnightReportDFormTable.INSTANCE.endDate,  dgfLocUnionTable.INSTANCE.name, dgfLocSubdistrictTable.INSTANCE.name.as("upazilaName")).
					from(DgfUsersFortnightReportDFormTable.INSTANCE).innerJoinON(licnsUserRegsTable.INSTANCE, licnsUserRegsTable.INSTANCE.nationalId.eq(DgfUsersFortnightReportDFormTable.INSTANCE.usernationalId))
					.innerJoinON(dgfLocSubdistrictTable.INSTANCE, dgfLocSubdistrictTable.INSTANCE.id.eq(licnsUserRegsTable.INSTANCE.businessUpzilla))
					.innerJoinON(dgfLocUnionTable.INSTANCE, dgfLocUnionTable.INSTANCE.id.eq(licnsUserRegsTable.INSTANCE.businessUnionName))
					.innerJoinON(ResourcePermissionTable.INSTANCE, ResourcePermissionTable.INSTANCE.primKeyId.eq(DgfUsersFortnightReportDFormTable.INSTANCE.reportId))
					.where(() -> gePredicate(bussinessType, new AtomicLong().addAndGet(subdistrict), new AtomicLong().addAndGet(union)));
	
			session = openSession();
			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(dslQuery);
			Iterator<Object[]> iterator = sqlQuery.iterate();
			while (iterator.hasNext()) {
				Object[] array = iterator.next();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("reportId", array[0]);
				map.put("bussinessType", array[1]);
				map.put("screenName", array[2]);
				map.put("endDate", array[3]);
				map.put("businessUnionName", array[4]);
				map.put("businessUpazilla", array[5]);
				dataList.add(map);
			}
		} catch (Exception e) {
			log.error("Error retrieving bussinessType names: " + e.getMessage());
		}finally {
			closeSession(session);
		}
		
		return dataList;
	}

	private Predicate gePredicate(String bussinessType, long subdistrict, long union) {
		Predicate predicate = DgfUsersFortnightReportDFormTable.INSTANCE.reportId.neq(0L);
		if(bussinessType != null && !bussinessType.isEmpty()) {
			predicate = predicate.and(DgfUsersFortnightReportDFormTable.INSTANCE.bussinessType.eq(bussinessType));
		}
				
		if(subdistrict >0) {
			predicate = predicate.and(dgfLocSubdistrictTable.INSTANCE.id.eq(subdistrict));
		}
		
		if(union >0) {
			predicate = predicate.and(dgfLocUnionTable.INSTANCE.id.eq(union));
		}
		
		Role role = PrincipalRoleAndLocationUtil.principalRole();
		String locationWithPrefix = PrincipalRoleAndLocationUtil.principalUserLocationWithPrefixByRole(role.getName());
		if(locationWithPrefix != null && !locationWithPrefix.isEmpty()) {
			predicate = predicate.and(ResourcePermissionTable.INSTANCE.primKey.like("%_"+locationWithPrefix));
		}
	
		if(role != null) {
			predicate = predicate.and(ResourcePermissionTable.INSTANCE.roleId.eq(role.getRoleId()));
		}
		return predicate;
	}
}
