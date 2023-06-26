create unique index IX_660E9BD7 on dgf_dlr_perf_dtls (dlr_reg_no);
create unique index IX_CEFA79D6 on dgf_dlr_perf_dtls (national_id[$COLUMN_LENGTH:75$]);

create unique index IX_10E6516A on dgf_dlr_reg_addl_dtls (dlr_reg_no);
create unique index IX_7F1976A3 on dgf_dlr_reg_addl_dtls (national_id[$COLUMN_LENGTH:75$]);

create unique index IX_55BF97F on dgf_dlr_reg_dtls (national_id[$COLUMN_LENGTH:75$]);
create index IX_4E5C2586 on dgf_dlr_reg_dtls (user_id);

create unique index IX_4F7D6B3A on dgf_dlr_updt_temp_dtls (dlr_reg_no);
create unique index IX_136596D3 on dgf_dlr_updt_temp_dtls (national_id[$COLUMN_LENGTH:75$]);

create index IX_48C66C1F on dgf_dlr_withdrawal (license_no[$COLUMN_LENGTH:75$]);
create unique index IX_F274FF8C on dgf_dlr_withdrawal (national_id[$COLUMN_LENGTH:75$]);