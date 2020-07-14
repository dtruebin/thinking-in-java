package main.java.chapter5_initialization;

public class E21_Enum {
    public static void main(String[] args) {
        for (Currency c :
                Currency.values()) {
            System.out.println(c.ordinal() + ": " + c);
            describe(c);
        }

    }

    static void describe(Currency m) {
        //noinspection EnhancedSwitchMigration
        switch (m) {
            case DOLLAR:
                System.out.println(m + " is American currency");
                break;
            case EURO:
                System.out.println(m + " is European currency");
                break;
            case POUND:
                System.out.println(m + " is British currency");
                break;
            case ROUBLE:
                System.out.println(m + " is Russian currency");
                break;
            case YEN:
                System.out.println(m + " is Chinese currency");
                break;
        }
    }

    public enum Currency {
        DOLLAR, EURO, POUND, ROUBLE, YEN
    }
}
