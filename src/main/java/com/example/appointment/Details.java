package com.example.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class Details {

    private @Id @GeneratedValue int id;
    private String payment;
    private float charges;
    private String description;
    @OneToOne(mappedBy = "details",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Doctor doctor;

    public void addDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    @Override
    public String toString(){
        return "Details[id="+id+", payment="+payment+", charges=$"+charges+", description="+description+"]";
    }
}