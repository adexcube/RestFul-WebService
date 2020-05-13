
package edu.miu.cs.cs544.util.mail;

import javax.mail.MessagingException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);
	}

	// @Override
	public void run(String... args) throws MessagingException {
		System.out.println("Appointment Status-Tracker: STARTED");
	}
}
