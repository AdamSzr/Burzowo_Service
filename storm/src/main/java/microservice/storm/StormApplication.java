package microservice.storm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StormApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StormApplication.class, args);
		BurzowoApp app = new BurzowoApp();
	}

}
