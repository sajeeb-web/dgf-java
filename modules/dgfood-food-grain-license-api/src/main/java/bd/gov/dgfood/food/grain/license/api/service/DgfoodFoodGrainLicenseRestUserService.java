package bd.gov.dgfood.food.grain.license.api.service;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.service.persistence.UserUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.api.common.CommonConstant;
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
import bd.gov.dgfood.food.grain.license.exception.NoSuchBeneficiaryOtherInfoException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDistributionSchedulesException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDlrDistributionDtlsException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersException;
import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo;
import bd.gov.dgfood.food.grain.license.model.DealerMasters;
import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules;
import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;
import bd.gov.dgfood.food.grain.license.service.BeneficiaryOtherInfoLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DealerMastersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfDistributionSchedulesLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfDlrDistributionDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.VerifiedBeneficiariesLocalServiceUtil;

@Component(service = DgfoodFoodGrainLicenseRestUserService.class)
public class DgfoodFoodGrainLicenseRestUserService {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	public ResponseData addUserData(UserRequestData userRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseUserService.addUserData START");
		// Add first contact info
		UserUtil.clearCache();
		long userId = CounterLocalServiceUtil.increment(User.class.getName());
		User userToCreate = UserLocalServiceUtil.createUser(userId);
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class);

		long companyId = userRequestData.getCompanyId();
		
		String emailAddress = userRequestData.getEmailAddress();
		String firstName = userRequestData.getFirstName();
		String lastName = userRequestData.getLastName();
		String screenName = userRequestData.getScreenName();
		String password = userRequestData.getPassword();
		int status = userRequestData.getStatus();
		String languageId = userRequestData.getLanguageId();

		Contact contact = setAndStoreContactData(userId, userToCreate, classNameId, companyId, emailAddress, firstName);
		// TODO add user group
		// TODO add user role assign
		// User userToCreate = UserLocalServiceUtil.createUser(userId);

		User createdUser = setAndStoreUserData(userToCreate, companyId, emailAddress, firstName, lastName, screenName,
				password, status, languageId, contact);
		// set response data
		ResponseData responseData = new ResponseData();
		if (createdUser != null) {
			responseData.setData(createdUser);
			responseData.setStatus(CommonConstant.OK);
			responseData.setMessage(CommonConstant.USER_DATA_FOUND);
		}
		log.info("DgfoodFoodGrainLicenseUserService.addUserData END");
		return responseData;

	}

	private User setAndStoreUserData(User userToCreate, long companyId, String emailAddress, String firstName,
			String lastName, String screenName, String password, int status, String languageId, Contact contact) {
		userToCreate.setFirstName(firstName);
		userToCreate.setLastName(lastName);
		userToCreate.setEmailAddress(emailAddress);
		userToCreate.setCreateDate(new Date());
		userToCreate.setModifiedDate(new Date());
		userToCreate.setPassword(password);
		userToCreate.setScreenName(screenName);
		userToCreate.setCompanyId(companyId);
		userToCreate.setStatus(status);
		userToCreate.setLanguageId(languageId);
		userToCreate.setStatus(WorkflowConstants.STATUS_APPROVED);
		userToCreate.setContactId(contact.getContactId());
		//userToCreate.setPasswordReset(true);

		User createdUser = UserLocalServiceUtil.addUser(userToCreate);
		return createdUser;
	}

	private Contact setAndStoreContactData(long userId, User userToCreate, long classNameId, long companyId,
			String emailAddress, String firstName) {
		long contactId = CounterLocalServiceUtil.increment(Contact.class.getName());
		Contact contactObj = ContactLocalServiceUtil.createContact(contactId);
		contactObj.setContactId(contactId);
		contactObj.setCompanyId(companyId);
		contactObj.setUserId(userId);
		contactObj.setCreateDate(new Date());
		contactObj.setModifiedDate(new Date());
		contactObj.setEmailAddress(emailAddress);
		contactObj.setFirstName(firstName);
		contactObj.setClassNameId(classNameId);
		contactObj.setClassPK(userToCreate.getPrimaryKey());
		Contact contact = ContactLocalServiceUtil.addContact(contactObj);
		return contact;
	}

	public ResponseData verifyDealerData(DealerRequestData dealerRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.verifyDealerData START");
		ResourceBundle bundle = ResourceBundle.getBundle("license-api");
		String baseHostUrl = bundle.getString("beneficiaries.image.host.url");

		DealerMasters dealerMasters = null;
		if (Validator.isNotNull(dealerRequestData.getNationalId())
				&& Validator.isNotNull(dealerRequestData.getMobileNo())) {
			try {
				//TODO check the NID length and call service if length 10, 13 or 17 degit call second NID 
				String nationalId = dealerRequestData.getNationalId();
				if(nationalId.length()==10) {
					dealerMasters = DealerMastersLocalServiceUtil
							.getDealerMastersByNidAndMobile(nationalId, dealerRequestData.getMobileNo());
				}else if(nationalId.length()==17) {
					// get dealer info using second NID and mobile
					dealerMasters = DealerMastersLocalServiceUtil
							.getDealerMastersBySecondNidAndMobile(nationalId, dealerRequestData.getMobileNo());
				}else if(nationalId.length()==13) {
					// get dealer info by mobile and make NID (year+nid) from date of birth
					dealerMasters = DealerMastersLocalServiceUtil
							.getDealerMastersByMobileNo(dealerRequestData.getMobileNo());
					if(Validator.isNotNull(dealerMasters)) {
						Date birthDate = dealerMasters.getBirthDate();
						SimpleDateFormat simpleDateFormatForYear = new SimpleDateFormat("YYYY");
						String currentYear = simpleDateFormatForYear.format(birthDate);
						String preparedNationalId = currentYear+nationalId;
						// check dealer master by preparedNationalId
						dealerMasters = DealerMastersLocalServiceUtil
								.getDealerMastersBySecondNidAndMobile(preparedNationalId, dealerRequestData.getMobileNo());
					}else {
						throw new SystemException();
					}
				}else {
					throw new SystemException();
				}
				
			}catch (Exception e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.verifyDealerData ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(dealerMasters)) {
			// add data into liferay user_ and dgf_users table
			// check dgf user by national id if not exist then create user
			DgfUsers dgfUsers = null;
			try {
				dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dealerMasters.getDealerNationalId());
			}catch (NoSuchDgfUsersException e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.verifyDealerData ERROR "+e.getMessage());
				dgfUsers = null;
			}
			if (Validator.isNull(dgfUsers)) {
				dgfUsers =  createUserAndRoleAndDgfUser(dealerMasters);
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dealerId", dealerMasters.getId());
			map.put("dateOfBirth", dealerMasters.getBirthDate());
			map.put("dealerName", dealerMasters.getDealerName());
			map.put("dealerNameEn", dealerMasters.getDealerNameEn());
			map.put("fatherName", dealerMasters.getFatherName());
			map.put("motherName", dealerMasters.getMotherName());
			map.put("unionId", dealerMasters.getUnionId());
			map.put("ecPrUnionWard", dealerMasters.getEcPrUnionWard());
			if (Validator.isNotNull(dgfUsers)) {
				map.put("userId", dgfUsers.getUserId());
			}
			//map.put("userId", dealerMasters.getUserId());
			map.put("dealerMobileNo", dealerMasters.getDealerMobileNo());
			map.put("gender", dealerMasters.getGender());
			map.put("nationalId", dealerMasters.getDealerNationalId());
			map.put("secondNationalId", dealerMasters.getSecondNationalId());
			map.put("spouseName", dealerMasters.getSpouseName());
			map.put("spouseNid", dealerMasters.getSpouseNid());
			map.put("govtEmployee", dealerMasters.getGovtEmployee());
			map.put("status", dealerMasters.getStatus());
			// TODO prepared imagePathEc full path
			String imagePathEc = baseHostUrl+dealerMasters.getImagePathEc();
			// TODO need to chage when get the proper image access
			//String imagePathEc = baseHostUrl + "/documents/20121/0/" + "nidphoto.jpg";
			map.put("imagePathEc", imagePathEc);
			// TODO prepared imagePathReal full path
			String imagePathReal = baseHostUrl+dealerMasters.getImagePathReal();
			// TODO need to chage when get the proper image access
			//String imagePathReal = baseHostUrl + "/documents/20121/0/" + "jobId-19374910676343987.jpg";
			map.put("imagePathReal", imagePathReal);

			responseData.setData(map);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.DEALER_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.verifyDealerData END");
		return responseData;
	}

	private DgfUsers createUserAndRoleAndDgfUser(DealerMasters dealerMasters) throws PortalException {

		User user = UserLocalServiceUtil.createUser(CounterLocalServiceUtil.increment());
		//long userId = CounterLocalServiceUtil.increment(User.class.getName());
		long userId = user.getUserId();
		User userToCreate = UserLocalServiceUtil.createUser(userId);
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class);
		long companyId = PortalUtil.getDefaultCompanyId();
		long currentTime = System.currentTimeMillis();
		String emailAddress = currentTime+"@liferay.com";
		String firstName = dealerMasters.getDealerNameEn();
		String lastName = dealerMasters.getDealerNameEn();
		String screenName = dealerMasters.getDealerNationalId();
		String password = "password";
		int status = WorkflowConstants.STATUS_DRAFT;
		String languageId = "en_US";
		String roleName = "Guest";
		
		Contact contact = setAndStoreContactData(userId, userToCreate, classNameId, companyId, emailAddress, firstName);
		User createdUser = setAndStoreUserData(userToCreate, companyId, emailAddress, firstName, lastName, screenName,
				password, status, languageId, contact);
		//User user = UserServiceUtil.getUserById(userId);
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		long[] userIds = new long[] {createdUser.getUserId()};
		UserServiceUtil.addRoleUsers(role.getRoleId(), userIds );
		// Add dgf user
		DgfUsers dgfUsers = addDgfUserData(dealerMasters, userId, password);
		return dgfUsers;
	}

	private DgfUsers addDgfUserData(DealerMasters dealerMasters, long userId, String password) {
		DgfUsers dgfUsers = DgfUsersLocalServiceUtil.createDgfUsers(userId);
		dgfUsers.setApplicantName(dealerMasters.getDealerNameEn());
		dgfUsers.setNationalId(dealerMasters.getDealerNationalId());
		dgfUsers.setPassword(password);
		dgfUsers.setFatherName(dealerMasters.getFatherName());
		dgfUsers.setMotherName(dealerMasters.getMotherName());
		dgfUsers.setGender(dealerMasters.getGender());
		dgfUsers.setBirthDate(dealerMasters.getBirthDate());
		dgfUsers.setMobileNo(dealerMasters.getDealerMobileNo());
		dgfUsers.setModifiedDate(new Date());
		dgfUsers.setCreateDate(new Date());
		dgfUsers = DgfUsersLocalServiceUtil.addDgfUsers(dgfUsers);
		return dgfUsers;
	}
	
	public ResponseData dealerDistribution(DealerDistributionRequestData dealerDistributionRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.dealerDistribution START");
		DealerMasters dealerMasters = null;
		VerifiedBeneficiaries verifiedBeneficiaries = null;
		DgfDlrDistributionDtls dgfDlrDistributionDtls = null;
		if (Validator.isNotNull(dealerDistributionRequestData) && Validator.isNotNull(dealerDistributionRequestData.getDealerId())
				&& Validator.isNotNull(dealerDistributionRequestData.getBeneficiariesId())&& Validator.isNotNull(dealerDistributionRequestData.getCardNo())) {
			try {
				// check distribution schedule
				boolean isActiveDistributionSchedule = checkDistributionSchedules();
				if(isActiveDistributionSchedule) {
					//check dealerId and BeneficiariesId
					dealerMasters = DealerMastersLocalServiceUtil.getDealerMasters(dealerDistributionRequestData.getDealerId());
					if(Validator.isNotNull(dealerMasters)) {
						verifiedBeneficiaries = VerifiedBeneficiariesLocalServiceUtil.getVerifiedBeneficiaries(dealerDistributionRequestData.getBeneficiariesId());
						//check the dealer and Beneficiaries are same
						if(Validator.isNotNull(verifiedBeneficiaries) && Validator.isNotNull(verifiedBeneficiaries.getDealerId()== dealerDistributionRequestData.getDealerId()) && verifiedBeneficiaries.getCardNo()==dealerDistributionRequestData.getCardNo() && verifiedBeneficiaries.getFinalStatus()==CommonConstant.FINAL_STATUS) {
							// check the Beneficiaries taken rice in current month
							// get current month and year
							Date date = new Date();
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
							int currentMonth = Integer.parseInt(simpleDateFormat.format(date));
							SimpleDateFormat simpleDateFormatForYear = new SimpleDateFormat("YYYY");
							int currentYear = Integer.parseInt(simpleDateFormatForYear.format(date));
							//Add exception
							try {
								dgfDlrDistributionDtls = DgfDlrDistributionDtlsLocalServiceUtil.getDgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(verifiedBeneficiaries.getId(), currentMonth, currentYear);
							}catch (NoSuchDgfDlrDistributionDtlsException e) {
								// handle exception
								log.info("DgfoodFoodGrainLicenseRestUserService.dealerDistribution: Beneficiaries Data Not Found for this month");
								dgfDlrDistributionDtls = null;
							}
							
							if(Validator.isNotNull(dgfDlrDistributionDtls)) {
								// already taken rice this month
								throw new BeneficiariesDataFoundException();
							}else {
								dgfDlrDistributionDtls = DgfDlrDistributionDtlsLocalServiceUtil
						                .createDgfDlrDistributionDtls(CounterLocalServiceUtil.increment());
								dgfDlrDistributionDtls.setDealerId(dealerMasters.getId());
								dgfDlrDistributionDtls.setBeneficiariesId(verifiedBeneficiaries.getId());
								BeneficiaryOtherInfo beneficiaryOtherInfo = getBeneficiaryOtherInfoByBeneficiaryId(verifiedBeneficiaries);
								if(Validator.isNotNull(beneficiaryOtherInfo)){
									dgfDlrDistributionDtls.setBeneficiariesMobileNo(beneficiaryOtherInfo.getMobileNo());
								}
								dgfDlrDistributionDtls.setCardNo(dealerDistributionRequestData.getCardNo());
								dgfDlrDistributionDtls.setUnionId(verifiedBeneficiaries.getUnionId());
								dgfDlrDistributionDtls.setDistributionDate(new Date());
								dgfDlrDistributionDtls.setStatus(CommonConstant.DELIVERED_STATUS);
								dgfDlrDistributionDtls.setDistributionQty(CommonConstant.DEALER_DISTRIBUTION_QTY);
								//TODO set user and name
								dgfDlrDistributionDtls.setCreatedAt(new Date());
								dgfDlrDistributionDtls.setUpdatedAt(new Date());
								dgfDlrDistributionDtls.setMonth(currentMonth);
								dgfDlrDistributionDtls.setYear(currentYear);
								dgfDlrDistributionDtls = DgfDlrDistributionDtlsLocalServiceUtil.addDgfDlrDistributionDtls(dgfDlrDistributionDtls);
								
							}
						}else {
							throw new SystemException();
						}
					}else {
						throw new SystemException();
					}
				}else {
					throw new ScheduleDataFoundException();
				}
			}catch (DataNotFoundException e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.dealerDistribution ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(dgfDlrDistributionDtls)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("distributionId", dgfDlrDistributionDtls.getId());
			map.put("dealerId", dgfDlrDistributionDtls.getDealerId());
			map.put("beneficiariesId", dgfDlrDistributionDtls.getBeneficiariesId());
			map.put("beneficiariesMobileNo", dgfDlrDistributionDtls.getBeneficiariesMobileNo());
			map.put("cardNo", dgfDlrDistributionDtls.getCardNo());
			map.put("unionId", dgfDlrDistributionDtls.getUnionId());
			map.put("distributionDate", dgfDlrDistributionDtls.getDistributionDate());
			map.put("distributionQty", dgfDlrDistributionDtls.getDistributionQty());
			map.put("status", dgfDlrDistributionDtls.getStatus());
			responseData.setData(map);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.DEALER_DISTRIBUTION_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.dealerDistribution END");
		return responseData;
	}

	public ResponseData getVerifiedBeneficiariesData(BeneficiariesRequestData beneficiariesRequestData)
			throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.getVerifiedBeneficiariesData START");
		ResourceBundle bundle = ResourceBundle.getBundle("license-api");
		String baseHostUrl = bundle.getString("beneficiaries.image.host.url");

		VerifiedBeneficiaries verifiedBeneficiaries = null;
		boolean isValidBeneficiaries = false;
		if (Validator.isNotNull(beneficiariesRequestData.getBeneficiariesId())) {
			try {
				verifiedBeneficiaries = VerifiedBeneficiariesLocalServiceUtil
					.getVerifiedBeneficiaries(beneficiariesRequestData.getBeneficiariesId());
				//check the dealer with Beneficiarie
				if(beneficiariesRequestData.getDealerId()==verifiedBeneficiaries.getDealerId()) {
					if(verifiedBeneficiaries.getFinalStatus()==CommonConstant.FINAL_STATUS) {
						isValidBeneficiaries = true;
					}
				}
			}catch (Exception e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.getVerifiedBeneficiariesData ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(verifiedBeneficiaries)&& isValidBeneficiaries) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("beneficiariesId", verifiedBeneficiaries.getId());
			map.put("dateOfBirth", verifiedBeneficiaries.getDateOfBirth());
			map.put("dealerId", verifiedBeneficiaries.getDealerId());
			map.put("ecBeneficiaryName", verifiedBeneficiaries.getEcBeneficiaryName());
			map.put("ecBeneficiaryNameEn", verifiedBeneficiaries.getEcBeneficiaryNameEn());
			// get beneficiary mobile number from beneficiary others info table
			BeneficiaryOtherInfo beneficiaryOtherInfo = getBeneficiaryOtherInfoByBeneficiaryId(verifiedBeneficiaries);
			if(Validator.isNotNull(beneficiaryOtherInfo)){
				map.put("beneficiaryMobileNo", beneficiaryOtherInfo.getMobileNo());
			}
			map.put("givenMobileNo", verifiedBeneficiaries.getGivenMobileNo());
			map.put("ecGender", verifiedBeneficiaries.getEcGender());
			map.put("nationalId", verifiedBeneficiaries.getNationalId());
			map.put("cardNo", verifiedBeneficiaries.getCardNo());
			map.put("unionId", verifiedBeneficiaries.getUnionId());
			map.put("ecPrUnionWard", verifiedBeneficiaries.getEcPrUnionWard());
			map.put("ecVerified", verifiedBeneficiaries.getEcVerified());
			map.put("verifiedDate", verifiedBeneficiaries.getVerifiedDate());
			// TODO prepared imagePathEc full path
			String imagePathEc = baseHostUrl+verifiedBeneficiaries.getImagePathEc();
			// TODO need to chage when get the proper image access
			// String imagePathEc = baseHostUrl + "/documents/20121/0/" + "nidphoto.jpg";
			map.put("imagePathEc", imagePathEc);
			// TODO prepared imagePathReal full path
			String imagePathReal = baseHostUrl+verifiedBeneficiaries.getImagePathReal();
			// TODO need to chage when get the proper image access
			//String imagePathReal = baseHostUrl + "/documents/20121/0/" + "realphoto.jpg";
			map.put("imagePathReal", imagePathReal);

			responseData.setData(map);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.BENEFICIARIES_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.getVerifiedBeneficiariesData END");
		return responseData;
	}
	
	
	
	public ResponseData getDealerDistributionList(long dealerId, long beneficiariesId)
			throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.getDealerDistributionList START");
		List<Map<String, Object>> distributionList = preparedDealerDistributionListByDealerAndBeneficiaries(dealerId, beneficiariesId);
		//sort list by cardNo
		Collections.sort(distributionList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Long id1 = (Long) o1.get("distributionId");
                Long id2 = (Long) o2.get("distributionId");
                return id2.compareTo(id1);
            }
        });

		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(distributionList)) {
			responseData.setData(distributionList);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.DEALER_DISTRIBUTION_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.getVerifiedBeneficiariesData END");
		return responseData;
	}

	private List<Map<String, Object>> preparedDealerDistributionListByDealerAndBeneficiaries(long dealerId, long beneficiariesId) {
		// get distribution list of particuler beneficiary
		List<DgfDlrDistributionDtls> dgfDlrDistributionDtlsList = null;
		try {
			dgfDlrDistributionDtlsList = DgfDlrDistributionDtlsLocalServiceUtil.getDgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(dealerId, beneficiariesId);
		}catch (NoSuchDgfDlrDistributionDtlsException e) {
			// handle exception
			log.error("DgfoodFoodGrainLicenseRestUserService.getDealerDistributionList ERROR "+e.getMessage());
			dgfDlrDistributionDtlsList = null;
		}
		
		List<Map<String, Object>> distributionList = new ArrayList<Map<String, Object>>();
		if(Validator.isNotNull(dgfDlrDistributionDtlsList) && dgfDlrDistributionDtlsList.size()>0) {
			for(DgfDlrDistributionDtls dgfDlrDistributionDtls : dgfDlrDistributionDtlsList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("distributionId", dgfDlrDistributionDtls.getId());
				map.put("dealerId", dgfDlrDistributionDtls.getDealerId());
				map.put("beneficiariesId", dgfDlrDistributionDtls.getBeneficiariesId());
				map.put("beneficiariesMobileNo", dgfDlrDistributionDtls.getBeneficiariesMobileNo());
				map.put("cardNo", dgfDlrDistributionDtls.getCardNo());
				map.put("unionId", dgfDlrDistributionDtls.getUnionId());
				map.put("distributionDate", dgfDlrDistributionDtls.getDistributionDate());
				map.put("distributionQty", dgfDlrDistributionDtls.getDistributionQty());
				map.put("status", dgfDlrDistributionDtls.getStatus());
				map.put("month", dgfDlrDistributionDtls.getMonth());
				map.put("year", dgfDlrDistributionDtls.getYear());
				distributionList.add(map);
			}
			
		}
		return distributionList;
	}

	private BeneficiaryOtherInfo getBeneficiaryOtherInfoByBeneficiaryId(VerifiedBeneficiaries verifiedBeneficiaries) {
		BeneficiaryOtherInfo beneficiaryOtherInfo = null;
		try {
			beneficiaryOtherInfo = BeneficiaryOtherInfoLocalServiceUtil.getBeneficiaryOtherInfoByVerifiedId(verifiedBeneficiaries.getId());
		}catch (NoSuchBeneficiaryOtherInfoException e) {
			// handle exception
			log.info("DgfoodFoodGrainLicenseRestUserService.getVerifiedBeneficiariesData BeneficiaryOtherInfo not found");
		}
		return beneficiaryOtherInfo;
	}
	
	public ResponseData sendOtpData(OtpRequestData otpRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.getOtpData START");

		DgfUsersOtpDetails dgfUsersOtpDetails = null;
		if (Validator.isNotNull(otpRequestData.getNationalId())
				&& Validator.isNotNull(otpRequestData.getMobileNo())) {
			try {
				dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByNidAndMobileAndUser(otpRequestData.getNationalId(), otpRequestData.getMobileNo(), otpRequestData.getUserId());	
			}catch (Exception e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.getOtpData ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(dgfUsersOtpDetails)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("otpId", dgfUsersOtpDetails.getOtpId());
			map.put("nationalId", dgfUsersOtpDetails.getNationalId());
			map.put("mobileNo", dgfUsersOtpDetails.getMobileNo());
			map.put("userId", dgfUsersOtpDetails.getUserId());
			map.put("otp", dgfUsersOtpDetails.getOtp());
			map.put("otpRequestTime", dgfUsersOtpDetails.getOtpRequestTime());
			map.put("isSent", dgfUsersOtpDetails.getIsSent());	
			responseData.setData(map);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.OTP_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.getOtpData END");
		return responseData;
	}

	public ResponseData verifyOtpData(OtpVerifyRequestData otpVerifyRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.verifyOtpData START");

		DgfUsersOtpDetails dgfUsersOtpDetails = null;
		if (Validator.isNotNull(otpVerifyRequestData.getMobileNo()) 
				&& Validator.isNotNull(otpVerifyRequestData.getOtp())
				&& Validator.isNotNull(otpVerifyRequestData.getOtpId()) && otpVerifyRequestData.getOtpId() != 0) {
			try {
				// find the dgfUsersOtpDetails by otpId and check the otp is same and update the data 
				dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(otpVerifyRequestData.getOtpId(), otpVerifyRequestData.getOtp(), otpVerifyRequestData.getMobileNo());
			}catch (Exception e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.verifyOtpData ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(dgfUsersOtpDetails)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("otpId", dgfUsersOtpDetails.getOtpId());
			map.put("nationalId", dgfUsersOtpDetails.getNationalId());
			map.put("mobileNo", dgfUsersOtpDetails.getMobileNo());
			map.put("userId", dgfUsersOtpDetails.getUserId());
			map.put("otp", dgfUsersOtpDetails.getOtp());
			map.put("otpRequestTime", dgfUsersOtpDetails.getOtpRequestTime());
			map.put("otpLoginTime", dgfUsersOtpDetails.getOtpLoginTime());
			map.put("otpSucess", dgfUsersOtpDetails.getOtpVerify());
			map.put("isSent", dgfUsersOtpDetails.getIsSent());
			responseData.setData(map);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.OTP_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.verifyOtpData END");
		return responseData;
	}
	
	public ResponseData getDealerBeneficiariesList(long dealerId) throws Exception {
		ResourceBundle bundle = ResourceBundle.getBundle("license-api");
		String baseHostUrl = bundle.getString("beneficiaries.image.host.url");
		log.info("DgfoodFoodGrainLicenseRestUserService.getDealerBeneficiariesList START");

		List<VerifiedBeneficiaries> verifiedBeneficiariesList = null;
		if (Validator.isNotNull(dealerId)) {
			try {
				verifiedBeneficiariesList = VerifiedBeneficiariesLocalServiceUtil.getVerifiedBeneficiariesByDealerId(dealerId);
			}catch (Exception e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.getDealerBeneficiariesList ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}else {
			throw new SystemException();
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(verifiedBeneficiariesList) && verifiedBeneficiariesList.size()>0) {
			List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
			for(VerifiedBeneficiaries verifiedBeneficiaries : verifiedBeneficiariesList) {
				// check active verifiedBeneficiaries
				if(verifiedBeneficiaries.getFinalStatus()==CommonConstant.FINAL_STATUS) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("beneficiariesId", verifiedBeneficiaries.getId());
					map.put("dateOfBirth", verifiedBeneficiaries.getDateOfBirth());
					map.put("dealerId", verifiedBeneficiaries.getDealerId());
					map.put("ecBeneficiaryName", verifiedBeneficiaries.getEcBeneficiaryName());
					map.put("ecBeneficiaryNameEn", verifiedBeneficiaries.getEcBeneficiaryNameEn());
					BeneficiaryOtherInfo beneficiaryOtherInfo = getBeneficiaryOtherInfoByBeneficiaryId(verifiedBeneficiaries);
					if(Validator.isNotNull(beneficiaryOtherInfo)){
						map.put("beneficiaryMobileNo", beneficiaryOtherInfo.getMobileNo());
					}
					//TODO get beneficiary real pic
					// TODO prepared imagePathReal full path
					String imagePathReal = baseHostUrl+verifiedBeneficiaries.getImagePathReal();
					// TODO need to chage when get the proper image access
					// String imagePathReal = baseHostUrl + "/documents/20121/0/" + "realphoto.jpg";
					map.put("imagePathReal", imagePathReal);
					map.put("givenMobileNo", verifiedBeneficiaries.getGivenMobileNo());
					map.put("ecGender", verifiedBeneficiaries.getEcGender());
					map.put("nationalId", verifiedBeneficiaries.getNationalId());
					map.put("secondNationalId", verifiedBeneficiaries.getSecondNationalId());
					map.put("cardNo", verifiedBeneficiaries.getCardNo());
					map.put("unionId", verifiedBeneficiaries.getUnionId());
					map.put("ecPrUnionWard", verifiedBeneficiaries.getEcPrUnionWard());
					map.put("ecVerified", verifiedBeneficiaries.getEcVerified());
					newList.add(map);
				}
				
			}
			//sort list by cardNo
			Collections.sort(newList, new Comparator<Map<String, Object>>() {
	            @Override
	            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
	                Long id1 = (Long) o1.get("cardNo");
	                Long id2 = (Long) o2.get("cardNo");
	                return id1.compareTo(id2);
	            }
	        });
			responseData.setData(newList);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.BENEFICIARIES_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.getDealerBeneficiariesList END");
		return responseData;
	}
	
	public ResponseData sendMessageData(SendMessageRequestData sendMessageRequestData) throws Exception {
		log.info("DgfoodFoodGrainLicenseRestUserService.sendMessageData START");

		DgfUsersOtpDetails dgfUsersOtpDetails = null;
		if (Validator.isNotNull(sendMessageRequestData.getNationalId())
				&& Validator.isNotNull(sendMessageRequestData.getMobileNo())&& Validator.isNotNull(sendMessageRequestData.getMessage())) {
			try {
				dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
						sendMessageRequestData.getMessage(), sendMessageRequestData.getNationalId(), sendMessageRequestData.getMobileNo(), sendMessageRequestData.getUserId(),
						sendMessageRequestData.getUserRegNo());
					
			}catch (Exception e) {
				log.error("DgfoodFoodGrainLicenseRestUserService.sendMessageData ERROR "+e.getMessage());
				throw new DataNotFoundException();
			}
		}
		ResponseData responseData = new ResponseData();
		if (Validator.isNotNull(dgfUsersOtpDetails)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("messageDtlsId", dgfUsersOtpDetails.getOtpId());
			map.put("nationalId", dgfUsersOtpDetails.getNationalId());
			map.put("mobileNo", dgfUsersOtpDetails.getMobileNo());
			map.put("userId", dgfUsersOtpDetails.getUserId());
			map.put("userRegNo", dgfUsersOtpDetails.getUserRegNo());
			map.put("responseResult", dgfUsersOtpDetails.getResponseResult());
			map.put("entryDate", dgfUsersOtpDetails.getOtpRequestTime());
			map.put("isSent", dgfUsersOtpDetails.getIsSent());	
			responseData.setData(map);
			responseData.setStatus(CommonConstant.SUCCESS);
			responseData.setMessage(CommonConstant.MESSAGE_DATA_FOUND);
		} else {
			throw new SystemException();
		}
		log.info("DgfoodFoodGrainLicenseRestUserService.sendMessageData END");
		return responseData;
	}
	
	private boolean checkDistributionSchedules() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
		String currentMonth = simpleDateFormat.format(date);
		SimpleDateFormat simpleDateFormatForYear = new SimpleDateFormat("YYYY");
		int currentYear = Integer.parseInt(simpleDateFormatForYear.format(date));
		boolean isActiveSchedules=false;
		DgfDistributionSchedules dgfDistributionSchedules = null;
		try {
			dgfDistributionSchedules = DgfDistributionSchedulesLocalServiceUtil.findDgfDistributionSchedulesByMonthAndYear(currentYear, currentMonth);
			if(Validator.isNotNull(dgfDistributionSchedules)) {
				String openStatus = dgfDistributionSchedules.getOpenStatus();
				if(openStatus.equals(CommonConstant.OPEN_STATUS)) {
					isActiveSchedules = true;
				}
			}
		}catch (NoSuchDgfDistributionSchedulesException e) {
			// handle exception
			log.info("DgfoodFoodGrainLicenseRestUserService.checkDistributionSchedules: DistributionSchedules Data Not Found for this month");
			dgfDistributionSchedules = null;
		}
		return isActiveSchedules;
	}
}
