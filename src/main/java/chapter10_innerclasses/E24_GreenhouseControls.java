package main.java.chapter10_innerclasses;

import main.java.chapter10_innerclasses.controller.Controller;
import main.java.chapter10_innerclasses.controller.Event;

public class E24_GreenhouseControls extends Controller {
    private boolean light = false;
    private String thermostat = "Day";
    private boolean fans = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class FansOn extends Event {

        public FansOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fans = true;
        }

        @Override
        public String toString() {
            return "Fans are on";
        }
    }

    public class FansOff extends Event {

        public FansOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fans = false;
        }

        @Override
        public String toString() {
            return "Fans are off";
        }
    }

    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        private final Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e :
                    eventList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e :
                    eventList) {
                e.start(); // Rerun each event
                addEvent(e);
            }
            start(); // Rerun this Event
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
}