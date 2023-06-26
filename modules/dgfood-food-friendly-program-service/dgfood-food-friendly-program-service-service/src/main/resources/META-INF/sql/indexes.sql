create index IX_CC18FD82 on dgf_ffp_dlr_dstrbn_dtls (dlrRegNo);
create index IX_47131B95 on dgf_ffp_dlr_dstrbn_dtls (ffpRegstrId);
create index IX_95302484 on dgf_ffp_dlr_dstrbn_dtls (inventoryId);

create index IX_C82C7204 on dgf_ffp_invtory_dtls (allcNtfyNo);
create index IX_AFC1C33 on dgf_ffp_invtory_dtls (dlrRegNo);

create index IX_74913F2E on dgf_ffpb_details (mobileNo[$COLUMN_LENGTH:12$]);
create unique index IX_D9A492D8 on dgf_ffpb_details (nationalId);