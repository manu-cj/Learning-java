package org.manu.services;

import org.manu.models.Doctor;
import org.manu.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    /**
     * Enregistre un nouveau docteur
     * @param name nom du docteur
     * @param role role du docteur (pédiatre, chirurgien)
     */
    public void registerDoctor(String name, String role) {
        Doctor doctor = new Doctor("DR. " +name, role);
        doctorRepository.addDoctor(doctor);
    }

    // genere un rapport de tous les médecins enregistré
    public void generateReport() {
        List<Doctor> doctors = doctorRepository.getAllDoctor();
        if (doctors.isEmpty()) {
            System.out.println("\n--- Doctor List report ---");
            System.out.println("No doctor recorded yet");
            System.out.println("---------------------------\n");
        } else {
            System.out.println("\n--- Doctor List report ---");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName());
                System.out.println("Role : " + doctor.getRole());
            }
            System.out.println("---------------------------\n");
        }
    }

    // Retourne une liste de tous les docteurs enregistrés
    public String doctorList() {
        List<Doctor> doctors = doctorRepository.getAllDoctor();
        String allDoctors = "";

        for (Doctor doctor : doctors) {
            allDoctors += " " + doctor.getName() + " (" + doctor.getRole() +")";
        }
        return allDoctors;
    }


    /**
     * Récupère les docteurs selon le role donné en paramètre
     * @param roleSearch
     */
    public void getDoctorByRole(String roleSearch) {
        List<Doctor> doctors = doctorRepository.getAllDoctorsByRole(roleSearch);

        if (doctors.isEmpty()) {
            System.out.println("\n--- Doctor (" + roleSearch + ") List report ---");
            System.out.println("No doctor with role: " + roleSearch);
            System.out.println("---------------------------\n");
        } else {
            System.out.println("\n--- Doctor (" + roleSearch + ") List report ---");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName());
                System.out.println("Role : " + doctor.getRole());
            }
            System.out.println("---------------------------\n");
        }
    }


}
