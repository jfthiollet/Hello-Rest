package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class GreetingControllerTest {

	private MockMvc mvc;
	
	private final static String GREETING_BASIC = "{\"id\":1,\"content\":\"Hello, World!\"}";
	private final static String GREETING_ADVANCED = "{\"id\":1,\"content\":\"Hello, Toto!\"}";

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}

	@Test
	public void getGreeting() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(GREETING_BASIC)));
	}
	
	@Test
	public void getGreetingAdvanced() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greeting?name=Toto").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(GREETING_ADVANCED)));
	}
	
}