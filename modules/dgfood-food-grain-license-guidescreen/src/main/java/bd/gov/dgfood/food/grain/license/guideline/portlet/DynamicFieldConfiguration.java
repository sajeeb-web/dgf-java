package bd.gov.dgfood.food.grain.license.guideline.portlet;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "dynamic-configuration-field",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)

@Meta.OCD(
		id = "bd.gov.dgfood.food.grain.license.guideline.portlet.DynamicFieldConfiguration"
	)
public interface DynamicFieldConfiguration {

	@Meta.AD(
	        description = "Guideline Text",
	        name = "guideLineText", required = false
	    )
	public String guideLineText();
	
	@Meta.AD(
	        description = "Guideline Description",
	        name = "guideLineTextDescription", required = false
	    )
	public String guideLineTextDescription();
	
	@Meta.AD(
			description = "Essential Product",
			name = "lmsEssentialProduct", required = false
			)
	public String lmsEssentialProduct();
}
