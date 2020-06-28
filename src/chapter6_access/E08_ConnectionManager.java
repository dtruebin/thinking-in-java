package chapter6_access;

import chapter6_access.connection.Connection;
import chapter6_access.connection.ConnectionManager;

public class E08_ConnectionManager {


    public static void main(String[] args) {

        Connection[] connections = new Connection[5];

        for (int i = 0; i < connections.length; i++) {
            connections[i] = ConnectionManager.getConnection();
            System.out.println(connections[i]);
        }

        System.out.println(ConnectionManager.getConnection()); // should print null

        connections[1].checkIn();
        connections[3].checkIn();

        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
    }
}
