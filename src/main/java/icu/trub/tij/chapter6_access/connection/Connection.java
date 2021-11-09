package icu.trub.tij.chapter6_access.connection;


public class Connection {
    static private int counter = 0;
    private final int id = counter++;

    Connection() {
    }

    public String toString() {
        return "Connection{" +
                "id=" + id +
                '}';
    }

    public void checkIn() {
        ConnectionManager.checkIn(this);
    }
}

