package hello;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// @Configuration
@Profile("prod")

// @PropertySource("file:///${JAVA_DATA_DIR}/application.properties")
// @PropertySource("file:///home/jft/Documents/application.properties")
@PropertySource("file:///deployments/data/application.properties")


@Component
public class ProdConfiguration implements IConfiguration  {

	@Value("${greeting.msg1}")
	private String hello;
	
	public ProdConfiguration() {
	}

	@Override
	public String getHello() {
		return hello;
	}
}
