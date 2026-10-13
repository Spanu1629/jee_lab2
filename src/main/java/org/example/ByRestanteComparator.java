package org.example;

import java.util.Comparator;

public class ByRestanteComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.numarRestante() == o2.numarRestante()) {
            return 0;
        }
        return o1.numarRestante() < o2.numarRestante() ? -1 : 1;
    }
}
