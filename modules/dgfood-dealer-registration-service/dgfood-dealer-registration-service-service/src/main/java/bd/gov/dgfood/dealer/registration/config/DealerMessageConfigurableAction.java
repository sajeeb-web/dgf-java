package bd.gov.dgfood.dealer.registration.config;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

@Component(
		configurationPid = "bd.gov.dgfood.dealer.registration.config.DealerMessageConfiguration",
				configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
		service = ConfigurationAction.class
	)
public class DealerMessageConfigurableAction extends DefaultConfigurationAction{
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		ConfigurableUtil.createConfigurable(
				DealerMessageConfiguration.class, properties);
	}
	
}
