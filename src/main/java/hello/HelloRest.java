package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloRest {
	
    public static void main(String[] args) {
    	SpringApplication.run(HelloRest.class, args);
         
    }
}
/* For war packaging
public class HelloRest extends SpringBootServletInitializer
 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	 	return application.sources(HelloRest.class);
    }
    


public static void main(String[] args) {
	SpringApplication.run(HelloRest.class, args);
     
	}
}
*/