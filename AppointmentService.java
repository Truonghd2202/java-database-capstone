package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import java.util.ArrayList;

public class AppointmentService {

    private ArrayList<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<>();
    }

    // Thêm một cuộc hẹn mới
    public void addAppointment(Appointment appt) {
        appointments.add(appt);
    }

    // Lấy toàn bộ danh sách cuộc hẹn
    public ArrayList<Appointment> getAllAppointments() {
        return appointments;
    }

    // Tìm cuộc hẹn theo ID
    public Appointment getAppointmentById(int id) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId() == id) {
                return a;
            }
        }
        return null;
    }

    // Xóa cuộc hẹn theo ID
    public boolean deleteAppointment(int id) {
        return appointments.removeIf(a -> a.getAppointmentId() == id);
    }
}
