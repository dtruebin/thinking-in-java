package icu.trub.tij.chapter10_innerclasses.controller;


public abstract class Event {
    protected final long delayTime;
    private long eventTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() { // Allows restarting
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}