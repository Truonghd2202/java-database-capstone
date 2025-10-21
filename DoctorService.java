package com.project.back_end.services;

import com.project.back_end.models.Doctors;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private final List<Doctors> doctors = new ArrayList<>();

    public DoctorService() {
        // dữ liệu mẫu
        doctors.add(new Doctors(0, "Truong", "TT", "0123456789", "tr12@gmail.com"));        
        doctors.add(new Doctors(0, "truong1", "TT", "0987654321", "ngan23@gmail.com"));

    }

    public List<Doctors> getAllDoctors() {
        return doctors;
    }

    public void addDoctor(Doctors doctor) {
        doctors.add(doctor);
    }

    public Doctors findDoctorById(int id) {
        for (Doctors d : doctors) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}
