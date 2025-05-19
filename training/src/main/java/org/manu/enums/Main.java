package org.manu.enums;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(LevelPriority.Haut.getValeur());

        for (LevelPriority p : LevelPriority.values()) {
            System.out.println(p + " urgent : " + (p.isPriority() == true ? "Oui" : "non"));
        }

        LevelPriority priorite = LevelPriority.Moyen;

        switch (priorite) {
            case Bas -> System.out.println("Peu important");
            case Moyen -> System.out.println("Important");
            case Haut -> System.out.println("Urgent !");
        }

        Operation ope = Operation.ADD;
        ope = Operation.MULTIPLY;
        System.out.println(ope.appliquer(5, 6));

        Day day = Day.MARDI;

        switch (day) {
            case LUNDI:
                System.out.println(Planning.showDay(day));
                break;
            case MARDI:
                System.out.println(Planning.showDay(day));
                break;
            case MERCREDI:
                System.out.println(Planning.showDay(day));
                break;
            case JEUDI:
                System.out.println(Planning.showDay(day));
                break;
            case VENDREDI:
                System.out.println(Planning.showDay(day));
                break;
            case SAMEDI:
                System.out.println(Planning.showDay(day));
                break;
            case DIMANCHE:
                System.out.println(Planning.showDay(day));
                break;
            default:
                break;
        }

        System.out.println(priorite.isPriority());

        List<Task> task = new ArrayList<>();
        LevelPriority bas = LevelPriority.Bas;
        LevelPriority moyen = LevelPriority.Moyen;
        LevelPriority haut = LevelPriority.Haut;

        task.add(new Task("Faire la vaisselle", bas));
        task.add(new Task("Aller travailler", haut));
        task.add(new Task("Manger", moyen));
        task.add(new Task("Aller dormir", haut));

        task.stream().sorted((t1, t2) -> Integer.compare(t2.getPriority().getValeur(), t1.getPriority().getValeur()))
                .forEach(t -> {
                    System.out.println(t.getName());
                    System.out.println(t.getPriority());
                });
    }

}
