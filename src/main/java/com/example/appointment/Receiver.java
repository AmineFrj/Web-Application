package com.example.appointment;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Receiver{
    Patient patient;
    String doctorId;
    Date date;
    String category;
    String motif;
}

