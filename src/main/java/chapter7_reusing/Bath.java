package main.java.chapter7_reusing;

class Soap {
    private final String s;

    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class Bath {
    private final String // Инициализация в точке определения:
            s1 = "Счастливый";
    private final String s2 = "Счастливый";
    private final String s3;
    private final Soap castille;
    private final int i;
    private final float toy;
    private String s4;

    // Инициализация экземпляра:
    {
        i = 47;
    }

    public Bath() {
        System.out.println("B конструкторе Bath()");
        s3 = "Радостный";
        toy = 3.14f;
        castille = new Soap();
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }

    public String toString() {
        if (s4 == null) // Отложенная инициализация:
            s4 = "Радостный";
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille;
    }
}