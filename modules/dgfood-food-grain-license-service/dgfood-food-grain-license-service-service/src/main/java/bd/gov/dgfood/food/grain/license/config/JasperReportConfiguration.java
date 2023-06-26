package bd.gov.dgfood.food.grain.license.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "jasper-report-configure",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)

@Meta.OCD(
		id = "bd.gov.dgfood.food.grain.license.config.JasperReportConfiguration"
	)
public interface JasperReportConfiguration {

	@Meta.AD(
			deflt = "https://portaldev.beximcocomputers.net",
	        description = "Jasper Report Base Url",
	        name = "baseUrl", required = true
	    )
	public String baseUrl();

	@Meta.AD(
			deflt = "mobileapp",
	        description = "Jasper Report Username",
	        name = "userName", required = true
	    )
	public String userName();

	@Meta.AD(
			deflt = "j@spermobile@pp",
	        description = "Jasper Report Password",
	        name = "password", required = true
	    )
	public String password();
}
