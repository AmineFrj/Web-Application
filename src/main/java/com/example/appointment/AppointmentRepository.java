package com.example.appointment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {
    Appointment getAppointmentById(int id);
}
