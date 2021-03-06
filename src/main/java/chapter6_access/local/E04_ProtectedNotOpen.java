package chapter6_access.local;

public class E04_ProtectedNotOpen {
    protected static void whoami() {
        System.out.println("E04_ProtectedNotOpen");
    }

    public static void whoamiPublic() {
        whoami();
    }

    private static void whoamiPrivate() {
        whoami();
    }
}