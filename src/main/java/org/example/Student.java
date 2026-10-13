package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        note = new ArrayList<>();
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void adaugaNota(int nota) {
        note.add(nota);
    }

    public int numarRestante() {
        int restante = 0;
        for (Integer nota : note) {
            if (nota < 5) {
                restante++;
            }
        }
        return restante;
    }

    public boolean esteIntegralist() {
        return numarRestante() == 0;
    }

    public double medie() {
        if (note.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (Integer nota : note) {
            suma += nota;
        }
        return (double) suma / note.size();
    }

    public String toString() {
        return String.format("%5s %10s %10s note: %s medie: %.2f restante: %d",
                grupa, nume, prenume, note, medie(), numarRestante());
    }
}
