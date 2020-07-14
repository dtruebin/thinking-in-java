package main.java.chapter10_innerclasses;

import main.java.chapter10_innerclasses.controller.Event;

public class E25_GreenhouseControls extends E24_GreenhouseControls {
    private boolean waterMistGenerators = false;

    public class WaterMistGeneratorsOn extends Event {
        public WaterMistGeneratorsOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMistGenerators = true;
        }

        @Override
        public String toString() {
            return "Water mist generators are on";
        }
    }

    public class WaterMistGeneratorsOff extends Event {
        public WaterMistGeneratorsOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMistGenerators = false;
        }

        @Override
        public String toString() {
            return "Water mist generators are off";
        }
    }

}