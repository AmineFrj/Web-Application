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
	public CommandLineRunner demo(AppointmentRepository repository,DoctorRepository doctorRepository) {
		return (args) -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
			Date deb = dateFormat.parse("2017"), fin = dateFormat.parse("2018");
			log.info(deb.toString());
			Details d = new Details();
			Doctor doctor = Doctor.builder()
					.firstName("Doctor")
					.lastName("AAA")
					.sex(true)
					.specialty("Generalist")
					.build();
			Doctor doctor2 = Doctor.builder()
					.firstName("Doctor")
					.lastName("BBB")
					.sex(false)
					.specialty("Bones")
					.build();
			Patient patient = Patient.builder()
					.firstName("Patient")
					.lastName("XXX")
					.sex(true)
					.build();
			d.addDoctor(doctor);
			doctor.addDetails(d);
			Appointment appointment = new Appointment();
			appointment.setDoctor(doctor);
			appointment.setPatient(patient);
			appointment.setCategory("Category_");
			appointment.setDate(deb);
			appointment.setMotif("Sport Certificate");
			patient.addAppointment(appointment);
			doctor.addAppointment(appointment);

			repository.save(appointment);
			doctorRepository.save(doctor);
			doctorRepository.save(doctor2);

			log.info("Appointments found with findAll():");
			log.info("-------------------------------");
			for (Appointment ap : repository.findAll()) {
				log.info(ap.toString());
			}

			log.info("Doctors found with findAll():");
			log.info("-------------------------------");
			for (Doctor ap : doctorRepository.findAll()) {
				log.info(ap.toString());
			}

			log.info("Doctors found with getDoctorById():");
			log.info("-------------------------------");
				log.info(doctorRepository.getDoctorById(new Integer(2)).toString());
		};

	}
}

