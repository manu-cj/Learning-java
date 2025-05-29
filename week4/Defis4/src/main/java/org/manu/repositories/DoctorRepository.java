package org.manu.repositories;

import org.manu.models.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository {
    private final List<Doctor> doctorRepository = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctorRepository.add(doctor);
    }

    public List<Doctor> getAllDoctor() {
        return doctorRepository;
    }

    public List<Doctor> getAllDoctorsByRole(String role) {
        return doctorRepository.stream()
                                .filter(d -> d.getRole().equalsIgnoreCase(role))
                                .toList();
    }

}
