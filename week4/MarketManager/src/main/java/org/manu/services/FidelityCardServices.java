package org.manu.services;

import org.manu.models.FidelityCard;
import org.manu.repositories.FidelityCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class FidelityCardServices {
    private final FidelityCardRepository fidelityCardRepository;

    @Autowired
    public FidelityCardServices(FidelityCardRepository fidelityCardRepository) {
        this.fidelityCardRepository = fidelityCardRepository;
    }

    /**
     * Create a fidelity card
     * @param firstname
     * @param lastname
     * @param birthday
     * @param email
     * @return
     */
    public FidelityCard addFidelityCard(String firstname, String lastname, LocalDate birthday, String email) {
        UUID id = UUID.randomUUID();
        LocalDate createdDate = LocalDate.now();
        long initialPointsBalance = 0;
        BigDecimal initialTotalSpent = BigDecimal.ZERO;
        FidelityCard fidelityCard = new FidelityCard(id, firstname, lastname, birthday, email, createdDate,initialPointsBalance, initialTotalSpent);

        boolean created = fidelityCardRepository.createCard(fidelityCard);

        if (!created) {
            if (fidelityCardRepository.getCardById(id) != null) {
                throw new IllegalArgumentException("One card with this id '" + id + "' already exist.");
            }
            if (fidelityCardRepository.getCardByEmail(email) != null) {
                throw new IllegalArgumentException("Email '" + email + "' is already use.");
            }
            throw new RuntimeException("Echec occured in the created for this fidelity card.");
        }

        return fidelityCard;
    }

}
