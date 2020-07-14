package main.java.chapter10_innerclasses.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    // A class from java.main.java.util to hold Event objects:
    private final List<Event> eventList = new LinkedList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            Iterator<Event> eventListIterator = new LinkedList<>(eventList).iterator();
            while (eventListIterator.hasNext()) {
                Event e = eventListIterator.next();
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventListIterator.remove();
                }
            }
        }
    }
}