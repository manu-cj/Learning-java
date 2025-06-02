package org.manu.repositories;

import org.manu.models.FidelityCard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FidelityCardRepository {
    List<FidelityCard> fidelityCardsRepository = new ArrayList<>();

    /**
     * add a fidelity card in the list
     * @param fidelityCard
     * @return
     */
    public boolean createCard(FidelityCard fidelityCard) {
        if (fidelityCard == null) {
            System.out.println("Impossible create a card with null value.");
            return false;
        }
        if (fidelityCard.getId() == null) {
            System.out.println("Impossible created card without id.");
            return false;
        }
        if (fidelityCard.getEmail() == null || fidelityCard.getEmail().trim().isEmpty()) {
            System.out.println("Impossible created card without email or with empty email.");
            return false;
        }

        for (int i = 0; i < fidelityCardsRepository.size(); i++) {
            if (fidelityCardsRepository.get(i).getId() != null && fidelityCardsRepository.get(i).getId().equals(fidelityCard.getId())) {
                System.out.println("This card id already exist !");
                return false;
            }
            else if (fidelityCardsRepository.get(i).getEmail().equals(fidelityCard.getEmail())) {
                System.out.println("Email is already use !");
                return false;
            }
        }

        fidelityCardsRepository.add(fidelityCard);
        System.out.println("Fidelity card create with success for email : " + fidelityCard.getEmail());
        return true;
    }

    /**
     * Get a fidelity card with id
     * @param id
     * @return
     */
    public List<FidelityCard> getCardById(UUID id) {
        return fidelityCardsRepository.stream()
                .filter(f -> f.getId().equals(id))
                .toList();
    }

    /**
     * Get a fidelity card with email
     * @param email
     * @return
     */
    public List<FidelityCard> getCardByEmail(String email) {
        return fidelityCardsRepository.stream()
                .filter(f -> f.getEmail().equals(email))
                .toList();
    }
}
