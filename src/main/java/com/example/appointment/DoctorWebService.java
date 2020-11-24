package com.example.appointment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DoctorWebService {
    private static final Logger log = LoggerFactory.getLogger(AppointmentApplication.class);
    DoctorRepository doctorRepository;
//    AppointmentRepository   appointmentRepository;
    @Autowired
    public DoctorWebService(DoctorRepository doctorRepository) {
        super();
        this.doctorRepository = doctorRepository;
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postDoctor(@Valid @RequestBody DoctorReceiver doctorReceiver) {
        log.info("-------------------------------");
        log.info("new doctor request ..\n"+doctorReceiver.doctor.toString()+"\n"+doctorReceiver.details.toString());
        doctorReceiver.doctor.addDetails(doctorReceiver.details);
        doctorReceiver.details.addDoctor(doctorReceiver.doctor);
        doctorRepository.save(doctorReceiver.doctor);
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void putDoctor(@Valid @RequestBody Doctor doctor) {
        log.info("-------------------------------");
        log.info("Doctor Put !!!");
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Doctor getBack(@PathVariable("id") int id){
        return doctorRepository.getDoctorById(id);
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteDoctor(@PathVariable int id) throws Exception{
        log.info("Delete request by Doctor_id="+id);
        doctorRepository.deleteById(new Integer(id));
    }

    @RequestMapping(value = "/doctors/{id}/details", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctorDetails(@PathVariable("id") int id){
        return doctorRepository.getDoctorById(id);
    }
}
