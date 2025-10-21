package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;
import java.util.List;

public class PrescriptionController {

    private PrescriptionService prescriptionService;

    public PrescriptionController() {
        prescriptionService = new PrescriptionService();
    }

    // Tạo mới đơn thuốc
    public void createPrescription(Prescription prescription) {
        prescriptionService.addPrescription(prescription);
        System.out.println("Prescription created successfully!");
    }

    // Lấy danh sách tất cả đơn thuốc
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    // Lấy đơn thuốc theo ID
    public Prescription getPrescriptionById(int id) {
        return prescriptionService.getPrescriptionById(id);
    }

    // Xóa đơn thuốc theo ID
    public boolean deletePrescription(int id) {
        boolean result = prescriptionService.deletePrescription(id);
        if (result) {
            System.out.println("Prescription deleted successfully!");
        } else {
            System.out.println("Prescription not found!");
        }
        return result;
    }
}
