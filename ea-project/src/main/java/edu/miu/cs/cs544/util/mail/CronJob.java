package edu.miu.cs.cs544.util.mail;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronJob {

	/**
	 * trigger every 10 seconds for email response for accept/reject reservation
	 */

	@Scheduled(cron = "0/10 * * * * *")
	public void emailAppointmentStatus() {
		// connect db table, parse and send

		try {
			Email.notificationAppointmentStatus();

		} catch (Exception e) {
			e.getStackTrace();
		}

		System.out.println("emailAppointmentStatus():  run every 10 seconds ");
	}

	/**
	 * trigger at 10 AM every Monday-Friday
	 * 
	 * @Scheduled(cron = "15 * * * * * MON-FRI") //for testing
	 */

	@Scheduled(cron = "0 0 10 ? * MON-FRI")

	public void emailRemainder() {

		try {
			Email.appointmentReminder();

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

	}

}