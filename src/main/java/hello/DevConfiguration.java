package hello;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("dev")
@PropertySource("file:///home/jft/Documents/application1.properties")

@Component
public class DevConfiguration extends AbstractConfiguration implements IConfiguration {

	public DevConfiguration() {
	}

}