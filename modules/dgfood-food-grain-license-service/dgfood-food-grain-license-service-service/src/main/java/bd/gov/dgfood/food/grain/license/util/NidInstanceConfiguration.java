package bd.gov.dgfood.food.grain.license.util;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "nid-verification-configure",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)

@Meta.OCD(
		id = "bd.gov.dgfood.food.grain.license.util.NidInstanceConfiguration"
	)
public interface NidInstanceConfiguration {

	@Meta.AD(
	        description = "Nid Verification Base Url",
	        name = "baseUrl", required = true
	    )
	public String baseUrl();

	@Meta.AD(
	        description = "Nid Verification User",
	        name = "userName", required = true
	    )
	public String userName();

	@Meta.AD(
	        description = "Nid Verification Password",
	        name = "password", required = true
	    )
	public String password();
}
