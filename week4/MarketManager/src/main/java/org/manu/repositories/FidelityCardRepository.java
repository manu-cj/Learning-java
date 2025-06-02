package org.manu.repositories;

import org.manu.models.FidelityCard;

import java.util.ArrayList;
import java.util.List;

public class FidelityCardRepository {
    List<FidelityCard> fidelityCardsRepository = new ArrayList<>();

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
        System.out.println("Fidelity card create with succes for email : " + fidelityCard.getEmail());
        return true;
    }
}
