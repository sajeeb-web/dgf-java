package bd.gov.dgfood.dealer.registration.util;

public enum DealerSmsMessageType {
	OTP(1),
    LMS_FORM_SUBMIT(2),
    ACF_APPROVED(3),
    ACF_REJECT(4),
    DCF_APPROVED(5),
    DCF_REJECT(6),
    PAYMENT_REQUEST(7),
    PAYMENT_RECEIVED(8),
    UCF_APPROVED(9),
    UCF_REJECT(10);

    private final int value;

    private DealerSmsMessageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
