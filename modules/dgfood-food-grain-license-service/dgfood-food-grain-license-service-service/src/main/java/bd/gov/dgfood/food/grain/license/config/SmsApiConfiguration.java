package bd.gov.dgfood.food.grain.license.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "sms-api-configure",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)

@Meta.OCD(
		id = "bd.gov.dgfood.food.grain.license.config.SmsApiConfiguration"
	)
public interface SmsApiConfiguration {

	@Meta.AD(
			deflt = "http://bulksms1.teletalk.com.bd:8091",
	        description = "SMS API Base Url",
	        name = "baseUrl", required = true
	    )
	public String baseUrl();
	
	@Meta.AD(
			deflt = "link_sms_send.php",
	        description = "SMS API action url",
	        name = "actionUrl", required = true
	    )
	public String actionUrl();
	
	@Meta.AD(
			deflt = "dgfood2",
	        description = "SMS API Username",
	        name = "user", required = true
	    )
	public String user();

	@Meta.AD(
			deflt = "DgFdJ7H6T9Pq",
	        description = "SMS API Password",
	        name = "pass", required = true
	    )
	public String pass();
	
	
	@Meta.AD(
			deflt = "SMS",
	        description = "SMS API Oparend",
	        name = "op", required = true
	    )
	public String op();

	@Meta.AD(
			deflt = "UTF-8",
	        description = "SMS API charset",
	        name = "charset", required = true
	    )
	public String charset();
	
	@Meta.AD(
			deflt = "c723dc15bd7eb3cb26a4f4dfc9ec7253",
	        description = "SMS API API Key",
	        name = "apiKey", required = true
	    )
	public String apiKey();
	
	
	@Meta.AD(
			deflt = "1971",
	        description = "SMS API Parameter Key",
	        name = "passKey", required = true
	    )
	public String passKey();

	@Meta.AD(
			deflt = "PE5YMFULAD",
	        description = "SMS API cid",
	        name = "cid", required = true
	    )
	public String cid();
}
