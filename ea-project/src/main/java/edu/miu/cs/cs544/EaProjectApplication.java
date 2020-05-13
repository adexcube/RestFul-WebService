package edu.miu.cs.cs544;

import edu.miu.cs.cs544.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class EaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaProjectApplication.class, args);
	}

}
