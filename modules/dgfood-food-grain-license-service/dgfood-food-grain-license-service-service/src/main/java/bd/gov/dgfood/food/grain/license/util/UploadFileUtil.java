package bd.gov.dgfood.food.grain.license.util;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;

import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalServiceUtil;

public class UploadFileUtil {
	private static Log log = LogFactoryUtil.getLog(UploadFileUtil.class);

	public static DgfAttachments saveDgfAttachments(String nationalId, String attachmentCatagory, String sourceFileName,
			String filePath, Date currentDate) {

		long attchmId = CounterLocalServiceUtil.increment(DgfAttachments.class.getName());

		DgfAttachments dgfAttachmentsObj = DgfAttachmentsLocalServiceUtil.createDgfAttachments(attchmId);

		long nid = 0L;
		if (nationalId != null && !nationalId.isEmpty()) {
			nid = Long.parseLong(nationalId);
		}

		dgfAttachmentsObj.setNationalId(nid);
		dgfAttachmentsObj.setAttachmentCatagory(attachmentCatagory);
		dgfAttachmentsObj.setTitle(sourceFileName);
		dgfAttachmentsObj.setFilePath(filePath);
		dgfAttachmentsObj.setAttachmntDate(currentDate);

		DgfAttachmentsLocalServiceUtil.addDgfAttachments(dgfAttachmentsObj);

		return dgfAttachmentsObj;
	}

	public static DgfAttachments addUploadDoc(ActionRequest actionRequest, String nationalId, String inputRealPath,
			ResourceBundle inputBundle, String filecat, String attachmentInputName) {

		String attachmentCatagory = null;
		String nid = nationalId;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		DgfAttachments dgfAttchmentobj = null;
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

		long currentTimeMillis = System.currentTimeMillis();

		try {
			currentDate = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e3) {
			e3.printStackTrace();
		}

		if (filecat.equals("license")) {
			AttachmentCategoryUtil cat = AttachmentCategoryUtil.LICENSE;
			attachmentCatagory = cat.toString().toLowerCase();
		} else if (filecat.equals("payment")) {
			AttachmentCategoryUtil cat = AttachmentCategoryUtil.PAYMENT;
			attachmentCatagory = cat.toString().toLowerCase();
		} else {
			AttachmentCategoryUtil cat = AttachmentCategoryUtil.OTHER;
			attachmentCatagory = cat.toString().toLowerCase();
		}

		ResourceBundle bundle = inputBundle;
		String realPath = localPath + inputRealPath;
		String attchDoc = attachmentInputName;
		String filePath = "";
		String lms = "lms";

		byte[] bytes = null;

		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String sourceFileName = currentTimeMillis + uploadRequest.getFileName(attchDoc);
			File file = uploadRequest.getFile(attchDoc);

			String docName = "/" + bundle.getString("image.file.path") + "/";

			String paymentFolder = "payment";
			String licenseFolder = "license";
			String otherFolder = "other";

			File paymentDirectory = new File(realPath + "/" + lms + "/" + nid + "/" + paymentFolder);
			File licenseDirectory = new File(realPath + "/" + lms + "/" + nid + "/" + licenseFolder);
			File otherDirectory = new File(realPath + "/" + lms + "/" + nid + "/" + otherFolder);

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
					if (attachmentCatagory.equals("license")) {
						newFile = new File(licenseDirectory + "/" + sourceFileName);
						filePath = docName + lms + "/" + nid + "/" + licenseFolder + "/" + sourceFileName;
						FileInputStream fileInputStream = new FileInputStream(file);
						FileOutputStream fileOutputStream = new FileOutputStream(newFile);
						fileInputStream.read(bytes);
						fileOutputStream.write(bytes, 0, bytes.length);
						dgfAttchmentobj = saveDgfAttachments(nid, attachmentCatagory, sourceFileName, filePath,
								currentDate);
						fileOutputStream.close();
						fileInputStream.close();

					} else if (attachmentCatagory.equals("payment")) {
						newFile = new File(paymentDirectory + "/" + sourceFileName);
						filePath = docName + lms + "/" + nid + "/" + paymentFolder + "/" + sourceFileName;
						FileInputStream fileInputStream = new FileInputStream(file);
						FileOutputStream fileOutputStream = new FileOutputStream(newFile);
						fileInputStream.read(bytes);
						fileOutputStream.write(bytes, 0, bytes.length);
						dgfAttchmentobj = saveDgfAttachments(nid, attachmentCatagory, sourceFileName, filePath,
								currentDate);
						fileOutputStream.close();
						fileInputStream.close();

					} else {
						newFile = new File(otherDirectory + "/" + sourceFileName);
						filePath = docName + lms + "/" + nid + "/" + otherFolder + "/" + sourceFileName;
						FileInputStream fileInputStream = new FileInputStream(file);
						FileOutputStream fileOutputStream = new FileOutputStream(newFile);
						fileInputStream.read(bytes);
						fileOutputStream.write(bytes, 0, bytes.length);
						dgfAttchmentobj = saveDgfAttachments(nid, attachmentCatagory, sourceFileName, filePath,
								currentDate);
						fileOutputStream.close();
						fileInputStream.close();

					}
				} catch (FileNotFoundException e) {
					log.error("File not Found " + e.getMessage());
				} catch (IOException e1) {

					log.error("Error Reading the File " + e1.getMessage());
				}
				return dgfAttchmentobj;
			} else {
				log.error("File size is 0KB or null");
				return dgfAttchmentobj;
			}
		} catch (Exception e) {
			log.error("Exception:::: " + e.getMessage());
		}
		return null;
	}

}
