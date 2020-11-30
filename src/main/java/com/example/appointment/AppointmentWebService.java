package com.example.appointment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AppointmentWebService {
    AppointmentRepository appointmentRepository;
    DoctorRepository doctorRepository;
    private static final Logger log = LoggerFactory.getLogger(AppointmentApplication.class);

    @Autowired
    public AppointmentWebService(AppointmentRepository rentRepository, DoctorRepository doctorRepository) {
        super();
        this.appointmentRepository = rentRepository;
        this.doctorRepository = doctorRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String get(){
        return "Welcome to the application !";
    }

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    @ResponseBody
    @JsonBackReference
    public Iterable<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    @RequestMapping(value = "/appointments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void postAppointment(@Valid @RequestBody Receiver receive){
        log.info("-------------------------------");
        log.info(receive.patient.toString()+receive.doctorId);
        Appointment appointment = new Appointment();
        appointment.setPatient(receive.patient);
        appointment.setDoctor(doctorRepository.getDoctorById(Integer.parseInt(receive.doctorId)));
        appointment.setCategory(receive.category);
        appointment.setDate(receive.date);
        appointment.setMotif(receive.motif);
        appointmentRepository.save(appointment);
    }


    @RequestMapping(value = "/appointments", method = RequestMethod.PUT)
    @ResponseBody
    public void putAppointment(@Valid @RequestBody Appointment appointment){
        log.info("-------------------------------");
        log.info("Appointment Add !!!");
        appointmentRepository.save(appointment);
    }

    @RequestMapping(value = "/appointments/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") int id){
        log.info("Get request by Appointment_id="+id);
        return new ResponseEntity<>(appointmentRepository.getAppointmentById(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/appointments/{id}/doctor", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteAppointment(@PathVariable("id") int id){
        log.info("Delete request by Appointment_id="+id);
        appointmentRepository.deleteById(new Integer(id));
    }

    @RequestMapping(value = "/appointments/{id}/doctor", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Doctor getAppointmentDoctor(@PathVariable("id") int id){
        log.info("Get Appointment("+id+") doctor");
        return appointmentRepository.getAppointmentById(id).getDoctor();
    }

    @RequestMapping(value = "/appointments/{id}/patient", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Patient getAppointmentPatient(@PathVariable("id") int id){
        log.info("Get Appointment("+id+") patient");
        return appointmentRepository.getAppointmentById(id).getPatient();
    }

}

