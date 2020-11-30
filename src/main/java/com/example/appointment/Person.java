package com.example.appointment;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Person {

    private @Id @GeneratedValue Integer id;
    @NonNull private String firstName;
    @NonNull private String lastName;
    private int phoneNumber;
    @NonNull private boolean sex;

}