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

package bd.gov.dgfood.food.grain.license.model.impl;

import bd.gov.dgfood.food.grain.license.model.DgfAttachments;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfAttachments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfAttachmentsCacheModel
	implements CacheModel<DgfAttachments>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfAttachmentsCacheModel)) {
			return false;
		}

		DgfAttachmentsCacheModel dgfAttachmentsCacheModel =
			(DgfAttachmentsCacheModel)object;

		if (attchmId == dgfAttachmentsCacheModel.attchmId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attchmId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{attchmId=");
		sb.append(attchmId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", attachmentCatagory=");
		sb.append(attachmentCatagory);
		sb.append(", attachmntDate=");
		sb.append(attachmntDate);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", filePath=");
		sb.append(filePath);
		sb.append(", version=");
		sb.append(version);
		sb.append(", openTextId=");
		sb.append(openTextId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", lastUpdatedDate=");
		sb.append(lastUpdatedDate);
		sb.append(", lastUpdatedBy=");
		sb.append(lastUpdatedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfAttachments toEntityModel() {
		DgfAttachmentsImpl dgfAttachmentsImpl = new DgfAttachmentsImpl();

		dgfAttachmentsImpl.setAttchmId(attchmId);
		dgfAttachmentsImpl.setNationalId(nationalId);

		if (attachmentCatagory == null) {
			dgfAttachmentsImpl.setAttachmentCatagory("");
		}
		else {
			dgfAttachmentsImpl.setAttachmentCatagory(attachmentCatagory);
		}

		if (attachmntDate == Long.MIN_VALUE) {
			dgfAttachmentsImpl.setAttachmntDate(null);
		}
		else {
			dgfAttachmentsImpl.setAttachmntDate(new Date(attachmntDate));
		}

		dgfAttachmentsImpl.setFileEntryId(fileEntryId);

		if (title == null) {
			dgfAttachmentsImpl.setTitle("");
		}
		else {
			dgfAttachmentsImpl.setTitle(title);
		}

		if (filePath == null) {
			dgfAttachmentsImpl.setFilePath("");
		}
		else {
			dgfAttachmentsImpl.setFilePath(filePath);
		}

		dgfAttachmentsImpl.setVersion(version);
		dgfAttachmentsImpl.setOpenTextId(openTextId);
		dgfAttachmentsImpl.setStatus(status);

		if (lastUpdatedDate == Long.MIN_VALUE) {
			dgfAttachmentsImpl.setLastUpdatedDate(null);
		}
		else {
			dgfAttachmentsImpl.setLastUpdatedDate(new Date(lastUpdatedDate));
		}

		dgfAttachmentsImpl.setLastUpdatedBy(lastUpdatedBy);

		dgfAttachmentsImpl.resetOriginalValues();

		return dgfAttachmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attchmId = objectInput.readLong();

		nationalId = objectInput.readLong();
		attachmentCatagory = objectInput.readUTF();
		attachmntDate = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		title = objectInput.readUTF();
		filePath = objectInput.readUTF();

		version = objectInput.readLong();

		openTextId = objectInput.readLong();

		status = objectInput.readLong();
		lastUpdatedDate = objectInput.readLong();

		lastUpdatedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(attchmId);

		objectOutput.writeLong(nationalId);

		if (attachmentCatagory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachmentCatagory);
		}

		objectOutput.writeLong(attachmntDate);

		objectOutput.writeLong(fileEntryId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (filePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filePath);
		}

		objectOutput.writeLong(version);

		objectOutput.writeLong(openTextId);

		objectOutput.writeLong(status);
		objectOutput.writeLong(lastUpdatedDate);

		objectOutput.writeLong(lastUpdatedBy);
	}

	public long attchmId;
	public long nationalId;
	public String attachmentCatagory;
	public long attachmntDate;
	public long fileEntryId;
	public String title;
	public String filePath;
	public long version;
	public long openTextId;
	public long status;
	public long lastUpdatedDate;
	public long lastUpdatedBy;

}