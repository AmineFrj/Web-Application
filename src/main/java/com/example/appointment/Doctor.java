package com.example.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@RequiredArgsConstructor
public class Doctor extends Person {

    private String speciality;
    private Date birthDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Details details;
    @OneToMany(mappedBy="doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Appointment> appointmentList = new ArrayList<>();

    @Builder public Doctor(String firstName, String lastName, boolean sex, String specialty){
        super(firstName, lastName, sex);
        this.speciality = specialty;
    }

    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }
    public void addDetails(Details details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "Doctor[id="+getId()+", first name="+getFirstName()+", last name="+getLastName()+
                ", speciality="+speciality+"]";
    }
}
