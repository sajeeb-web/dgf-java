package bd.gov.dgfood.food.grain.license.schedule.portlet;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;

/**
 * @author sajeeb
 */

@Component(property = { "dispatch.task.executor.name=FOODGRAIN_SCHEDULER",
		"dispatch.task.executor.type=FOODGRAIN_SCHEDULER" }, service = DispatchTaskExecutor.class)

public class foodgrain_schedulerPortlet extends BaseDispatchTaskExecutor {
	@Override
	public String getName() {
		return "FOODGRAIN_SCHEDULER";
	}
	private int successCount = 0;
	private int failCount = 0;

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws IOException, PortalException {

			// Send OTP TO User
			List<DgfUsersOtpDetails> dgfUsersOtpDetailsList = DgfUsersOtpDetailsLocalServiceUtil.findByIsSent(false);
			if(Validator.isNotNull(dgfUsersOtpDetailsList) && dgfUsersOtpDetailsList.size()>0) {
				for (DgfUsersOtpDetails dgfUsersOtpDetailsObj : dgfUsersOtpDetailsList) {
					// call sms api
					boolean isSuccess = DgfUsersOtpDetailsLocalServiceUtil.callSmsMessageApiByOtpId(dgfUsersOtpDetailsObj.getOtpId());
					if(isSuccess) {
						successCount++;
					}else {
						failCount++;
					}
				}
			}
			dispatchTaskExecutorOutput.setOutput("TOTAL SUCCESS: "+successCount+" FAIL: "+failCount);
	}

}