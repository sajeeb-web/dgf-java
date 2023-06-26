package bd.gov.dgfood.dealer.withdrawal.web.portlet.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalService;

/**
 * @author Sajeeb Ahmeed
 */

@Component(service = DgfoodDealerWithdrawalWebListPortletService.class)

public class DgfoodDealerWithdrawalWebListPortletService {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	DgfDlrWithdrawalLocalService dgfDlrWithdrawalLocalService;

	/**
	 * This method retrieves the withdrawal application data based on the given
	 * parameters.
	 *
	 * @param renderRequest: the RenderRequest object containing all the request
	 *                       parameters and attributes
	 * @return a List of Maps, each Map containing details of a withdrawal
	 *         application
	 * @getDlrWithdrawalListSearchResult : Call the service method (Local service impl ) to retrieve the list of withdrawal applications based on search criteria
	 */
	
	public List<Map<String, Object>> getActionRequestData(RenderRequest renderRequest) {
		// Retrieve request parameters
		String dateFrom = ParamUtil.getString(renderRequest, "dateFrom", null);
		renderRequest.setAttribute("dateFrom", dateFrom);
		String dateTo = ParamUtil.getString(renderRequest, "dateTo", null);
		renderRequest.setAttribute("dateTo", dateTo);
		String nid = ParamUtil.getString(renderRequest, "nid", null);
		long union = ParamUtil.get(renderRequest, "union", 0);
		renderRequest.setAttribute("union", union);
		String dealerType = ParamUtil.getString(renderRequest, "dealerType", null);
		renderRequest.setAttribute("dealerType", dealerType);
		int status = ParamUtil.getInteger(renderRequest, "appStatus", 1);
		renderRequest.setAttribute("status", status);
		
		return dgfDlrWithdrawalLocalService.findBySearchCriteria(dateFrom, dateTo, nid, union, dealerType, status);
	}

	/**
	 * This method retrieves the detailed view of a specific withdrawal application.
	 *
	 * @param dgfDlrWithdrawalNid: the national ID of the withdrawal application to
	 *                             be viewed
	 * @return a Map containing details of the specific withdrawal application
	 * @getdgfDlrWithdrawalDltsData :(Local service impl)  details of the specific withdrawal application by national ID (getdgfDlrWithdrawalDltsData )
	 */
	
	public Map<String, Object> getWithdrawalDetailView( long dlrWithdrawalId) {
	
		/** @getdgfDlrWithdrawalDltsData */
		Map<String, Object> dealerWithdrawalData = dgfDlrWithdrawalLocalService
				.getDgfDlrWithdrawalDltsData(dlrWithdrawalId);
		// Return the details of the withdrawal application
		return dealerWithdrawalData;
	}
}

