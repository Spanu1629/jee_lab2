package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        exercitiul271(rand);
        System.out.println();
        exercitiul272(rand);
    }

    private static void exercitiul271(Random rand) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11));
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }
        Collections.sort(x);
        Collections.sort(y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);

        xPlusYLimitedByP.addAll(xPlusY);
        Iterator<Integer> it = xPlusYLimitedByP.iterator();
        while (it.hasNext()) {
            Integer valoare = it.next();
            if (valoare > p) {
                it.remove();
            }
        }

        System.out.println("2.7.1 - Operatii cu liste si seturi");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("a) xPlusY = " + xPlusY);
        System.out.println("b) zSet = " + zSet);
        System.out.println("c) xMinusY = " + xMinusY);
        System.out.println("d) xPlusYLimitedByP (p = " + p + ") = " + xPlusYLimitedByP);
    }

    private static void exercitiul272(Random rand) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Popescu", "Marian", "225_3"));
        studenti.add(new Student("Popescu", "Maria", "225_3"));
        studenti.add(new Student("Popa", "Marian", "225_3"));
        studenti.add(new Student("Bica", "Irina", "225_3"));
        studenti.add(new Student("Badea", "Ion", "225_1"));
        studenti.add(new Student("Cacoveanu", "Andreea", "225_1"));
        studenti.add(new Student("Onofrei", "Mircea", "225_1"));

        for (Student student : studenti) {
            for (int i = 0; i < 5; i++) {
                student.adaugaNota(4 + rand.nextInt(7));
            }
        }

        Collections.sort(studenti, new ByGroupNameComparator());
        afiseazaStudenti("2.7.2 b1) Studentii in ordine alfabetica, pe grupe", studenti);

        List<Student> integralisti = new ArrayList<>();
        List<Student> restantieri = new ArrayList<>();
        for (Student student : studenti) {
            if (student.esteIntegralist()) {
                integralisti.add(student);
            } else {
                restantieri.add(student);
            }
        }

        Collections.sort(integralisti, new ByGradesComparator());
        afiseazaStudenti("2.7.2 b2) Integralisti dupa medie descrescatoare", integralisti);

        Collections.sort(restantieri, new ByRestanteComparator());
        afiseazaStudenti("2.7.2 b3) Restantieri dupa numarul de restante crescator", restantieri);
    }

    private static void afiseazaStudenti(String titlu, List<Student> studenti) {
        System.out.println();
        System.out.println(titlu);
        if (studenti.isEmpty()) {
            System.out.println("Niciun student.");
        }
        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}
