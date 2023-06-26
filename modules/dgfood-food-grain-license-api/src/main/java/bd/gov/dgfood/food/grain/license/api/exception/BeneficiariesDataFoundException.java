package bd.gov.dgfood.food.grain.license.api.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class BeneficiariesDataFoundException extends PortalException {
    public BeneficiariesDataFoundException() {
        super();
    }

    public BeneficiariesDataFoundException(String msg) {
        super(msg);
    }

    public BeneficiariesDataFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeneficiariesDataFoundException(Throwable cause) {
        super(cause);
    }
}