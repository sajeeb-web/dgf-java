package bd.gov.dgfood.food.grain.license.api.json;

public class SendMessageRequestData {
	String message;
	String nationalId;
	String mobileNo;
	long userId;
	long userRegNo;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUserRegNo() {
		return userRegNo;
	}
	public void setUserRegNo(long userRegNo) {
		this.userRegNo = userRegNo;
	}
	
	
}
