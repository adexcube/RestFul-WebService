package edu.miu.cs.cs544.util.mail2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsynchronouseMail implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronouseMail.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AsynchronouseMail Service ... Stared ");

	}
}