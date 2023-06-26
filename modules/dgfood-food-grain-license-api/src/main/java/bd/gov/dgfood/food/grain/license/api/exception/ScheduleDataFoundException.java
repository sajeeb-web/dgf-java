package bd.gov.dgfood.food.grain.license.api.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class ScheduleDataFoundException extends PortalException {
    public ScheduleDataFoundException() {
        super();
    }

    public ScheduleDataFoundException(String msg) {
        super(msg);
    }

    public ScheduleDataFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ScheduleDataFoundException(Throwable cause) {
        super(cause);
    }
}