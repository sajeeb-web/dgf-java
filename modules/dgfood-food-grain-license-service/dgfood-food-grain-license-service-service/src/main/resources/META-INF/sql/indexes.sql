create index IX_72255C75 on dgf_beneficiary_other_info (mobile_no[$COLUMN_LENGTH:11$]);
create index IX_33B149A9 on dgf_beneficiary_other_info (verified_id);

create index IX_9AEEA47D on dgf_buss_addr_dtls (businessDistrict);
create index IX_97A8850F on dgf_buss_addr_dtls (businessUnionName);
create index IX_C151742C on dgf_buss_addr_dtls (businessUpzilla);
create index IX_EF50266B on dgf_buss_addr_dtls (businessWard[$COLUMN_LENGTH:75$]);

create index IX_D8F0F539 on dgf_dealer_masters (dealer_mobile_no[$COLUMN_LENGTH:11$]);
create index IX_563A28CF on dgf_dealer_masters (dealer_national_id[$COLUMN_LENGTH:75$], dealer_mobile_no[$COLUMN_LENGTH:11$]);
create index IX_6B6BA32A on dgf_dealer_masters (second_national_id[$COLUMN_LENGTH:75$], dealer_mobile_no[$COLUMN_LENGTH:11$]);

create index IX_616CB6DE on dgf_distribution_schedules (distribution_year, distribution_month[$COLUMN_LENGTH:75$]);
create index IX_444E5214 on dgf_distribution_schedules (open_status[$COLUMN_LENGTH:75$]);
create index IX_562801E8 on dgf_distribution_schedules (start_date, end_date);

create unique index IX_88BAC3EF on dgf_dlr_distribution_dtls (beneficiaries_id, month, year);
create index IX_BAA8D7F5 on dgf_dlr_distribution_dtls (dealer_id, beneficiaries_id);

create index IX_4958B95E on dgf_duplct_licns_reason (applicationNo[$COLUMN_LENGTH:75$]);
create index IX_4463A132 on dgf_duplct_licns_reason (fglPrePrimaryId);
create index IX_1BFEC58E on dgf_duplct_licns_reason (nationalId[$COLUMN_LENGTH:75$], licenseNo[$COLUMN_LENGTH:75$]);
create index IX_1617632 on dgf_duplct_licns_reason (paymentAttchId);
create index IX_3E4DD8C on dgf_duplct_licns_reason (tradeLicAttchId);
create index IX_1D65151D on dgf_duplct_licns_reason (userId);

create index IX_FAB00B80 on dgf_fgl_lic_dtls (fglApplicationNo[$COLUMN_LENGTH:75$]);
create index IX_F80D770F on dgf_fgl_lic_dtls (fglPrePrimaryId);
create index IX_3724D01F on dgf_fgl_lic_dtls (foodgrainLicenseNo[$COLUMN_LENGTH:75$]);
create index IX_7A1DA240 on dgf_fgl_lic_dtls (nationalId[$COLUMN_LENGTH:75$], foodgrainLicenseNo[$COLUMN_LENGTH:75$]);

create index IX_D918853 on dgf_fgl_license_no (created_at);
create index IX_50409A87 on dgf_fgl_license_no (serial_no);

create index IX_C2D3E9F6 on dgf_fgl_pre_dtls (bnkStatmtDocId);
create index IX_48CFC47F on dgf_fgl_pre_dtls (bstiClrMemoId);
create index IX_77F10D40 on dgf_fgl_pre_dtls (bussIdentfctDocId);
create index IX_E40FE7E0 on dgf_fgl_pre_dtls (bussinessAddrId);
create index IX_62FBDF72 on dgf_fgl_pre_dtls (duplicateLicenseReasonId);
create index IX_FD76ABA8 on dgf_fgl_pre_dtls (electricExemptionMemoId);
create index IX_3B5977AE on dgf_fgl_pre_dtls (envClrMemoId);
create index IX_C5806603 on dgf_fgl_pre_dtls (fglApplicationNo[$COLUMN_LENGTH:75$]);
create index IX_B494EC84 on dgf_fgl_pre_dtls (fireLicNumDocId);
create index IX_1480D5CA on dgf_fgl_pre_dtls (nationalId);
create index IX_895C9D3F on dgf_fgl_pre_dtls (otherReleventDocId);
create index IX_1495B2BB on dgf_fgl_pre_dtls (paymentChallanId);
create index IX_A2B6B85E on dgf_fgl_pre_dtls (photographDocId);
create index IX_590AAFAE on dgf_fgl_pre_dtls (presentAddrId);
create index IX_1E2B57E on dgf_fgl_pre_dtls (taxIdentfctDocId);
create index IX_E051C01D on dgf_fgl_pre_dtls (tradeLicenseDocId);

create index IX_2CC842B5 on dgf_fgl_product_dtls (fglLicPrimaryId);
create index IX_E04067FE on dgf_fgl_product_dtls (nationalId[$COLUMN_LENGTH:75$]);

create unique index IX_645F90A on dgf_licns_user_regs (nationalId[$COLUMN_LENGTH:75$]);

create index IX_D5718E4B on dgf_loc_district (divisionId);

create index IX_DB249A56 on dgf_loc_subdistrict (districtId);

create index IX_97D927DF on dgf_loc_union (subdistrictId);

create index IX_61585DE8 on dgf_renew_license (applicationNo[$COLUMN_LENGTH:75$]);
create index IX_5B0C4B3C on dgf_renew_license (fglPrePrimaryId);
create index IX_88FE4018 on dgf_renew_license (nationalId[$COLUMN_LENGTH:75$], licenseNo[$COLUMN_LENGTH:75$]);
create index IX_E95662E8 on dgf_renew_license (paymentAttchId);
create index IX_1A8D8796 on dgf_renew_license (tradeLicAttchId);
create index IX_83D517D3 on dgf_renew_license (userId);

create index IX_30CAD6A1 on dgf_store_dtls (national_id[$COLUMN_LENGTH:75$]);
create index IX_B5C0BF25 on dgf_store_dtls (type[$COLUMN_LENGTH:75$]);

create index IX_C3027270 on dgf_user_message_dtls (emailId[$COLUMN_LENGTH:100$], isSent);
create index IX_3F7DEE23 on dgf_user_message_dtls (isSent);
create index IX_BE37C67C on dgf_user_message_dtls (isSuccess);
create index IX_445D6B1A on dgf_user_message_dtls (mobileNo[$COLUMN_LENGTH:75$], isSent);
create index IX_5E91766E on dgf_user_message_dtls (nationalId[$COLUMN_LENGTH:75$]);
create index IX_3D696787 on dgf_user_message_dtls (userId);

create index IX_FF83CE7F on dgf_user_otp_dtls (isSent);
create index IX_E6A4DCD1 on dgf_user_otp_dtls (mobileNo[$COLUMN_LENGTH:75$], otp, isSent);
create index IX_EDB7C8CA on dgf_user_otp_dtls (nationalId[$COLUMN_LENGTH:75$]);
create index IX_FD6F47E3 on dgf_user_otp_dtls (userId);

create index IX_1CBFE989 on dgf_users (mobileNo[$COLUMN_LENGTH:75$]);
create unique index IX_30D21273 on dgf_users (nationalId[$COLUMN_LENGTH:75$]);

create index IX_1E5D207A on dgf_users_addr_dtls (district);
create index IX_D61975CC on dgf_users_addr_dtls (division, district, upzilla);
create index IX_3CAD519 on dgf_users_addr_dtls (nationalId);
create index IX_820988B2 on dgf_users_addr_dtls (unionName);
create index IX_DE55048F on dgf_users_addr_dtls (upzilla);
create index IX_2EAE28E8 on dgf_users_addr_dtls (ward[$COLUMN_LENGTH:75$]);

create index IX_84559E51 on dgf_users_dtls (nationalId);

create index IX_67BD43CE on dgf_users_fortnight_report_c (screenName[$COLUMN_LENGTH:75$]);
create index IX_AAE4206F on dgf_users_fortnight_report_c (usernationalId[$COLUMN_LENGTH:75$]);

create index IX_C198AE0F on dgf_users_fortnight_report_d (screenName[$COLUMN_LENGTH:75$]);
create index IX_788E8230 on dgf_users_fortnight_report_d (usernationalId[$COLUMN_LENGTH:75$]);

create index IX_F7B34FE3 on dgf_users_fortnightreport_c (screenName[$COLUMN_LENGTH:75$]);
create index IX_DB8A748E on dgf_users_fortnightreport_c (usernationalId[$COLUMN_LENGTH:75$], licenseNo[$COLUMN_LENGTH:75$]);

create index IX_518EBA24 on dgf_users_fortnightreport_d (screenName[$COLUMN_LENGTH:75$]);
create index IX_DC37202D on dgf_users_fortnightreport_d (usernationalId[$COLUMN_LENGTH:75$], licenseNo[$COLUMN_LENGTH:75$]);

create index IX_7826E963 on dgf_verified_beneficiaries (dealer_id);
create index IX_6709D6A on dgf_verified_beneficiaries (national_id[$COLUMN_LENGTH:100$]);