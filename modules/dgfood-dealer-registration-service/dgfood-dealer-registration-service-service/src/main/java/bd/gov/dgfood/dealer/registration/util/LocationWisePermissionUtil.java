package bd.gov.dgfood.dealer.registration.util;

import com.liferay.portal.kernel.model.ResourceConstants;

import java.util.StringJoiner;

public class LocationWisePermissionUtil {
	public static String addLocationWisePermission(String name, String key, long roleId, String upazillaOrDistrict,
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
}
