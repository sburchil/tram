package dev.symmys.tram.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(cron = "0 2 * * * *")
	public void reportCurrentTime() {
		System.out.println(dateFormat.format(new Date()));
	}
}
