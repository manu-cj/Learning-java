package org.manu.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Scope("prototype") // <- Réinitialise le compteur
public class WordCounterService {
    Map<String, Integer> wordCounts = new HashMap<>();

    public void countWords(String line) {
        String cleanedSentence = line.toLowerCase()
                .replaceAll("[^a-z\\s]", " ") // Remplace tout ce qui n'est pas lettre ou espace par un espace
                .trim();

        String[] words = cleanedSentence.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) +1);
            }
        }
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }

    // Méthode pour vider le compteur (uniquement si on passe en singleton)
    public void clearCounts() {
        this.wordCounts = new HashMap<>();
        System.out.println("Compteur vidé.");
    }

}
