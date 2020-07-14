package main.java.chapter7_reusing;

class Amphibian {
    void say(String s) {
        System.out.println("I am amphibian and I say: " + s);
    }
}

class Frog extends Amphibian {
    void jump() {
        System.out.println("I jumped!");
    }

    @Override
    void say(String s) {
        System.out.println("I am frog and I say: " + s);
    }
}

@SuppressWarnings("UnnecessaryLocalVariable")
public class E17_Upcasting {
    public static void main(String[] args) {
        Frog frog = new Frog();
        Amphibian amphibian = frog;
        Amphibian pureAmphibian = new Amphibian();

        frog.say("frog");
        amphibian.say("amphibian");
        pureAmphibian.say("pure amphibian");
    }
}
