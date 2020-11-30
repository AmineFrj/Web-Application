package com.example.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Patient extends Person {
    private short age;
    @OneToMany(mappedBy="patient", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Appointment> appointmentList = new ArrayList<>();

    @Builder
    public Patient(String firstName, String lastName, boolean sex){
        super(firstName, lastName, sex);
    }
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }
    @Override
    public String toString() {
        return "Patient(id="+getId()+", first name="+getFirstName()+", last name="+getLastName()+", phone number="+getPhoneNumber()+", age="+age+")";
    }
}