package bd.gov.dgfood.food.grain.license.api.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class DataNotFoundException extends PortalException {
    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}