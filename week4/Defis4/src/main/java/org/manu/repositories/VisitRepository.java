package org.manu.repositories;

import org.manu.models.VisitorReport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitRepository {
    private final List<VisitorReport> visitRepository = new ArrayList<>();

    public void addVisit(VisitorReport report) {
        visitRepository.add(report);
    }

    public List<VisitorReport> getAllVisits() {
        return visitRepository;
    }
}
