package icu.trub.tij.chapter10_innerclasses;

import icu.trub.tij.chapter10_innerclasses.controller.Event;

public class E25_GreenhouseController extends E24_GreenhouseController {
    public static void main(String[] args) {
        E25_GreenhouseControls gc = new E25_GreenhouseControls();

        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FansOn(300),
                gc.new LightOff(400),
                gc.new ThermostatDay(1400),
                gc.new FansOff(1600),
                gc.new WaterMistGeneratorsOn(1700),
                gc.new WaterMistGeneratorsOff(1800)
        };
        gc.addEvent(gc.new Restart(2000, eventList));

        if (args.length == 1)
            gc.addEvent(
                    gc.new Terminate(
                            new Integer(args[0])
                    )
            );

        gc.run();
    }
}
