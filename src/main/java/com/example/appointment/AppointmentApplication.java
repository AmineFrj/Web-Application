package com.example.appointment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppointmentApplication {

	private static final Logger log = LoggerFactory.getLogger(AppointmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppointmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("-------------------------------");
		};

	}
}

