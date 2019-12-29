package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.AlarmDecorator;

import static ru.sbt.mipt.oop.FakeSensorEventsGenerator.getNextSensorEvent;

public class EventProcessor {
    public static void process(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            AlarmDecorator alarmDecorator = new AlarmDecorator();
            alarmDecorator.handle(event, smartHome);
            event = getNextSensorEvent();
        }
    }
}