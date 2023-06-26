package bd.gov.dgfood.dealer.registration.util;

import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMakerUtil {
	public static Date dateMaker(String dateStr) {
		if (Validator.isNotNull(dateStr)) {
			SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateobj = null;
				dateobj = dateformater.parse(dateStr);
				return dateobj;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
