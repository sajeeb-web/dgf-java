package bd.gov.dgfood.food.grain.license.api.application;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import bd.gov.dgfood.food.grain.license.api.common.CommonConstant;
import bd.gov.dgfood.food.grain.license.api.common.HttpCode;
import bd.gov.dgfood.food.grain.license.api.exception.BeneficiariesDataFoundException;
import bd.gov.dgfood.food.grain.license.api.exception.DataNotFoundException;
import bd.gov.dgfood.food.grain.license.api.exception.ScheduleDataFoundException;
import bd.gov.dgfood.food.grain.license.api.json.BeneficiariesRequestData;
import bd.gov.dgfood.food.grain.license.api.json.DealerDistributionRequestData;
import bd.gov.dgfood.food.grain.license.api.json.DealerRequestData;
import bd.gov.dgfood.food.grain.license.api.json.OtpRequestData;
import bd.gov.dgfood.food.grain.license.api.json.OtpVerifyRequestData;
import bd.gov.dgfood.food.grain.license.api.json.ResponseData;
import bd.gov.dgfood.food.grain.license.api.json.SendMessageRequestData;
import bd.gov.dgfood.food.grain.license.api.json.UserRequestData;
import bd.gov.dgfood.food.grain.license.api.service.DgfoodFoodGrainLicenseRestUserService;

/**
 * @author HP
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/license",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=License.Rest"
	},
	service = Application.class
)
public class DgfoodFoodGrainLicenseRestApiApplication extends Application {

	@Reference
	DgfoodFoodGrainLicenseRestUserService dgfoodFoodGrainLicenseRestUserService;
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}
	
	@POST
	@Path("/verify-dealer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verifyDealer(DealerRequestData dealerRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.verifyDealer START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.verifyDealerData(dealerRequestData);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.verifyDealer ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.verifyDealer ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.verifyDealer ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.verifyDealer END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}
	
	@POST
	@Path("/verify-beneficiaries")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVerifiedBeneficiariesData(BeneficiariesRequestData beneficiariesRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.getVerifiedBeneficiariesData START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.getVerifiedBeneficiariesData(beneficiariesRequestData);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getVerifiedBeneficiariesData ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getVerifiedBeneficiariesData ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getVerifiedBeneficiariesData ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.getVerifiedBeneficiariesData END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}

	@POST
	@Path("/send-otp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendOtp(OtpRequestData otpRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.sendOtp START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.sendOtpData(otpRequestData);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendOtp ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendOtp ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendOtp ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.sendOtp END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}

	@POST
	@Path("/verify-otp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verifyOtp(OtpVerifyRequestData otpVerifyRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.sendOtp START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.verifyOtpData(otpVerifyRequestData);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendOtp ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendOtp ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendOtp ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.sendOtp END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}
	
	@POST
	@Path("/dealer-distribution")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dealerDistribution(DealerDistributionRequestData dealerDistributionRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.dealerDistribution(dealerDistributionRequestData);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (BeneficiariesDataFoundException bex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution ERROR: "+bex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BENEFICIARIES_ALLREADY_TAKEN);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (ScheduleDataFoundException schex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution ERROR: "+schex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DISTRIBUTION_SCHEDULE_NOT_FOUND);
			return Response.status(HttpCode.HTTP_PRECONDITION_FAILED).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.dealerDistribution END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}
	
	@GET
	@Path("/dealer-beneficiaries")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDealerBeneficiariesList(@QueryParam("dealerId") long dealerId) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.getDealerBeneficiariesList START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.getDealerBeneficiariesList(dealerId);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getDealerBeneficiariesList ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getDealerBeneficiariesList ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getDealerBeneficiariesList ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.getDealerBeneficiariesList END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}
	
	@GET
	@Path("/beneficiaries-distribution-list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDealerDistributionList(@QueryParam("dealerId") long dealerId, @QueryParam("beneficiariesId") long beneficiariesId) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.getDealerDistributionList START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.getDealerDistributionList(dealerId, beneficiariesId);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getDealerDistributionList ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getDealerDistributionList ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.getDealerDistributionList ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.getDealerDistributionList END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}
	
	@POST
	@Path("/add-user")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseData addUser(UserRequestData userRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.addUser START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.addUserData(userRequestData);

		}catch(SystemException syex) {
			log.error("UserApiApplication.addUser ERROR: "+syex.getMessage());
			throw syex;
		}catch (Exception e) {
			log.error("UserApiApplication.addUser ERROR: "+e.getMessage());
			throw e;
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.addUser END");
		return responseData;
	}
	
	@POST
	@Path("/send-message")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendMessage(SendMessageRequestData sendMessageRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestApiApplication.sendMessage START");
		ResponseData responseData = null;
		try {
			responseData = dgfoodFoodGrainLicenseRestUserService.sendMessageData(sendMessageRequestData);

		}catch(SystemException syex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendMessage ERROR: "+syex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.BAD_REQUEST);
			return Response.status(HttpCode.HTTP_BAD_REQUEST).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (DataNotFoundException dex) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendMessage ERROR: "+dex.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.DATA_NOT_FOUND);
			return Response.status(HttpCode.HTTP_NOT_FOUND).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			log.error("DgfoodFoodGrainLicenseRestApiApplication.sendMessage ERROR: "+e.getMessage());
			responseData = new ResponseData();
			responseData.setStatus(CommonConstant.ERROR);
			responseData.setMessage(CommonConstant.INTERNAL_SERVER_ERROR);
			return Response.status(HttpCode.HTTP_INTERNAL_SERVER_ERROR).entity(responseData).type(MediaType.APPLICATION_JSON).build();
		}
		log.info("DgfoodFoodGrainLicenseRestApiApplication.sendMessage END");
		//TODO responseData make as proper JSON and set SerializationFeature.FAIL_ON_EMPTY_BEANS 
		return Response.ok(responseData).build();
	}

}