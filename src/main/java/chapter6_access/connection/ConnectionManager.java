package main.java.chapter6_access.connection;

public class ConnectionManager {
    private static final Connection[] pool = new Connection[5];

    static {
        for (int i = 0; i < pool.length; i++) {
            pool[i] = new Connection();
        }
    }

    public static Connection getConnection() {
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null) {
                Connection conn = pool[i];
                pool[i] = null; // remove from pool, i.e. it's in use now
                return conn;
            }
        }
        System.out.println("Pool is fully used. Unable to provide a connection.");
        return null;
    }

    public static void checkIn(Connection conn) {
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] == null) {
                pool[i] = conn;
                return;
            }
        }
    }
}