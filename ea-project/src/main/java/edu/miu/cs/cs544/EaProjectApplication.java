package edu.miu.cs.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaProjectApplication.class, args);
	}

}
