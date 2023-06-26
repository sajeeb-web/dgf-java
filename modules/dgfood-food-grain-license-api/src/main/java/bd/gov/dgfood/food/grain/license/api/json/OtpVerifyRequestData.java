package bd.gov.dgfood.food.grain.license.api.json;

public class OtpVerifyRequestData {
	String mobileNo;
	long otpId;
	long otp;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getOtpId() {
		return otpId;
	}
	public void setOtpId(long otpId) {
		this.otpId = otpId;
	}
	public long getOtp() {
		return otp;
	}
	public void setOtp(long otp) {
		this.otp = otp;
	}

}
