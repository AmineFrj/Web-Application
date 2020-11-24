package com.example.appointment;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class DoctorReceiver{
    Doctor doctor;
    Details details;
}
