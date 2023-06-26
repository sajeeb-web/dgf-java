package bd.gov.dgfood.food.grain.license.api.json;

public class DealerDistributionRequestData {
	long dealerId;
	long beneficiariesId;
	long cardNo;
	
	public long getDealerId() {
		return dealerId;
	}
	public void setDealerId(long dealerId) {
		this.dealerId = dealerId;
	}
	public long getBeneficiariesId() {
		return beneficiariesId;
	}
	public void setBeneficiariesId(long beneficiariesId) {
		this.beneficiariesId = beneficiariesId;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	
	
}
