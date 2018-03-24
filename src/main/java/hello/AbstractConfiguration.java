package hello;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractConfiguration {

	@Value("${greeting.msg1}")
	private String hello;

	public String getHello() {
		return hello;
	}
}
