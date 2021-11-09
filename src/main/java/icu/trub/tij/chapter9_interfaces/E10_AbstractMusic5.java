/* **************** Exercise 9 ******************
 * Refactor Music5.java by moving the common
 * methods in Wind, Percussion and Stringed into
 * an abstract class.
 ***********************************************/
package icu.trub.tij.chapter9_interfaces;

import icu.trub.tij.chapter8_polymorphism.music.Note;

interface Instrument {
    void adjust();
}

interface Playable {
    void play(Note n);
}

class Wind implements Playable, Instrument {
    public String toString() {
        return "Wind";
    }

    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Percussion implements Playable, Instrument {
    public String toString() {
        return "Percussion";
    }

    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Stringed implements Playable, Instrument {
    public String toString() {
        return "Stringed";
    }

    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Brass extends Wind {
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    public String toString() {
        return "Woodwind";
    }
}

public class E10_AbstractMusic5 {
    static void tune(Playable p) {
        p.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e) {
        for (Playable p : e)
            tune(p);
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~ 