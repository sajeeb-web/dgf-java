package bd.gov.dgfood.food.grain.license.portlet.service;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.constants.LicenseRegistrationKeys;
import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfBnkChllnDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglProductDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfStoreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

@Component(service = LicenseRegistrationPortletService.class)
public class LicenseRegistrationPortletService {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	licnsUserRegsLocalService licnsUserRegsLocalService;

	@Reference
	DgfUsersLocalService dgfUsersLocalService;

	@Reference
	DgfUsersDtlsLocalService dgfUsersDtlsLocalService;

	@Reference
	DgfFglLicDtlsLocalService dgfFglLicDtlsLocalService;

	@Reference
	DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService;

	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;

	@Reference
	DgfBussAddrDtlsLocalService dgfBussAddrDtlsLocalService;

	@Reference
	DgfAttachmentsLocalService dgfAttachmentsLocalService;

	@Reference
	DgfBnkChllnDtlsLocalService dgfBnkChllnDtlsLocalService;

	@Reference
	DgfDuplctLicnsReasonLocalService dgfDuplctLicnsReasonLocalService;

	@Reference
	AssetEntryLocalService assetEntryLocalService;

	@Reference
	UserLocalService userLocalService;

	@Reference
	RoleLocalService roleLocalService;

	@Reference
	ResourcePermissionLocalService resourcePermissionLocalService;
	
	@Reference
	DgfFglProductDtlsLocalService dgfFglProductDtlsLocalService;
	
	@Reference
	private ConfigurationAdmin configurationAdmin;
	
	@Reference
	DgfStoreDtlsLocalService dgfStoreDtlsLocalService;

	public licnsUserRegs getLicenseRegData(ActionRequest actionRequest) {
//		Get data from form 
		String nationalId = ParamUtil.getString(actionRequest, "nationalId");
		String email = ParamUtil.getString(actionRequest, "email");
		String mobileNo = ParamUtil.getString(actionRequest, "mobileNo");
		String password = ParamUtil.getString(actionRequest, "password");
		String birthDateStr = ParamUtil.getString(actionRequest, "birthDate");
		Date birthDate = null;
		if (Validator.isNotNull(birthDateStr)) {
			SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				birthDate = formatter6.parse(birthDateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		set data for create user
		// insert in DB
		boolean isAdded = false;
		if (Validator.isNotNull(nationalId)) {
			licnsUserRegs licnsUserRegsObj = null;
			try {
				licnsUserRegsObj = licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
				String checkNationalId = licnsUserRegsObj.getNationalId();
				if (checkNationalId != null) {
					if (checkNationalId.equals(nationalId)) {
						isAdded = true;

						if (Validator.isNotNull(nationalId)) {
							licnsUserRegsObj.setNationalId(nationalId);
						}

						if (Validator.isNotNull(email)) {
							licnsUserRegsObj.setEmail(email);
						}
						if (Validator.isNotNull(mobileNo)) {
							licnsUserRegsObj.setMobileNo(mobileNo);
						}
						if (Validator.isNotNull(password)) {
							licnsUserRegsObj.setPassword(base64Encoder(password));
						}
						if (Validator.isNotNull(birthDate)) {
							licnsUserRegsObj.setBirthDate(birthDate);
						}
						licnsUserRegsLocalService.updatelicnsUserRegs(licnsUserRegsObj);
						return licnsUserRegsObj;
					}
				}
//				}
			} catch (NoSuchlicnsUserRegsException e) {
				// TODO Auto-generated catch block
				isAdded = false;
//				e.printStackTrace();
			}
		}

		if (!isAdded) {
			licnsUserRegs licnsUserRegs = licnsUserRegsLocalService
					.createlicnsUserRegs(CounterLocalServiceUtil.increment());

			licnsUserRegs.setNationalId(nationalId);
			licnsUserRegs.setEmail(email);
			licnsUserRegs.setMobileNo(mobileNo);
			licnsUserRegs.setBirthDate(birthDate);
			licnsUserRegs.setPassword(base64Encoder(password));

			licnsUserRegsLocalService.addlicnsUserRegs(licnsUserRegs);
			return licnsUserRegs;
		}
		return null;

	}

	public licnsUserRegs getLicenseRegBasicData(ActionRequest actionRequest) {
//		Get data from form 
		String nationalId = ParamUtil.getString(actionRequest, "nationalId");

		String applicantName = ParamUtil.getString(actionRequest, "applicantName");
		String fatherName = ParamUtil.getString(actionRequest, "fatherName");
		String motherName = ParamUtil.getString(actionRequest, "motherName");
		String gender = ParamUtil.getString(actionRequest, "gender");
		String maritalStatus = ParamUtil.getString(actionRequest, "maritalStatus");

		String nidDivision = ParamUtil.getString(actionRequest, "nidDivision");
		String nidDistrict = ParamUtil.getString(actionRequest, "nidDistrict");
		String nidUpzilla = ParamUtil.getString(actionRequest, "nidUpzilla");
		String nidUnion = ParamUtil.getString(actionRequest, "nidUnion");
		String nidVillage = ParamUtil.getString(actionRequest, "nidVillage");
		String nidWard = ParamUtil.getString(actionRequest, "nidWard");
		String nidZipCode = ParamUtil.getString(actionRequest, "nidZipCode");
		String nidPostOffice = ParamUtil.getString(actionRequest, "nidPostOffice");
		String nidHouseAddress = ParamUtil.getString(actionRequest, "nidHouseAddress");

		long division = ParamUtil.getLong(actionRequest, "division");
		long district = ParamUtil.getLong(actionRequest, "district");
		long upzilla = ParamUtil.getLong(actionRequest, "upzilla");
		long unionName = ParamUtil.getLong(actionRequest, "unionName");
		String village = ParamUtil.getString(actionRequest, "village");
		String ward = ParamUtil.getString(actionRequest, "ward");
		String zipCode = ParamUtil.getString(actionRequest, "zipCode");
		String postOffice = ParamUtil.getString(actionRequest, "postOffice");
		String houseAddress = ParamUtil.getString(actionRequest, "houseAddress");
		
		//configurable product type
		try {
			Configuration configuration = configurationAdmin.getConfiguration("bd.gov.dgfood.food.grain.license.guideline.portlet.DynamicFieldConfiguration");
			Dictionary<String, Object> dictionary = configuration.getProperties();
			String essentialProductStr = (String) dictionary.get("lmsEssentialProduct");

	        if(essentialProductStr != null) {
	        	// Split the string into an array
		        String[] essentialProductArr = essentialProductStr.split(",");
		        actionRequest.setAttribute("essentialProductArr", essentialProductArr);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Product type not found!" + e.getMessage());
		}

//		set data for create user
		if (Validator.isNotNull(nationalId)) {
			licnsUserRegs licnsUserRegsObj = null;
			try {
				licnsUserRegsObj = licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
				String checkNationalId = licnsUserRegsObj.getNationalId();
				if (checkNationalId != null) {
					if (checkNationalId.equals(nationalId)) {
						if (Validator.isNotNull(applicantName)) {
							licnsUserRegsObj.setApplicantName(applicantName);
						}

						if (Validator.isNotNull(fatherName)) {
							licnsUserRegsObj.setFatherName(fatherName);
						}
						if (Validator.isNotNull(motherName)) {
							licnsUserRegsObj.setMotherName(motherName);
						}
						if (Validator.isNotNull(gender)) {
							licnsUserRegsObj.setGender(gender);
						}
						if (Validator.isNotNull(maritalStatus)) {
							licnsUserRegsObj.setMaritalStatus(maritalStatus);
						}

						if (Validator.isNotNull(division)) {
							licnsUserRegsObj.setDivision(division);
						}
						if (Validator.isNotNull(district)) {
							licnsUserRegsObj.setDistrict(district);
						}
						if (Validator.isNotNull(upzilla)) {
							licnsUserRegsObj.setUpzilla(upzilla);
						}
						if (Validator.isNotNull(unionName)) {
							licnsUserRegsObj.setUnionName(unionName);
						}

						if (Validator.isNotNull(village)) {
							licnsUserRegsObj.setVillage(village);
						}
						if (Validator.isNotNull(ward)) {
							licnsUserRegsObj.setWard(ward);
						}
						if (Validator.isNotNull(zipCode)) {
							licnsUserRegsObj.setZipCode(zipCode);
						}
						if (Validator.isNotNull(postOffice)) {
							licnsUserRegsObj.setPostOffice(postOffice);
						}
						if (Validator.isNotNull(houseAddress)) {
							licnsUserRegsObj.setHouseAddress(houseAddress);
						}
						if (Validator.isNotNull(nidDivision)) {
							licnsUserRegsObj.setNidDivision(nidDivision);
							;
						}
						if (Validator.isNotNull(nidDistrict)) {
							licnsUserRegsObj.setNidDistrict(nidDistrict);
						}
						if (Validator.isNotNull(nidUpzilla)) {
							licnsUserRegsObj.setNidUpzilla(nidUpzilla);
						}
						if (Validator.isNotNull(nidUnion)) {
							licnsUserRegsObj.setNidUnion(nidUnion);
						}
						if (Validator.isNotNull(nidVillage)) {
							licnsUserRegsObj.setNidVillage(nidVillage);
						}
						if (Validator.isNotNull(nidWard)) {
							licnsUserRegsObj.setNidWard(nidWard);
						}
						if (Validator.isNotNull(nidZipCode)) {
							licnsUserRegsObj.setNidZipCode(nidZipCode);
						}
						if (Validator.isNotNull(nidPostOffice)) {
							licnsUserRegsObj.setNidPostOffice(nidPostOffice);
						}
						if (Validator.isNotNull(nidHouseAddress)) {
							licnsUserRegsObj.setNidHouseAddress(nidHouseAddress);
						}

						licnsUserRegsLocalService.updatelicnsUserRegs(licnsUserRegsObj);
					}
				}
//				}
			} catch (Exception e) {
				log.error("add update license user reg error===" + e.getMessage());
			}

			return licnsUserRegsObj;
		}
		return null;
	}

	Map<String, String> photographFileName = null;
	Map<String, String> tradeLicFileName = null;
	Map<String, String> binFileName = null;
	Map<String, String> tinFileName = null;
	Map<String, String> bankStatFileName = null;
	Map<String, String> otherReleventFileName = null;
	// 1 new attachments
	Map<String, String> electricExemptionMemo = null;
	Map<String, String> envClrMemo = null;
	Map<String, String> bstiClrMemo = null;
	Map<String, String> fireLicNumDoc = null;

	public void getLicenseRegTradeLicData(ActionRequest actionRequest) {
//		Get data from form 
		String nationalId = ParamUtil.getString(actionRequest, "nationalId");

		String tradeLicenseNo = ParamUtil.getString(actionRequest, "tradeLicenseNo");
		String dateStr = ParamUtil.getString(actionRequest, "tradeLicenseExpiryDate");
		Date tradeLicenseExpiryDate = null;
		if (Validator.isNotNull(dateStr)) {
			SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				tradeLicenseExpiryDate = formatter6.parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String taxIdentificationNo = ParamUtil.getString(actionRequest, "taxIdentificationNo");
		String businessIdentificationNo = ParamUtil.getString(actionRequest, "businessIdentificationNo");
		String tradeLicenseIssuerCode = ParamUtil.getString(actionRequest, "tradeLicenseIssuerCode");
		String tradeLicenseIssuerCity = ParamUtil.getString(actionRequest, "tradeLicenseIssuerCity");
		String businessName = ParamUtil.getString(actionRequest, "businessName");
		String businessType = ParamUtil.getString(actionRequest, "businessType");
		//configurable product type
			String productType = "";
			String essentialProductStr = ParamUtil.getString(actionRequest, "essentialProductStr");
			// Split the string into an array
	        String[] essentialProductArr = essentialProductStr.split(",");
	        String productName = LicenseRegistrationKeys.PRODUCT_TYPE;
	        List<String> productValList = new ArrayList<>();
	        for (String product : essentialProductArr) {
	        	product = ParamUtil.getString(actionRequest, productName+product);
	            if(product != LicenseRegistrationKeys.FALSE) {
	            	productValList.add(product);
	            }
	        }
	        // Construct the product output string with comma-separated values
	        StringBuilder productOutput = new StringBuilder();
	        for (String productVal : productValList) {
	            if(!productVal.isEmpty()) {
	            	productOutput.append(productVal).append(",");
	            }
	        }
	
	        // Remove the trailing comma if any
	        if (productOutput.length() > 0) {
	        	productOutput.deleteCharAt(productOutput.length() - 1);
	        }
	        productType = productOutput.toString();

		long businessDivision = ParamUtil.getLong(actionRequest, "businessDivision");
		long businessDistrict = ParamUtil.getLong(actionRequest, "businessDistrict");
		long businessUpzilla = ParamUtil.getLong(actionRequest, "businessUpzilla");
		long businessUnionName = ParamUtil.getLong(actionRequest, "businessUnionName");
		String businessVillage = ParamUtil.getString(actionRequest, "businessVillage");
		String businessWard = ParamUtil.getString(actionRequest, "businessWard");
		String businessZipCode = ParamUtil.getString(actionRequest, "businessZipCode");
		String businessPostOffice = ParamUtil.getString(actionRequest, "businessPostOffice");
		String businessHouseAddress = ParamUtil.getString(actionRequest, "businessHouseAddress");

		// file upload
		String photographAttchType = ParamUtil.getString(actionRequest, "photographAttchType");
		String tradeLicAttchType = ParamUtil.getString(actionRequest, "tradeLicAttchType");
		String binAttchType = ParamUtil.getString(actionRequest, "binAttchType");
		String tinAttchType = ParamUtil.getString(actionRequest, "tinAttchType");
		String bankStatAttchType = ParamUtil.getString(actionRequest, "bankStatAttchType");
		String otherReleventAttchType = ParamUtil.getString(actionRequest, "otherReleventAttchType");
		String photographAttchInputName = "photographFile";
		String tradeLicAttchInputName = "tradeLicDoc";
		String binAttchInputName = "binDoc";
		String tinAttchInputName = "tinDoc";
		String bankStatAttchInputName = "bankStat";
		String otherReleventAttchInputName = "otherReleventDoc";
		// 2 new attachments
		String electricExemptionMemoType = ParamUtil.getString(actionRequest, "electricExemptionMemoType");
		String envClrMemoType = ParamUtil.getString(actionRequest, "envClrMemoType");
		String bstiClrMemoType = ParamUtil.getString(actionRequest, "bankStatAttchType");
		String fireLicNumDocType = ParamUtil.getString(actionRequest, "fireLicNumDocType");
		String electricExemptionMemoInpName = "electricExemptionMemo";
		String envClrMemoInpName = "envClrMemo";
		String bstiClrMemoInpName = "bstiClrMemo";
		String fireLicNumDocInpName = "fireLicNumDoc";

		ResourceBundle bundle = ResourceBundle.getBundle("custom/action");
		String realPath = bundle.getString("image.file.root.dir");

		photographFileName = addUploadDoc(actionRequest, nationalId, realPath, bundle, photographAttchType,
				photographAttchInputName);
		tradeLicFileName = addUploadDoc(actionRequest, nationalId, realPath, bundle, tradeLicAttchType,
				tradeLicAttchInputName);
		binFileName = addUploadDoc(actionRequest, nationalId, realPath, bundle, binAttchType, binAttchInputName);
		tinFileName = addUploadDoc(actionRequest, nationalId, realPath, bundle, tinAttchType, tinAttchInputName);
		bankStatFileName = addUploadDoc(actionRequest, nationalId, realPath, bundle, bankStatAttchType,
				bankStatAttchInputName);
		otherReleventFileName = addUploadDoc(actionRequest, nationalId, realPath, bundle, otherReleventAttchType,
				otherReleventAttchInputName);
		// 4 new attachments
		electricExemptionMemo = addUploadDoc(actionRequest, nationalId, realPath, bundle, electricExemptionMemoType,
				electricExemptionMemoInpName);
		envClrMemo = addUploadDoc(actionRequest, nationalId, realPath, bundle, envClrMemoType, envClrMemoInpName);
		bstiClrMemo = addUploadDoc(actionRequest, nationalId, realPath, bundle, bstiClrMemoType, bstiClrMemoInpName);
		fireLicNumDoc = addUploadDoc(actionRequest, nationalId, realPath, bundle, fireLicNumDocType,
				fireLicNumDocInpName);

		// set data for create user
		// insert in DB
		if (Validator.isNotNull(nationalId)) {
			licnsUserRegs licnsUserRegsObj = null;
			try {
				licnsUserRegsObj = licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
				String checkNationalId = licnsUserRegsObj.getNationalId();
				if (checkNationalId != null) {
					if (checkNationalId.equals(nationalId)) {
						if (Validator.isNotNull(tradeLicenseNo)) {
							licnsUserRegsObj.setTradeLicenseNo(tradeLicenseNo);
						}
						if (Validator.isNotNull(dateStr)) {
							licnsUserRegsObj.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
						}
						if (Validator.isNotNull(taxIdentificationNo)) {
							licnsUserRegsObj.setTaxIdentificationNo(taxIdentificationNo);
						}
						if (Validator.isNotNull(businessIdentificationNo)) {
							licnsUserRegsObj.setBusinessIdentificationNo(businessIdentificationNo);
						}
						if (Validator.isNotNull(tradeLicenseIssuerCode)) {
							licnsUserRegsObj.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
						}
						if (Validator.isNotNull(tradeLicenseIssuerCity)) {
							licnsUserRegsObj.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
						}
						if (Validator.isNotNull(businessName)) {
							licnsUserRegsObj.setBusinessName(businessName);
						}
						if (Validator.isNotNull(businessType)) {
							licnsUserRegsObj.setBusinessType(businessType);
						}
							licnsUserRegsObj.setProductType(productType);
						if (Validator.isNotNull(businessDivision)) {
							licnsUserRegsObj.setBusinessDivision(businessDivision);
						}
						if (Validator.isNotNull(businessDistrict)) {
							licnsUserRegsObj.setBusinessDistrict(businessDistrict);
						}
						if (Validator.isNotNull(businessUpzilla)) {
							licnsUserRegsObj.setBusinessUpzilla(businessUpzilla);
						}
						if (Validator.isNotNull(businessUnionName)) {
							licnsUserRegsObj.setBusinessUnionName(businessUnionName);
						}
						if (Validator.isNotNull(businessVillage)) {
							licnsUserRegsObj.setBusinessVillage(businessVillage);
						}
						if (Validator.isNotNull(businessWard)) {
							licnsUserRegsObj.setBusinessWard(businessWard);
						}
						if (Validator.isNotNull(businessZipCode)) {
							licnsUserRegsObj.setBusinessZipCode(businessZipCode);
						}
						if (Validator.isNotNull(businessPostOffice)) {
							licnsUserRegsObj.setBusinessPostOffice(businessPostOffice);
						}
						if (Validator.isNotNull(businessHouseAddress)) {
							licnsUserRegsObj.setBusinessHouseAddress(businessHouseAddress);
						}

						if (Validator.isNotNull(photographFileName)) {
							licnsUserRegsObj.setPhotographFile(photographFileName.get("filePath"));
						}
						if (Validator.isNotNull(tradeLicFileName)) {
							licnsUserRegsObj.setTradeLicDoc(tradeLicFileName.get("filePath"));
						}
						if (Validator.isNotNull(binFileName)) {
							licnsUserRegsObj.setBinDoc(binFileName.get("filePath"));
						}
						if (Validator.isNotNull(tinFileName)) {
							licnsUserRegsObj.setTinDoc(tinFileName.get("filePath"));
						}
						if (Validator.isNotNull(bankStatFileName)) {
							licnsUserRegsObj.setBankStat(bankStatFileName.get("filePath"));
						}
						if (Validator.isNotNull(otherReleventFileName)) {
							licnsUserRegsObj.setOtherReleventDoc(otherReleventFileName.get("filePath"));
						}
						if (Validator.isNotNull(electricExemptionMemo)) {
							licnsUserRegsObj.setElectricExemptionMemo(electricExemptionMemo.get("filePath"));
						}
						if (Validator.isNotNull(envClrMemo)) {
							licnsUserRegsObj.setEnvClrMemo(envClrMemo.get("filePath"));
						}
						if (Validator.isNotNull(bstiClrMemo)) {
							licnsUserRegsObj.setBstiClrMemo(bstiClrMemo.get("filePath"));
						}
						if (Validator.isNotNull(fireLicNumDoc)) {
							licnsUserRegsObj.setFireLicNumDoc(fireLicNumDoc.get("filePath"));
						}

						licnsUserRegsLocalService.updatelicnsUserRegs(licnsUserRegsObj);
						
						//added license store
						addedLicenseStore(actionRequest, nationalId);
					}
				}

			} catch (Exception e) {
				log.error("added trade license error=========================");
			} 
		}
	}

	private void addedLicenseStore(ActionRequest actionRequest, String nationalId){
		long count = ParamUtil.getLong(actionRequest, "counterInput", -1);
		
		label:
		for (int i = 0; i <= count; i++) {
			String storeType = ParamUtil.getString(actionRequest, "storeType" + i);
			if(Validator.isBlank(storeType)) {
				continue label;
			}
			String mouza = ParamUtil.getString(actionRequest, "mouza" + i);
			String khotiyan = ParamUtil.getString(actionRequest, "khotiyan" + i);
			String dag = ParamUtil.getString(actionRequest, "dag" + i);
			String height = ParamUtil.getString(actionRequest, "height" + i);
			String width = ParamUtil.getString(actionRequest, "width" + i);
			String length = ParamUtil.getString(actionRequest, "length" + i);
			long totalCapacity = 0;
			long capacity = ParamUtil.getLong(actionRequest, "capacity" + i);
			totalCapacity += capacity;

			long storeDivision = ParamUtil.getLong(actionRequest, "storeDivision" + i);
			long storeDistrict = ParamUtil.getLong(actionRequest, "storeDistrict" + i);
			long storeUpzilla = ParamUtil.getLong(actionRequest, "storeUpzilla" + i);

			long storeId = ParamUtil.getLong(actionRequest, "storeId" + i);
			try {
			DgfStoreDtls dgfStoreDtl = null;
			if (storeId > 0) {
				dgfStoreDtl = dgfStoreDtlsLocalService.getDgfStoreDtls(storeId);
				dgfStoreDtl.setUpdatedAt(new Date());
			} else {
				dgfStoreDtl = dgfStoreDtlsLocalService.createDgfStoreDtls(CounterLocalServiceUtil.increment(DgfStoreDtls.class.getName()));
				dgfStoreDtl.setCreatedAt(new Date());
			}

			dgfStoreDtl.setNationalId(nationalId);
			dgfStoreDtl.setType(storeType);
			dgfStoreDtl.setMouza(mouza);
			dgfStoreDtl.setKhatiyn(khotiyan);
			dgfStoreDtl.setDagNo(dag);
			dgfStoreDtl.setDivision(storeDivision);
			dgfStoreDtl.setDistrict(storeDistrict);
			dgfStoreDtl.setUpzilla(storeUpzilla);
			dgfStoreDtl.setCityCrprtn(storeUpzilla);
			dgfStoreDtl.setDicsHight(height);
			dgfStoreDtl.setDicsWidth(width);
			dgfStoreDtl.setDicsLngth(length);
			dgfStoreDtl.setDicsCpacty(capacity);
			dgfStoreDtl.setTotalCpacty(totalCapacity);
			dgfStoreDtl.setCreatedAt(new Date());
			dgfStoreDtlsLocalService.updateDgfStoreDtls(dgfStoreDtl);
			} catch (PortalException e) {
				log.error("added or updated license store error=========================");
			}
		}

		
	}

	public void getLicenseRegPreviewData(ActionRequest actionRequest) throws PortalException {
		// final submit form submission
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		licnsUserRegs licnsUserRegsObj = getLicenseRegData(actionRequest);

		User user = createUser(licnsUserRegsObj, themeDisplay);

		DgfUsersAddrDtls dgfUsersAddrDtls = saveDgfUsersAddrDtls(licnsUserRegsObj);
		DgfBussAddrDtls dgfBussAddrDtls = saveDgfBussAddrDtls(licnsUserRegsObj);
		DgfAttachments dgfAttachmentsPhotoDocId = saveDgfAttachments(licnsUserRegsObj, photographFileName);
		DgfAttachments dgfAttachmentsTradeDocId = saveDgfAttachments(licnsUserRegsObj, tradeLicFileName);
		DgfAttachments dgfAttachmentsBinDocId = null;
		if (binFileName != null && !binFileName.isEmpty()) {
			dgfAttachmentsBinDocId = saveDgfAttachments(licnsUserRegsObj, binFileName);
		}
		DgfAttachments dgfAttachmentsTinDocId = saveDgfAttachments(licnsUserRegsObj, tinFileName);
		DgfAttachments dgfAttachmentsBankDocId = saveDgfAttachments(licnsUserRegsObj, bankStatFileName);
		DgfAttachments dgfAttachmentsOtherDocId = null;
		if (otherReleventFileName != null && !otherReleventFileName.isEmpty()) {
			dgfAttachmentsOtherDocId = saveDgfAttachments(licnsUserRegsObj, otherReleventFileName);
		}
		DgfAttachments dgfAttachElectricMemoId = null;
		if (electricExemptionMemo != null && !electricExemptionMemo.isEmpty()) {
			dgfAttachElectricMemoId = saveDgfAttachments(licnsUserRegsObj, electricExemptionMemo);
		}
		DgfAttachments dgfAttachEnvClrMemoId = null;
		if (envClrMemo != null && !envClrMemo.isEmpty()) {
			dgfAttachEnvClrMemoId = saveDgfAttachments(licnsUserRegsObj, envClrMemo);
		}
		DgfAttachments dgfAttachBstiClrMemoId = null;
		if (bstiClrMemo != null && !bstiClrMemo.isEmpty()) {
			dgfAttachBstiClrMemoId = saveDgfAttachments(licnsUserRegsObj, bstiClrMemo);
		}
		DgfAttachments dgfAttachFireLicNumDocId = null;
		if (fireLicNumDoc != null && !fireLicNumDoc.isEmpty()) {
			dgfAttachFireLicNumDocId = saveDgfAttachments(licnsUserRegsObj, fireLicNumDoc);
		}
		DgfFglPreDtls dgfFglPreDtls = saveDgfFglPreDtls(themeDisplay, licnsUserRegsObj, dgfUsersAddrDtls,
				dgfBussAddrDtls, dgfAttachmentsPhotoDocId, dgfAttachmentsTradeDocId, dgfAttachmentsBinDocId,
				dgfAttachmentsTinDocId, dgfAttachmentsBankDocId, dgfAttachmentsOtherDocId, dgfAttachElectricMemoId,
				dgfAttachEnvClrMemoId, dgfAttachBstiClrMemoId, dgfAttachFireLicNumDocId);
		DgfFglLicDtls dgfFglLicDtls = saveDgfFglLicDtls(licnsUserRegsObj, dgfFglPreDtls);
		DgfUsers dgfUsers = saveDgfUsers(user, licnsUserRegsObj, dgfUsersAddrDtls);
		DgfUsersDtls dgfUsersDtls = saveUsersDtls(licnsUserRegsObj);
		saveDgfFglProductDtls(dgfFglLicDtls);
		
		String applicationNo = dgfFglPreDtls.getFglApplicationNo();
		actionRequest.setAttribute("applicationNo", applicationNo);
		// set workflow
		getWorkflow(actionRequest, user, dgfFglPreDtls, themeDisplay);
		// get and prepared message LMS_FORM_SUBMIT
		String licenseMessage = DgfFglPreDtlsLocalServiceUtil.getLicenseFormSubmitMessage();
		String message = licenseMessage + " #" + applicationNo;
		// send message to license user
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(), Long.parseLong(applicationNo));
	}

	///////////// workflow///////////////
	public void getWorkflow(ActionRequest actionRequest, User user, DgfFglPreDtls dgfFglPreDtls,
			ThemeDisplay themeDisplay) throws PortalException {
		// workflow connection starting
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DgfFglPreDtls.class.getName(), actionRequest);
		long userId = user.getUserId();

		dgfFglPreDtls.setUserId(userId);

		long groupId = themeDisplay.getScopeGroupId();

		dgfFglPreDtls.setGroupId(groupId);

		int status = WorkflowConstants.STATUS_DRAFT;

		serviceContext.setScopeGroupId(groupId);
		serviceContext.setCompanyId(themeDisplay.getCompanyId());
		serviceContext.setUserId(themeDisplay.getUserId());

		String className = DgfFglPreDtls.class.getName();

		dgfFglPreDtlsLocalService.updateDgfFglPreDtls(dgfFglPreDtls);
		dgfFglPreDtlsLocalService.updateStatus(user.getUserId(), dgfFglPreDtls.getFglPrePrimaryId(), status,
				serviceContext);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(themeDisplay.getUserId(),
				serviceContext.getScopeGroupId(), new Date(), new Date(), className, dgfFglPreDtls.getFglPrePrimaryId(),
				null, 0, null, null, true, false, new Date(), null, new Date(), null, ContentTypes.TEXT_HTML,
				dgfFglPreDtls.getApplicantName(), dgfFglPreDtls.getApplicantName(), null, null, null, 0, 0, null);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(),
				dgfFglPreDtls.getUserId(), className, dgfFglPreDtls.getPrimaryKey(), dgfFglPreDtls, serviceContext);
	}

	private User createUser(licnsUserRegs licnsUserRegsObj, ThemeDisplay themeDisplay) {

		int dayOfMonth = 1;
		int monthOfYear = 0;
		int year = 1970;
		if (licnsUserRegsObj.getBirthDate() != null) {
			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(licnsUserRegsObj.getBirthDate());
			dayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
			monthOfYear = birthDate.get(Calendar.MONTH);
			year = birthDate.get(Calendar.YEAR);
		}

		User user = null;
		try {
			String password = base64Decoder(licnsUserRegsObj.getPassword());
			user = userLocalService.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), false, password,
					password, false, licnsUserRegsObj.getNationalId(), licnsUserRegsObj.getEmail(),
					themeDisplay.getLocale(), licnsUserRegsObj.getApplicantName(), "",
					licnsUserRegsObj.getApplicantName(), 0L, 0L, false, monthOfYear, dayOfMonth, year, "", 1,
					new long[0], new long[0], new long[0], new long[0], false, new ServiceContext());
			user.setPasswordReset(false);
			user.setStatus(WorkflowConstants.STATUS_INACTIVE);
			// assign guest user role
			assignRole(user, themeDisplay);
			UserLocalServiceUtil.updateUser(user);
		} catch (PortalException e) {
			log.error("not created user by====" + licnsUserRegsObj.getNationalId());
		}

		return user;
	}

//file upload start 
	public Map<String, String> addUploadDoc(ActionRequest actionRequest, String nationalId, String inputRealPath,
			ResourceBundle inputBundle, String filecat, String attachmentInputName) {
		String attachmentCatagory = null;
		String nid = nationalId;
		String filePath = "";
		Map<String, String> filePath_Name = new HashMap<>();
		String localPath = System.getProperty("catalina.base");

		if (localPath != null && !localPath.trim().isEmpty()) {

			String opSys = System.getProperty("os.name").toLowerCase();

			if (opSys.contains("nix") || opSys.contains("nux") || opSys.contains("aix") || opSys.contains("mac")) {
				inputRealPath = inputRealPath.replace("\\", "/");
			} else {
				inputRealPath = inputRealPath;
			}
		} else {
			log.error("catalina.base not Found");
		}

		if (filecat.equals("license")) {
			attachmentCatagory = "license";
		} else if (filecat.equals("payment")) {
			attachmentCatagory = "payment";
		} else {
			attachmentCatagory = "other";
		}

		ResourceBundle bundle = inputBundle;
		String realPath = localPath + inputRealPath;
		String attchDoc = attachmentInputName;
		String lms = "lms";

		byte[] bytes = null;

		try {
			String sourceFileName = "";
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String uploadFileName = uploadRequest.getFileName(attchDoc);
			if (uploadFileName != null && !uploadFileName.isEmpty()) {
				long currentTimeMillis = System.currentTimeMillis();
				if (uploadFileName.contains("_")) {
					String[] parts = uploadFileName.split("_");
					if (parts.length > 0) {
						// The sourceFileName has a timestamp in it
						try {
							long oldTimestamp = Long.parseLong(parts[0]);
							if (String.valueOf(oldTimestamp).length() == 13) {
								// The timestamp has 13 digits
								long newTimestamp = System.currentTimeMillis();
								sourceFileName = uploadFileName.replace(String.valueOf(oldTimestamp),
										String.valueOf(newTimestamp));
							}
						} catch (NumberFormatException e) {
							// The first part is not a valid long number
							sourceFileName = currentTimeMillis + "_" + uploadFileName;
						}
					}
				} else {
					sourceFileName = currentTimeMillis + "_" + uploadFileName;
				}

			}
			File file = uploadRequest.getFile(attchDoc);
			String docName = "/" + bundle.getString("image.file.path") + "/";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			String paymentFolder = "payment";
			String licenseFolder = "license";
			String otherFolder = "other";

			File paymentDirectory = new File(realPath + "/" + lms + "/" + nid + "/" + paymentFolder);
			File licenseDirectory = new File(realPath + "/" + lms + "/" + nid + "/" + licenseFolder);
			File otherDirectory = new File(realPath + "/" + lms + "/" + nid + "/" + otherFolder);

			;
			if (!paymentDirectory.exists()) {
				paymentDirectory.mkdirs();
			}

			if (!licenseDirectory.exists()) {
				licenseDirectory.mkdirs();
			}

			if (!otherDirectory.exists()) {
				otherDirectory.mkdirs();
			}

			try {

				bytes = FileUtil.getBytes(file);

			} catch (IOException e2) {
				e2.printStackTrace();
			}
			File newFile = null;

			if ((bytes != null) && (bytes.length > 0)) {

				try {
//				realPath +"/" -->> filepath name
					if (attachmentCatagory.equals("license")) {
						newFile = new File(licenseDirectory + "/" + sourceFileName);
						filePath = docName + lms + "/" + nid + "/" + licenseFolder + "/" + sourceFileName;
						FileInputStream fileInputStream = new FileInputStream(file);
						FileOutputStream fileOutputStream = new FileOutputStream(newFile);
						fileInputStream.read(bytes);
						fileOutputStream.write(bytes, 0, bytes.length);
						String attachmentDate = formatter.format(new Date());
						fileOutputStream.close();
						fileInputStream.close();
						filePath_Name.put("filePath", filePath);
						filePath_Name.put("fileName", uploadFileName);
						filePath_Name.put("attachmentCategory", attachmentCatagory);
						filePath_Name.put("attachmentDate", attachmentDate);

					} else if (attachmentCatagory.equals("payment")) {
						newFile = new File(paymentDirectory + "/" + sourceFileName);
						filePath = docName + lms + "/" + nid + "/" + paymentFolder + "/" + sourceFileName;
						FileInputStream fileInputStream = new FileInputStream(file);
						FileOutputStream fileOutputStream = new FileOutputStream(newFile);
						fileInputStream.read(bytes);
						String attachmentDate = formatter.format(new Date());
						fileOutputStream.write(bytes, 0, bytes.length);
						fileOutputStream.close();
						fileInputStream.close();
						filePath_Name.put("filePath", filePath);
						filePath_Name.put("fileName", uploadFileName);
						filePath_Name.put("attachmentCategory", attachmentCatagory);
						filePath_Name.put("attachmentDate", attachmentDate);

					} else {
						newFile = new File(otherDirectory + "/" + sourceFileName);
						filePath = docName + lms + "/" + nid + "/" + otherFolder + "/" + sourceFileName;
						FileInputStream fileInputStream = new FileInputStream(file);
						FileOutputStream fileOutputStream = new FileOutputStream(newFile);
						fileInputStream.read(bytes);
						fileOutputStream.write(bytes, 0, bytes.length);
						String attachmentDate = formatter.format(new Date());
						fileOutputStream.close();
						fileInputStream.close();
						filePath_Name.put("filePath", filePath);
						filePath_Name.put("fileName", uploadFileName);
						filePath_Name.put("attachmentCategory", attachmentCatagory);
						filePath_Name.put("attachmentDate", attachmentDate);
					}
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found.");
					e.printStackTrace();
				} catch (IOException e1) {
					System.out.println("Error Reading The File.");
					e1.printStackTrace();
				}
			}

			return filePath_Name;
		} catch (Exception e) {
			System.out.println("Exception::::" + e.getMessage());
		}
		return null;
	}
//end

	public DgfFglLicDtls saveDgfFglLicDtls(licnsUserRegs licnsObj, DgfFglPreDtls dgfFglPreDtls) {
		DgfFglLicDtls dgfFglLicDtlsObj = dgfFglLicDtlsLocalService
				.createDgfFglLicDtls(CounterLocalServiceUtil.increment());
		dgfFglLicDtlsObj.setFglPrePrimaryId(dgfFglPreDtls.getFglPrePrimaryId());
		dgfFglLicDtlsObj.setFglApplicationNo(dgfFglPreDtls.getFglApplicationNo());
		dgfFglLicDtlsObj.setFoodgrainLicenseType(dgfFglPreDtls.getBusinessType());
		dgfFglLicDtlsObj.setProductType(dgfFglPreDtls.getProductType());
		dgfFglLicDtlsObj.setNationalId(licnsObj.getNationalId());
		dgfFglLicDtlsObj.setTradeLicenseNo(licnsObj.getTradeLicenseNo());
		dgfFglLicDtlsObj.setTradeLicenseExpiryDate(licnsObj.getTradeLicenseExpiryDate());
		
		dgfFglLicDtlsLocalService.addDgfFglLicDtls(dgfFglLicDtlsObj);
		return dgfFglLicDtlsObj;
	}

	public DgfFglPreDtls saveDgfFglPreDtls(ThemeDisplay themeDisplay, licnsUserRegs licnsObj,
			DgfUsersAddrDtls dgfUsersAddrDtls, DgfBussAddrDtls dgfBussAddrDtls, DgfAttachments dgfAttachmentsPhotoDocId,
			DgfAttachments dgfAttachmentsTradeDocId, DgfAttachments dgfAttachmentsBinDocId,
			DgfAttachments dgfAttachmentsTinDocId, DgfAttachments dgfAttachmentsBankDocId,
			DgfAttachments dgfAttachmentsOtherDocId, DgfAttachments dgfAttachElectricMemoId,
			DgfAttachments dgfAttachEnvClrMemoId, DgfAttachments dgfAttachBstiClrMemoId,
			DgfAttachments dgfAttachFireLicNumDocId) {
		DgfFglPreDtls dgfFglPreDtlsObj = dgfFglPreDtlsLocalService
				.createDgfFglPreDtls(CounterLocalServiceUtil.increment());
		dgfFglPreDtlsObj.setPresentAddrId(dgfUsersAddrDtls.getAddressId());
		dgfFglPreDtlsObj.setBussinessAddrId(dgfBussAddrDtls.getBusinessAddressId());
		dgfFglPreDtlsObj.setTradeLicenseDocId(dgfAttachmentsTradeDocId.getAttchmId());
		if (dgfAttachmentsBinDocId != null) {
			dgfFglPreDtlsObj.setBussIdentfctDocId(dgfAttachmentsBinDocId.getAttchmId());
		}
		dgfFglPreDtlsObj.setTaxIdentfctDocId(dgfAttachmentsTinDocId.getAttchmId());
		dgfFglPreDtlsObj.setBnkStatmtDocId(dgfAttachmentsBankDocId.getAttchmId());
		dgfFglPreDtlsObj.setPhotographDocId(dgfAttachmentsPhotoDocId.getAttchmId());
		if (dgfAttachmentsOtherDocId != null) {
			dgfFglPreDtlsObj.setOtherReleventDocId(dgfAttachmentsOtherDocId.getAttchmId());
		}
		if (dgfAttachElectricMemoId != null) {
			dgfFglPreDtlsObj.setElectricExemptionMemoId(dgfAttachElectricMemoId.getAttchmId());
		}
		if (dgfAttachEnvClrMemoId != null) {
			dgfFglPreDtlsObj.setEnvClrMemoId(dgfAttachEnvClrMemoId.getAttchmId());
		}
		if (dgfAttachBstiClrMemoId != null) {
			dgfFglPreDtlsObj.setBstiClrMemoId(dgfAttachBstiClrMemoId.getAttchmId());
		}
		if (dgfAttachFireLicNumDocId != null) {
			dgfFglPreDtlsObj.setFireLicNumDocId(dgfAttachFireLicNumDocId.getAttchmId());
		}

		long nid = 0L;
		String nidStr = licnsObj.getNationalId();
		if (nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfFglPreDtlsObj.setNationalId(nid);

		long currentTimeMillis = System.currentTimeMillis();
		String applicationNo = licnsObj.getNationalId().substring(licnsObj.getNationalId().length() - 4)
				+ currentTimeMillis;
		dgfFglPreDtlsObj.setFglApplicationNo(applicationNo);
		dgfFglPreDtlsObj.setApplicantName(licnsObj.getApplicantName());
		dgfFglPreDtlsObj.setTradeLicenseNo(licnsObj.getTradeLicenseNo());
		dgfFglPreDtlsObj.setTradeLicenseExpiryDate(licnsObj.getTradeLicenseExpiryDate());
		dgfFglPreDtlsObj.setTradeLicenseIssuerCode(licnsObj.getTradeLicenseIssuerCode());
		dgfFglPreDtlsObj.setTradeLicenseIssuerCity(licnsObj.getTradeLicenseIssuerCity());
		dgfFglPreDtlsObj.setBusinessIdentificationNo(licnsObj.getBusinessIdentificationNo());
		dgfFglPreDtlsObj.setTaxIdentificationNo(licnsObj.getTaxIdentificationNo());
		dgfFglPreDtlsObj.setBusinessName(licnsObj.getBusinessName());
		dgfFglPreDtlsObj.setBusinessType(licnsObj.getBusinessType());
		dgfFglPreDtlsObj.setProductType(licnsObj.getProductType());
		dgfFglPreDtlsObj.setComments(licnsObj.getComments());
		dgfFglPreDtlsObj.setFoodGrainLicenseType(licnsObj.getFoodGrainLicenseType());
		dgfFglPreDtlsObj.setBirthDate(licnsObj.getBirthDate());
		dgfFglPreDtlsObj.setFglApplicationType("New");
		dgfFglPreDtlsObj.setStatus(1);
		dgfFglPreDtlsObj.setCreatedDate(new Date());
		dgfFglPreDtlsLocalService.addDgfFglPreDtls(dgfFglPreDtlsObj);

		// added the resource permission
		if (licnsObj.getBusinessType() != null) {
			addPreDtlsPermission(dgfFglPreDtlsObj, dgfBussAddrDtls);
		}

		return dgfFglPreDtlsObj;
	}

	public DgfUsersAddrDtls saveDgfUsersAddrDtls(licnsUserRegs licnsObj) {
		DgfUsersAddrDtls dgfUsersAddrDtlsObj = dgfUsersAddrDtlsLocalService
				.createDgfUsersAddrDtls(CounterLocalServiceUtil.increment());

		long nid = 0L;
		String nidStr = licnsObj.getNationalId();
		if (nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfUsersAddrDtlsObj.setNationalId(nid);
		dgfUsersAddrDtlsObj.setDivision(licnsObj.getDivision());
		dgfUsersAddrDtlsObj.setDistrict(licnsObj.getDistrict());
		dgfUsersAddrDtlsObj.setUpzilla(licnsObj.getUpzilla());
		dgfUsersAddrDtlsObj.setUnionName(licnsObj.getUnionName());
		dgfUsersAddrDtlsObj.setVillage(licnsObj.getVillage());
		dgfUsersAddrDtlsObj.setWard(licnsObj.getWard());
		dgfUsersAddrDtlsObj.setZipCode(licnsObj.getZipCode());
		dgfUsersAddrDtlsObj.setPostOffice(licnsObj.getPostOffice());
		dgfUsersAddrDtlsObj.setHouseAddress(licnsObj.getHouseAddress());

		dgfUsersAddrDtlsLocalService.addDgfUsersAddrDtls(dgfUsersAddrDtlsObj);
		return dgfUsersAddrDtlsObj;
	}

	public DgfBussAddrDtls saveDgfBussAddrDtls(licnsUserRegs licnsObj) {
		DgfBussAddrDtls dgfBussAddrDtlsObj = dgfBussAddrDtlsLocalService
				.createDgfBussAddrDtls(CounterLocalServiceUtil.increment());

		long nid = 0L;
		String nidStr = licnsObj.getNationalId();
		if (nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfBussAddrDtlsObj.setNationalId(nid);
		dgfBussAddrDtlsObj.setBusinessDivision(licnsObj.getBusinessDivision());
		dgfBussAddrDtlsObj.setBusinessDistrict(licnsObj.getBusinessDistrict());
		dgfBussAddrDtlsObj.setBusinessUpzilla(licnsObj.getBusinessUpzilla());
		dgfBussAddrDtlsObj.setBusinessUnionName(licnsObj.getBusinessUnionName());
		dgfBussAddrDtlsObj.setBusinessVillage(licnsObj.getBusinessVillage());
		dgfBussAddrDtlsObj.setBusinessWard(licnsObj.getBusinessWard());
		dgfBussAddrDtlsObj.setBusinessZipCode(licnsObj.getBusinessZipCode());
		dgfBussAddrDtlsObj.setBusinessPostOffice(licnsObj.getBusinessPostOffice());
		dgfBussAddrDtlsObj.setBusinessHouseAddress(licnsObj.getBusinessHouseAddress());

		dgfBussAddrDtlsLocalService.addDgfBussAddrDtls(dgfBussAddrDtlsObj);
		return dgfBussAddrDtlsObj;
	}

	// Password encoding decoding
	public String base64Encoder(String password) {
		String s = Base64.getEncoder().encodeToString(password.getBytes());
		return s;
	}

	public String base64Decoder(String password) {
		byte[] byteArr = Base64.getDecoder().decode(password);
		String strPass = new String(byteArr);
		return strPass;
	}

	public DgfUsers saveDgfUsers(User user, licnsUserRegs licnsObj, DgfUsersAddrDtls dgfUsersAddrDtls) {
		DgfUsers dgfUsersObj = dgfUsersLocalService.createDgfUsers(CounterLocalServiceUtil.increment());

		dgfUsersObj.setUserId(user.getUserId());
		dgfUsersObj.setPresentAddrId(dgfUsersAddrDtls.getAddressId());

		dgfUsersObj.setNationalId(licnsObj.getNationalId());
		dgfUsersObj.setApplicantName(licnsObj.getApplicantName());
		dgfUsersObj.setPassword(licnsObj.getPassword());
		dgfUsersObj.setFatherName(licnsObj.getFatherName());
		dgfUsersObj.setLastName(licnsObj.getLastName());
		dgfUsersObj.setMotherName(licnsObj.getMotherName());
		dgfUsersObj.setGender(licnsObj.getGender());
		dgfUsersObj.setMaritalStatus(licnsObj.getMaritalStatus());
		dgfUsersObj.setBirthDate(licnsObj.getBirthDate());
		dgfUsersObj.setMobileNo(licnsObj.getMobileNo());

		dgfUsersLocalService.addDgfUsers(dgfUsersObj);
		dgfUsersObj.setCreateDate(dgfUsersObj.getModifiedDate());
		dgfUsersLocalService.updateDgfUsers(dgfUsersObj);
		return dgfUsersObj;
	}

	public DgfUsersDtls saveUsersDtls(licnsUserRegs licnsObj) {
		DgfUsersDtls dgfUsersDtlsObj = dgfUsersDtlsLocalService.createDgfUsersDtls(CounterLocalServiceUtil.increment());

		long nid = 0L;
		String nidStr = licnsObj.getNationalId();
		if (nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfUsersDtlsObj.setNationalId(nid);
		dgfUsersDtlsObj.setEmail(licnsObj.getEmail());
		dgfUsersDtlsObj.setNidDivision(licnsObj.getNidDivision());
		dgfUsersDtlsObj.setNidDistrict(licnsObj.getNidDistrict());
		dgfUsersDtlsObj.setNidUpzilla(licnsObj.getNidUpzilla());
		dgfUsersDtlsObj.setNidUnion(licnsObj.getNidUnion());
		dgfUsersDtlsObj.setNidVillage(licnsObj.getNidVillage());
		dgfUsersDtlsObj.setNidWard(licnsObj.getNidWard());
		dgfUsersDtlsObj.setNidZipCode(licnsObj.getNidZipCode());
		dgfUsersDtlsObj.setNidPostOffice(licnsObj.getNidPostOffice());
		dgfUsersDtlsObj.setNidHouseAddress(licnsObj.getNidHouseAddress());

		dgfUsersDtlsLocalService.addDgfUsersDtls(dgfUsersDtlsObj);
		return dgfUsersDtlsObj;
	}

	public DgfAttachments saveDgfAttachments(licnsUserRegs licnsObj, Map<String, String> attachDocDtls) {
		DgfAttachments dgfAttachmentsObj = dgfAttachmentsLocalService
				.createDgfAttachments(CounterLocalServiceUtil.increment());

		long nid = 0L;
		String nidStr = licnsObj.getNationalId();
		if (nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfAttachmentsObj.setNationalId(nid);
		dgfAttachmentsObj.setFilePath(attachDocDtls.get("filePath"));
		dgfAttachmentsObj.setTitle(attachDocDtls.get("fileName"));
		dgfAttachmentsObj.setAttachmentCatagory(attachDocDtls.get("attachmentCategory"));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = attachDocDtls.get("attachmentDate");
		try {
			Date attachmentDate = formatter.parse(currentDate);
			dgfAttachmentsObj.setAttachmntDate(attachmentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dgfAttachmentsLocalService.addDgfAttachments(dgfAttachmentsObj);
		return dgfAttachmentsObj;
	}
	
	public void saveDgfFglProductDtls(DgfFglLicDtls dgfFglLicDtls) {
		String productTypeStr = dgfFglLicDtls.getProductType();
		String[] productTypeStrArr = productTypeStr.split(",");
		List<String> productValList = new ArrayList<>();
		for (String product : productTypeStrArr) {
        	productValList.add(product);
    		long fglProductPrimaryId = CounterLocalServiceUtil.increment();
    		DgfFglProductDtls dgfFglProductDtls = dgfFglProductDtlsLocalService.createDgfFglProductDtls(fglProductPrimaryId);
    		if (Validator.isNotNull(dgfFglLicDtls)) {
    			if (Validator.isNotNull(dgfFglLicDtls.getFglLicPrimaryId())) {
    				dgfFglProductDtls.setFglLicPrimaryId(dgfFglLicDtls.getFglLicPrimaryId());
    			}
    			if (Validator.isNotNull(dgfFglLicDtls.getNationalId())) {
    				dgfFglProductDtls.setNationalId(dgfFglLicDtls.getNationalId());
    			}
    			if (Validator.isNotNull(product)) {
    				dgfFglProductDtls.setProductType(product);
    			}
    			dgfFglProductDtlsLocalService.addDgfFglProductDtls(dgfFglProductDtls);
    		}
		}
	}

	private void assignRole(User user, ThemeDisplay themeDisplay) {
		try {
			Role guestRole = roleLocalService.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			RoleLocalServiceUtil.addUserRole(user.getUserId(), guestRole.getRoleId());
		} catch (PortalException e) {
			log.error("assign roll error===");
		}
	}

	private void addPreDtlsPermission(DgfFglPreDtls dgfFglPreDtls, DgfBussAddrDtls dgfBussAddrDtls) {
		try {
			long companyId = dgfFglPreDtls.getCompanyId();
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
			String roleName = LicenseRegistrationKeys.ROLE_DCF;
			String primKey = dgfFglPreDtls.getFglPrePrimaryId() + StringPool.UNDERLINE
					+ LicenseRegistrationKeys.DISTRICT_FIRST_LETTER
					+ Long.toString(dgfBussAddrDtls.getBusinessDistrict());
			String businessType = dgfFglPreDtls.getBusinessType();
			if (businessType != null) {
				if (LicenseRegistrationKeys.ATTACHAKKI.equals(businessType.toUpperCase())
						|| LicenseRegistrationKeys.RETAILERS.equals(businessType.toUpperCase())) {
					roleName = LicenseRegistrationKeys.ROLE_UCF;
					primKey = dgfFglPreDtls.getFglPrePrimaryId() + StringPool.UNDERLINE
							+ LicenseRegistrationKeys.UPAZILLA_FIRST_LETTER
							+ Long.toString(dgfBussAddrDtls.getBusinessUpzilla());
				} else {
					List<DgfUsers> dgfAcfUsers = dgfUsersLocalService
							.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(), companyId);
					if (dgfAcfUsers != null && dgfAcfUsers.size() > 0) {
						roleName = LicenseRegistrationKeys.ROLE_ACF;
					}
				}
			}

			Role role = roleLocalService.getRole(companyId, roleName);
			if (role != null) {
				resourcePermissionLocalService.setResourcePermissions(companyId, DgfFglPreDtls.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, primKey, role.getRoleId(), actionsRW);
			}
		} catch (PortalException e) {
			log.error("added new license permission error===" + e.getMessage());
		}
	}

}
