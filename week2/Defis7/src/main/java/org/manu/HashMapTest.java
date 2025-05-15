package org.manu;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> articles = new HashMap<>();
        articles.put("Pomme", 10);
        articles.put("Banane", 5);
        articles.put("Orange", 8);

        System.out.println("🔎 Stock initial :");
        for (Map.Entry<String, Integer> article : articles.entrySet()) {
            System.out.println(" - " + article.getKey() + " : " + article.getValue());
        }

        // Mise à jour
        if (articles.containsKey("Banane")) {
            articles.put("Banane", articles.get("Banane") + 5);
        }

        // Suppression
        articles.remove("Orange");

        System.out.println("\n📦 Stock mis à jour :");
        for (Map.Entry<String, Integer> article : articles.entrySet()) {
            System.out.println(" - " + article.getKey() + " : " + article.getValue());
        }
    }
}
