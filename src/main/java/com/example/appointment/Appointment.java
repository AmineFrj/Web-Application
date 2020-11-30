package com.example.appointment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@RequiredArgsConstructor
@Entity
public class Appointment {

    private @Id @GeneratedValue Integer id;
    private String category;
    private String motif;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonBackReference
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonBackReference
    private Patient patient;

}