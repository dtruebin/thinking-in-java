/*
Create a simple class that inherits from Object and contains no members, and
show that you cannot successfully add multiple elements of that class to a
PriorityQueue. This issue will be fully explained in the Containers in Depth
chapter.
 */

package chapter11_holding;

import java.util.PriorityQueue;
import java.util.Queue;

class Issue {
}

public class E29_PriorityQueue {
    public static void main(String[] args) {
        Queue<Issue> pq = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Adding item #" + i);
            try {
                pq.offer(new Issue());
                System.out.println("Added!");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
