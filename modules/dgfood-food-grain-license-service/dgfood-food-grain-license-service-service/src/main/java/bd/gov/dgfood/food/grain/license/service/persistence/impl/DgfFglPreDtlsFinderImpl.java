package bd.gov.dgfood.food.grain.license.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglPreDtlsFinder;

@Component(service = DgfFglPreDtlsFinder.class)
public class DgfFglPreDtlsFinderImpl extends DgfFglPreDtlsFinderBaseImpl implements DgfFglPreDtlsFinder {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	public List<Map<String, Object>> findBySearchCriteria(String dateFrom, String dateTo, String dateType,
			String applicationNo, String businessType, int status, String licenseType, long roleId,
			String upazillaOrDistrict, long companyId) {
		Session session = null;
		Date dateF = dateMaker(dateFrom);
		Date dateT = dateMaker(dateTo);
		try {
			session = openSession();
			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery searchQuery1 = DynamicQueryFactoryUtil.forClass(DgfFglPreDtls.class, classLoader);
			searchQuery1
					.add(RestrictionsFactoryUtil.sqlRestriction(addLocationWisePermission(DgfFglPreDtls.class.getName(),
							"fglPrePrimaryId", roleId, upazillaOrDistrict, companyId)));
			searchQuery1.addOrder(OrderFactoryUtil.desc("modifiedDate"));

			DynamicQuery searchQuery2 = DynamicQueryFactoryUtil.forClass(DgfRenewLicense.class, classLoader);
			searchQuery2.add(RestrictionsFactoryUtil.sqlRestriction(addLocationWisePermission(
					DgfRenewLicense.class.getName(), "renewLicenseId", roleId, upazillaOrDistrict, companyId)));
			searchQuery2.addOrder(OrderFactoryUtil.desc("modifiedDate"));

			DynamicQuery searchQuery3 = DynamicQueryFactoryUtil.forClass(DgfDuplctLicnsReason.class, classLoader);
			searchQuery3.add(RestrictionsFactoryUtil
					.sqlRestriction(addLocationWisePermission(DgfDuplctLicnsReason.class.getName(),
							"duplicateLicenseReasonID", roleId, upazillaOrDistrict, companyId)));
			searchQuery3.addOrder(OrderFactoryUtil.desc("modifiedDate"));

			Junction conjunction1 = RestrictionsFactoryUtil.conjunction();
			Junction conjunction2 = RestrictionsFactoryUtil.conjunction();
			Junction conjunction3 = RestrictionsFactoryUtil.conjunction();

			if (dateF != null) {
				if (dateType != null && dateType.equals("applStatusUpdateDate")) {

					conjunction1.add(PropertyFactoryUtil.forName("modifiedDate").ge(dateF));
					conjunction2.add(PropertyFactoryUtil.forName("modifiedDate").ge(dateF));
					conjunction3.add(PropertyFactoryUtil.forName("modifiedDate").ge(dateF));

				} else {
					conjunction1.add(PropertyFactoryUtil.forName("createdDate").ge(dateF));
					conjunction2.add(PropertyFactoryUtil.forName("createdDate").ge(dateF));
					conjunction3.add(PropertyFactoryUtil.forName("createdDate").ge(dateF));
				}

			}

			if (dateT != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(dateT);
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 59);
				cal.set(Calendar.SECOND, 59);
				cal.set(Calendar.MILLISECOND, 999);
				Date endOfDay = cal.getTime();
				if (dateType != null && dateType.equals("applStatusUpdateDate")) {

					conjunction1.add(PropertyFactoryUtil.forName("modifiedDate").le(endOfDay));
					conjunction2.add(PropertyFactoryUtil.forName("modifiedDate").le(endOfDay));
					conjunction3.add(PropertyFactoryUtil.forName("modifiedDate").le(endOfDay));
				} else {

					conjunction1.add(PropertyFactoryUtil.forName("createdDate").le(endOfDay));
					conjunction2.add(PropertyFactoryUtil.forName("createdDate").le(endOfDay));
					conjunction3.add(PropertyFactoryUtil.forName("createdDate").le(endOfDay));
				}

			}

			if (Validator.isNotNull(applicationNo) && !applicationNo.trim().isEmpty()) {
//				status = (status != -2) ? status : -2;
				status = -2;
				conjunction1.add(PropertyFactoryUtil.forName("fglApplicationNo").eq(applicationNo));
				conjunction2.add(PropertyFactoryUtil.forName("applicationNo").eq(applicationNo));
				conjunction3.add(PropertyFactoryUtil.forName("applicationNo").eq(applicationNo));
			}

			if (Validator.isNotNull(businessType) && !businessType.trim().isEmpty()) {
				conjunction1.add(PropertyFactoryUtil.forName("businessType").eq(businessType));
				// Query to fetch filtered fglPrePrimaryId values from DgfFglPreDtls
				DynamicQuery subquery = DynamicQueryFactoryUtil.forClass(DgfFglPreDtls.class, classLoader);
				subquery.setProjection(ProjectionFactoryUtil.property("fglPrePrimaryId"));
				subquery.add(conjunction1);
				// Get the list of filtered fglPrePrimaryId values
				List<Long> filteredIds = DgfFglPreDtlsLocalServiceUtil.dynamicQuery(subquery);
				// Add the filter on fglPrePrimaryId in DgfRenewLicense query
				conjunction2.add(PropertyFactoryUtil.forName("fglPrePrimaryId").in(filteredIds));
				conjunction3.add(PropertyFactoryUtil.forName("fglPrePrimaryId").in(filteredIds));
			}

			if (status != -2) {
				conjunction1.add(PropertyFactoryUtil.forName("status").eq(status));
				conjunction2.add(PropertyFactoryUtil.forName("status").eq(status));
				conjunction3.add(PropertyFactoryUtil.forName("status").eq(status));

			}
			if (Validator.isNotNull(licenseType) && !licenseType.trim().isEmpty()) {
				conjunction1.add(PropertyFactoryUtil.forName("fglApplicationType").eq(licenseType));
				conjunction2.add(PropertyFactoryUtil.forName("licenseApplicationType").eq(licenseType));
				conjunction3.add(PropertyFactoryUtil.forName("licenseApplicationType").eq(licenseType));

			}

			searchQuery1.add(conjunction1);
			searchQuery2.add(conjunction2);
			searchQuery3.add(conjunction3);

			List<DgfFglPreDtls> dgfFglPreDtlsObj = new ArrayList<DgfFglPreDtls>();
			if (Validator.isNull(licenseType) || "NEW".equals(licenseType.trim().toUpperCase())) {
				dgfFglPreDtlsObj = DgfFglPreDtlsLocalServiceUtil.dynamicQuery(searchQuery1);
			}

			List<DgfRenewLicense> dgfRenewLicenseObj = new ArrayList<DgfRenewLicense>();
			if (Validator.isNull(licenseType) || "RENEW".equals(licenseType.trim().toUpperCase())) {
				dgfRenewLicenseObj = DgfRenewLicenseLocalServiceUtil.dynamicQuery(searchQuery2);
			}

			List<DgfDuplctLicnsReason> dgfDuplctLicnsReasonObj = new ArrayList<DgfDuplctLicnsReason>();
			if (Validator.isNull(licenseType) || "DUPLICATE".equals(licenseType.trim().toUpperCase())) {
				dgfDuplctLicnsReasonObj = DgfDuplctLicnsReasonLocalServiceUtil.dynamicQuery(searchQuery3);
			}

			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
			for (DgfFglPreDtls item : dgfFglPreDtlsObj) {
				// boolean hasPermission =
				// ResourcePermissionLocalServiceUtil.hasResourcePermission(PortalUtil.getDefaultCompanyId(),
				// DgfFglPreDtls.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				// Long.toString(item.getPrimaryKey())+"_"+ upazillaOrDistrict, roleId,
				// ActionKeys.VIEW);
				Map<String, Object> map = new HashMap<String, Object>();
				DgfFglLicDtls dgfFglDtlsObj = null;
				String licnsNo = null;
				String licnsExpDate = null;
				try {
					dgfFglDtlsObj = DgfFglLicDtlsLocalServiceUtil
							.getDgfFglLicDtlsByFglPrePrimaryId(item.getFglPrePrimaryId());

				} catch (Exception e1) {
					log.info("DgfFglLicDtls not found for the DgfFglPreDtls in the application details ");
				}
				if (dgfFglDtlsObj != null) {
					licnsNo = (dgfFglDtlsObj.getFoodgrainLicenseNo() != null) ? dgfFglDtlsObj.getFoodgrainLicenseNo()
							: licnsNo;

					licnsExpDate = (dgfFglDtlsObj.getFoodgrainLicenseExpiryDate() != null)
							? newFormat.format(dgfFglDtlsObj.getFoodgrainLicenseExpiryDate())
							: licnsExpDate;
				}
				try {
					map.put("fglApplicationNo", item.getFglApplicationNo());
					map.put("applicantName", item.getApplicantName());
					map.put("fglLicenseNo", licnsNo);
					map.put("fglLicneseApplicationType", item.getFglApplicationType());
					map.put("fglLicenseExpiryDate", licnsExpDate);
					map.put("status", item.getStatus());
					map.put("fglPrePrimaryId", item.getFglPrePrimaryId());
					map.put("paymentStatus", item.getPaymentStatus());
					map.put("businessType", item.getBusinessType());
					map.put("modifiedDate", item.getModifiedDate());
					dataList.add(map);
				} catch (Exception e) {
					log.debug("not found new license");
				}
			}

			for (DgfRenewLicense item1 : dgfRenewLicenseObj) {
				Map<String, Object> map = new HashMap<String, Object>();
				try {

					DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil
							.getDgfFglPreDtls(item1.getFglPrePrimaryId());

					map.put("renewLicenseId", item1.getRenewLicenseId());
					map.put("fglApplicationNo", item1.getApplicationNo());
					map.put("fglLicenseNo", item1.getLicenseNo());
					map.put("fglLicneseApplicationType", item1.getLicenseApplicationType());
					map.put("fglLicenseExpiryDate", newFormat.format(item1.getLicenseExpiryDate()));
					map.put("status", item1.getStatus());
					map.put("fglPrePrimaryId", item1.getFglPrePrimaryId());
					map.put("applicantName", dgfFglPreDtls.getApplicantName());
					map.put("paymentStatus", dgfFglPreDtls.getPaymentStatus());
					map.put("businessType", dgfFglPreDtls.getBusinessType());
					map.put("modifiedDate", dgfFglPreDtls.getModifiedDate());
					dataList.add(map);
				} catch (Exception e) {
					log.debug("not found renew license");
				}
			}

			for (DgfDuplctLicnsReason item2 : dgfDuplctLicnsReasonObj) {
				Map<String, Object> map = new HashMap<String, Object>();
				try {

					DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil
							.getDgfFglPreDtls(item2.getFglPrePrimaryId());

					map.put("duplicateLicenseReasonId", item2.getDuplicateLicenseReasonID());
					map.put("fglApplicationNo", item2.getApplicationNo());
					map.put("fglLicenseNo", item2.getLicenseNo());
					map.put("fglLicneseApplicationType", item2.getLicenseApplicationType());
					map.put("fglLicenseExpiryDate", newFormat.format(item2.getLicenseExpiryDate()));
					map.put("status", item2.getStatus());
					map.put("fglPrePrimaryId", item2.getFglPrePrimaryId());
					map.put("applicantName", dgfFglPreDtls.getApplicantName());
					map.put("paymentStatus", dgfFglPreDtls.getPaymentStatus());
					map.put("businessType", dgfFglPreDtls.getBusinessType());
					map.put("modifiedDate", dgfFglPreDtls.getModifiedDate());
					dataList.add(map);
				} catch (Exception e) {
					log.debug("not found duplicate license");
				}

			}

			return dataList;

		} catch (Exception e) {
			log.debug("license find error======" + e.getMessage());
		} finally {
			closeSession(session);
		}
		return null;

	}

	private String addLocationWisePermission(String name, String key, long roleId, String upazillaOrDistrict,
			long companyId) {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add("exists(select rp.primKey from ResourcePermission rp where");
		joiner.add("rp.companyId = " + companyId);
		joiner.add("and rp.name = '" + name + "'");
		joiner.add("and rp.scope=" + ResourceConstants.SCOPE_INDIVIDUAL);
		joiner.add("and rp.primKey = TO_CHAR(this_." + key + ") || '_" + upazillaOrDistrict + "'");
		joiner.add("and rp.roleId = " + roleId);
		joiner.add("and rp.ctCollectionId >= 0)");
		return joiner.toString();
	}

	public Date dateMaker(String dateStr) {
		if (Validator.isNotNull(dateStr)) {
			SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateobj = null;
				dateobj = dateformater.parse(dateStr);
				return dateobj;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
