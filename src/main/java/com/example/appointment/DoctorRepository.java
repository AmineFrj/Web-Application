package com.example.appointment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    Doctor getDoctorById(Integer id);
}
