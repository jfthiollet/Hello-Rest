package hello;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// @Configuration
@Profile("dev")
@PropertySource("file:///home/jft/Documents/application1.properties")

@Component
public class DevConfiguration implements IConfiguration  {

	@Value("${greeting.msg1}")
	private String hello;
	
	public DevConfiguration() {
	}

	@Override
	public String getHello() {
		return hello;
	}
}