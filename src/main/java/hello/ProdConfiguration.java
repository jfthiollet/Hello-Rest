package hello;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("prod")

@PropertySource("file:///${JAVA_DATA_DIR}/application.properties")
// @PropertySource("file:///deployments/data/application.properties")


@Component
public class ProdConfiguration extends AbstractConfiguration implements IConfiguration {

	public ProdConfiguration() {
	}
}
