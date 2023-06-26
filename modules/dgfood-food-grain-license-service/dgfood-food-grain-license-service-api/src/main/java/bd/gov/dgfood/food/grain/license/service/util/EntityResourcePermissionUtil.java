package bd.gov.dgfood.food.grain.license.service.util;
	
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
	
public class EntityResourcePermissionUtil {
	
	private static Log log = LogFactoryUtil.getLog(EntityResourcePermissionUtil.class);

	public static void addEntityPermission( String entityName, long primaryKey, String  businessType, String nationalId, long companyId) {
			addEntityPermission(entityName, primaryKey, businessType, nationalId, companyId, false, null);
		}
	
	public static void addEntityPermission( String entityName, long primaryKey, String  businessType, String nationalId, long companyId, String locationWithPrefix) {
		addEntityPermission(entityName, primaryKey, businessType, nationalId, companyId, false, locationWithPrefix);
	}
	
	public static void addEntityPermission( String entityName, long primaryKey, String  businessType, String nationalId, long companyId, boolean isLicenseReg, String locationWithPrefix) {
		try {
			String roleName = PrincipalRoleAndLocationUtil.getRoleByType(businessType);
			if(Validator.isNull(locationWithPrefix)) {
				DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
				DgfBussAddrDtls dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
				locationWithPrefix = PrincipalRoleAndLocationUtil.getLocationWithPrefixByRole(dgfBussAddrDtls, roleName);
				if(companyId ==0) {
					companyId = dgfFglPreDtls.getCompanyId();
				}
				
			}
			
			if(isLicenseReg && LicenseCommonConstant.ROLE_DCF.equals(roleName)) {
				DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
				DgfBussAddrDtls dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
				List<DgfUsers> dgfAcfUsers = DgfUsersLocalServiceUtil.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(), 0);
				if (dgfAcfUsers != null && dgfAcfUsers.size() > 0) {
					roleName = LicenseCommonConstant.ROLE_ACF;
				}
			}
			
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
			System.out.println("roleName======"+roleName);
			if(roleName != null) {
//				if(LicenseCommonConstant.ATTACHAKKI.equals(businessType.toUpperCase()) || LicenseCommonConstant.RETAILERS.equals(businessType.toUpperCase())) {
//					roleName = LicenseCommonConstant.ROLE_UCF;
//					primKey = generatePrimKey(primaryKey, LicenseCommonConstant.UPAZILLA_FIRST_LETTER, dgfBussAddrDtls.getBusinessUpzilla());
//				} else {
//					roleName = LicenseCommonConstant.ROLE_DCF;
//					primKey = generatePrimKey(primaryKey, LicenseCommonConstant.DISTRICT_FIRST_LETTER, dgfBussAddrDtls.getBusinessDistrict());
//					if(isLicenseReg) {
//						List<DgfUsers> dgfAcfUsers = DgfUsersLocalServiceUtil.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(), 0);
//						if (dgfAcfUsers != null && dgfAcfUsers.size() > 0) {
//							roleName = LicenseCommonConstant.ROLE_ACF;
//						}
//					}
//				}
				String primKey = generatePrimKey(primaryKey, locationWithPrefix);
				System.out.println("primKey======"+primKey);
	
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				if(role != null) {
					ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, entityName,ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId(), actionsRW);
					ResourcePermission resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(companyId, entityName, ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId());
					resourcePermission.setPrimKeyId(primaryKey);
					ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
				}
			}
			
		} catch (PortalException e) {
			log.error("added permission error===" + e.getMessage());
		}
		
	}
	
	
	private static String getLocationPrefixByRole(String role) {
		String locationPrefix = "";
		switch (role) {
		case LicenseCommonConstant.ROLE_UCF:
			locationPrefix = LicenseCommonConstant.UPAZILLA_FIRST_LETTER;
			break;
		case LicenseCommonConstant.ROLE_CCDR:
			locationPrefix = LicenseCommonConstant.DHAKA_METRO_TWO_LETTER;
			break;
		case LicenseCommonConstant.ROLE_RCF:
			locationPrefix = LicenseCommonConstant.OTHER_METRO_TWO_LETTER;
			break;
		default:
			locationPrefix = LicenseCommonConstant.DISTRICT_FIRST_LETTER;
		}
		return locationPrefix;
	}
	
	private static String generatePrimKey(long id, String locationWithprefix) {
		return 	id+ StringPool.UNDERLINE + locationWithprefix;
	}
	
//	public static void main(String[] args) {
//		System.out.println("(LicenseCommonConstant.OMS_DHAKA_METRO===="+getRoleByType(LicenseCommonConstant.OMS_DHAKA_METRO));
//		System.out.println("LicenseCommonConstant.FFP===="+getRoleByType(LicenseCommonConstant.FFP));
//		System.out.println("DEALER===="+getRoleByType(LicenseCommonConstant.DEALER));
//		
//		System.out.println("LicenseCommonConstant.ROLE_ACF===="+getLocationPrefixByRole(LicenseCommonConstant.ROLE_ACF));
//		System.out.println("LicenseCommonConstant.ROLE_CCDR===="+getLocationPrefixByRole(LicenseCommonConstant.ROLE_CCDR));
//		System.out.println("LicenseCommonConstant.ROLE_DCF===="+getLocationPrefixByRole(LicenseCommonConstant.ROLE_DCF));
//	}
}
