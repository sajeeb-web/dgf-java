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

package bd.gov.dgfood.food.grain.license.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.DealerMasters;
import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;
import bd.gov.dgfood.food.grain.license.service.DealerMastersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.VerifiedBeneficiariesLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries", service = AopService.class)
public class VerifiedBeneficiariesLocalServiceImpl extends VerifiedBeneficiariesLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Override
	public List<VerifiedBeneficiaries> getVerifiedBeneficiariesByDealerId(long dealerId) {
		return verifiedBeneficiariesPersistence.findByverifiedBeneficiariesDealerIdFinder(dealerId);
	}

	public List<VerifiedBeneficiaries> getDealerLinkedVerifiedBeneficiaries() {
		List<VerifiedBeneficiaries> dealerLinkedBeneficiaryList = new ArrayList<>();
		try {
			long userId = PrincipalRoleAndLocationUtil.principalUser().getUserId();
			String loggedDealerNid = DgfUsersLocalServiceUtil.getDgfUsers(userId).getNationalId();
			List<DealerMasters> dealerMasterObj = DealerMastersLocalServiceUtil.getDealerMastersByNid(loggedDealerNid);

			if (dealerMasterObj != null && !dealerMasterObj.isEmpty()) {
				dealerLinkedBeneficiaryList = getVerifiedBeneficiariesByDealerId(dealerMasterObj.get(0).getId());
			}
		} catch (PortalException e) {
			log.error("Dealer Not Found for Verified Beneficiary List: " + e.getMessage());
		}

		return dealerLinkedBeneficiaryList;
	}

	public List<VerifiedBeneficiaries> getSearchedDealerLinkedVerifiedBeneficiaries(String nid, long ffpCardNo) {
		List<VerifiedBeneficiaries> beneficiaryList = new ArrayList<>();
		beneficiaryList = getDealerLinkedVerifiedBeneficiaries();
		if (nid.isEmpty() && ffpCardNo == -2) {
			return beneficiaryList;
		} else {
			Predicate<VerifiedBeneficiaries> nidCondition = beneficiary -> beneficiary.getNationalId().equals(nid);

			Predicate<VerifiedBeneficiaries> ffpCardNoCondition = beneficiary -> beneficiary.getCardNo() == ffpCardNo;
			Predicate<VerifiedBeneficiaries> combinedCondition;
			if (!nid.isEmpty() && ffpCardNo != -2) {
				combinedCondition = nidCondition.and(ffpCardNoCondition);
			} else {
				combinedCondition = nidCondition.or(ffpCardNoCondition);
			}
			return beneficiaryList.stream().filter(combinedCondition).collect(Collectors.toList());
		}
	}
}