package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import java.util.ArrayList;

public class DoctorController {

    private ArrayList<Doctor> doctors;

    public DoctorController() {
        doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public ArrayList<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorById(int id) {
        for (Doctor d : doctors) {
            if (d.getDoctorId() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean updateDoctor(int id, Doctor updatedDoctor) {
        for (Doctor d : doctors) {
            if (d.getDoctorId() == id) {
                d.setName(updatedDoctor.getName());
                d.setSpecialty(updatedDoctor.getSpecialty());
                d.setPhone(updatedDoctor.getPhone());
                d.setEmail(updatedDoctor.getEmail());
                return true;
            }
        }
        return false;
    }

    public boolean deleteDoctor(int id) {
        return doctors.removeIf(d -> d.getDoctorId() == id);
    }
}
