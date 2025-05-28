package org.manu.services;

import org.manu.models.Visitor;
import org.manu.models.VisitorReport;
import org.manu.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * Enregistre la visite d'un nouveau visiteur.
     * @param firstName Prénom du visiteur.
     * @param lastName Nom du visiteur.
     * @param doctorChoice Nom du médecin choisi, ou vide si visite d'un patient.
     */
    public void registerVisitor(String firstName, String lastName, String doctorChoice) {
        Visitor visitor = new Visitor(firstName, lastName);
        String purpose;
        String doctorName = null;

        if (doctorChoice != null) {
            doctorName = doctorChoice.trim();
            purpose = "Consultation avec (" + doctorName + ")";
        } else {
            purpose = "Visite d'un patient";
        }

        VisitorReport report = new VisitorReport(visitor, doctorName, purpose, LocalDateTime.now());
        visitRepository.addVisit(report);
        System.out.println("Visite enregistré pour : " + visitor.getFirstname() + " " + visitor.getLastname());
    }

    // genere le rapport de toutes les visites
    public void generateReport() {
        List<VisitorReport> reports = visitRepository.getAllVisits();
        if (reports.isEmpty()) {
            System.out.println("\n--- Hospital Visit Report ---");
            System.out.println("No visits recorded yet.");
            System.out.println("---------------------------\n");
        } else {
            System.out.println("\n--- Hospital Visit Report ---");
            for (VisitorReport visit : reports) {
                System.out.println("Prénom : " + visit.getVisitor().getFirstname());
                System.out.println("Nom de famille : " + visit.getVisitor().getLastname());
                System.out.println("Raison : " + visit.getPurpose());
                if (visit.getDoctorName() != null) {
                    System.out.println("Nom du docteur : " + visit.getDoctorName());
                }
                System.out.println("timestamp : " + visit.getTimestamp());
            }
            System.out.println("---------------------------\n");
        }
    }
}
