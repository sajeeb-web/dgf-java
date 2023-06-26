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

package bd.gov.dgfood.food.grain.license.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfAttachments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachments
 * @generated
 */
public class DgfAttachmentsWrapper
	extends BaseModelWrapper<DgfAttachments>
	implements DgfAttachments, ModelWrapper<DgfAttachments> {

	public DgfAttachmentsWrapper(DgfAttachments dgfAttachments) {
		super(dgfAttachments);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attchmId", getAttchmId());
		attributes.put("nationalId", getNationalId());
		attributes.put("attachmentCatagory", getAttachmentCatagory());
		attributes.put("attachmntDate", getAttachmntDate());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("title", getTitle());
		attributes.put("filePath", getFilePath());
		attributes.put("version", getVersion());
		attributes.put("openTextId", getOpenTextId());
		attributes.put("status", getStatus());
		attributes.put("lastUpdatedDate", getLastUpdatedDate());
		attributes.put("lastUpdatedBy", getLastUpdatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attchmId = (Long)attributes.get("attchmId");

		if (attchmId != null) {
			setAttchmId(attchmId);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String attachmentCatagory = (String)attributes.get(
			"attachmentCatagory");

		if (attachmentCatagory != null) {
			setAttachmentCatagory(attachmentCatagory);
		}

		Date attachmntDate = (Date)attributes.get("attachmntDate");

		if (attachmntDate != null) {
			setAttachmntDate(attachmntDate);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String filePath = (String)attributes.get("filePath");

		if (filePath != null) {
			setFilePath(filePath);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long openTextId = (Long)attributes.get("openTextId");

		if (openTextId != null) {
			setOpenTextId(openTextId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date lastUpdatedDate = (Date)attributes.get("lastUpdatedDate");

		if (lastUpdatedDate != null) {
			setLastUpdatedDate(lastUpdatedDate);
		}

		Long lastUpdatedBy = (Long)attributes.get("lastUpdatedBy");

		if (lastUpdatedBy != null) {
			setLastUpdatedBy(lastUpdatedBy);
		}
	}

	@Override
	public DgfAttachments cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attachment catagory of this dgf attachments.
	 *
	 * @return the attachment catagory of this dgf attachments
	 */
	@Override
	public String getAttachmentCatagory() {
		return model.getAttachmentCatagory();
	}

	/**
	 * Returns the attachmnt date of this dgf attachments.
	 *
	 * @return the attachmnt date of this dgf attachments
	 */
	@Override
	public Date getAttachmntDate() {
		return model.getAttachmntDate();
	}

	/**
	 * Returns the attchm ID of this dgf attachments.
	 *
	 * @return the attchm ID of this dgf attachments
	 */
	@Override
	public long getAttchmId() {
		return model.getAttchmId();
	}

	/**
	 * Returns the file entry ID of this dgf attachments.
	 *
	 * @return the file entry ID of this dgf attachments
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the file path of this dgf attachments.
	 *
	 * @return the file path of this dgf attachments
	 */
	@Override
	public String getFilePath() {
		return model.getFilePath();
	}

	/**
	 * Returns the last updated by of this dgf attachments.
	 *
	 * @return the last updated by of this dgf attachments
	 */
	@Override
	public long getLastUpdatedBy() {
		return model.getLastUpdatedBy();
	}

	/**
	 * Returns the last updated date of this dgf attachments.
	 *
	 * @return the last updated date of this dgf attachments
	 */
	@Override
	public Date getLastUpdatedDate() {
		return model.getLastUpdatedDate();
	}

	/**
	 * Returns the national ID of this dgf attachments.
	 *
	 * @return the national ID of this dgf attachments
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the open text ID of this dgf attachments.
	 *
	 * @return the open text ID of this dgf attachments
	 */
	@Override
	public long getOpenTextId() {
		return model.getOpenTextId();
	}

	/**
	 * Returns the primary key of this dgf attachments.
	 *
	 * @return the primary key of this dgf attachments
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dgf attachments.
	 *
	 * @return the status of this dgf attachments
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this dgf attachments.
	 *
	 * @return the title of this dgf attachments
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the version of this dgf attachments.
	 *
	 * @return the version of this dgf attachments
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment catagory of this dgf attachments.
	 *
	 * @param attachmentCatagory the attachment catagory of this dgf attachments
	 */
	@Override
	public void setAttachmentCatagory(String attachmentCatagory) {
		model.setAttachmentCatagory(attachmentCatagory);
	}

	/**
	 * Sets the attachmnt date of this dgf attachments.
	 *
	 * @param attachmntDate the attachmnt date of this dgf attachments
	 */
	@Override
	public void setAttachmntDate(Date attachmntDate) {
		model.setAttachmntDate(attachmntDate);
	}

	/**
	 * Sets the attchm ID of this dgf attachments.
	 *
	 * @param attchmId the attchm ID of this dgf attachments
	 */
	@Override
	public void setAttchmId(long attchmId) {
		model.setAttchmId(attchmId);
	}

	/**
	 * Sets the file entry ID of this dgf attachments.
	 *
	 * @param fileEntryId the file entry ID of this dgf attachments
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the file path of this dgf attachments.
	 *
	 * @param filePath the file path of this dgf attachments
	 */
	@Override
	public void setFilePath(String filePath) {
		model.setFilePath(filePath);
	}

	/**
	 * Sets the last updated by of this dgf attachments.
	 *
	 * @param lastUpdatedBy the last updated by of this dgf attachments
	 */
	@Override
	public void setLastUpdatedBy(long lastUpdatedBy) {
		model.setLastUpdatedBy(lastUpdatedBy);
	}

	/**
	 * Sets the last updated date of this dgf attachments.
	 *
	 * @param lastUpdatedDate the last updated date of this dgf attachments
	 */
	@Override
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		model.setLastUpdatedDate(lastUpdatedDate);
	}

	/**
	 * Sets the national ID of this dgf attachments.
	 *
	 * @param nationalId the national ID of this dgf attachments
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the open text ID of this dgf attachments.
	 *
	 * @param openTextId the open text ID of this dgf attachments
	 */
	@Override
	public void setOpenTextId(long openTextId) {
		model.setOpenTextId(openTextId);
	}

	/**
	 * Sets the primary key of this dgf attachments.
	 *
	 * @param primaryKey the primary key of this dgf attachments
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dgf attachments.
	 *
	 * @param status the status of this dgf attachments
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this dgf attachments.
	 *
	 * @param title the title of this dgf attachments
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the version of this dgf attachments.
	 *
	 * @param version the version of this dgf attachments
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfAttachmentsWrapper wrap(DgfAttachments dgfAttachments) {
		return new DgfAttachmentsWrapper(dgfAttachments);
	}

}