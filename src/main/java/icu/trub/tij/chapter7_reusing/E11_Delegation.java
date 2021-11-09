package icu.trub.tij.chapter7_reusing;

class Cleanser {
    private String s = "Cleanser";

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }
}

class DetergentWithDelegation {
    private final Cleanser cleanser = new Cleanser();

    public static void main(String[] args) {
        DetergentWithDelegation x = new DetergentWithDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Проверяем базовый класс");
        Cleanser.main(args);
    }

    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public String toString() {
        return cleanser.toString();
    }

    // Изменяем метод:
    public void scrub() {
        append(" Detergent.scrub()");
        cleanser.scrub();
    }

    // Добавляем новые методы к интерфейсу:
    public void foam() {
        append(" foam()");
    }
}

public class E11_Delegation {
    public static void main(String[] args) {
        DetergentWithDelegation.main(args);
    }
}